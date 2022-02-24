# Distributed tracing POC

Mimics a microservice/distributed architecture environment in which we wish to distributed tracing.

## Zipkin

The traces have been ported to zipkin and all implementations use the zipkin library for integrations and extensions.

You will need to have the zipkin server locally running. Easiest way to do it is to run the zipkin docker container

Using Docker

```bash
docker run -d -p 9411:9411 openzipkin/zipkin
```

Using Java

If you have Java 8 or higher installed, the quickest way to get started is to fetch the latest release as a self-contained executable jar:

```bash
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar
```

## Open Telemetry

We will switch this to open telemetry to find more be portable and expand to multiple other reporters
like New Relic, jaeger etc ...

## How to Run

- Node Modules : ESB, SAP
- PIM : PHP
- Elastic Path : Spring boot (Java)

### Node Modules

ESB & SAP are written in node with express you will need a to have npm installed. Once you have set the envirnment run the command

```bash
npm run start
```

### PHP

PIM is written in PHP any version of PHP above 5.6 will work and you will also need composer in your path.

```bash
composer run serve
```

### Spring boot

Elastic path is written in Java 8 and you will need to have it installed and the package manage is maven 3.5.2. Just run

Build the App first

```bash
mvn clean install
```

Run the app

```bash
mvn spring-boot:run
```

## Plans

- Dockerize
- Switch to open telemetry
- Export to Jaeger
- Export to New Relic
- Introduce Metrics
