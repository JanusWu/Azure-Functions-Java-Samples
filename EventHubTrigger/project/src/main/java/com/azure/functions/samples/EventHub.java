package com.azure.functions.samples;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Event Hub trigger.
 */
public class EventHub {
    /**
     * This function will be invoked when an event is received from Event Hub.
     */
    @FunctionName("EventHub")
    public void eventHubHandler(
        @EventHubTrigger(name = "message", eventHubName = "myhub", connection = "connection", consumerGroup = "$default") String message,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Event Hub trigger function executed.");
        context.getLogger().info(message);
    }
}
