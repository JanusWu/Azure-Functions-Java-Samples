package com.azure.functions.samples;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Azure Blob trigger.
 */
public class Blob {
    /**
     * This function will be invoked when a new or updated blob is detected at the specified path. The blob contents are provided as input to this function.
     */
    @FunctionName("Blob")
    @StorageAccount("connection")
    public void blobHandler(
        @BlobTrigger(name = "content", path = "samples/{fileName}", dataType = "binary") byte[] content,
        @BindingName("fileName") String name,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Blob trigger function processed a blob. Name: " + name + "\n  Size: " + content.length + " Bytes");
    }
}
