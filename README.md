# delivery
$ docker run -d --name postgres-delivery -p 5432:5432 -e POSTGRES_DB=delivery -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=asdasd123 -e TZ=Europe/Kiev   postgres:latest
