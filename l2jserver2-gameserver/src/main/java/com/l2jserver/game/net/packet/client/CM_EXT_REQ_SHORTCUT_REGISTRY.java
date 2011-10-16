/*
 * This file is part of l2jserver2 <l2jserver2.com>.
 *
 * l2jserver2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * l2jserver2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with l2jserver2.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.game.net.packet.client;

import org.jboss.netty.buffer.ChannelBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.l2jserver.game.net.Lineage2Client;
import com.l2jserver.game.net.packet.AbstractClientPacket;

/**
 * The client is requesting a logout. Currently, when this packet is received
 * the connection is immediately closed.
 * 
 * @author <a href="http://www.rogiel.com">Rogiel</a>
 */
public class CM_EXT_REQ_SHORTCUT_REGISTRY extends AbstractClientPacket {
	/**
	 * The packet OPCODE1
	 */
	public static final int OPCODE1 = 0xd0;
	/**
	 * The packet OPCODE2
	 */
	public static final int OPCODE2 = 0x3d;

	/**
	 * The logger
	 */
	private static final Logger log = LoggerFactory
			.getLogger(CM_EXT_REQ_SHORTCUT_REGISTRY.class);

	/**
	 * The shortcut type
	 */
	@SuppressWarnings("unused")
	private int type;
	/**
	 * The shortcut ID
	 */
	@SuppressWarnings("unused")
	private int id;
	@SuppressWarnings("unused")
	private int slot;
	@SuppressWarnings("unused")
	private int page;
	@SuppressWarnings("unused")
	private int lvl;
	@SuppressWarnings("unused")
	private int characterType;

	@Override
	public void read(Lineage2Client conn, ChannelBuffer buffer) {
	}

	@Override
	public void process(final Lineage2Client conn) {
		log.debug("Logging out client {}", conn);
		conn.close();
	}
}
