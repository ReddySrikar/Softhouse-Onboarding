package com.bth.softboarder;

/**
 * Created by Srikar on 31-08-2016.
 */


import com.bth.softboarder.db.UserDAO;
import com.bth.softboarder.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

import java.sql.SQLException;

//import com.softhouse.onboarder.resources.OnboarderResource;
//import com.softhouse.onboarder.db.OrderDAO;
//import com.softhouse.onboarder.db.InventoryDAO;
//import com.softhouse.onboarder.resources.OrderResource;
//import com.softhouse.onboarder.resources.InventoryResource;

//import com.softhouse.process.FilterProcess;


public class SoftApplication extends Application<SoftConfiguration> {
    public static void main(String[] args) throws Exception {
        new SoftApplication().run(args);
    }

    private static final String API_URL_PATTERN = "/api/*";

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void run(SoftConfiguration configuration, Environment environment) throws SQLException {
        //configureCrossOriginFilter(configuration, environment);
        //environment.jersey().register(MultiPartFeature.class);
        // resources
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDatabaseConfiguration(), "h2");
        org.h2.tools.Server myH2adminGUI = org.h2.tools.Server.createWebServer("-webDaemon");
        myH2adminGUI.start();

        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);
        //final OrderDAO orderDAO = jdbi.onDemand(OrdersDAO.class);
        //final InventoryDAO userDAO = jdbi.onDemand(InventoryDAO.class);
        //environment.jersey().setUrlPattern("/api/*");
        userDAO.createUsersTable();
        //orderDAO.createOrderTable();
        //inventoryDAO.createInventoryTable();


        //final FilterProcess filterProcess = new FilterProcess(filterDAO);

        //final OnboarderResource onboarderResource= new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());

        //final UserResource userResource = new UserResource(filterProcess);
        //final OrderResource orderResource = new AudioResource();

        ;
        //final InventoryResource userResource = new InventoryResource(userDAO);

        //final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        // environment.healthChecks().register("template", healthCheck);

        //environment.jersey().register(onboarderResource);
        environment.jersey().register(new UserResource(userDAO));
        //environment.jersey().register(orderResource);
        //environment.jersey().register(inventoryResource);
    }

    @Override
    public void initialize(Bootstrap<SoftConfiguration> bootstrap) {
        // nothing to do yet
        //bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }

    /*private void configureCrossOriginFilter(HelloWorldConfiguration configuration, Environment environment) {
        String[] allowedOrigins = configuration.getAllowedOrigins();
        if (allowedOrigins == null || allowedOrigins.length == 0) {
            return;
        }

        Dynamic filter = environment.servlets().addFilter("CrossOriginFilter", CrossOriginFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, API_URL_PATTERN);
        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, Joiner.on(',').join(allowedOrigins));
        filter.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM,
                "X-Requested-With,Content-Type,Accept,Accept-Language,Origin,Authorization");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,POST,PUT,DELETE");
        filter.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");
    }*/

}