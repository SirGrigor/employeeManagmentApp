#!/bin/sh
#mvn clean install -DskipTests

echo "Install mvn"
mvn package -Dmaven.test.skip

echo "Copying file"
cp ./target/employeeManagmentApp-0.0.1-SNAPSHOT.jar src/main/deployment

echo "Run docker-compose"
cd ./src/main/deployment
docker compose up --build