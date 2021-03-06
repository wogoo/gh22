const TabelaFornecedor = require('./TabelaFornecedor')

class Fornecedor {
    constructor({id, empresa, email, categoria, dataCriacao, dataAtualizacao, versao}) {
        this.id = id;
        this.empresa = empresa;
        this.email = email;
        this.categoria = categoria;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.versao = versao;
    }

    async criar() {
        this.validar()
        const result = await TabelaFornecedor.inserir({
            empresa: this.empresa,
            email: this.email,
            categoria: this.categoria
        })

        this.id = result.id;
        this.dataCriacao = result.dataCriacao;
        this.dataAtualizacao = result.dataAtualizacao;
        this.versao = result.versao;
    }

    async carregar() {
        const encontrado = await TabelaFornecedor.pegaPorId(this.id)
        this.empresa = encontrado.empresa;
        this.email = encontrado.email;
        this.categoria = encontrado.categoria;
        this.dataCriacao = encontrado.dataCriacao;
        this.dataAtualizacao = encontrado.dataAtualizacao;
        this.versao = encontrado.versao;
    }

    async atualizar() {
        await TabelaFornecedor.pegaPorId(this.id)
        const campos = ['empresa', 'email', 'categoria']
        const dadosParaAtualizar = {}

        campos.forEach((campo) => {
            const valor = this[campo]
            if(typeof valor === 'string' && valor.length > 0) {
                dadosParaAtualizar[campo] = valor
            }
        })

        if(Object.keys(dadosParaAtualizar).length === 0) {
            throw new Error('Dados para atualização não foram fornecidos!')
        }

        await TabelaFornecedor.atualizar(this.id, dadosParaAtualizar)
    }

    async remover() {
        return TabelaFornecedor.remover(this.id)
    }
    async validar() {
        const campos = ['empresa', 'email', 'categoria']
        
        campos.forEach(campo => {
            const valor = this[campo]

            if(typeof valor === 'string' && valor.length === 0) {
                throw new Error(`O campo ${campo} não pode ser vazio!`)}
        })
    }
}

module.exports = Fornecedor;