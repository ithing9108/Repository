var express=require('express');
var app=express();
var nodemailer = require('nodemailer');
var smtpPool = require('nodemailer-smtp-pool');
//var config = require('./config/config.json');

var router = express.Router();

var mysql = require('mysql');
var pool = mysql.createPool({
  connectionLimit : 10,
  port: '3001', //수정!!!
  host:'localhost',
  user:'root',
  password:'111111',
  database:'myapp'
});

var userid;
var userpassword; 

var transporter = nodemailer.createTransport(smtpPool({
  service: 'gmail',
  host:"smtp.gamil.com",
  port:587,
  auth:{
    user:userid,
    pass:userpassword
  }
}));

app.listen(3001,function(req,res){
	  console.log('Server Conneted');
	});

app.get('/mail',function(req,res){
	console.log('aaaaa');
 
	var mailOptions = {
      from:'choidh9853@gmail.com', // sender address
      to: 'choidh9853@gmail.com', // list of receivers
      subject: 'Email Example', // Subject line
      text: "Hello" //, // plaintext body
      // html: '<b>Hello world ✔</b>' // You can choose to send an HTML body instead
  };
	mailOptions.from=rows[0].email;
    console.log('load success');
    smtpTransporter.sendMail(mailOptions, function(err,res){
      if(err)
      {
        console.log('sending fail');
      }
      else {
        console.log('sending success');
      }
      transporter.close();
    });
});




app.post('/board',function(req,res){
  console.log('load');

  var mailOptions = {
      from:'choidh9853@gmail.com', // sender address
      to: 'choidh9853@gmail.com', // list of receivers
      subject: 'Email Example', // Subject line
      text: "Hello" //, // plaintext body
      // html: '<b>Hello world ✔</b>' // You can choose to send an HTML body instead
  
  
  };

  userid = req.body.id;
  password=req.body.password;

  var sql = 'select email from user where id=?';
  var params = [userid];

  pool.query(sql,params,function(err,rows){
    if(err)
    {
      console.log('load error');
    }
    if(rows)
    {
      mailOptions.from=rows[0].email;
      console.log('load success');
      smtpTransporter.sendMail(mailOptions, function(err,res){
        if(err)
        {
          console.log('sending fail');
        }
        else {
          console.log('sending success');
        }
        transporter.close();
      });
    }
  })
});



/*
 
var nodemailer = require('nodemailer');

var smtpTransport = nodemailer.createTransport("SMTP", {
	service: 'Gmail', 
	auth : {
		user: 'ithing108@gmail.com',
		pass: 'qudcoekt18'
	}
});

var mailOptions = {
	from: '임병채 <ithing108@gmail.com>',
	to: 'ithing108@gmail.com',
	subject: '히스토리가 추가됬습니다.',
	text: '히스토리가 추가됬습니다.'
		
};

smtpTransport.sendMail(mailOptions, function(error, response){
	if(error){
		console.log(error);
	}else{
		console.log("Message sent : " +response.message);
	}
	smtpTransport.close();
});*/