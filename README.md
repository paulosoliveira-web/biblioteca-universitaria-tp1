# TP1 - Sistema de Gestão de Biblioteca Universitária

**Aluno:** Paulo Vinicius Santos Oliveira  
**Disciplina:** 26E4_5  
**Trilha:** Java 21

## Organização

- `src/Main.java`: protótipo procedural standalone.
- [Documento de requisitos e escopo](docs/requisitos_Paulo_Vinicius_Santos_Oliveira_26E4_5.md): requisitos funcionais e não funcionais, regras de negócio, quatro casos de uso, hipóteses e justificativa.
- [Diagrama UML](docs/diagrama_casos_de_uso.svg): representação visual dos atores e casos de uso.
- [Fonte PlantUML](docs/casos_de_uso.puml): versão editável do diagrama.
- [Registro de verificação](docs/verificacao.md): compilação e cenários exercitados.

O PDF identificado e o ZIP institucional são entregues separadamente no Moodle, junto ao vídeo e ao link deste repositório.

## Executar

Instale o JDK 21. Abra o terminal na raiz do projeto:

```sh
java -version
javac -version
mkdir out
javac -encoding UTF-8 --release 21 -d out src/Main.java
java -cp out Main
```

Se a pasta `out` já existir, prossiga com a compilação. No IntelliJ IDEA Community, crie um projeto Java com SDK 21, coloque Main.java em src e execute Main.main. Para obter os arquivos, use Code > Download ZIP neste repositório e extraia o arquivo.

## Funcionalidades do protótipo

1. Consultar um registro fictício fixo do acervo.
2. Simular empréstimo: verificar disponibilidade e limite de 3 ativos; informar prazo de 14 dias.
3. Simular devolução: verificar existência de empréstimo e calcular multa pelos dias corridos de atraso informados.
4. Simular reserva: permitir apenas se o exemplar de referência estiver emprestado.
0. Encerrar o programa.

As simulações são independentes e não persistem dados. Autorizar empréstimo não altera o acervo exibido nem as próximas operações. A tarifa de R$ 1,00 por dia é uma hipótese didática; o valor não foi definido no enunciado e depende de validação do professor. Datas reais, cadastros, classes de domínio, banco, API, autenticação e Spring Boot ficam para os próximos TPs.

## Uso de IA

A versão inicial do código e da documentação foi gerada com apoio de IA. O aluno deve estudar e adaptar o material e observar a orientação do professor sobre o uso permitido. Não se declara autoria independente nem uma revisão pessoal ainda não realizada.
