## TASK 1
Чтобы сбилдить любой сервис,
нужно прогнать gradle
Например `gradle build`


1. build images: dataservice и loginservice

```bash
docker build -t nickzay/dataservice -f ./dockerfiles/DataServiceDockerfile .
docker build -t nickzay/loginservice -f ./dockerfiles/LoginServiceDockerfile .
```

2. push
```bash
docker push nickzay/dataservice
docker push nickzay/loginservice 
```

3. запуск docker-compose
```bash
docker-compose -f docker-compose-local.yml up
```

Запуски для локального тестирования
```bash
docker run --name dataservcice --rm -p 7777:7777 -e SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5433/postgres -e SPRING_DATASOURCE_USERNAME=postgres -e SPRING_DATASOURCE_PASSWORD=secret nickzay/dataservice
docker run --name loginservcice -p 8888:8888 -e DATA_SERVICE_URL=http://localhost:7777/ nickzay/loginservice
docker run --name postgres_container -e POSTGRES_PASSWORD=secret -e POSTGRES_USER=postgres -d -p 5433:5432 postgres
```

## TASK 2
Конфигурация ansible
1. node
```bash
docker pull ubuntu
docker run -dit --name node ubuntu /bin/bash
docker attach node
apt update ; apt install ssh vim -y
passwd root
vim /etc/ssh/sshd_config
# #PermitRootLogin prohibit-password ->
# PermitRootLogin yes
service ssh restart
service ssh start
```
2. master
```bash
docker run -dit --name master ubuntu /bin/bash
docker attach master
apt update ; apt update ; apt install python3 ansible openssh-client vim iputils-ping -y
ping 172.17.0.3
ssh-keygen
ssh-copy-id root@172.17.0.3
ssh 'root@172.17.0.3'
logout
mkdir -p vim /etc/ansible/
vim /etc/ansible/hosts
# [machine]
# 172.17.0.3
ansible -m ping machine
```

Плейбуки находятся в папке ansible

## TASK 3
запуск docker-compose.yml
```bash
docker-compose -f docker-compose-jenkins.yml up
```
