Чтобы сбилдить любой сервис,
нужно создать в IDEA соответствующую конфигурацию
в Project Structure / Artifacts

Собрал jar файлы в папку artifacts

Чтобы запустить все локально, делаю:

1. build dataservice и loginservice

```bash
docker build -t nickzay/dataservice -f ./dockerfiles/DataServiceDockerfile .
docker build -t nickzay/loginservice -f ./dockerfiles/LoginServiceDockerfile .
```

2. push

3. запуск docker-compose.yml


Просто запуски
```bash
docker run --name loginservcice -p 8888:8888 -e DATA_SERVICE_URL=http://localhost:7777/ nickzay/loginservice
docker run --name postgres_container -e POSTGRES_PASSWORD=secret -e POSTGRES_USER=postgres -d -p 5433:5432 postgres
```
