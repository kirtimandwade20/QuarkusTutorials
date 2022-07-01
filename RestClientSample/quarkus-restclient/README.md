# quarkus-restclient Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.
1) This contains sample for invoking Third Party Rest API Using Quarkus
    Check thte FruityViceService for the implementation, also we need to add the api-url in application.properties.

 2) Fault Tolerance
  Fault tolerance implemented using Circuitbreaker and Fault tolerance annotations provided by quarkus

 3) HealthCheck
    Health check is implemented for checking healthcheck of resources and the 3rd party API's.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

## Testing

Post Request
``` curl -d '{"name": "Banana", "season": "Summer"}' -H "Content-Type: application/json" http://localhost:8080/fruit ```

Response

```
 {"id":1,"name":"Banana","season":"Summer"} 
```

Get Request

```
http://localhost:8080/fruit?season=Summer
```
Response:
```
[{"calories":96.0,"carbohydrates":22.0,"name":"Banana","season":"Summer"},{"calories":52.0,"carbohydrates":11.4,"name":"Apple","season":"Summer"}]
```

HealthCheck
You can check health metrics using 
```
http://localhost:8080/q/health-ui/
```
Getting all health metrics

``` 
http://localhost:8080/health 
```

Response

```
{
    "status": "UP",
    "checks": [
        {
            "name": "I'm alive",
            "status": "UP"
        },
        {
            "name": "Database connections health check",
            "status": "UP"
        },
        {
            "name": "ExternalURL health check",
            "status": "UP",
            "data": {
                "host": "GET https://www.fruityvice.com/api/fruit/banana"
            }
        }
    ]
}
```
