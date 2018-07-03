'use strict';
console.log();
console.log('Azure Cosmos DB Node.js Samples');
console.log('================================');
console.log();
console.log('DOCUMENT MANAGEMENT');
console.log('===================');
console.log();

var DocumentDBClient = require('documentdb').DocumentClient
  , config = require('./config')
  , fs = require('fs')
  , async = require('async')
  , databaseId = config.names.database
  , collectionId = config.names.collection
  , dbLink
  , collLink;

var host = config.connection.uri;
var masterKey = config.connection.key;

var documentDefinitions = function () {
    var data = fs.readFileSync('./Families.json');   
    return JSON.parse(data).Families;
};

var client = new DocumentDBClient( host, { masterKey: masterKey });

init(function (err) {
    if (!err) {
        dbLink = 'dbs/' + databaseId;
        console.log(dbLink);
        
        collLink = dbLink + '/colls/' + collectionId;
        console.log(collLink);

        console.log('\n1. insertDocuments in to database \'' + databaseId + '\' and collection \'' + collectionId + '\'');
        insertDocuments(collLink, function (docs) {
            console.log(docs.length + ' docs created');
        });
    }
});


function init(callback) {
    getOrCreateDatabase(databaseId, function (db) {
        getOrCreateCollection(db._self, collectionId, function (coll) {
            callback();
        });
    });
}

function insertDocuments(collLink, callback) {
    var createdList = [];

    async.each(
        documentDefinitions(), 
        
        function iterator(documentDefinition, cb) {
            client.createDocument(collLink, documentDefinition, function (err, document) {
                if (err) {
                    console.log(err);

                } else {
                    console.log('created ' + document.id);
                    createdList.push(document);
                    cb();
                }
            });
        },

        function (err) {
            console.log('iterating done ' + createdList.length);
            callback(createdList);
        }
    );
}

function deleteDatabase(dbLink) {
    client.deleteDatabase(dbLink, function (err) {
        if (err) {
            handleError(err);
        }
    });
}

function getOrCreateCollection(dbLink, id, callback) {
    var querySpec = {
        query: 'SELECT * FROM root r WHERE r.id=@id',
        parameters: [
            {
                name: '@id',
                value: id
            }
        ]
    };
    
    client.queryCollections(dbLink, querySpec).toArray(function (err, results) {
        if (err) {
            handleError(err);

        } else if (results.length === 0) {
            var collDef = { id: id };
            
            client.createCollection(dbLink, collDef, function (err, created) {
                if (err) {
                    handleError(err);
                
                } else {                    
                    callback(created);
                }
            });

        } else {
            callback(results[0]);
        }
    });
}

function getOrCreateDatabase(id, callback) {
    var querySpec = {
        query: 'SELECT * FROM root r WHERE r.id=@id',
        parameters: [
            {
                name: '@id',
                value: id
            }
        ]
    };
    
    client.queryDatabases(querySpec).toArray(function (err, results) {
        if (err) {
            handleError(err);

        } else if (results.length === 0) {
            var databaseDef = { id: id };
            
            client.createDatabase(databaseDef, function (err, created) {
                if (err) {
                    handleError(err);
                
                } else {                    
                    callback(created);
                }
            });
        
        } else {
            callback(results[0]);
        }
    });
}

function handleError(error) {
    console.log('\nAn error with code \'' + error.code + '\' has occurred:');
    console.log('\t' + JSON.parse(error.body).message);
    
    finish();
}

function finish() {
    deleteDatabase(dbLink);
    console.log('\nEnd of demo.');
}