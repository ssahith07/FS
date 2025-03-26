const WebSocket = require('ws');

const ws = new WebSocket('ws://192.168.5.15:8080');

ws.on('open',()=>{
    console.log("Connected to server.");
    ws.send('INSERT Alice 50000 Developer IT 5');
    // ws.send('RETRIEVE');
})

ws.on('message',(data)=>{
    console.log("Received from server",data);
});

ws.on('close',()=>{
    console.log("connection closed.");
});

ws.on('error', (error) => {
    console.error(`WebSocket error: ${error}`);
});
  