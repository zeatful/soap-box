FROM node:6

COPY . /usr

WORKDIR /usr/src/app

EXPOSE 4200

# Ensure that we install new dependencies everytime we start the container in addition to starting the app
ENTRYPOINT npm install && npm start