# language: pt
# Sample Template Da Feature

Funcionalidade: Resetar credenciais na tela de login

  @reset
  Cenario: resetar credenciais
    Dado Insiro o Username e Password
    Quando Reseto as credentiais
    Entao Os campos Username e Password devem ser limpos
    
