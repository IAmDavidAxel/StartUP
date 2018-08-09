package server;

public class ApplicationConfiguration {

	/**
	 * Properties files
	 */
	public static final String PROPERTIES_FILE_NAME = "StartUP.properties";

	/**
	 * Security properties configuration Password policy : basic
	 * Expiration : midterm , shortterm, longterm
	 */
	public static String tokenExpirationPolicyFromPorperties;
	public static int tokenLength;
	public static String passwordPolicyMode;

	/**
	 * Application general properties files
	 */
	public static String mode;
	public static int serverPort;

	/**
	 * Data Base configuration
	 */
	public static String sqliteDbName;
	public static String testSqliteDbName;
	public static String sqliteSchemaFileName;


}
