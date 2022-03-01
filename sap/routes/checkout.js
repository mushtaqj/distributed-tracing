const app = require("express");

const router = app.Router();

router.post("/", async (req, resp) => {
  const delay = (ms) => new Promise((resolve) => setTimeout(resolve, ms));
  const delayTime = Math.floor(10000 * Math.random());
  await delay(delayTime);

  const sapOrder = req.body;
  sapOrder.orderId = Math.floor(100000 + Math.random() * 900000);

  console.log({ sapOrder });
  resp.send(sapOrder);
});

module.exports = router;
