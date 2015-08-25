package com.coxes.alina;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws Exception {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8081);
		tomcat.getConnector().setURIEncoding("UTF-8");
		String path = Main.class.getResource("/").getPath();
		tomcat.addWebapp("/alina", path.substring(0, path.indexOf("target")) + "src/main/webapp");
		tomcat.start();
		logger.info("Started tomcat");
		tomcat.getServer().await();
	}
}
