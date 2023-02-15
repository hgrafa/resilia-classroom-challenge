# Smart Classes - Resilia

Desafio em java para demonstrar conhecimento e boas práticas no desenvovimento.

## Como testar

Para testar este projeto é importante ter a ferramenta gradle para gerenciamento de dependencias do projeto e o java na versão mínima 17. Além disso também é necessário ter o **MySql** como seviço ativo na máquina.

### Ativando o **MySQL**

Depois te ter baixado o Mysql verifique nos serviços do seu gerenciador de tarefas se o **MYSQL80** ou similar está ativo.

### Banco de dados

Utilize o banco na porta local padrão 3306, através de um usuário os seguintes valores de usuário:

```
user: root
password: admin123
```

Através destes valores, crie um **Schema** no banco com o nome do projeto (**smartclasses**).

### Execute o comando `gradle build`:

Caso esteja utilizando o Intellij como editor esta etapa pode ser facilitada abrindo a aba de manipulação com o gradle e fazendo uma atualização do projeto.

### Para ligar a aplicação

Basta executar o arquivo `SmartClassesApplication.java` e testar os endpoints da aplicação na porta padrão 8080.


## Conhecimentos demonstrados

- Organização e divisão de responsabilidade.
- Princípios de SOLID.
- Desenvolvimento Orientado a Testes.

---

made with 💛 to Resilia Educação