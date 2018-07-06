package com.azure.functions.samples;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Cosmos DB trigger.
 */
public class CosmosDb {
    /**
     * This function will be invoked when there are inserts or updates in the specified database and collection.
     */
    @FunctionName("CosmosDb")
    public void cosmosDBHandler(
        @CosmosDBTrigger(
            name = "items",
            databaseName = "db",
            collectionName = "col",
            leaseCollectionName="leasecol",
            connectionStringSetting = "connection",
            createLeaseCollectionIfNotExists = true
        )
        Object[] items,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Cosmos DB trigger function executed.");
        context.getLogger().info("Documents count: " + items.length);
    }
}
