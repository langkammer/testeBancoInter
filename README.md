# Teste Robson Emilio Langkammer Banco Inter

Para instalar e executar o sistema favor seguir os seguintes passos

### Usando a aplicacao
Backend para codigo rest client onde deve rodar :
######Para Instalar Dependencias
`mvn install`
######Para Rodar
`mvn spring-boot:run` 
######Para Executar Testes Unitarios
`mvn test` 

| Nome              | Tipo Requisição | URl                    | Param                                                   | Precisa Autenticação ?  |
|-------------------|-----------------|------------------------|---------------------------------------------------------|-------------------------|
| Lista Usuarios    | GET             | /usuario               | [nome = String, page = number, limit = number]          | Nao                     |
| Cria Usuarios     | POST            | /usuario               | {nome : String, email: String, resultadoVoList : Array} | Nao                     |
| Atualiza Usuarios | PUT             | /usuario               | {nome : String, email: String, resultadoVoList : Array} | Nao                     |
| Deleta Usuarios   | DELETE          | /usuario?id=number     | Params na url req                                       | Nao                     |
| Calcula Digito    | POST            | /usuario/calculoDigito | {digito : number, usuarioVo: Object}                    | Nao                     |


#### OBS
> Não Foi Implementando a criptografia pois não consegui entender isso bem claro na prova,
> mas deixo aqui um link para um projeto onde implementei > autenticação stateless,
> acho isso atenderia o projeto. Esse Projeto fiz para outra empresa é 100% autoria minha tanto front end quanto backend
https://github.com/langkammer/testeCastGroup
# Se você não me conhece ?
# Prazer meu nome é ROBSON,
![N|Solid](https://i.ibb.co/PjHNJgM/robson.jpg)

## e sou Desenvolvedor de Sistemas Web e outros abaixo listo alguns de meus conhecimentos :
 - Java ( 4 Anos ) Spring Boot, Play FrameWork
 - Android ( 2 Anos )
 - Javascript : Angular, Lodash, Bootstrap , Node js, Ionic... ( 4 Anos )
 - Php
 - Python
 - Sql
 - Mysql
 - Maven
 - Firebase
 - Servidores
 - Jenkins
 - Jira
 - Git
 - ADVPL









