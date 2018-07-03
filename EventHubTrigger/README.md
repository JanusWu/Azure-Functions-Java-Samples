### Prerequisites

- An [Event Hub](https://azure.microsoft.com/en-us/services/event-hubs/)
- Node.js (send message to Service Bus queue)

### Steps
1. Go to `project/pom.xml`, replace the value of `resource-group` and `azure-functions-name` with the real value you want.
2. In `azure-functions-maven-plugin` configuration field, repleace the `connectionString` with your Service Bus's connection string.
3. Find your Event Hubs Namespace in Azure Portal. Create a new Event Hub `myHub`. It's the name we will use in the function example.
4. Run `mvn clean package` under `project` folder to build the project.
5. Run `mvn azure-functions:deploy` to deploy the project, if the function app not exists in Azure, it will create a new one.
6. Go to `script/` folder, run `npm install`.
7. In `config.js`, fill your Event Hub's connection string.
8. Run `node app.js`, the program will send a message into your Event Hub.
9. See if your function can be triggered.
