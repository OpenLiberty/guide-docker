#!/bin/bash
set -euxo pipefail

##############################################################################
##
##  Travis CI test script
##
##############################################################################

mvn -q clean install

docker pull openliberty/open-liberty:kernel-java8-openj9-ubi

docker build -t ol-runtime .

docker run -d --name rest-app \
  -p 9080:9080 -p 9443:9443 \
  -v $(pwd)/target/liberty/wlp/usr/servers:/servers \
  -u `id -u` ol-runtime

sleep 60

status="$(curl --write-out "%{http_code}\n" --silent --output /dev/null "http://localhost:9080/system/properties-new")"
if [ "$status" == "200" ]
then
  echo ENDPOINT OK
else
  echo "$status_code"
  echo ENDPOINT NOT OK
  exit 1
fi

docker stop rest-app

docker rm rest-app
