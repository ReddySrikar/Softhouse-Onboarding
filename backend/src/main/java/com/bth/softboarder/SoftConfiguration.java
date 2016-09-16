package com.bth.softboarder;

/**
 * Created by Srikar on 31-08-2016.
 */

import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;

public class SoftConfiguration extends Configuration implements AssetsBundleConfiguration{

    @JsonProperty
    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDatabaseConfiguration()
    {
        return database;
    }

    @Valid
    @NotNull
    @JsonProperty
    private final AssetsConfiguration assets = new AssetsConfiguration();

    public AssetsConfiguration getAssetsConfiguration() {
        return assets;
    }


    public void setDatabase(DataSourceFactory database) {
        this.database = database;
    }
}