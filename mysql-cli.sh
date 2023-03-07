#! /bin/bash -e

docker run $* \
   --name mysqlterm --rm --network=shopiny-backend \
   mysql/mysql-server:8.0.27-1.2.6-server  \
   mysql -hmysql -P3306 -uroot -prootpassword
