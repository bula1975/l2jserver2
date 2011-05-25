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
package script.template.actor.npc.riftinvader;

import com.google.inject.Inject;
import com.l2jserver.model.id.template.provider.ItemTemplateIDProvider;
import com.l2jserver.model.id.template.provider.NPCTemplateIDProvider;
import com.l2jserver.model.template.npc.RiftInvaderNPCTemplate;
import com.l2jserver.model.world.Actor.ActorSex;

/**
 * @author <a href="http://www.rogiel.com">Rogiel</a>
 */
public class OtherworldlyInvaderArcherTemplate extends RiftInvaderNPCTemplate {
	public static final int ID = 21661;

	@Inject
	protected OtherworldlyInvaderArcherTemplate(NPCTemplateIDProvider provider, ItemTemplateIDProvider itemProvider) {
		super(provider.createID(ID));
		this.name = "Otherworldly Invader Archer";
		this.serverSideName = false;
		this.title = "";
		this.serverSideTitle = false;
		this.collisionRadius = 11.00;
		this.collisionHeight = 27.00;
		this.level = 33;
		this.sex = ActorSex.MALE;
		this.attackRange = 1100;
		this.maxHP = 702.204630000000000;
		this.maxMP = 372.960000000000000;
		this.hpRegeneration = 4.500000000000000;
		this.mpRegeneration = 1.800000000000000;
		this.experience = 4478;
		this.sp = 257;
		this.aggressive = false;
		this.rightHand = itemProvider.createID(275);
		this.leftHand = null;
		this.enchantLevel = 0;
		this.targetable = true;
		this.showName = true;
		this.dropHerbGroup = 0;
		this.baseAttributes = true;
		
		attributes.intelligence = 21;
		attributes.strength = 40;
		attributes.concentration = 43;
		attributes.mentality = 20;
		attributes.dexterity = 30;
		attributes.witness = 20;
		attributes.physicalAttack = 113.49065;
		attributes.magicalAttack = 77.49941;
		attributes.physicalDefense = 129.23095;
		attributes.magicalDefense = 86.04342;
		attributes.attackSpeed = 253;
		attributes.castSpeed = 333;
		attributes.criticalChance = 8;
		attributes.walkSpeed = 40.00000;
		attributes.runSpeed = 165.00000;
	}
}