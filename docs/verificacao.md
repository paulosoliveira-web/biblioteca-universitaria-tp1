# Verificação do protótipo

Aluno: Paulo Vinicius Santos Oliveira  
Disciplina: 26E4_5

Data: 16/11/2026. Ambiente: OpenJDK 21.0.13, Linux. Compilação com alvo Java 21, sem bibliotecas externas. Os casos abaixo foram executados em processos independentes; cada caso recebeu as entradas pela entrada padrão. Não foi verificada a instalação do IntelliJ no computador do aluno, nem medida a meta proposta de desempenho RNF05.

Comando usado neste ambiente:

```sh
java com.sun.tools.javac.Main -encoding UTF-8 -source 21 -target 21 -d tmp/classes src/Main.java
java -cp tmp/classes Main
```

O primeiro comando invoca o mesmo compilador disponível como `javac` em uma instalação completa do JDK. No computador do aluno, usar os comandos do README.

| Cenário | Entradas em sequência | Saída verificada (trecho) | Resultado |
| --- | --- | --- | --- |
| Consulta fixa | 1 → 0 | ISBN ficticio: 9780000000002 | Aprovado |
| Empréstimo válido | 2 → 2 → s → 0 | Total simulado de emprestimos ativos: 3 | Aprovado |
| Limite atingido | 2 → 3 → s → 0 | limite de 3 emprestimos ativos | Aprovado |
| Exemplar indisponível | 2 → 1 → n → 0 | exemplar indisponivel | Aprovado |
| Devolução no prazo | 3 → s → 0 → 0 | Sem multa. | Aprovado |
| Devolução atrasada | 3 → s → 5 → 0 | R$ 5,00 | Aprovado |
| Empréstimo inexistente | 3 → n → 0 | emprestimo ativo nao encontrado | Aprovado |
| Reserva aceita | 4 → s → 0 | Reserva autorizada | Aprovado |
| Reserva recusada | 4 → n → 0 | Reserva negada | Aprovado |
| Menu inválido | abc → 0 | Opcao invalida | Aprovado |
| Quantidade negativa | 2 → -1 → 0 | Entrada invalida | Aprovado |
| Quantidade textual | 2 → texto → 0 | Entrada invalida | Aprovado |
| Resposta inválida | 4 → x → 0 | Entrada invalida | Aprovado |
| Atraso negativo | 3 → s → -1 → 0 | Entrada invalida | Aprovado |
| Atraso excessivo | 3 → s → 36501 → 0 | Entrada invalida | Aprovado |
| Atraso no limite técnico | 3 → s → 36500 → 0 | R$ 36500,00 | Aprovado |
| Inteiro muito longo | 3 → s → 999999999999999999 → 0 | Entrada invalida | Aprovado |
| Resposta maiúscula | 4 → S → 0 | Reserva autorizada | Aprovado |
| Saída | 0 | Programa encerrado. | Aprovado |
| Fim de entrada | fim de entrada | BIBLIOTECA UNIVERSITARIA | Aprovado |

Limitação: estas verificações cobrem somente o protótipo procedural. Não validam cadastros, persistência, concorrência ou fluxos completos ainda não implementados.
