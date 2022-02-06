const Modelo = require('./ModeloTabelaFornecedores')
const NaoEncontrado = requir('../../erros/NaoEncontrado')

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
            throw new NaoEncontrado()
        }

        return encontrado
    },
    async atualizar(id, dadosParaAtualizar) { 
        return Modelo.update(dadosParaAtualizar, 
            { where: { id: id } }
            )
    },
    async remover(id) { 
        return Modelo.destroy({
            where: { id: id}
        })
    }
}