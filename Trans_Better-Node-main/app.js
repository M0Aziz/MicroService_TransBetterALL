var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
const mongoose = require('mongoose');
const { Eureka } = require('eureka-js-client');


var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');
var blogRouter = require('./routes/BlogRoute');
var app = express();

const client = new Eureka({
  instance: {
    app: 'black-ops-js-ms', // Replace with your application name
    instanceId: 'black-ops-js-ms',
    hostName: 'black-ops-js-ms',
    ipAddr: '172.22.0.6',
    port: {
      $: 5000, // Your Node.js service port
      '@enabled': 'true',
    },
    vipAddress: 'black-ops-js-ms', // Replace with your application name
    dataCenterInfo: {
      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
      name: 'MyOwn',
    },
  },
  eureka: {
    host: 'eureka-server', // Eureka server host
    port: 8761, // Eureka server port
    servicePath: '/eureka/apps/',
  },
});

// Start the Eureka client
client.start((error) => {
  if (!error) {
    console.log('Eureka client started');
  } else {
    console.error('Eureka client could not be started', error);
  }
});


// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/users', usersRouter);
app.use('/blog',blogRouter);


mongoose.connect('mongodb://mongodb:27017/TransBetter', {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});
mongoose.connection.on('error', console.error.bind(console, 'Connection error:'));
mongoose.connection.once('open', () => {
  console.log('Connected to the database');
});
// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});



app.listen(5000, () => {
  console.log('Serveur Express en cours d\'exécution sur le port 5000');
});
module.exports = app;
