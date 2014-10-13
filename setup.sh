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

# install fig
sudo sh -c "curl -L https://github.com/docker/fig/releases/download/0.5.2/linux > /usr/local/bin/fig"
sudo chmod +x /usr/local/bin/fig

#
# Disable SELinux
#
sudo sed -i -e s/SELINUX=enforcing/SELINUX=disabled/g /etc/selinux/config

#
# configurate docker
#
sudo systemctl enable docker
sudo systemctl start docker

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
