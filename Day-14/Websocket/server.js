const WebSocket = require('ws');

const wss = new WebSocket.Server({ port: 8080 });

let employees = [];
let employeeId = 1;

wss.on('connection', (ws) => {
  console.log('New client connected');

  ws.on('message', (message) => {
    console.log(`Received: ${message}`);
    
    message = message.toString();

    const parts = message.split(' ');

    if (parts[0] === 'INSERT') {
      const name = parts[1];
      const salary = parseInt(parts[2]);

      if (salary) {
          employees.push({ id: employeeId++, name, salary });
          ws.send('Employee inserted successfully.');
        }
    } else if (parts[0] === 'RETRIEVE') {
      if (employees.length === 0) {
        ws.send('No employees found.');
      } else {
        let employeeList = '';
        employees.forEach((emp) => {
          employeeList += `ID: ${emp.id}, Name: ${emp.name}, Salary: ${emp.salary}\n`;
        });
        ws.send(employeeList);
      }
    } else {
      ws.send('Invalid command.');
    }
  });

  ws.on('close', () => {
    console.log('Client disconnected');
  });
});

console.log('WebSocket server started on ws://192.168.3.158:8080');
