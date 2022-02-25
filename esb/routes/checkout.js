const app = require("express");
const fetch = require("node-fetch");

const router = app.Router();

router.get("/", async (req, resp) => {
  const response = await fetch("https://jsonplaceholder.typicode.com/todos/1");
  const data = await response.json();

  resp.send(data);
});

router.post("/", async (req, resp) => {

  const response = await fetch("http://localhost:4000/checkout",{
    method : 'POST',
    body: JSON.stringify(req.body),
    headers : {'Content-Type' : 'application/json'}
  })

  const esbOrder = await response.json();
  console.log({esbOrder});

  resp.send(esbOrder);
});


module.exports = router;
