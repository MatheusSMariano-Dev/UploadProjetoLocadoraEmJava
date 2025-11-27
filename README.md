🎬 Locadora Essencial — Sistema de Aluguel de Filmes (Java)

Este projeto é um sistema simples de locadora de filmes, desenvolvido totalmente em Java puro, seguindo uma arquitetura organizada com:

Model

Repository

Service

UI (Menu)

App (Main)

O sistema permite cadastrar clientes, cadastrar filmes, realizar aluguel, devolver filmes e listar todos os dados registrados.

🚀 Funcionalidades
👤 Clientes

Cadastrar cliente

Listar clientes

Validação de CPF, telefone e email

🎞 Filmes

Cadastrar filme

Listar filmes

Validação de nome, categoria e valor por hora

Gerenciamento de disponibilidade

🎟 Aluguéis

Realizar aluguel

Impedir aluguel de filme já alugado

Registrar data/hora do aluguel

Registrar data/hora da devolução

Calcular valor total automaticamente

Listar todos os aluguéis

🧱 Arquitetura do Projeto
src/
 └── locadora/
      ├── app/
      │    └── Main.java
      ├── model/
      │    ├── Cliente.java
      │    ├── Filme.java
      │    └── Aluguel.java
      ├── repository/
      │    ├── ClienteRepository.java
      │    ├── FilmeRepository.java
      │    └── AluguelRepository.java
      ├── service/
      │    ├── ClienteService.java
      │    ├── FilmeService.java
      │    └── AluguelService.java
      └── ui/
           └── Menu.java

🖥 Como executar

Baixe ou clone o repositório:

git clone https://github.com/SEU_USUARIO/locadora-java.git


Abra o projeto em sua IDE (IntelliJ, Eclipse, VSCode com Java).

Execute a classe:

locadora.app.Main


O menu aparecerá no console:

1 - Cadastrar Cliente
2 - Cadastrar Filme
3 - Realizar Aluguel
4 - Devolver Filme
5 - Listar Clientes
6 - Listar Filmes
7 - Listar Aluguéis
0 - Sair

📌 Exemplos de Saída
Cadastro de Filme
Filme cadastrado com sucesso!
Filme{id=1, nome='Scarface', categoria='Mafia', ano=1983, valorPorHora=5.0, disponível=Sim}

Cadastro de Cliente
Cliente cadastrado com sucesso!
Cliente{id=1, nome='Matheus', CPF=12345678900, email='teste@gmail.com', telefone=31999999999}

Aluguel
Aluguel realizado com sucesso!
Aluguel{id=1, filme='Scarface', cliente='Matheus', data='2025-11-26 12:00'}

🧠 Aprendizados neste projeto

Durante a construção do sistema foram praticados conceitos importantes:

✔ Encapsulamento
✔ Padrão MVC
✔ Separação de responsabilidades (Repository / Service / UI)
✔ Validação de dados
✔ Manipulação de datas com LocalDateTime
✔ Estrutura de listas em memória
✔ Fluxo de menus no console
✔ Boas práticas em Java

🛠️ Tecnologias Utilizadas

Java 17+

Orientação a Objetos (POO)

Estrutura em camadas (MVC)

Scanner (entrada do usuário via console)

Collections (List)

LocalDate e LocalDateTime

Duration para cálculo de horas de aluguel


👑 Autor

Desenvolvido por Matheus Mariano 
 
LinkedIn: https://www.linkedin.com/in/matheus-s-mariano
