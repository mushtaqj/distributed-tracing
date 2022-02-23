const {
  Tracer,
  BatchRecorder,
  jsonEncoder: { JSON_V2 },
} = require("zipkin");

const http = require('http');
const { HttpLogger } = require("zipkin-transport-http");
const zipkinMiddleware = require("zipkin-instrumentation-express").expressMiddleware;
const CLSContext = require('zipkin-context-cls');
const fetch = require('node-fetch');
const wrapFetch = require('zipkin-instrumentation-fetch');

const ctxImpl = new CLSContext('zipkin', true);
const recorder = new BatchRecorder({
  logger: new HttpLogger({
    endpoint: 'http://localhost:9411/api/v2/spans', // Required
    jsonEncoder: JSON_V2,
    agent: new http.Agent({keepAlive: true}), // Agent used for network related options. Optional (defaults to null)
  }),
});
const localServiceName = "Wurth-ESB";
const tracer = new Tracer({ ctxImpl, recorder, localServiceName });
const zipkinFetch = wrapFetch(fetch, {
  tracer,
  localServiceName
})

module.exports = { tracer, zipkinMiddleware, zipkinFetch };
