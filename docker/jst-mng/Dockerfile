FROM koduki/centos7
MAINTAINER koduki

# Build tools
RUN yum -y install git maven java

# Install Gatling
ADD resources/install-gatling.sh /tmp/
RUN /tmp/install-gatling.sh
ADD resources/RecordedSimulation.scala /opt/gatling2/user-files/simulations/RecordedSimulation.scala

# Install Jenkins
ADD resources/install-jenkins.sh /tmp/
RUN /tmp/install-jenkins.sh

# Install Fluentd
ADD resources/install-fluentd.sh /tmp/
RUN /tmp/install-fluentd.sh
ADD resources/fluent.conf /etc/fluent/fluent.conf

# Install Consul
ADD resources/install-consul.sh /tmp/
RUN /tmp/install-consul.sh
ADD resources/consul.d/fluent.json /etc/consul/conf.d/

# Fluentd port
EXPOSE 24224 

# Run Jenkins
EXPOSE 8000
EXPOSE 8686
#USER jenkins
USER root

RUN mkdir -p /var/lib/jenkins/jobs/simple-test01
ADD resources/simple-test01/config.xml /var/lib/jenkins/jobs/simple-test01/config.xml
WORKDIR /var/lib/jenkins
ADD resources/run.sh /tmp/
ENTRYPOINT /tmp/run.sh
