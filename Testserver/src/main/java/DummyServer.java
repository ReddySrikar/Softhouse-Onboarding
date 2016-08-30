import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


/**
 * Created by Srikar on 29-08-2016.
 */
public class DummyServer extends Application<Configuration>{

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.jersey().register(DummyResource.class);
        myConfigurationBootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html"));
    }

    public static void main(String[] args) throws Exception{
        new DummyServer().run(args);
    }


}
