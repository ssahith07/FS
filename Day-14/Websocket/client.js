const WebSocket = require('ws');

// Connect to the WebSocket server
const ws = new WebSocket('ws://192.168.3.158:8080');

ws.on('open', () => {
  console.log('Connected to the server');

  // Sending commands
  ws.send('INSERT Alice 50000');
  ws.send('INSERT Bob 60000');
  ws.send('RETRIEVE');
  ws.send('INVALID');
});

ws.on('message', (data) => {
  console.log(`Received from server: ${data}`);
});

ws.on('close', () => {
  console.log('Connection closed');
});

ws.on('error', (error) => {
  console.error(`WebSocket error: ${error}`);
});
