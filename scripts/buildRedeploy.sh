#!/bin/sh

echo "************ UNDEPLOYING *******************"
asadmin undeploy cars
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
asadmin deploy target/cars.war
