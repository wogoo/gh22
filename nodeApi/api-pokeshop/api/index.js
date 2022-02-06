const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const config = require('config');
const NaoEncontrado = require('./erros/NaoEncontrado');

app.use(bodyParser.json());

const roteador = require('./rotas/fornecedores');
app.use('/api/fornecedores', roteador)

app.use( (err, req, res, next) => {
    if( err instanceof NaoEncontrado) {
        res.status(404)
    }else {
        res.status(400)
    }        
    res.send(
        JSON.stringify({
            mensagem: err.message,
            id: err.idErro
        })
    )
}
    
)

app.listen(config.get('api.port'), () => console.log('working'))