package com.l2jserver.service.database;

import java.io.File;

import com.l2jserver.service.configuration.Configuration.ConfigurationName;

/**
 * Configuration for DB4O Database Service
 * 
 * @author <a href="http://www.rogiel.com">Rogiel</a>
 */
@ConfigurationName("db4o")
public interface DB4ODatabaseConfiguration extends DatabaseConfiguration {
	/**
	 * @return the database file
	 */
	@ConfigurationPropertyGetter(name = "db4o.file", defaultValue = "database.bin")
	File getDatabaseFile();

	/**
	 * @param jdbcUrl
	 *            the new database file
	 */
	@ConfigurationPropertySetter(name = "db4o.file")
	void setDatabaseFile(File file);
}
