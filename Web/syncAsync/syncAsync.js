/**
 * http://usejsdoc.org/
 */
var fs = require('fs');
//Sync
//var data = fs.readFileSync('data.txt', {encoding:'utf8'});

fs.readFile('data.txt', {encoding:'utf8'}, function(err, data){
	console.log(data);
})

//console.log(data);