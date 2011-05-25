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
package com.l2jserver.model.world.npc.controller;

import com.l2jserver.game.net.Lineage2Connection;
import com.l2jserver.model.template.NPCTemplate;
import com.l2jserver.model.world.L2Character;
import com.l2jserver.model.world.NPC;
import com.l2jserver.util.exception.L2Exception;

/**
 * @author <a href="http://www.rogiel.com">Rogiel</a>
 * 
 */
public class NPCController {
	/**
	 * The {@link NPC} instance
	 */
	protected final NPC npc;
	/**
	 * The {@link NPC} template
	 */
	protected final NPCTemplate template;

	/**
	 * Creates a new instance
	 * 
	 * @param npc
	 *            the {@link NPC}
	 */
	public NPCController(NPC npc) {
		this.npc = npc;
		this.template = null;
	}

	/**
	 * Performs an interaction with this template.
	 * 
	 * @param character
	 *            the interacting character
	 * @param args
	 *            the action arguments
	 * @throws L2Exception
	 *             any {@link L2Exception}
	 */
	public void action(NPC npc, L2Character character, String... args)
			throws L2Exception {

	}

	/**
	 * Talks with this NPC
	 * 
	 * @param npc
	 *            the npc
	 * @param character
	 *            the character
	 * @param conn
	 *            the lineage 2 connection
	 * @param args
	 *            the action arguments
	 * @throws L2Exception
	 */
	protected void talk(NPC npc, L2Character character,
			Lineage2Connection conn, String... args) throws L2Exception {

		conn.sendActionFailed();
	}
}
