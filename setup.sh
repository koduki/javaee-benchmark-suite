#!/bin/bash

#
# install packages
#

# yum installs
sudo yum install -y \
  zsh \
  unzip \
  wget \
  docker \
  git



#
# Disable SELinux
#
sudo sed -i -e s/SELINUX=enforcing/SELINUX=disabled/g /etc/selinux/config

#
# Install docker and fig
#

# install docker
sudo sh -c "curl -L https://raw.githubusercontent.com/docker/docker/master/contrib/init/systemd/docker.service > /etc/systemd/system/"
sudo sh -c "curl -L https://raw.githubusercontent.com/docker/docker/master/contrib/init/systemd/docker.socket > /etc/systemd/system/"
sudo sh -c "curl -L https://get.docker.io/builds/Linux/x86_64/docker-latest > /usr/bin/docker"

sudo chmod +x /etc/systemd/system/docker.service
sudo chmod +x /etc/systemd/system/docker.socket
sudo chmod +x /usr/bin/docker

sudo systemctl enable docker
sudo systemctl start docker

# install fig
sudo sh -c "curl -L https://github.com/docker/fig/releases/download/0.5.2/linux > /usr/bin/fig"
sudo chmod +x /usr/bin/fig

#
# configurate home settings.
#
sudo usermod -s /usr/bin/zsh vagrant
GIT_DIR="/home/vagrant/git/"
mkdir -p ${GIT_DIR}

cd ${GIT_DIR}
git clone git@github.com:koduki/homebase.git
ln -s /home/vagrant/git/homebase/.zshrc.mine ${HOME}/
ln -s /home/vagrant/git/homebase/.zshrc ${HOME}/
ln -s /home/vagrant/git/homebase/.gitconfig ${HOME}/

# install projects
cd ${GIT_DIR}
git clone git@github.com:koduki/docker.git
