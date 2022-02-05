const ModeloTabela = require('../rotas/fornecedores/ModeloTabelaFornecedores')

ModeloTabela.sync()
    .then(() => console.log('Tabela criada com sucesso'))
    .catch(err => console.log('Erro ao criar a tabela', err))
    