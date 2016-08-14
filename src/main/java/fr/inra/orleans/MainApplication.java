package fr.inra.orleans;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MainApplication extends Application<MyConfiguration> {

    
    public static void main(String[] args) throws Exception {
        new MainApplication().run(args);
    }
	
    @Override
    public void initialize(Bootstrap<MyConfiguration> bootstrap) {
    }
	
    @Override
    public void run(MyConfiguration configuration, Environment env) throws Exception {
		
        Resource resource = new Resource() ;		
	env.jersey().register(resource)    ;
		
    }
}
