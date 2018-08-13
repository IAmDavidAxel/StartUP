package server;

import com.sun.javafx.util.Logging;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import server.database.Database;

import javax.servlet.Servlet;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartUPServer {

	private static final Logger SERVER_LOGGER = Logger.getLogger(StartUPServer.class.getName());

	private  Server server;

	public static void main (String[] args )throws Exception {

		SERVER_LOGGER.info("loading application parameters");
		PropertyConfiguration property = new PropertyConfiguration(ApplicationConfiguration.PROPERTIES_FILE_NAME);
		property.initialize();
		property.apply();

		SERVER_LOGGER.info("Registering resource and services");
		Context context = Context.create();
		context.registerServices();
		context.initializeResource();

		SERVER_LOGGER.info("Creating database");
		Database database = new Database();
		database.createDatabase(ApplicationConfiguration.sqliteDbName);

		SERVER_LOGGER.info("Starting the server ♥♥♥♥");
		StartUPServer server = new StartUPServer();
		server.start(ApplicationConfiguration.serverPort, context);
		server.join();


	}

	private void join() {
		try {
			server.join();
		}catch (Exception e){
			Logger.getGlobal().log(Level.SEVERE,e.getMessage());
		}finally {
			tryStopServer();
		}
	}

	private void start(int httpPort,Context applicationContext) throws Exception {

		server = new Server(httpPort);
		ServletContextHandler servletContext = new ServletContextHandler(ServletContextHandler.SESSIONS);

		ContextHandlerCollection contextHandlerCollection = configureJersey(servletContext,applicationContext);

		server.setHandler(contextHandlerCollection);

		try{
			server.start();
			SERVER_LOGGER.info("Server Started at "+server.getURI()+"♦♦");
		}catch (Exception e){
			Logger.getGlobal().log(Level.SEVERE,e.getMessage());
		}finally {
			tryStopServer();
		}
	}

	private ContextHandlerCollection configureJersey(ServletContextHandler servletContext, Context applicationContext) throws Exception{

		SERVER_LOGGER.info("Registering resources");
		ResourceConfig resourceConfig = ResourceConfig.forApplication(new Application(){
			@Override
			public Set<Object> getSingletons() {
				HashSet<Object> resources = new HashSet<>();
				resources.addAll(applicationContext.getResourcesContext());
				return resources;
			}
		});

		ServletContainer servletContainer = new ServletContainer(resourceConfig);
		ServletHolder servletHolder = new ServletHolder(servletContainer);
		servletContext.addServlet(servletHolder,"/*");

		//Setup http server
		ContextHandlerCollection contexts = new ContextHandlerCollection();
		contexts.setHandlers(new ServletContextHandler[]{servletContext});

		return contexts;
	}

	private void tryStopServer() {
		try {
			server.destroy();
		}catch (Exception e){
			return;
		}
	}
}
