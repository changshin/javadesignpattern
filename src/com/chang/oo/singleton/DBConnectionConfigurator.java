package com.chang.oo.singleton;

import java.util.*;
import java.io.*;
import java.lang.reflect.Field;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class DBConnectionConfigurator {

	private static final String dbConnectionProperty_file = "connectDB.properties";	
	private static final String jddcProperty_file = "jdbc.properties";	
    private static Log log = LogFactory.getLog(DBConnectionConfigurator.class);

    //private static DBConnectionConfigurator dbConnectionConfigurator = null;
    String driver = null;
    String dbType = null;		//mysql,sqlserver,oracle
    String databaseName = null;
    String username = null;
    String password = null;
    String testHostAndPort = null;	// for locahost:3306
    String hostAndPort = null;		// db01.company.com:3305
    String url = null;
   	String maxActive = null;	// default 0, zero for no limit
   	String maxWait = null;		// milliseconds 
   	String maxIdle = null;		// default 0, zero for no limit 

    public DBConnectionConfigurator() throws Exception {
    	//log.info("Constructor Called");
    	setJbdcProperties();
    	//setConnecionDBProperties();	// Old versiopn
    	//log.info("maxActive="+maxActive);
    	//log.info("maxWait="+maxWait);
    	//log.info("maxIdle="+maxIdle);
    }
    
    
	public void setJbdcProperties() {
    	Properties prop = new Properties();
    	try {
    	    InputStream is = getClass().getResourceAsStream("/"+jddcProperty_file);
    	    prop.load(is);
        	driver = prop.getProperty("database.driver");
        	//dbType = prop.getProperty("dbType");
        	databaseName = prop.getProperty("databaseName");
        	username = prop.getProperty("database.user");
        	password = prop.getProperty("database.password");
        	url = prop.getProperty("database.url");
        	maxActive = prop.getProperty("maxActive");
        	maxIdle =  prop.getProperty("maxIdle");
        	maxWait = prop.getProperty("maxWait");
        	
    	} catch(Exception ex) {
    	    log.fatal(ex.toString());			
    	    //throw new Exception(ex.toString());
    	}
    }
    
    //not using
	public void setConnecionDBProperties() {
    	Properties prop = new Properties();
    	try {
    	    InputStream is = getClass().getResourceAsStream("/"+dbConnectionProperty_file);
    	    prop.load(is);
        	driver = prop.getProperty("driver");
        	dbType = prop.getProperty("dbType");
        	databaseName = prop.getProperty("databaseName");
        	username = prop.getProperty("username");
        	password = prop.getProperty("password");
        	testHostAndPort = prop.getProperty("testHostAndPort");
        	hostAndPort = prop.getProperty("hostAndPort");
        	url = prop.getProperty("url");
        	maxActive = prop.getProperty("maxActive");
        	maxIdle = prop.getProperty("maxIdle");
        	maxWait = prop.getProperty("maxWait");
    	} catch(Exception ex) {
    	    log.fatal(ex.toString());			
    	    //throw new Exception(ex.toString());
    	}
    }
    
    
	public String getDriver() {
		return driver;
	}


	public void setDriver(String driver) {
		this.driver = driver;
	}


	public String getDbType() {
		return dbType;
	}


	public void setDbType(String dbType) {
		this.dbType = dbType;
	}


	public String getDatabaseName() {
		return databaseName;
	}


	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getTestHostAndPort() {
		return testHostAndPort;
	}


	public void setTestHostAndPort(String testHostAndPort) {
		this.testHostAndPort = testHostAndPort;
	}


	public String getHostAndPort() {
		return hostAndPort;
	}


	public void setHostAndPort(String hostAndPort) {
		this.hostAndPort = hostAndPort;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getMaxActive() {
		return maxActive;
	}


	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}


	public String getMaxWait() {
		return maxWait;
	}


	public void setMaxWait(String maxWait) {
		this.maxWait = maxWait;
	}


	public String getMaxIdle() {
		return maxIdle;
	}


	public void setMaxIdle(String maxIdle) {
		this.maxIdle = maxIdle;
	}


	@Override
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    //String newLine = System.getProperty("line.separator");
	    //result.append( this.getClass().getName() );
	    //result.append( " Object {" );
	    //result.append(newLine);
	    //determine fields declared in this class only (no fields of superclass)
	    Field[] fields = this.getClass().getDeclaredFields();

	    //print field names paired with their values
	    for ( Field field : fields  ) {
	    	if ( field.getName().equalsIgnoreCase("log") ) {
	    		continue;
	    	}
	    	//result.append("  ");
	    	StringBuffer fieldNameAndValue = new StringBuffer();
	    	try {
	    		fieldNameAndValue.append( field.getName() );
	    		fieldNameAndValue.append(":");
	    		//requires access to private field:
	    		fieldNameAndValue.append( field.get(this) );
	    		//fieldNameAndValue.append( field.get(field.getName()) );
	    	} catch ( IllegalAccessException ex ) {
	    		fieldNameAndValue.append("ex="+ex.toString());
	    	}
	    	result.append(fieldNameAndValue);
    		result.append(";\t");
	    	//result.append(newLine);
	    }
	    //result.append("}");
	    return result.toString();
	}

}