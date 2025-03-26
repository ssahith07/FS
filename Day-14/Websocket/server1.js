// <!--

// Real-Time Group Chat using WebSockets

// You are required to build a real-time group chat application using WebSockets, 
// where multiple users (clients) can join a chatroom and exchange messages in 
// real-time. The application must consist of a WebSocket server and a browser-based 
// client. All messages sent by any client must be visible to all other connected 
// clients, including the sender — similar to a WhatsApp group.


// Functional Requirements:

// 1. WebSocket Server (Node.js):
// ------------------------------
// You must implement a WebSocket server with the following behavior:
// 	- Accept connections from multiple clients.
// 	- Maintain a list of all connected clients.
// 	- When a message is received from any client:
// 		- Broadcast that message to all connected clients.
// 	- Handle client disconnections and remove them from the active list.

// Use the ws npm package to create the server. The server should run on ws://localhost:8080.

// 2. Web-based Client (HTML + JavaScript):
// ----------------------------------------
// You must create a basic client interface with the following requirements:
// 	- Connect to the WebSocket server at ws://localhost:8080.
// 	- The page should have:
// 		- A <div> with id="chat" that shows all chat messages.
// 		- An <input> box with id="msg" to type the message.
// 		- A <button> that, when clicked, sends the message.
// 	- When a message is received from the server:
// 		- It must be displayed as a new paragraph <p> inside the #chat area.
// 	- When the user sends a message:
// 		- It should be sent to the server using WebSocket.
// 		- The input box should be cleared after sending.
        
// ================================================================================		
// Example URL value=>   http://192.168.xx.xx:5500/index.html

// -->

// <config>
//     <url value="http://192.168.5.15:5501/client1.html"></url>
// </config>

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