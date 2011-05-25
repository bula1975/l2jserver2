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
package script.template.actor.npc.defender;

import com.google.inject.Inject;
import com.l2jserver.model.id.template.provider.ItemTemplateIDProvider;
import com.l2jserver.model.id.template.provider.NPCTemplateIDProvider;
import com.l2jserver.model.template.npc.DefenderNPCTemplate;
import com.l2jserver.model.world.Actor.ActorSex;

/**
 * @author <a href="http://www.rogiel.com">Rogiel</a>
 */
public class CourtSorcererTemplate extends DefenderNPCTemplate {
	public static final int ID = 35067;

	@Inject
	protected CourtSorcererTemplate(NPCTemplateIDProvider provider, ItemTemplateIDProvider itemProvider) {
		super(provider.createID(ID));
		this.name = "Court Sorcerer";
		this.serverSideName = false;
		this.title = "Gludio";
		this.serverSideTitle = false;
		this.collisionRadius = 8.00;
		this.collisionHeight = 22.50;
		this.level = 77;
		this.sex = ActorSex.MALE;
		this.attackRange = 40;
		this.maxHP = 2856.768725631600000;
		this.maxMP = 1574.000000000000000;
		this.hpRegeneration = 8.500000000000000;
		this.mpRegeneration = 3.000000000000000;
		this.experience = 593;
		this.sp = 1;
		this.aggressive = false;
		this.rightHand = itemProvider.createID(325);
		this.leftHand = null;
		this.enchantLevel = 0;
		this.targetable = true;
		this.showName = true;
		this.dropHerbGroup = 0;
		this.baseAttributes = true;
		
		attributes.intelligence = 41;
		attributes.strength = 22;
		attributes.concentration = 27;
		attributes.mentality = 20;
		attributes.dexterity = 21;
		attributes.witness = 20;
		attributes.physicalAttack = 856.44056;
		attributes.magicalAttack = 584.83789;
		attributes.physicalDefense = 328.27073;
		attributes.magicalDefense = 240.21427;
		attributes.attackSpeed = 253;
		attributes.castSpeed = 333;
		attributes.criticalChance = 1;
		attributes.walkSpeed = 50.00000;
		attributes.runSpeed = 120.00000;
	}
}