#language: pt
#encoded: UTF-8
#author: Claudinei Oliveira
#version:1.0

  Funcionalidade: Validar endpoint de Auth(login)

    @login @regressivo
    Cenario: Verificar login com sucesso
      Dado que o payload foi criado com dados validos de login
      Quando realizar a chamada de login
      Entao deve visualizar a mensagem de login "Logado com sucesso."

    @login @regressivo
    Cenario: Verificar login não autorizado
      Dado que o payload foi criado com dados invalidos de login
      Quando realizar a chamada de login
      Entao deve visualizar a mensagem de login "Não autorizado."
