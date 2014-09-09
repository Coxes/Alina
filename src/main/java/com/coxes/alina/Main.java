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
		tomcat.addWebapp("/poseidon", path.substring(0, path.indexOf("target")) + "src/main/webapp");
		tomcat.start();
		logger.info("Started tomcat");
		tomcat.getServer().await();
	}
	// public static void main(String[] args) throws Exception {
	//
	// String contextPath = "/alina";
	// int port = Integer.getInteger("port", 8080);
	//
	// Server server = createServer(contextPath, port);
	//
	// try {
	// server.start();
	// server.join();
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.exit(100);
	// }
	// }
	// private static Server createServer(String contextPath, int port) {
	// //use Eclipse JDT compiler
	// System.setProperty("org.apache.jasper.compiler.disablejsr199", "true");
	//
	// Server server = new Server(port);
	// server.setStopAtShutdown(true);
	//
	// String warFile = "src/main/webapp";
	// WebAppContext context = new WebAppContext(warFile, contextPath);
	// context.setServer(server);
	//
	// //设置work dir,war包将解压到该目录，jsp编译后的文件也将放入其中。
	// String currentDir = new File(warFile).getParent();
	// File workDir = new File(currentDir, "work");
	// context.setTempDirectory(workDir);
	//
	// server.setHandler(context);
	// return server;
	// }
	//
	// /*
	// private static Server createServer(String contextPath, int port) {
	// // use Eclipse JDT compiler
	// System.setProperty("org.apache.jasper.compiler.disablejsr199", "true");
	//
	// Server server = new Server(port);
	// server.setStopAtShutdown(true);
	//
	// ProtectionDomain protectionDomain = Main.class.getProtectionDomain();
	// URL location = protectionDomain.getCodeSource().getLocation();
	// String warFile = location.toExternalForm();
	//
	// WebAppContext context = new WebAppContext(warFile, contextPath);
	// context.setServer(server);
	//
	// // 设置work dir,war包将解压到该目录，jsp编译后的文件也将放入其中。
	// String currentDir = new File(location.getPath()).getParent();
	// File workDir = new File(currentDir, "work");
	// context.setTempDirectory(workDir);
	//
	// server.setHandler(context);
	// return server;
	// }
	// */
}
