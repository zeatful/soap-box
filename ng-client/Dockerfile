FROM node:6

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . /usr/src/app

EXPOSE 4200

# Ensure that we install new dependencies everytime we start the container in addition to starting the app
ENTRYPOINT npm install && npm start