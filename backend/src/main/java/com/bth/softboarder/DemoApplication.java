package com.bth.softboarder;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


/**
 * Created by Srikar on 29-08-2016.
 */
public class DemoApplication extends Application<DemoConfiguration> {

    @Override
    public void run(DemoConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().setUrlPattern("/api/*");
        //environment.jersey().register(new DemoResource());

    }

    @Override
    public void initialize(Bootstrap<DemoConfiguration> configuration) {
        configuration.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }

    public static void main(String[] args) throws Exception {
        new DemoApplication().run(args);
    }
}
