package server;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyConfiguration {

	private String fileName;
	private Properties properties  = null;
	private InputStream inputStream = null;

	public PropertyConfiguration(String propertiesFileName){
		this.fileName = propertiesFileName;
	}

	public void initialize(){
		properties = new Properties();
		inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
	}

	public void apply(){
		if (properties != null){

			try{
				properties.load(inputStream);
			}catch (IOException exception){
				Logger.getGlobal().log(Level.SEVERE,"Can't load properties");
			}

			ApplicationConfiguration.mode = properties.getProperty("app.mode");
			ApplicationConfiguration.serverPort = Integer.parseInt(properties.getProperty("app.server.port"));

			ApplicationConfiguration.sqliteDbName = properties.getProperty("sqlite.database.name");

			ApplicationConfiguration.testSqliteDbName = properties.getProperty("test.sqlite.database.name");

			ApplicationConfiguration.sqliteSchemaFileName = properties.getProperty("sqlite.schema.file.name");

			ApplicationConfiguration.tokenExpirationPolicyFromPorperties = properties.getProperty("app.system.token.expiration.policy");
			ApplicationConfiguration.tokenLength = Integer.parseInt(properties.getProperty("user.token.length"));
			ApplicationConfiguration.passwordPolicyMode = properties.getProperty("app.system.token.password.policy");
		}

	}



}
