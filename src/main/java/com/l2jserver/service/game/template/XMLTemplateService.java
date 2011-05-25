/*
 * This file is part of l2jserver <l2jserver.com>.
 *
 * l2jserver is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * l2jserver is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with l2jserver.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.service.game.template;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.l2jserver.model.id.TemplateID;
import com.l2jserver.model.template.CharacterTemplate;
import com.l2jserver.model.template.ItemTemplate;
import com.l2jserver.model.template.NPCTemplate;
import com.l2jserver.model.template.Template;
import com.l2jserver.service.AbstractService;
import com.l2jserver.service.AbstractService.Depends;
import com.l2jserver.service.ServiceStartException;
import com.l2jserver.service.ServiceStopException;
import com.l2jserver.service.configuration.ConfigurationService;
import com.l2jserver.service.core.LoggingService;
import com.l2jserver.util.factory.CollectionFactory;
import com.l2jserver.util.jaxb.CharacterTemplateIDAdapter;
import com.l2jserver.util.jaxb.ItemTemplateIDAdapter;
import com.l2jserver.util.jaxb.NPCTemplateIDAdapter;

@Depends({ LoggingService.class, ConfigurationService.class })
public class XMLTemplateService extends AbstractService implements
		TemplateService {
	private final XMLTemplateServiceConfiguration config;
	private final NPCTemplateIDAdapter npcTemplateIdAdapter;
	private final ItemTemplateIDAdapter itemTemplateIdAdapter;
	private final CharacterTemplateIDAdapter charIdTemplateAdapter;

	private JAXBContext context;
	private Unmarshaller unmarshaller;

	@SuppressWarnings("rawtypes")
	private Map<TemplateID, Template> templates = CollectionFactory.newMap();

	@Inject
	public XMLTemplateService(ConfigurationService configService,
			NPCTemplateIDAdapter npcTemplateIdAdapter,
			ItemTemplateIDAdapter itemTemplateIdAdapter,
			CharacterTemplateIDAdapter charIdTemplateAdapter) {
		this.config = configService.get(XMLTemplateServiceConfiguration.class);
		this.npcTemplateIdAdapter = npcTemplateIdAdapter;
		this.itemTemplateIdAdapter = itemTemplateIdAdapter;
		this.charIdTemplateAdapter = charIdTemplateAdapter;
	}

	@Override
	protected void doStart() throws ServiceStartException {
		try {
			context = JAXBContext.newInstance(CharacterTemplate.class,
					NPCTemplate.class, ItemTemplate.class);
			unmarshaller = context.createUnmarshaller();

			unmarshaller.setAdapter(NPCTemplateIDAdapter.class,
					npcTemplateIdAdapter);
			unmarshaller.setAdapter(ItemTemplateIDAdapter.class,
					itemTemplateIdAdapter);
			unmarshaller.setAdapter(CharacterTemplateIDAdapter.class,
					charIdTemplateAdapter);

			@SuppressWarnings("unchecked")
			Collection<File> files = FileUtils
					.listFiles(config.getTemplateDirectory(),
							new String[] { "xml" }, true);
			for (final File file : files) {
				loadTemplate(file);
			}
		} catch (JAXBException e) {
			throw new ServiceStartException(e);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends Template<?>> T getTemplate(TemplateID<T> id) {
		Preconditions.checkNotNull(id, "id");
		return (T) templates.get(id);
	}

	public void loadTemplate(File file) throws JAXBException {
		Preconditions.checkNotNull(file, "file");
		final Template<?> template = (Template<?>) unmarshaller.unmarshal(file);
		if (template.getID() != null)
			templates.put(template.getID(), template);
	}

	public void removeTemplate(Template<?> template) {
		Preconditions.checkNotNull(template, "template");
		templates.remove(template.getID());
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doStop() throws ServiceStopException {
		templates.clear();
		unmarshaller = null;
		context = null;
	}
}
