# Soap-Box
**Please note this is a work in progress**

This project is a proof of concept using docker to run an Angular 4 front-end, a Spring-Boot Java backend, and a MySql database.

## Getting started
To start the application locally for development just run the below command from the project folder:

`docker-compose up`

We use docker-compose to orchestrate the docker containers for the angular 4 client, spring boot server and the mysql database.

### Running in production
In production you will not need to mount a volume for source to be editable so there is a separate `docker-compose.yml` file for this purpose.  You can invoke it with the following command:

`docker-compose -f docker-compose-dev.yml`

## Deploying to production

### Heroku

### AWS

### Openshift V3