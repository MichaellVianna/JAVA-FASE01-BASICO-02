import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner conversor = new Scanner(System.in);
        double unidade1 = 0;
        double unidade2 = 0;
        double temperatura = 0;
        double resultado = 0;

        // Arrays para unidades e símbolos
        String[] unidades = {"Celsius", "Fahrenheit", "Kelvin"};
        String[] simbolos = {"°C", "°F", "K"};

        // Histórico de conversões
        StringBuilder historico = new StringBuilder();

        boolean continuar = true;
        while (continuar) {
            // Banner de boas-vindas
            System.out.println("*******************************************");
            System.out.println("*       CONVERSOR DE TEMPERATURA         *");
            System.out.println("*******************************************");

            // Entrada de temperatura
            System.out.println("\nDigite o valor que você deseja converter: ");
            temperatura = conversor.nextDouble();

            // Entrada da unidade de origem
            System.out.println("\nDigite o número correspondente a unidade de origem: ");
            System.out.println("1 - Celsius (" + simbolos[0] + ")");
            System.out.println("2 - Fahrenheit (" + simbolos[1] + ")");
            System.out.println("3 - Kelvin (" + simbolos[2] + ")");
            unidade1 = conversor.nextDouble();

            // Entrada da unidade de destino
            System.out.println("\nDigite o número correspondente a unidade de destino: ");
            System.out.println("1 - Celsius (" + simbolos[0] + ")");
            System.out.println("2 - Fahrenheit (" + simbolos[1] + ")");
            System.out.println("3 - Kelvin (" + simbolos[2] + ")");
            unidade2 = conversor.nextDouble();

            // Validação de entrada
            if (unidade1 < 1 || unidade1 > 3 || unidade2 < 1 || unidade2 > 3) {
                System.out.println("Opção inválida! Por favor, escolha uma unidade válida (1, 2 ou 3).");
                continue;
            }

            // Conversão de temperatura
            if (unidade1 == unidade2) {
                resultado = temperatura;
                System.out.println("\nAs unidades são iguais, não é necessário conversão.");
            } else if (unidade1 == 1 && unidade2 == 2) {
                resultado = (temperatura * 9/5) + 32;
                System.out.println("\nFórmula: (°C × 9/5) + 32 = °F");
            } else if (unidade1 == 1 && unidade2 == 3) {
                resultado = (temperatura + 273.15);
                System.out.println("\nFórmula: °C + 273.15 = K");
            } else if (unidade1 == 2 && unidade2 == 1) {
                resultado = (temperatura - 32) * 5/9;
                System.out.println("\nFórmula: (°F - 32) × 5/9 = °C");
            } else if (unidade1 == 2 && unidade2 == 3) {
                resultado = (temperatura - 32) * 5/9 + 273.15;
                System.out.println("\nFórmula: (°F - 32) × 5/9 + 273.15 = K");
            } else if (unidade1 == 3 && unidade2 == 1) {
                resultado = (temperatura - 273.15);
                System.out.println("\nFórmula: K - 273.15 = °C");
            } else if (unidade1 == 3 && unidade2 == 2) {
                resultado = (temperatura - 273.15) * 9/5 + 32;
                System.out.println("\nFórmula: (K - 273.15) × 9/5 + 32 = °F");
            }

            // Exibição do resultado
            System.out.printf("\nResultado: %.2f %s = %.2f %s\n",
                    temperatura, simbolos[(int)unidade1-1],
                    resultado, simbolos[(int)unidade2-1]);

            // Adicionar ao histórico
            historico.append(String.format("%.2f %s → %.2f %s\n",
                    temperatura, simbolos[(int)unidade1-1],
                    resultado, simbolos[(int)unidade2-1]));

            // Perguntar se deseja continuar
            System.out.println("\nDeseja fazer outra conversão? (S/N)");
            String resposta = conversor.next();
            continuar = resposta.equalsIgnoreCase("S");

            // Se não for continuar, perguntar se deseja ver o histórico
            if (!continuar) {
                System.out.println("\nDeseja ver o histórico de conversões? (S/N)");
                resposta = conversor.next();
                if (resposta.equalsIgnoreCase("S")) {
                    System.out.println("\n----- HISTÓRICO DE CONVERSÕES -----");
                    System.out.println(historico.toString());
                }
            }
        }

        System.out.println("\nObrigado por utilizar o Conversor de Temperatura!");
        conversor.close();
    }
}
