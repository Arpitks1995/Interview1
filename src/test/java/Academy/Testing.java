package Academy;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

public class Testing {
	
	public static Logger log;
	public static void xyz() {
		System.setProperty("logpath", System.getProperty("user.dir")+"/Report/logReport");
		System.setProperty("htmlpath", System.getProperty("user.dir")+"/Report/htmlReport");
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		System.setProperty("timestamp", sdf.format(new Date()));
		PropertyConfigurator.configure("log4j.properties");
		log=Logger.getLogger(Testing.class);
		log.info("Framework execution is started");
	
		/*log.error("Info Log is print");
		log.warn("Info Log is print");
		log.fatal("Info Log is print");
		log.debug("Info Log is print");*/
		
	}

}
