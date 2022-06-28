# RestCRUD Project
This project includes basic CRUD operations using H2 db with quarkus

# Adding Extensions to projec
For CRUD operations we will need following extensions to be added, you can execute following line in terminal to add extensions

```mvn quarkus:add-extension -Dextension="quarkus-jdbc-h2, quarkus-hibernate-orm-panache, quarkus-smallrye-openapi"```

Note*: I have already added these in pom.xml so you dont have to execute it for this sample

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

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/RestCRUD-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Testing the application
```localhost:8080/product ```
```curl -d '{"name": "Iphone 10", "quantity": 10}' -H "Content-Type: application/json" http://localhost:8080/product ```