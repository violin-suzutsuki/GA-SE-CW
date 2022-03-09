FROM mysql
COPY world.sql /docker-entrypoint-initdb.d
WORKDIR /tmp
ENV MYSQL_ROOT_PASSWORD example