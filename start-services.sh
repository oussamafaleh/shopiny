#! /bin/bash -e

docker-compose up -d --build

./wait-for-mysql.sh

docker-compose up -d --build

echo -n waiting for the services to start...

./wait-for-services.sh
