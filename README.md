# DesafioApi
Desafio Warren
# barriga-rest-api-test

Projeto de testes da api (https://barrigarest.wcaquino.me).

## Escopo:

Os testes estão dividos nos seguintes objetivos:
* HealthCheck: valida se a api está UP;
* Contract: valida o contrato de response, visando identificar possíveis alterações em atributos, tanto inclusões/exclusões quanto regras de obrigatoriedade;
* Functional: valida os fluxos específicos e alternativos da api.

# Pré-requisitos:

* Gradle 6.1
* Java 11
* Git
* IDE (preferencialmente IntelliJ)

# Instruções para baixar o projeto:

* Crie uma pasta local em seu computador;
* Acesse o Git Bash na pasta criada;
* Clonar o projeto. Execute o comando: git clone https://github.com/arianeazambujagf/desafioApi.git
* Verificar que as dependências foram baixadas com sucesso.

# Execução dos Testes

## Execução local:

* No configurador do Run (Run > Edit Configurations no IntelliJ), adicionar Nova Configuração TestNG
* Em configuration:  
    - Use classpath of module: closure-api-test.test
    - JRE: 11
    - Test kind: Class
    - Class: <selecionar o nome da classe de teste>
   
* Concluir: OK
* Selecionar a configuração realizada e Run.

## Execução por linha de comando:

* No terminal, executar: gradlew test -i --tests NOME_DO_TESTE 


