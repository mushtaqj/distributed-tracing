const app = require("express");
const fetch = require("node-fetch");
const dateFns = require('date-fns');
const { zipkinFetch } = require('../middleware/zipkin');

const router = app.Router();

router.get("/", async (req, resp) => {
  const response = await fetch("https://jsonplaceholder.typicode.com/todos/1");
  const data = await response.json();

  resp.send(data);
});

router.post("/", async (req, resp) => {
  const dateTime = dateFns.format(new Date(), 'dd-MMM-yy H:mm:ss');
  console.log(`${dateTime} Hopping through the ESB ~`);

  const response = await zipkinFetch("http://localhost:4000/checkout",{
    method : 'POST',
    body: JSON.stringify(req.body),
    headers : {'Content-Type' : 'application/json'}
  })

  const esbOrder = await response.json();
  console.log({esbOrder});

  resp.send(esbOrder);
});


module.exports = router;
