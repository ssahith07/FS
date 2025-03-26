const WebSocket = require('ws');

const ws = new WebSocket.Server({port:8080});
let clients = [];
ws.on('connection',(socket)=>{
    clients.push(socket);
    console.log("Client Connected.");

    socket.on('message',(message)=>{
        console.log("Received");
        message = message.toString();
        for(let client of clients){
            if(client.readyState===WebSocket.OPEN){
                client.send(message);
            }
        }
    })
    socket.on('close',()=>{
        clients = clients.filter((client)=>client!==socket);
    })
});

console.log("WebSocket server started on ws://192.168.5.15:8080");