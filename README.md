# Exemplos de Projeto ToDo com Padrão MVC

Este repositório contém dois projetos didáticos simples que implementam o padrão arquitetural **MVC (Model-View-Controller)** com o objetivo de demonstrar a separação de responsabilidades e a estrutura modular em diferentes linguagens: **Java** e **JavaScript**.

---

## 📁 Estrutura do Repositório

```
mvc-tasks-example/
├── mvc-with-without/             # Projetos em JavaScript
│   ├── with_mvc/                 # Aplicação usando o padrão MVC
│   └── without_mvc/             # Aplicação sem uso de MVC (para comparação)
│
├── src/main/java/github/lucasmartins/classes/
│   ├── controller/              # Controlador da aplicação Java
│   ├── model/                   # Lógica e dados
│   └── view/                    # Interface via console
│   └── Main.java                # Classe principal
│
├── pom.xml                      # Arquivo Maven para o projeto Java
└── README.md
```

---

## Projeto JavaScript: Tasks com e sem MVC

Caminho: `mvc-with-without/`

### 🔹 `with_mvc/`
Aplicação de lista de tarefas estruturada em três arquivos:
- `TaskModel.js` — representa os dados
- `TaskView.js` — manipula o DOM
- `TaskController.js` — controla interações
- `index.html` — conecta tudo

### 🔸 `without_mvc/`
Versão equivalente, mas com código acoplado e sem separação de responsabilidades. Serve para comparação com a versão MVC.

### Como executar:
Abra o `index.html` ou `without_mvc_example.html` diretamente no navegador ou com Live Server no VS Code.

---

## Projeto Java (Console): Tasks com MVC

Caminho: `src/main/java/github/lucasmartins/classes/`

- `TasksModel.java` — lógica de dados
- `TasksView.java` — interação com o usuário via console
- `TasksController.java` — fluxo de controle
- `Main.java` — ponto de entrada
- Empacotado como projeto Maven

### Como executar com Maven:

1. No terminal:
```bash
mvn compile
mvn exec:java
```

> Certifique-se de estar na raiz do projeto onde está o `pom.xml`.

---

## 🎓 Objetivos Educacionais

- Entender a aplicação do padrão MVC em diferentes linguagens.
- Comparar arquitetura modular (MVC) com código acoplado.
- Refletir sobre manutenibilidade e legibilidade do código.

---

## 👨‍🏫 Autoria / Créditos

- Lucas Martins
- Projeto educacional para a disciplina de Arquitetura de Software

---

## 📄 Licença

Uso educacional. Reutilize e adapte conforme necessário.
