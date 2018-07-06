### Steps
1. Go to `project/pom.xml`, replace the value of `resource-group` and `azure-functions-name` with the real value you want.
2. Run `mvn clean package` under `HttpTrigger` folder to build the project.
3. Run `mvn azure-functions:deploy` to deploy the project, if the function app not exists in Azure, it will create a new one.
4. Since the schedule we are using in the example is `0 */1 * * * *`, you can observe that the function will be triggered every 1 minute.
