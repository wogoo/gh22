const Modelo = require('./ModeloTabelaFornecedores')

module.exports = {
    listar () {
        return Modelo.findAll()
    },

    inserir (fornecedor) {
        return Modelo.create(fornecedor)
    },
    async pegaPorId(id) {
        const encontrado = await Modelo.findOne({
            where: {
                id: id
            }
        })
        return encontrado
    }
}