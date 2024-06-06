#language: pt
#encoded:  UTF-8
#author: Claudinei Oliveira
#version 1.0



Funcionalidade: Validar o endpoint de usuários

        @cadastroSucesso @regressivo
        Cenario: Verificar cadastro de novo usuário com sucesso
            Dado que o payload possua dados de um novo usuário
            Quando realizar a criação de um novo usuário
            Então deve criar o usuario com sucesso

        @emailExistente @regressivo
        Cenario: Verificar mensagem de erro ao utilizar e-mail existente
            Dado que o payload possua dados de um novo usuário com email existente
            Quando realizar a criação de um novo usuário
            Então deve visualizar a mensagem "Este e-mail já está sendo utilizado."
