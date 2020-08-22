The aim of the project is to build an api for a client (browser/mobile) to fetch restaurants within a given area and a particular time.

The data's about the restaurant are in json format. So to access them and use them in our project, we inserted the data's to mongodb.

We inserted the json file in mongodb with the help of the following query:

mongoimport --jsonArray --db database_name --collection collection_name --file file_name.json