const Sequelize = require('sequelize');
const instance = require('../../database')

const columns = { 

    empresa: {
        type: Sequelize.STRING,
        allowNull: false
    },
    email: {
        type: Sequelize.STRING,
        allowNull: false
    },
    categoria: {
        type: Sequelize.ENUM('ração', 'brinquedos'),
        allowNull: false
    }

}

const opcoes = {
    freezeTableName: true,
    tableName: 'fornecedores', 
    timestamp: true,
    createdAt: 'dataCriacao',
    updatedAt: 'dataAtualizacao',
    version: 'versao'
}

module.exports = instance.define('fornecedor', columns, opcoes)