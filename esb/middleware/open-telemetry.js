const opentelemetry = require("@opentelemetry/sdk-node");
const { getNodeAutoInstrumentations } = require("@opentelemetry/auto-instrumentations-node");
const {ZipkinExporter} = require('@opentelemetry/exporter-zipkin');
const { SemanticResourceAttributes } = require('@opentelemetry/semantic-conventions');
const { Resource } = require('@opentelemetry/resources');

const zipkinExporter = new ZipkinExporter({
  url : 'http://localhost:9411/api/v2/spans'
});

const sdk = new opentelemetry.NodeSDK({
  resource: new Resource({
    [SemanticResourceAttributes.SERVICE_NAME] : 'Wurth-ESB'
  }),
  traceExporter : zipkinExporter,
  instrumentations: [getNodeAutoInstrumentations()]
});

module.exports = { sdk };
