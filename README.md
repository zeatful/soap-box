# Soap-Box
**Please note this is a work in progress**

This project is a proof of concept using docker to run an Angular 4 front-end, a Spring-Boot Java backend, and a MySql database.

## Getting started
To start the application locally for development just run the below command from the project folder:

`docker-compose up`

docker-compose orchestrates the docker containers for the Angular 4 client, Spring-Boot server and the MySql database.

### Running in production
In production you will not need to mount a volume for source to be editable so there is a separate `docker-compose.yml` file for this purpose.  You can invoke it with the following command:

`docker-compose -f docker-compose-prod.yml`

## Deploying to production

### Heroku

### AWS

### Openshift V3