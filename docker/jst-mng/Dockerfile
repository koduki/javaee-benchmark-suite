FROM koduki/centos7
MAINTAINER koduki

# Build tools
RUN yum -y install git maven java

# Install Gatling
RUN \
   cd /tmp && \
   wget http://repo1.maven.org/maven2/io/gatling/highcharts/gatling-charts-highcharts/2.0.2/gatling-charts-highcharts-2.0.2-bundle.zip  && \
   unzip gatling-charts-highcharts-2.0.2-bundle.zip && \
   mv gatling-charts-highcharts-2.0.2 /opt/gatling2

RUN rm -rf /opt/gatling2/user-files/simulations/computerdatabase/
ADD resources/RecordedSimulation.scala /opt/gatling2/user-files/simulations/RecordedSimulation.scala

# Install Jenkins
ADD resources/install-jenkins.sh /tmp/install-jenkins.sh
RUN /tmp/install-jenkins.sh

# Run Jenkins
EXPOSE 8000
EXPOSE 8686
USER jenkins

RUN mkdir -p /var/lib/jenkins/jobs/simple-test01
ADD resources/simple-test01/config.xml /var/lib/jenkins/jobs/simple-test01/config.xml
WORKDIR /var/lib/jenkins
ENTRYPOINT ["java", "-DJENKINS_HOME=/var/lib/jenkins", \
  "-jar", "/usr/lib/jenkins/jenkins.war", \
  "--webroot=/var/cache/jenkins/war", "--httpPort=8000"]
