# Nation Beatdown Server Project

The server part of my master project for the game design masters at the Zurich University of Arts. It contains a small microservices based on Spring Cloud for the corresponding game "Nation Beatdown" which is a private repository. 

## Requirements

For building and running the project the following tools are needed:


* OpenJDK 11 or higher
* Maven 3 or higher
* Docker Runtime and Docker Compose (Docker Toolbox is not supported)

The tools must be properly installed and the environment variables must be properly defined

## Build project


The project can be built as follows:

mvn clean install -DskipTests=true


Maven will download and install all needed dependencies automatically. After that it will build the project.
The built jar files will be copied to the target subfolders of each service.


## Start the containers

To start the cluster you only need to execute the following command:


docker-compose up


The docker runtime will download the base image, copy the jar files, and the corresponding config files.




## Access the services

The services can be accessed via nginx reverse proxy by calling localhost/api/rest/v1/<service-name>.

The ports can be changed in the docker-compose.yml file.


## Stop the containers

The containers can be stopped by executing:

docker-compose down


