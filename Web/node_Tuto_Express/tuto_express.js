/**
 * http://usejsdoc.org/
 */
var express = require('express');
var app = express();
app.use(express.static('public'));		//퍼블릭이라는 폴더안에 것을 출력(끄림이든,txt든,html이든), 정적 - 노드 어플리케이션을 껏다 켜야함.
app.get('/route', function(req, res){		
	res.send('Hello Router, <img src="/route.png>')
})
app.get('/', function(req, res){		//라우트라는 이미지
	res.send('Hello home page');
});
app.get('/login', function(req, res){
	res.send('<h1>Login Please</h1>');
});
app.listen(3000, function(){
	console.log('Connected 3000 port!');
})

app.get('/dynamic', function(req, res){
	var lis = '';
	for(var i=0; i<5; i++){
		lis = lis + `<li>coding</li>`;
	}
	var output = `
	<!DOCTYPE html>
	  <html>
		<head>
		</head>
		<body>
			Hello, Dynamic!
			<ul>
				${lis}
			</ul> 
		</body>
	  </html>`;
	res.send(output);
})
/*app.get('/topic', function(req, res){  //req 는 
	res.send(req.query.id);    // topic?id=1 이면 1출력    topic?name=1이면 그값 모르는..
})*/
app.get('/topic', function(req, res){
	var topics = [
		'javascript is....',
		'nodejs is...',
		'expresss is....'
		];
	var output = `
		<a href="/topic?id=0">javascript</a><br>
		<a href="/topic?id=1">nodejs</a><br>
		<a href="/topic?id=2">express</a><br>
		${topics[req.query.id]}
		`
		res.send(output);

})