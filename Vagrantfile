# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "centos7"

  config.vm.define :dev do |server|
    server.vm.network :private_network, ip: "192.168.56.10"
    server.vm.synced_folder ".", "/vagrant"
  end
end
