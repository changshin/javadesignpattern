package com.chang.oo.singleton;
import java.util.Properties;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.cpdsadapter.*;
import org.apache.commons.dbcp.datasources.*;
import org.apache.commons.lang.StringEscapeUtils;

import com.chang.oo.singleton.DAO;
import com.chang.oo.singleton.DAOException;
import com.chang.oo.singleton.DBConnectionConfigurator;

import org.apache.log4j.Logger;

public class DAOBase implements DAO {
	private static Logger log = Logger.getLogger(DAOBase.class);
	private static DataSource dataSource;
	static {
  		setDataSource();
	}
    public Connection getConnection() throws DAOException   {
    	//log.debug("getConection is called.");
    	Connection connection = null;
    	try {
    		int count = 0;
    		// try 5 times
   	    	do {
   		    	count++;
   		    	if  ( count > 5 ) {
   		    		throw new DAOException("DAOBase(),Db Connection error, please check DAOBase().");
   		    	}
   		    	try {
   	    			connection = dataSource.getConnection();
   		    	} catch (Exception ex) {
   					//log.info("DAOBase(),dataSource,count,username,ex="+count+":"+ex.toString());
   		    		try {
   		    			Thread.sleep(1000);	// One second sleep/wait
   		    			setDataSource();
   		    			//EntityDAO entityDAO = EntityDAOFactory.getInstance().getEntityDAO();
   		    		} catch ( Exception ex2 ) {
   	   					//log.error("DAOBase(),dataSource,count,Thread.sleep(1000),ex="+count+":"+ex.toString());
   		    		}
   		    		continue;
   		    	}
   	    	} while (connection == null );
    	} catch ( Exception ex ) {
    		log.info("getConnection(),ex="+ex.toString());
    	}
        return connection;
    }  
    
    public static void setDataSource() {
    	try {
    		DBConnectionConfigurator dbConf = new DBConnectionConfigurator();
    	    String driver = dbConf.getDriver();
    	    String dbType = dbConf.getDbType();
    	    String databaseName = dbConf.getDatabaseName();
    	    String username = dbConf.getUsername();
    	    String testHostAndPort = dbConf.getTestHostAndPort();
    	    String hostAndPort = dbConf.getHostAndPort();
    	    String password = dbConf.getPassword();
    	    String url = dbConf.getUrl();
    	   	String maxActive = dbConf.getMaxActive();
    	   	String maxIdle = dbConf.getMaxIdle();
    	   	String maxWait = dbConf.getMaxWait();
    	   	//log.debug("dbConf.toString="+dbConf.toString());
    	   	//url = jdbc:mysql://localhost:3305/test?user=root&password=root&useUnicode=true&characterEncoding=UTF8
    	   	java.net.InetAddress iNetAddress = java.net.InetAddress.getLocalHost();
    	   	//log.debug("iNetAddress.getHostName()="+iNetAddress.getHostName());
    	   	//log.debug("iNetAddress.getHostAddress()="+iNetAddress.getHostAddress());
    	    //if  ( iNetAddress.getHostName().equalsIgnoreCase("chang-PC") ) {
    	   	//	url = "jdbc:"+dbType+"://"+testHostAndPort+"/"+databaseName+"?&useUnicode=true&characterEncoding=UTF8";
    	   	//} else {
    	   	//	url = "jdbc:"+dbType+"://"+hostAndPort+"/"+databaseName+"?&useUnicode=true&characterEncoding=UTF8";
    	   	//}
    	   	//url ="jdbc:mysql://localhost:3306/test";
            //String driver ="org.gjt.mm.mysql.Driver";
    	   	//log.info("setDataSource,driver="+driver);
    	   	//log.info("setDataSource,url="+url);
    	   	//log.info("setDataSource="+username+":"+password+":"+maxActive+":"+maxIdle+":"+maxWait);
            DriverAdapterCPDS cpds = new DriverAdapterCPDS();
            cpds.setDriver(driver);
            cpds.setUrl(url);
            cpds.setUser(username);
            cpds.setPassword(password);
            cpds.setMaxActive(Integer.parseInt(maxActive));
            cpds.setMaxIdle(Integer.parseInt(maxIdle));
            cpds.setTimeBetweenEvictionRunsMillis(10000);
            cpds.setMinEvictableIdleTimeMillis(60000);
            
            SharedPoolDataSource tds = new SharedPoolDataSource();
            tds.setConnectionPoolDataSource(cpds);
            tds.setMaxActive(Integer.parseInt(maxActive));
            tds.setMaxIdle(Integer.parseInt(maxIdle));
            tds.setMaxWait( Integer.parseInt(maxWait));
            // added 2013-01-08 for 'wait_timeout' error, upgraded commons-dbcp 1.3 to 1.4.jar
            tds.setTestWhileIdle(true);
            tds.setTestOnReturn(true);
            tds.setValidationQuery("select 1");
            tds.setTestOnBorrow(true);	// default true, maybe performance problem?
            
            //tds.setTimeBetweenEvictionRunsMillis(10000);
            //tds.setMinEvictableIdleTimeMillis(60000);
            dataSource = tds;
            //log.debug("dataSource="+dataSource);
            //System.out.println("dataSource="+dataSource);
    	} catch ( Exception ex ) {
    		log.debug("setDataSource(),ex="+ex.toString());
    	}
    }

    public static int getResultSetSize(ResultSet resultSet) throws DAOException {
		int size = -1;

		try {
			resultSet.last();
			size = resultSet.getRow();
			resultSet.beforeFirst();
		} catch(SQLException e) {
			return size;
		}

		return size;
	}

	public static String escapeForSql(String s)throws DAOException  {                  
		//remove harmful HTML tags         
		if (s != null) {                 
			s = s.replaceAll("(?i)</?(HTML|SCRIPT|HEAD|CSS)\\b[^>]*>", "");          
		}          
		String rtn = StringEscapeUtils.escapeSql(s);                  
		//escape utils returns null if null         
		if (rtn == null) {                 
			rtn = "";         
		}          
		return rtn; 
	}

}	// end of class

