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
package com.l2jserver.service.database.jdbc.mysql5;

import com.google.inject.Inject;
import com.l2jserver.model.dao.CharacterDAO;
import com.l2jserver.model.dao.NPCDAO;
import com.l2jserver.model.id.object.provider.NPCIDProvider;
import com.l2jserver.model.id.template.provider.NPCTemplateIDProvider;
import com.l2jserver.service.database.DatabaseService;
import com.l2jserver.service.database.jdbc.JDBCNPCDAO;

/**
 * {@link CharacterDAO} implementation for MySQL5
 * 
 * @author <a href="http://www.rogiel.com">Rogiel</a>
 */
public class MySQL5NPCDAO extends JDBCNPCDAO implements NPCDAO {
	@Inject
	public MySQL5NPCDAO(DatabaseService database, NPCIDProvider idProvider,
			NPCTemplateIDProvider templateIdProvider) {
		super(database, idProvider, templateIdProvider);
	}
}