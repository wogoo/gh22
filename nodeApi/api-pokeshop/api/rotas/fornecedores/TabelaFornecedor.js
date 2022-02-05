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

        if(!encontrado) {
            throw new Error("Fornecedor não encontrado")
        }

        return encontrado
    },
    async atualizar(id, dadosParaAtualizar) { 
        return Modelo.update(dadosParaAtualizar, 
            { where: { id: id } }
            )
    }
}