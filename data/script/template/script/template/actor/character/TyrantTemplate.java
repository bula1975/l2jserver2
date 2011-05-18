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
package script.template.actor.character;

import com.google.inject.Inject;
import com.l2jserver.model.id.template.CharacterTemplateID;
import com.l2jserver.model.id.template.factory.CharacterTemplateIDFactory;
import com.l2jserver.model.world.L2Character;
import com.l2jserver.model.world.character.CharacterClass;
import com.l2jserver.util.dimensional.Point;

public class TyrantTemplate extends OrcRaiderTemplate {
	@Inject
	public TyrantTemplate(CharacterTemplateIDFactory factory) {
		super(factory.createID(CharacterClass.TYRANT.id), CharacterClass.TYRANT,	Point.fromXYZ(-56693, -113610, -690));
		// ATTRIBUTES
		attributes.intelligence = 18;
		attributes.strength = 40;
		attributes.concentration = 47;
		attributes.mentality = 27;
		attributes.dexterity = 26;
		attributes.witness = 12;
		attributes.physicalAttack = 4;
		attributes.magicalAttack = 6;
		attributes.physicalDefense = 80;
		attributes.magicalDefense = 41;
		attributes.attackSpeed = 300;
		attributes.castSpeed = 333;
		attributes.accuracy = 31;
		attributes.criticalChance = 42;
		attributes.evasionChance = 31;
		attributes.moveSpeed = 117;
		attributes.maxWeigth = 87000;
		attributes.craft = false;
	}
	
	protected TyrantTemplate(CharacterTemplateID id,
			CharacterClass characterClass, Point spawnLocation) {
		super(id, characterClass, spawnLocation);
	}

	@Override
	public L2Character create() {
		final L2Character character = super.create();
		// TODO register skills
		return character;
	}
}