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
package com.l2jserver.service.database.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.l2jserver.model.Model;
import com.l2jserver.model.dao.CharacterDAO;
import com.l2jserver.model.dao.NPCDAO;
import com.l2jserver.model.id.object.NPCID;
import com.l2jserver.model.id.object.provider.NPCIDProvider;
import com.l2jserver.model.id.template.NPCTemplateID;
import com.l2jserver.model.id.template.provider.NPCTemplateIDProvider;
import com.l2jserver.model.template.npc.NPCTemplate;
import com.l2jserver.model.world.NPC;
import com.l2jserver.service.database.AbstractJDBCDatabaseService.CachedMapper;
import com.l2jserver.service.database.AbstractJDBCDatabaseService.InsertUpdateQuery;
import com.l2jserver.service.database.AbstractJDBCDatabaseService.Mapper;
import com.l2jserver.service.database.AbstractJDBCDatabaseService.SelectListQuery;
import com.l2jserver.service.database.AbstractJDBCDatabaseService.SelectSingleQuery;
import com.l2jserver.service.database.DatabaseService;
import com.l2jserver.util.geometry.Point3D;

/**
 * {@link CharacterDAO} implementation for JDBC
 * 
 * @author <a href="http://www.rogiel.com">Rogiel</a>
 */
public class JDBCNPCDAO extends AbstractJDBCDAO<NPC, NPCID> implements
		NPCDAO {
	/**
	 * The logger
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * The {@link NPCID} provider
	 */
	private final NPCIDProvider idProvider;
	/**
	 * The {@link NPCTemplateID} provider
	 */
	private final NPCTemplateIDProvider templateIdProvider;

	/**
	 * Character table name
	 */
	public static final String TABLE = "npc";
	// FIELDS
	public static final String NPC_ID = "npc_id";
	public static final String NPC_TEMPLATE_ID = "npc_template_id";

	public static final String HP = "hp";
	public static final String MP = "mp";

	public static final String POINT_X = "point_x";
	public static final String POINT_Y = "point_y";
	public static final String POINT_Z = "point_z";
	public static final String POINT_ANGLE = "point_angle";

	public static final String RESPAWN_TIME = "respawn_time";

	/**
	 * @param database
	 *            the database service
	 * @param idProvider
	 *            the npc id provider
	 * @param templateIdProvider
	 *            the npc template id provider
	 */
	@Inject
	public JDBCNPCDAO(DatabaseService database, final NPCIDProvider idProvider,
			NPCTemplateIDProvider templateIdProvider) {
		super(database);
		this.idProvider = idProvider;
		this.templateIdProvider = templateIdProvider;
	}

	/**
	 * The {@link Mapper} for {@link NPCID}
	 */
	private final Mapper<NPCID> idMapper = new Mapper<NPCID>() {
		@Override
		public NPCID map(ResultSet rs) throws SQLException {
			if (rs.getString(NPC_ID) == null)
				return null;
			return idProvider.resolveID(rs.getInt(NPC_ID));
		}
	};

	/**
	 * The {@link Mapper} for {@link NPC}
	 */
	private final Mapper<NPC> mapper = new CachedMapper<NPC, NPCID>(database,
			idMapper) {
		@Override
		protected NPC map(NPCID id, ResultSet rs) throws SQLException {
			NPCTemplateID templateId = templateIdProvider.resolveID(rs
					.getInt(NPC_TEMPLATE_ID));
			NPCTemplate template = templateId.getTemplate();
			if (template == null) {
				log.warn("No template found for {}", templateId);
				return null;
			}

			final NPC npc = template.create();
			npc.setID(id);

			if (rs.getString(HP) != null)
				npc.setHP(rs.getDouble(HP));
			if (rs.getString(MP) != null)
				npc.setMP(rs.getDouble(MP));

			npc.setPoint(Point3D.fromXYZA(rs.getInt(POINT_X),
					rs.getInt(POINT_Y), rs.getInt(POINT_Z),
					rs.getDouble(POINT_ANGLE)));

			npc.setRespawnInterval(rs.getLong(RESPAWN_TIME));

			return npc;
		}
	};

	@Override
	public NPC select(final NPCID id) {
		return database.query(new SelectSingleQuery<NPC>() {
			@Override
			protected String query() {
				return "SELECT * FROM `" + TABLE + "` WHERE `" + NPC_ID
						+ "` = ?";
			}

			@Override
			protected void parametize(PreparedStatement st) throws SQLException {
				st.setInt(1, id.getID());
			}

			@Override
			protected Mapper<NPC> mapper() {
				return mapper;
			}
		});
	}

	@Override
	public List<NPC> loadAll() {
		return database.query(new SelectListQuery<NPC>() {
			@Override
			protected String query() {
				return "SELECT * FROM `" + TABLE + "`";
			}

			@Override
			protected Mapper<NPC> mapper() {
				return mapper;
			}
		});
	}

	@Override
	public List<NPC> selectByTemplate(final NPCTemplateID template) {
		return database.query(new SelectListQuery<NPC>() {
			@Override
			protected String query() {
				return "SELECT * FROM `" + TABLE + "` WHERE `"
						+ NPC_TEMPLATE_ID + "` = ?";
			}

			@Override
			protected void parametize(PreparedStatement st) throws SQLException {
				st.setInt(1, template.getID());
			}

			@Override
			protected Mapper<NPC> mapper() {
				return mapper;
			}
		});
	}

	@Override
	public List<NPCID> selectIDs() {
		return database.query(new SelectListQuery<NPCID>() {
			@Override
			protected String query() {
				return "SELECT `" + NPC_ID + "` FROM `" + TABLE + "`";
			}

			@Override
			protected Mapper<NPCID> mapper() {
				return idMapper;
			}
		});
	}

	@Override
	public int insertObjects(NPC... npcs) {
		return database.query(new InsertUpdateQuery<NPC>(npcs) {
			@Override
			protected String query() {
				return "INSERT INTO `" + TABLE + "` (`" + NPC_ID + "`,`"
						+ NPC_TEMPLATE_ID + "`,`" + HP + "`, `" + MP + "`,`"
						+ POINT_X + "`,`" + POINT_Y + "`,`" + POINT_Z + "`,`"
						+ POINT_ANGLE + "`,`" + RESPAWN_TIME
						+ "`) VALUES(?,?,?,?,?,?,?,?,?)";
			}

			@Override
			protected void parametize(PreparedStatement st, NPC npc)
					throws SQLException {
				int i = 1;

				st.setInt(i++, npc.getID().getID());
				st.setInt(i++, npc.getTemplateID().getID());

				st.setDouble(i++, npc.getHP());
				st.setDouble(i++, npc.getMP());

				st.setInt(i++, npc.getPoint().getX());
				st.setInt(i++, npc.getPoint().getY());
				st.setInt(i++, npc.getPoint().getZ());
				st.setDouble(i++, npc.getPoint().getAngle());

				st.setLong(i++, npc.getRespawnInterval());
			}
		});
	}

	@Override
	public int updateObjects(NPC... npcs) {
		return database.query(new InsertUpdateQuery<NPC>(npcs) {
			@Override
			protected String query() {
				return "UPDATE `" + TABLE + "` SET `" + NPC_TEMPLATE_ID
						+ "` = ?,`" + HP + "` = ?, `" + MP + "` = ?,`"
						+ POINT_X + "` = ?,`" + POINT_Y + "` = ?,`" + POINT_Z
						+ "` = ?,`" + POINT_ANGLE + "` = ?, `" + RESPAWN_TIME
						+ "` = ? WHERE `" + NPC_ID + "` = ?";
			}

			@Override
			protected void parametize(PreparedStatement st, NPC npc)
					throws SQLException {
				int i = 1;

				// SET
				st.setInt(i++, npc.getTemplateID().getID());

				st.setDouble(i++, npc.getHP());
				st.setDouble(i++, npc.getMP());

				st.setInt(i++, npc.getPoint().getX());
				st.setInt(i++, npc.getPoint().getY());
				st.setInt(i++, npc.getPoint().getZ());
				st.setDouble(i++, npc.getPoint().getAngle());

				st.setLong(i++, npc.getRespawnInterval());

				// WHERE
				st.setInt(i++, npc.getID().getID());
			}
		});
	}

	@Override
	public int deleteObjects(NPC... npcs) {
		return database.query(new InsertUpdateQuery<NPC>(npcs) {
			@Override
			protected String query() {
				return "DELETE FROM `" + TABLE + "` WHERE `" + NPC_ID + "` = ?";
			}

			@Override
			protected void parametize(PreparedStatement st, NPC npc)
					throws SQLException {
				st.setInt(1, npc.getID().getID());
			}
		});
	}

	@Override
	protected NPC[] wrap(Model<?>... objects) {
		final NPC[] array = new NPC[objects.length];
		int i = 0;
		for (final Model<?> object : objects) {
			array[i++] = (NPC) object;
		}
		return array;
	}
}
