#!/bin/bash

URL=http://dlc.sun.com.edgesuite.net/glassfish/4.1/release/glassfish-4.1.zip

# install
cd /opt/
wget -qO- -O tmp.zip $URL
unzip tmp.zip
rm tmp.zip 

# change permission
useradd glassfish
chown -R glassfish:glassfish /opt/glassfish4/
