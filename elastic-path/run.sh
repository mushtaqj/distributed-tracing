#!/bin/zsh

java -javaagent:otel/opentelemetry-javaagent.jar \
  -Dotel.service.name=wurth-elasticpath \
  -Dotel.traces.exporter=zipkin \
  -jar target/*.jar
