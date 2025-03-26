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



const mongoose = require('mongoose');
const WebSocket = require('ws');

mongoose.connect("mongodb://localhost:27017/FS").then(() => console.log("Connected to mongoDB"))

const employeeSchema = new mongoose.Schema({
    name : String, 
    salary : Number,
    role : String,
    department: String,
    experience: Number
});

const empModel = mongoose.model('employees' , employeeSchema);

let idCounter = 1;

const server = new WebSocket.Server({port : 8080});


server.on("connection" , (socket) => {
    console.log("Client Connected");

    socket.on("message" , async (event) => {
        const parts = event.toString().split(" ");
        const command = parts[0];
        console.log(parts);

        if(command === "INSERT" && parts.length === 6){
            const name = parts[1];
            const salary = parseInt(parts[2]);
            const role = parts[3];
            const department = parts[4];
            const experience = parseInt(parts[5]);

            const response = await empModel.create({id : idCounter++ , name , salary , role , department , experience});

            socket.send("Employee inserted successfully.");
        } else if(command === "RETRIEVE"){
            const response = await empModel.find({} , {_id : 0 , __v : 0});
            const data = response.map(d => `ID: ${idCounter++}, Name: ${d.name}, Salary: ${d.salary}, Role: ${d.role}, Department: ${d.department}, Experience: ${d.experience} years `).join('\n');
            idCounter = 1;
            socket.send(data);
        } else if(command === "RETRIEVE_BY_DEPT" && parts.length === 2){
            const dept = parts[1];
            const response = await empModel.find({department: dept} , { _id: 0 , __v: 0});
            const data = response.map(d => `ID: ${idCounter++}, Name: ${d.name}, Salary: ${d.salary}, Role: ${d.role}, Department: ${d.department}, Experience: ${d.experience} years `).join('\n');
            idCounter = 1;
            socket.send(data);
            console.log(data);
        } else {
            socket.send("Invalid Command");
        }
    })
})








// const WebSocket = require('ws');
// const mongoose = require('mongoose');
// const cors = require('cors');

// mongoose.connect("mongodb://localhost:27017/")
// .then(()=>console.log("connected to monogodb"))
// .catch((err)=>console.log("connection error.",err))

// const EmployeeSchema = mongoose.Schema({
//     name: String,
//     salary: Number,
//     role: String,
//     department: String,
//     experience: Number
// });

// const Employee = mongoose.model("Employee",EmployeeSchema);

// const ws = new WebSocket.Server({port:8080});
// let i=1;
// ws.on('connection',(socket)=>{
//     console.log("Connected");
    
//     socket.on('message',async (message)=>{
//         message = message.toString();
//         console.log(message);
//         const parts = message.split(" ");
//         console.log(parts);
//         if(parts[0]=='INSERT' && parts.length==6){
//             const name = parts[1];
//             const salary = parseInt(parts[2]);
//             const role = parts[3];
//             const department = parts[4];
//             const experience = parseInt(parts[5]);
//             const emp = {
//                 ID:i++,
//                 name:name,
//                 salary:salary,
//                 role:role,
//                 department:department,
//                 experience:experience,
//             }
//             console.log(emp);
//             const employee = new Employee(emp);
//             await employee.save();
//         }
//         else if(parts[0]=='RETRIEVE'){
//             const allEmp = Employee.find({},{__v:0,id:0});
//             console.log(allEmp);
//         }
//     });

//     socket.on('close',()=>{
//         console.log("Connection closed serverENd");
//     })
// });
// console.log('WebSocket server started on ws://192.168.5.15:8080');