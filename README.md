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

3. запуск docker-compose.yml
```bash
docker-compose up
```

Запуски для локального тестирования
```bash
docker run --name dataservcice --rm -p 7777:7777 -e SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5433/postgres -e SPRING_DATASOURCE_USERNAME=postgres -e SPRING_DATASOURCE_PASSWORD=secret nickzay/dataservice
docker run --name loginservcice -p 8888:8888 -e DATA_SERVICE_URL=http://localhost:7777/ nickzay/loginservice
docker run --name postgres_container -e POSTGRES_PASSWORD=secret -e POSTGRES_USER=postgres -d -p 5433:5432 postgres
```
