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
public class RayitoTheLooterTemplate extends RaidBossNPCTemplate {
	public static final int ID = 25506;

	@Inject
	protected RayitoTheLooterTemplate(NPCTemplateIDProvider provider, ItemTemplateIDProvider itemProvider) {
		super(provider.createID(ID));
		this.name = "Rayito the Looter";
		this.serverSideName = false;
		this.title = "Raid Boss";
		this.serverSideTitle = false;
		this.collisionRadius = 16.00;
		this.collisionHeight = 33.20;
		this.level = 37;
		this.sex = ActorSex.MALE;
		this.attackRange = 40;
		this.maxHP = 77592.657060626300000;
		this.maxMP = 432.720000000000000;
		this.hpRegeneration = 29.423286817115800;
		this.mpRegeneration = 1.800000000000000;
		this.experience = 1932589;
		this.sp = 153693;
		this.aggressive = false;
		this.rightHand = itemProvider.createID(67);
		this.leftHand = itemProvider.createID(633);
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
		attributes.physicalAttack = 190.06221;
		attributes.magicalAttack = 15.06832;
		attributes.physicalDefense = 433.43274;
		attributes.magicalDefense = 211.44000;
		attributes.attackSpeed = 253;
		attributes.castSpeed = 333;
		attributes.criticalChance = 1;
		attributes.walkSpeed = 50.00000;
		attributes.runSpeed = 190.00000;
	}
}