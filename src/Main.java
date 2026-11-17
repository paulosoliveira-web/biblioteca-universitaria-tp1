/*
 * Aluno: Paulo Vinicius Santos Oliveira
 * Disciplina: 26E4_5
 * TP1 - Sistema de Gestao de Biblioteca Universitaria
 * Java 21. Simulacao procedural: dados nao sao armazenados.
 * Uso de IA: versao inicial gerada com apoio de IA; revisar e compreender
 * antes da entrega, conforme as orientacoes do professor.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final int PRAZO_DIAS = 14;
        final int LIMITE_EMPRESTIMOS = 3;
        // Hipotese didatica: R$ 1,00/dia. O professor deve validar o valor.
        final int MULTA_DIARIA_CENTAVOS = 100;
        boolean executando = true;

        System.out.println("BIBLIOTECA UNIVERSITARIA - TP1");
        System.out.println("Simulacoes independentes, sem cadastro ou persistencia.");

        while (executando) {
            System.out.println("\n1 - Consultar acervo demonstrativo");
            System.out.println("2 - Simular emprestimo");
            System.out.println("3 - Simular devolucao e multa");
            System.out.println("4 - Simular reserva");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            if (!entrada.hasNextLine()) break;
            String opcao = entrada.nextLine().trim();

            switch (opcao) {
                case "1" -> {
                    System.out.println("ACERVO FIXO PARA DEMONSTRACAO");
                    System.out.println("Livro: Introducao a Biblioteca | Autor: Autor demonstrativo");
                    System.out.println("ISBN ficticio: 9780000000002 | Patrimonio: EX001");
                    System.out.println("Conservacao: bom | Situacao demonstrativa: disponivel");
                    System.out.println("A consulta nao altera as outras simulacoes.");
                }
                case "2" -> {
                    System.out.print("Quantidade atual de emprestimos ativos (0 a 3): ");
                    if (!entrada.hasNextLine()) break;
                    String texto = entrada.nextLine().trim();
                    if (!texto.matches("[0-3]")) {
                        System.out.println("Entrada invalida. Informe um inteiro de 0 a 3.");
                        break;
                    }
                    int ativos = Integer.parseInt(texto);
                    System.out.print("O exemplar esta disponivel? (s/n): ");
                    if (!entrada.hasNextLine()) break;
                    String resposta = entrada.nextLine().trim();
                    if (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n")) {
                        System.out.println("Entrada invalida. Use s ou n.");
                        break;
                    }
                    boolean disponivel = resposta.equalsIgnoreCase("s");
                    if (ativos >= LIMITE_EMPRESTIMOS) {
                        System.out.println("Emprestimo negado: limite de 3 emprestimos ativos.");
                    } else if (!disponivel) {
                        System.out.println("Emprestimo negado: exemplar indisponivel.");
                    } else {
                        int novoTotal = ativos + 1;
                        System.out.println("Emprestimo autorizado na simulacao.");
                        System.out.println("Prazo: " + PRAZO_DIAS + " dias.");
                        System.out.println("Total simulado de emprestimos ativos: " + novoTotal);
                    }
                }
                case "3" -> {
                    System.out.print("Existe emprestimo ativo deste exemplar? (s/n): ");
                    if (!entrada.hasNextLine()) break;
                    String resposta = entrada.nextLine().trim();
                    if (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n")) {
                        System.out.println("Entrada invalida. Use s ou n.");
                        break;
                    }
                    if (resposta.equalsIgnoreCase("n")) {
                        System.out.println("Devolucao negada: emprestimo ativo nao encontrado.");
                        break;
                    }
                    System.out.print("Dias corridos de atraso (0 a 36500): ");
                    if (!entrada.hasNextLine()) break;
                    String texto = entrada.nextLine().trim();
                    if (!texto.matches("[0-9]{1,5}")) {
                        System.out.println("Entrada invalida. Informe um inteiro de 0 a 36500.");
                        break;
                    }
                    int diasAtraso = Integer.parseInt(texto);
                    if (diasAtraso > 36500) {
                        System.out.println("Entrada invalida. Informe um inteiro de 0 a 36500.");
                        break;
                    }
                    int multaCentavos = diasAtraso * MULTA_DIARIA_CENTAVOS;
                    double multaReais = multaCentavos / 100.0;
                    System.out.println("Devolucao aceita na simulacao.");
                    if (diasAtraso == 0) {
                        System.out.println("Devolucao no prazo. Sem multa.");
                    } else {
                        System.out.printf(java.util.Locale.forLanguageTag("pt-BR"),
                            "Multa simulada: R$ %.2f (%d dias corridos).%n",
                            multaReais, diasAtraso);
                    }
                    System.out.println("Tarifa didatica: R$ 1,00/dia, sujeita a validacao.");
                }
                case "4" -> {
                    System.out.print("O exemplar de referencia esta emprestado agora? (s/n): ");
                    if (!entrada.hasNextLine()) break;
                    String resposta = entrada.nextLine().trim();
                    if (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n")) {
                        System.out.println("Entrada invalida. Use s ou n.");
                        break;
                    }
                    boolean emprestado = resposta.equalsIgnoreCase("s");
                    if (emprestado) {
                        System.out.println("Reserva autorizada na simulacao.");
                        System.out.println("No sistema completo, sera vinculada ao livro e ao membro.");
                    } else {
                        System.out.println("Reserva negada: o exemplar precisa estar emprestado.");
                    }
                }
                case "0" -> {
                    executando = false;
                    System.out.println("Programa encerrado.");
                }
                default -> System.out.println("Opcao invalida. Escolha 0, 1, 2, 3 ou 4.");
            }
        }
        entrada.close();
    }
}
