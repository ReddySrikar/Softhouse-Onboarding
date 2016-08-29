package com.softhouse.onboarder;

import java.sql.SQLException;
import java.util.EnumSet;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.skife.jdbi.v2.DBI;

import com.softhouse.onboarder.resources.OnboarderResource;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.softhouse.onboarder.db.UserDAO;
import com.softhouse.onboarder.db.OrderDAO;
import com.softhouse.onboarder.db.InventoryDAO;

import com.softhouse.onboarder.resources.UserResource;
import com.softhouse.onboarder.resources.OrderResource;
import com.softhouse.onboarder.resources.InventoryResource;

//import com.softhouse.process.FilterProcess;



public class DemoApplication extends Application<DemoConfiguration> {
    public static void main(String[] args) throws Exception {
        new DemoApplication().run(args);
    }

    private static final String API_URL_PATTERN = "/api/*";

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<DemoConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(DemoConfiguration configuration, Environment environment) throws SQLException {
        configureCrossOriginFilter(configuration, environment);
        environment.jersey().register(MultiPartFeature.class);
        // resources
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDatabaseConfiguration(), "h2");
        org.h2.tools.Server myH2adminGUI = org.h2.tools.Server.createWebServer("-webDaemon");
        myH2adminGUI.start();

        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);
        final OrderDAO orderDAO = jdbi.onDemand(OrdersDAO.class);
        final InventoryDAO userDAO = jdbi.onDemand(InventoryDAO.class);

        userDAO.createUserTable();
        orderDAO.createOrderTable();
        inventoryDAO.createInventoryTable();


        //final FilterProcess filterProcess = new FilterProcess(filterDAO);

        final OnboarderResource onboarderResource= new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());

        final UserResource userResource = new UserResource(filterProcess);
        final OrderResource orderResource = new AudioResource();

        ;
        final InventoryResource userResource = new InventoryResource(userDAO);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);

        environment.jersey().register(onboarderResource);
        environment.jersey().register(userResource);
        environment.jersey().register(orderResource);
        environment.jersey().register(inventoryResource);
    }

    private void configureCrossOriginFilter(HelloWorldConfiguration configuration, Environment environment) {
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
    }

}