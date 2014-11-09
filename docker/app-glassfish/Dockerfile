FROM koduki/base
MAINTAINER koduki

# Install Oracle JDK
ADD resources/install-oracle-jdk8.sh /tmp/
RUN /tmp/install-oracle-jdk8.sh

# Install GlassFish
ADD resources/install-glassfish.sh /tmp/
RUN /tmp/install-glassfish.sh

#
# Configurate GlassFish
#

# set glassfish user and workdir
USER glassfish
WORKDIR /opt/glassfish4/bin

# User: admin / Pass: glassfish
RUN echo "admin;{SSHA256}80e0NeB6XBWXsIPa7pT54D9JZ5DR5hGQV1kN1OAsgJePNXY6Pl0EIw==;asadmin" > /opt/glassfish4/glassfish/domains/domain1/config/admin-keyfile
RUN echo "AS_ADMIN_PASSWORD=glassfish" > pwdfile

# Default to admin/glassfish as user/pass
RUN \
  ./asadmin start-domain && \
  ./asadmin --user admin --passwordfile pwdfile enable-secure-admin && \
  ./asadmin stop-domain

# JDBC
RUN \
  ./asadmin start-domain && \
  ./asadmin --user admin --passwordfile=pwdfile -I false create-jdbc-connection-pool --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --restype javax.sql.DataSource --property user=docker:password=password:url='jdbc\:mysql\://docker_db_1\:3306/testdb' MySQLPool && \
  ./asadmin --user admin --passwordfile=pwdfile -I false create-jdbc-resource --connectionpoolid MySQLPool jdbc/testdb && \
  ./asadmin stop-domain

# default glassfish ports
EXPOSE 4848 8080 8181

#
# RUN GlassFish
#
CMD ["/opt/glassfish4/glassfish/bin/asadmin", "start-domain", "--verbose=true"]
