package com.softhouse.onboarder;


import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by hxs on 2016-08-16.
 */



public class DemoConfiguration extends Configuration implements AssetsBundleConfiguration{

    private Note defaultNote;

    public Note getDefaultNote() {
        return defaultNote;
    }

    @Valid
    @NotNull
    @JsonProperty

    private DataSourceFactory database = new DataSourceFactory();
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}






public class HelloWorldConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    private String[] allowedOrigins;

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

    @JsonProperty
    public String[] getAllowedOrigins() {
        return allowedOrigins;
    }

    @JsonProperty
    public void setAllowedOrigins(String[] allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    @JsonProperty
    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDatabaseConfiguration()
    {
        return database;
    }
}