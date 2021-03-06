### Prerequisites

- A [Azure Storage](https://azure.microsoft.com/en-us/services/storage/)
- [Azure Storage Explorer](https://azure.microsoft.com/en-us/features/storage-explorer/) (Insert items to Blob Container)

### Steps
1. Go to `project/pom.xml`, replace the value of `resource-group` and `azure-functions-name` with the real value you want.
2. In `azure-functions-maven-plugin` configuration field, repleace the `connectionString` with your Azure Storage's connection string.
3. Run `mvn clean package` under `BlobTrigger` folder to build the project.
4. Run `mvn azure-functions:deploy` to deploy the project, if the function app not exists in Azure, it will create a new one.
5. In this sample, we will listen the path `samples/{fileName}`, so the function will be invoked when a new or updated blob is detected in the blob container named `samples`.
6. In the `Azure Storage Explorer`, insert a file into the target blob container and see if the function get triggered.
