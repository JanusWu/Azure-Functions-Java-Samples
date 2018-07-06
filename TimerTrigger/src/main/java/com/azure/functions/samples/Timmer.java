package com.azure.functions.samples;

import java.time.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Timer trigger.
 */
public class Timmer {
    /**
     * This function will be invoked periodically according to the specified schedule.
     */
    @FunctionName("Timmer")
    public void timerHandler(
        @TimerTrigger(name = "timerInfo", schedule = "0 */1 * * * *") String timerInfo,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Timer trigger function executed at: " + LocalDateTime.now());
    }
}
