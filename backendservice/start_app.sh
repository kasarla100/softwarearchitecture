#!/bin/sh
echo "Building and Running docker image"
docker build --tag backendservice .
docker run -d -p 5000:5000 backendservice
docker ps
