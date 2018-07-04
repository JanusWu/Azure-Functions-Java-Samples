### Prerequisites

- A [Service Bus](https://azure.microsoft.com/en-us/services/service-bus/)
- Node.js (send message to Service Bus Topic)

### Steps
1. Go to `project/pom.xml`, replace the value of `resource-group` and `azure-functions-name` with the real value you want.
2. In `azure-functions-maven-plugin` configuration field, repleace the `connectionString` with your Service Bus's connection string.
3. In `project/src/main/java/com/azure/functions/samples/ServiceBusTopic.java`, you can replace the value of topicName and subscriptionName according to your requirement, here we will use a topic named `helloTopic` with a subscription named `subs`.
4. Run `mvn clean package` under `project` folder to build the project.
5. Run `mvn azure-functions:deploy` to deploy the project, if the function app not exists in Azure, it will create a new one.
6. Go to `script/` folder, run `npm install`.
7. In `messageProducer.js`, fill your Service Bus's connection string in `azure.createServiceBusService("")`.
8. Start the script by `node messageProducer.js`, enter some message
9. See if your function can be triggered.

