# Octo Events
Octo Events é uma aplicação que escuta e registra eventos GitHub via webhooks e permite consultar os eventos registrados.

## Tecnologia
O Octo Events foi implementado em Java 8 com suporte do Spring Boot 2.

## Ferramentas
Para implementação da aplicação, foi utilizado a IDE NetBeans(Build 201804200002).
Para testes do Events Endpoint foi utilizado a ferramenta Postman (Versão 7.0.6).
Para testes do Webhook Endpoint foi utilizado a ferramenta ngrok, que gera uma url pública e roteia para o localhost.

## Banco de Dados
Foi utilizado o banco de dados relacional PostgreSQL 11.

## Configurando o Banco de Dados
Para que a migração executada pela ferramento Flyway ocorra corretamente ao iniciar a aplicação pela primeira vez, é necessário fazer algumas configurações prévias no PostgreSQL 11. Após a instalação, deve ser criado uma role (usuário) de nome "octo". O usuário octo deve possuir o password "octo" e ter os privilégios de "login" e "criação de banco de dados".

Deve ser criado um banco de dados de nome "octoevents", onde o owner é o usuário criado "octo". Nesse banco de dados deve ser configurado um schema de nome "octo".

## Configurando o Webhook do Repositório.
Para realizar os testes do Webhook Endpoint, é necessário atualizar a Payload url do webhook configurado no repositório. Essa url deve ser atualizada com a url gerada pela ferramenta ngrok, para o localhost na porta 8080 concatenada ao sufixo "/issues", exemplo: http://b48fd5a1.ngrok.io/issues.

## OBS: A aplicação está configurada para rodar na porta 8080.
