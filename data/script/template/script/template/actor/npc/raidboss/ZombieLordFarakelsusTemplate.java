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
package script.template.actor.npc.raidboss;

import com.google.inject.Inject;
import com.l2jserver.model.id.template.provider.ItemTemplateIDProvider;
import com.l2jserver.model.id.template.provider.NPCTemplateIDProvider;
import com.l2jserver.model.template.npc.RaidBossNPCTemplate;
import com.l2jserver.model.world.Actor.ActorSex;

/**
 * @author <a href="http://www.rogiel.com">Rogiel</a>
 */
public class ZombieLordFarakelsusTemplate extends RaidBossNPCTemplate {
	public static final int ID = 25375;

	@Inject
	protected ZombieLordFarakelsusTemplate(NPCTemplateIDProvider provider, ItemTemplateIDProvider itemProvider) {
		super(provider.createID(ID));
		this.name = "Zombie Lord Farakelsus";
		this.serverSideName = false;
		this.title = "Raid Boss";
		this.serverSideTitle = false;
		this.collisionRadius = 12.00;
		this.collisionHeight = 27.50;
		this.level = 20;
		this.sex = ActorSex.MALE;
		this.attackRange = 40;
		this.maxHP = 36847.186075394200000;
		this.maxMP = 192.000000000000000;
		this.hpRegeneration = 16.540032322353500;
		this.mpRegeneration = 1.200000000000000;
		this.experience = 3041766;
		this.sp = 59634;
		this.aggressive = false;
		this.rightHand = null;
		this.leftHand = null;
		this.enchantLevel = 0;
		this.targetable = true;
		this.showName = true;
		this.dropHerbGroup = 0;
		this.baseAttributes = true;
		
		attributes.intelligence = 76;
		attributes.strength = 60;
		attributes.concentration = 57;
		attributes.mentality = 80;
		attributes.dexterity = 73;
		attributes.witness = 70;
		attributes.physicalAttack = 48.82516;
		attributes.magicalAttack = 2.38239;
		attributes.physicalDefense = 260.61147;
		attributes.magicalDefense = 127.14000;
		attributes.attackSpeed = 253;
		attributes.castSpeed = 333;
		attributes.criticalChance = 4;
		attributes.walkSpeed = 15.00000;
		attributes.runSpeed = 190.00000;
	}
}