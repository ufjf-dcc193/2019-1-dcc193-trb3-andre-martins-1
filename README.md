T3 - Acervo de documentos
=========================

Sobre
-----

**Autor:** André Ferreira Martins  
**Matrícula:** 201565010AC  
**Disciplina:** DCC193 - Laboratório de Programação de Sistemas Web II  
**Professor:** Igor Knop  


Descrição
---------

### Objetivo

Uma instituição administra um grande acervo de obras e documentos em diversos setores diferentes. Ela deseja documentar, organizar e disponibilizar esse catálogo ao público.


### Requisitos

- Cada *Item* possui: um título, um conjunto de *Anotações*, um conjunto de *Etiquetas* e um conjunto de *Vínculos* com outros *Itens*;
- Cada *Vínculo* possui: um *Item* de origem, um *Item* de destino, um conjunto de *Etiquetas* e um conjunto de *Anotações*;
- Cada *Anotação* possui: um título, uma descrição textual, uma URL opcional, um *Usuário* que a criou, uma data de inclusão e uma data de alteração;
- Um *Usuário* possui: um nome completo, um código de acesso, uma descrição textual e um e-mail de contato;
- Cada *Etiqueta* possui: um título, uma descrição textual e uma URL;
- Crie um conjunto de telas para criar, listar, editar e excluir *Etiquetas*, *Usuários* e *Itens*;
- Crie uma tela que ao selecionar um *Item*, permita criar, listar, editar e excluir *Vínculos* para outros *Itens*;
- Crie telas que permitam criar, listar, editar e excluir *Anotações* em *Itens* e *Vínculos* específicos;
- Crie telas que permitam adicionar e excluir *Etiquetas* de *Itens* e *Vínculos* específicos;
- Crie uma tela que permita listar os *Itens* por *Etiquetas*.


### Detalhes adicionais

Utilize o *Spring Boot* com os módulos *Web*, *JPA* (*H2*/*Derby* local de dev e *PostgreSQL* de produção), *Thymeleaf*, *Devtools* para construir a aplicação. Crie as telas com o *Thymeleaf* para visualização dos dados.


O desenvolvimento deve ser feito sob controle de versão, em commits pequenos, bem definidos e planejados antes de serem realizados. Faça a implantação do sistema no *Heroku*.


Instalação
----------

1. Instale o *[Visual Studio Code](https://code.visualstudio.com/)*;
1. Faça download da extensão *[Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack)*;
1. Clone o repositório: `git clone https://github.com/ufjf-dcc193/2019-1-dcc193-trb3-andre-martins-1.git`;
1. Abra o *Spring Boot Dashboard* na barra lateral, clique com o botão direito em `documentos` e selecione a opção `Start`;
1. Acesse o *website* em [localhost:8080](http://localhost:8080).