/**
 * http://usejsdoc.org/
 */
var http = require('http');
http.createServer(function(req, res) {
	
	//build the answer
	var answer = "";
	answer += "Request URL: " + req.url + "\n";
	answer += "Request type: " + req.method + "\n";
	answer += "Request headers: " + JSON.stringify(req.headers) + "\n";
	
	//send answer
	res.writeHead(200, {'Content-Type' : 'text/plain'});
	res.end('Hello World\n\n' + answer);
	
	
}).listen(1338, '127.0.0.1');