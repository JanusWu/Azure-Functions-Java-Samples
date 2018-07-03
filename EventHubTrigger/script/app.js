const eventHubClient = require("azure-event-hubs").EventHubClient;
const config = require("./config");

async function main() {
  const client = eventHubClient.createFromConnectionString(config.connectionString, config.eventHubName);
  const data = {
    body: "Hello World!!"
  };
  const delivery = await client.send(data);
  console.log(">>> Sent the message successfully: ", delivery.id);
}

main().catch((err) => {
  console.log("error: ", err);
});