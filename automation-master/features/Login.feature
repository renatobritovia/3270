# language: pt

# Author: Andre Berte
# Sample Template Da Feature

Funcionalidade: Fazer os testes de login nas plataformas

  Cenario: login e primeiros passos
    Dado efetuei login no sistema
    E acessei o menu Clientes Inserir
    
  Cenario: Login com Facebook
  	Dado que clico no login por facebook
  	E coloco o email
  	E senha
  	Entao clico em acessar
  	
  Cenario: Login com Google
  	Dado que clico no login por google
  	E coloco o email google
  	E senha google
  	Entao clico em acessar google
  	  
  Cenario: Login com Linkedin
  	Dado que clico no login por linkedin
  	E coloco o email linkedin
  	E senha linkedin
  	Entao clico em acessar linkedin    
  	
#    When na tela Dados de Identificacao informo os dados de Pessoa Fisica
#    Then na tela Enderecos sera exibida mensagem de sucesso

#  @test
#  Scenario Outline: Title of your scenario outline
#    Given I want to write a step with <name>
#    When I check for the <value> in step
#    Then I verify the <status> in step

#    Examples: 
#      | name  | value | status  |
#      | name1 |     5 | success |
#      | name2 |     7 | Fail    |
