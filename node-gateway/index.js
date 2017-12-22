const express = require('express');
const request = require('request-promise');
const bodyParser = require('body-parser');
const app = express();
const port = 8084;
const customerServiceUrl = 'http://localhost:8081/v1/customer'; 
const productServiceUrl = 'http://localhost:8080/v1/product'; 
app.use(bodyParser.json());

const post = (uri, body) => request.post({uri, body, json: true});

// Product Service
app.get('/productService/v1/product',(req,res) => {
    request(productServiceUrl, function (error, response, body) {
        res.send(body);
    });
}); 

app.get('/productService/v1/product/:id',(req,res) => {
    const id = req.params.id;
    request(productServiceUrl+`/${id}`, function (error, response, body) {
        res.send(body);
    });
}); 

app.post('/productService/v1/product', (req, res, next) => {
    post(productServiceUrl, req.body);
    res.send('OK');
});

app.post('/productService/v1/product/:id', (req, res, next) => {
    const id = req.params.id;
    post(productServiceUrl+`/${id}`, req.body);
    res.send('OK');
});

app.delete('/productService/v1/product/:id', (req,res) => {
    const id = req.params.id;
    request.delete(productServiceUrl+`/${id}`,function (error, response, body) {
        res.send(body);
    });
});

// Customer Service
app.get('/customerService/v1/customer',(req,res) => {
    request(customerServiceUrl, function (error, response, body) {
        res.send(body);
    });
});

app.get('/customerService/v1/customer/:id',(req,res) => {
    const id = req.params.id;
    request(customerServiceUrl+`/${id}`, function (error, response, body) {
        res.send(body);
    });
}); 

app.post('/customerService/v1/customer', (req, res, next) => {
    post(customerServiceUrl, req.body);
    res.send('OK');
});

app.post('/customerService/v1/customer/:id', (req, res, next) => {
    const id = req.params.id;
    post(customerServiceUrl+`/${id}`, req.body);
    res.send('OK');
});

app.delete('/customerService/v1/customer/:id', (req,res) => {
    const id = req.params.id;
    request.delete(customerServiceUrl+`/${id}`,function (error, response, body) {
        res.send(body);
    });
});

app.listen(port, () => {
    console.log(`Node Gateway upp and running listen to ${port}`);
});