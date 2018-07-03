### Prerequisites

- A [Service Bus](https://azure.microsoft.com/en-us/services/service-bus/)
- Node.js (send message to Service Bus queue)

### Steps
1. Go to `project/pom.xml`, replace the value of `resource-group` and `azure-functions-name` with the real value you want.
2. Run `mvn clean package` under `EventGridTrigger` folder to build the project.
3. Run `mvn azure-functions:deploy` to deploy the project, if the function app not exists in Azure, it will create a new one.
4. Follow this [link](https://docs.microsoft.com/en-us/azure/azure-functions/functions-bindings-event-grid#create-a-subscription) to enable the Event Grid Trigger. For example, you can create a Web Hook subscriber, and then using [Postman](https://www.getpostman.com/) to [manually trigger it](https://docs.microsoft.com/en-us/azure/azure-functions/functions-bindings-event-grid#manually-post-the-request).

