package com.azure.functions.samples;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Service Topic Trigger.
 */
public class ServiceBusTopic {
    /**
     * This function will be invoked when a new message is received at the Service Bus Topic.
     */
    @FunctionName("ServiceBusTopicTriggerJava")
    public void serviceBusHandler(
        @ServiceBusTopicTrigger(
            name = "message",
            topicName = "helloTopic",
            subscriptionName = "subs",
            connection = "connection"
        )
        String message,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Service Bus Topic trigger function executed.");
        context.getLogger().info(message);
    }
}
