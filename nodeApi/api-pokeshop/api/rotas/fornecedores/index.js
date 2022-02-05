const roteador = require('express').Router()
const TabelaFornecedor = require('./TabelaFornecedor')
const Fornecedor = require('./Fornecedor')

roteador.get('/', async (req, res) => {
    const results = await TabelaFornecedor.listar()
    res.send(
        JSON.stringify(results)
    )
})

roteador.post('/', async (req, res) => {
    const dadosRecebidos = req.body
    const fornecedor = new Fornecedor(dadosRecebidos)
    await fornecedor.criar()
    res.send(JSON.stringify(fornecedor))
})

roteador.get('/:idFornecedor', (req, res) => {
    const id = req.params.idFornecedor
    const fornecedor = new Fornecedor({id: id})
    
})

module.exports = roteador