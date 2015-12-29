package com.weishengming.web.test;

import java.io.File;
import java.io.IOException;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.NCSARequestLog;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebHttpServer {
	Server server;
	int port;
	final int DEFAULTPORT = 9999;
	Connector connector = new SelectChannelConnector();
	HandlerCollection handlers = new HandlerCollection();
	ContextHandlerCollection contexts = new ContextHandlerCollection();
	RequestLogHandler requestLogHandler = new RequestLogHandler();
	WebAppContext context;

	public WebHttpServer() throws IOException {
		initialize(null, 0, null, null);
	}

	public WebHttpServer(File webAppDir, int port, String host, File logFile)
			throws IOException {
		initialize(webAppDir, port, host, logFile);
	}

	protected void initialize(File webAppDir, int port, String host,
			File logFile) throws IOException {
		webAppDir = webAppDir == null ? new File(
				new File("").getAbsoluteFile(), "webapp") : webAppDir;
		server = new Server();
		this.port = port == 0 ? DEFAULTPORT : port;
		connector.setPort(this.port);
		if (host != null && host.length() > 1)
			connector.setHost(host);
		server.setConnectors(new Connector[] { connector });

		handlers.setHandlers(new Handler[] { contexts, new DefaultHandler(),
				requestLogHandler });
		context = new WebAppContext(contexts, webAppDir.getAbsolutePath(), "/");
		server.setHandler(handlers);
		// jetty日志
		/*logFile = logFile == null ? new File(new File("").getAbsoluteFile(),
				"jetty.log") : logFile;
		logFile.createNewFile();
		NCSARequestLog requestLog = new NCSARequestLog(
				logFile.getAbsolutePath());
		requestLog.setExtended(false);*/
//		requestLogHandler.setRequestLog(requestLog);
		server.setSendServerVersion(true);
	}

	public void start() throws Exception {
		if (this.server != null)
			this.server.start();
	}

	public static void main(String[] args) throws Exception {
		WebHttpServer server = new WebHttpServer(new File("src/main/webapp"),9999, null, null);
		server.start();
	}

}
