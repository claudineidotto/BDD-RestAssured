#language: pt
#encoded:  UTF-8
#author: Claudinei Oliveira
#version 1.0



Funcionalidade: Validade o endpoint de usuários

        Cenario: Verificar cadastro de novo usuário com sucesso
            Dado que o payload possua dados de um novo usuário
            Quando realizar a criação de um novo usuário
            Então deve criar o usuário com sucesso

            
