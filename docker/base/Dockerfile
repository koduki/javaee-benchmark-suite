FROM centos:centos7
MAINTAINER koduki

#
# set repositories
#
RUN yum update -y

#
# Install default packages
#
RUN yum install -y \
  sudo\
  passwd\
  syslog\
  wget\
  rsync\
  unzip\
  nkf\
  telnet\
  tar

#
# operation user
#
RUN useradd docker
RUN passwd -f -u docker
RUN usermod -s /bin/zsh docker
RUN echo "docker    ALL=(ALL)       ALL" >> /etc/sudoers.d/docker

#
# App Dir
#
RUN echo 'export PATH=/usr/local/bin:$PATH' >> /root/.bashrc
