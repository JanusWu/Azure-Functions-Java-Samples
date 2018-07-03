package com.azure.functions.samples;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Service Bus Trigger.
 */
public class ServiceBusQueue {
    /**
     * This function will be invoked when a new message is received at the Service Bus Queue.
     */
    @FunctionName("ServiceBusQueueTriggerJava")
    public void serviceBusHandler(
            @ServiceBusQueueTrigger(name = "message", queueName = "hello", connection = "connection") String message,
            final ExecutionContext context
    ) {
        context.getLogger().info("Java Service Bus Queue trigger function executed.");
        context.getLogger().info(message);
    }
}
