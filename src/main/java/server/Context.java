package server;

import javax.security.auth.login.AppConfigurationEntry;
import java.util.ArrayList;
import java.util.List;

public abstract class Context {

	protected List<Object> resourcesContext = new ArrayList<>();

	public static Context create(){
		if(ApplicationConfiguration.mode.equals("dev")){
			return new DevelopmentContext();
		}else{
			throw new UnknowModeServerException();
		}
	}

	public List<Object> getResourcesContext() {
		return resourcesContext;
	}

	public abstract void initializeResource();

	public abstract void registerServices();

}

