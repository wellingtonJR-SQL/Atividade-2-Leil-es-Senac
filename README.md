# Sistema de Leilões — LeiloesTDSat

Sistema desktop desenvolvido em Java (Swing) para cadastro e listagem de produtos de leilão, como atividade da UC11 (Módulo 9) do curso Técnico em Desenvolvimento de Sistemas — Senac.

## Tecnologias

- Java (Swing)
- MySQL / MariaDB
- JDBC
- NetBeans IDE
- Padrão DAO/DTO

## Funcionalidades

- Cadastro de produtos (nome e valor), com status inicial "A Venda"
- Mensagens de sucesso/erro ao cadastrar
- Listagem de todos os produtos cadastrados no banco de dados
- Tela `cadastroVIEW` como tela principal do sistema

## Estrutura do projeto

```
LeiloesTDSat/
├── src/
│   ├── cadastroVIEW.java     # Tela principal — cadastro de produtos
│   ├── listagemVIEW.java     # Tela de listagem de produtos
│   ├── ProdutosDAO.java      # Acesso ao banco (INSERT/SELECT)
│   ├── ProdutosDTO.java      # Objeto de transferência de dados
│   └── conectaDAO.java       # Conexão com o banco de dados
├── lib/                      # Drivers JDBC do MySQL
└── nbproject/                # Configurações do projeto NetBeans
```

## Banco de dados

O sistema utiliza o banco `uc11`, com a tabela `produtos` (`id`, `nome`, `valor`, `status`). O script de criação está no arquivo `uc11.sql`.

## Como executar

1. Importe o `uc11.sql` no MySQL/MariaDB
2. Ajuste o usuário e senha em `src/conectaDAO.java`, se necessário
3. Abra o projeto no NetBeans
4. Execute (F6) — a tela de cadastro abrirá automaticamente
