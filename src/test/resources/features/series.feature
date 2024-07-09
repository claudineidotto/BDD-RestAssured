#language: pt
#encoded: UTF-8
#author: Claudinei Oliveira
#version: 1.0



Funcionalidade: Validar endpoint de Series

  Contexto: Realizar login na api
    Dado que o payload foi criado com dados validos de login
    E realizar a chamada de login

  @series @regressivo
    Cenario: Validar a inclusao de uma serie com sucesso
    Dado que o payload foi criado com dados validos de uma serie
    Quando envia a requisição para criar uma serie
    Então deve visualizar a mensagem de sucesso na criação da serie