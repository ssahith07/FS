const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const PORT = 4000;

const app = express();
app.use(cors())

app.use(express.json());
// app.use(bodyParser.json());

let orders = [
    { 
        id: 1,
        customerName: "Azar",
        totalPrice: 150.0
    },
    { 
        id: 2,
        customerName: "Abbas",
        totalPrice: 550.0
    }
]

app.get("/orders", (req,res)=>{
    res.json(orders);
});

app.get("/orders/:id",(req,res)=>{
    const userId = parseInt(req.params.id);
    const order = orders.find(u=>u.id===userId);
    if (order) {
      res.json(order);
    }else{
        res.status(404).send();
    }
});

app.post("/orders",(req,res)=>{
    const order = req.body;
    const newOrder = {
        id : orders.length+1,
        ...order
    };
    orders.push(newOrder);
    res.status(201).send(newOrder);
})

app.put("/orders/:id",(req,res)=>{
    const oid = parseInt(req.params.id);
    const order = orders.find(o=>o.id===oid);
    const newOrder = req.body;
    console.log(order)
    if(order){
        orders.push(newOrder);
        res.send(newOrder);
    }else{
        res.status(404).send();
    }
    orders.pop(order);
});

app.delete("/orders/:id",(req,res)=>{
    const oid = parseInt(req.params.id);
    const order = orders.find(o=>o.id===oid);
    const delOrder = orders.pop(order.id);
    if(delOrder){
        res.status(200).send()
    }
});

app.listen(PORT,()=>{
    console.log(`Server running on http://localhost:${PORT}`);
})