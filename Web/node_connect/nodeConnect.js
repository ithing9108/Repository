/**
 * http://usejsdoc.org/
 */

/**
 * http://usejsdoc.org/
 */
var connect = require('connect');
	http = require('http');
var app = connect();

app.use(function(req, res){
	res.writeHead(200, {'Content-Type': 'text/plain'});
	res.end('Hello World\n');
}).listen(1337, '127.0.0.1');

console.log('Server runing at http://127.0.0.1:1339/');  