FROM koduki/base
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

# RUN stress test
WORKDIR /opt/gatling2/bin
CMD ["./gatling.sh", "-m", "-s", "RecordedSimulation"]
