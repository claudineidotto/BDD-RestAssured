#language: pt
#encoded: UTF-8
#author: Claudinei Oliveira
#version:1.0

  Funcionalidade: Validar endpoint de Auth(login)

    @login @regressivo
    Cenario: Verificar login com sucesso
      Dado que o payload foi criado com dados validos de login
      Quando realizar a chamada de login
      Entao deve visulizar a mensagem de login "Logado com sucesso."