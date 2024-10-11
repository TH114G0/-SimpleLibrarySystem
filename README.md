# Sistema de Biblioteca Simples

O **Sistema de Biblioteca Simples** é uma aplicação desenvolvida em Java com Spring Boot, projetada para gerenciar autores e livros. O sistema permite criar, editar, visualizar e excluir registros de autores e livros, facilitando a organização e o acesso às informações bibliográficas.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.0.0
- MariaDB
- Maven
- Lombok

## Pré-requisitos

Antes de compilar a aplicação, certifique-se de ter os seguintes itens instalados em seu ambiente:

- [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [MariaDB](https://mariadb.org/download/)
- [DBeaver](https://dbeaver.io/download/)

## Configuração do Banco de Dados

1. **Crie um banco de dados no MariaDB** chamado `sistema_de_biblioteca_simples`.
2. **Configure o arquivo `application.properties`** para conectar ao seu banco de dados:

   ```properties
   spring.datasource.url=jdbc:mariadb://localhost:3307/sistema_de_biblioteca_simples
   spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
   spring.datasource.username=root
   spring.datasource.password=root

## Visualizando o Banco de Dados com DBeaver
1. **Abra o DBeaver e crie uma nova conexão:**
   - Clique em "Nova Conexão" e selecione "MariaDB".
   - Preencha os detalhes da conexão (Host: localhost, Porta: 3307, Banco de Dados: sistema_de_biblioteca_simples, Usuário: root, Senha: root).
   - Clique em "Testar Conexão" para garantir que tudo está configurado corretamente e depois em "Concluir".
2. **Navegue até o banco de dados e visualize as tabelas author e book para verificar as informações armazenadas.**
## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.
