#!/usr/bin/env bash
#!/bin/bash
echo "=================Removing target before making assembly==========="
rm -rf ../chapter5/target && rm -rf docker/*
echo "=================Entering the akka-cookbook directory and creating assembly====="
cd ../ && sbt assembly
echo "=================Coming back to dockerApp directory ================="
cd -
echo "====creating docker directory======"
sudo mkdir -p docker
echo "=====created docker directory successfully========"
echo "======Copying application jar to docker jar============"
sudo cp ../chapter5/target/scala-2.12/chapter5-assembly-1.0.jar docker/
echo "============Building docker Image====================="
sudo docker build -t akkapp .
echo "==============Running docker container ================"
sudo docker run -d akkapp
