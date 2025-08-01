# Enzima's Contact Book 📒

## PT-BR 🇧🇷|

**Enzima's Contact Book** é um aplicativo desktop desenvolvido em Java, utilizando Swing para a interface gráfica e MySQL como banco de dados.  
Ele permite gerenciar informações de contatos, incluindo nome, telefone, e-mail, endereço, data de nascimento e se a pessoa possui filhos.

## Funcionalidades

- Conexão com banco de dados MySQL  
- Adicionar, editar, excluir e buscar contatos  
- Edição rápida ao dar duplo clique em uma entrada  
- Busca em tempo real  
- Validação para garantir a conexão com o banco antes de acessar os contatos  

## Tecnologias 

- Java (Swing)  
- MySQL  
- JDBC  

## Como usar

1. Clone este repositório.
2. Configure um banco de dados MySQL com a estrutura da tabela register_table (veja abaixo).
3. Abra o projeto no Eclipse.
4. Execute o programa e clique em “Conectar ao Banco de Dados” antes de acessar o menu “Contatos”.
5. Use a tela de busca para adicionar, editar ou excluir registros.

## Estrutura da Tabela MySQL

sql
CREATE TABLE register_table (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(100),
  telephone VARCHAR(20),
  email VARCHAR(100),
  address VARCHAR(255),
  birthdate VARCHAR(20),
  children VARCHAR(10)
);

## EN 🇺🇸 |

**Enzima's Contact** Book is a desktop application developed in Java using Swing for the GUI and MySQL for the database. It allows users to manage contact information including name, phone, email, address, birth date, and number of children.

## Features

- Connect to MySQL database
- Add, edit, delete, and search contacts
- Double-click to edit entries
- Real-time search
- Validation to ensure database connection before accessing contacts

## Technologies

- Java Swing
- MySQL
- JDBC

## How to Use

1. Clone this repository.
2. Set up a MySQL database with the register_table structure (see below).
3. Open the project in Eclipse.
4. Run the program and **click “Connect to Database”** before accessing the “Contacts” menu.
5. Use the search screen to add, edit, or delete entries.

## MySQL Table Structure

sql
CREATE TABLE register_table (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(100),
  telephone VARCHAR(20),
  email VARCHAR(100),
  address VARCHAR(255),
  birthdate VARCHAR(20),
  children VARCHAR(10)
);
