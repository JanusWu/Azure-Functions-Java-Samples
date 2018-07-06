package com.azure.functions.samples;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Azure Storage Queue trigger.
 */
public class Queue {
    /**
     * This function will be invoked when a new message is received at the specified path. The message contents are provided as input to this function.
     */
    @FunctionName("Queue")
    public void queueHandler(
        @QueueTrigger(name = "message", queueName = "sample", connection = "connection") String message,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Queue trigger function processed a message: " + message);
    }
}
