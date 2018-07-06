### Steps
1. Go to `project/pom.xml`, replace the value of `resource-group` and `azure-functions-name` with the real value you want.
2. Run `mvn clean package` under `HttpTrigger` folder to build the project.
3. Run `mvn azure-functions:deploy` to deploy the project, if the function app not exists in Azure, it will create a new one.
4. Use whatever tools you want to send an Http request to the function. take `curl` as an example:
- Request with post body
```
curl -d "world" {your host}/api/${function-name}
```
- Request with query string
```
2. curl {your host}/api/${function-name}?name=world
```
