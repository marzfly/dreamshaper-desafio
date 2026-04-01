import java.util.ArrayList;
import java.util.Scanner;

public class CalculadoraSalario {
    public static final double SALARIO_BASE = 2000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double salarioFinal, vendas = 0, percentualComissao = 0, valorPeca;
        double comissao, produtividade;
        String nomeCompleto;
        int numeroRegistro, qtdPecas;
        int opcao = 0;

        ArrayList<String> nome = new ArrayList<String>();
        ArrayList<Integer> matricula = new ArrayList<>();
        ArrayList<Double> bonus = new ArrayList<>();
        ArrayList<Double> salario = new ArrayList<>();

        do{
            System.out.println("===========");
            System.out.println("MENU");
            System.out.println("===========");
            System.out.println("1 - Cadastrar funcionário padrão");
            System.out.println("2 - Cadastrar funcionário comissionado");
            System.out.println("3 - Cadastrar funcionário de produção");
            System.out.println("4 - Gerar folha de pagamento");
            System.out.println("0 - Sair do programa");

            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao){
                case 1:
                    System.out.print("Digite o seu nome completo: ");
                    nomeCompleto = sc.nextLine();
                    nome.add(nomeCompleto);

                    System.out.print("Digite o seu número de registro: ");
                    numeroRegistro = sc.nextInt();

                    if(numeroRegistro < 1){
                        System.out.println("Número de registro inválido!");
                        numeroRegistro = sc.nextInt();
                    } else {
                        matricula.add(numeroRegistro);
                    }

                    bonus.add(0.0);

                    salarioFinal = SALARIO_BASE;
                    salario.add(salarioFinal);
                    break;

                case 2:
                    System.out.print("Digite o seu nome completo: ");
                    nomeCompleto = sc.nextLine();
                    nome.add(nomeCompleto);

                    System.out.print("Digite o seu número de registro: ");
                    numeroRegistro = sc.nextInt();

                    if(numeroRegistro < 1){
                        System.out.println("Número de registro inválido!");
                        numeroRegistro = sc.nextInt();
                    } else {
                        matricula.add(numeroRegistro);
                    }

                    System.out.print("Informe o valor das vendas no último mês: ");
                    vendas = sc.nextDouble();
                    if (vendas < 0){
                        System.out.println("Número inválido!");
                        vendas = sc.nextDouble();
                    }
                    System.out.print("Informe o percentual de comissão: ");
                    percentualComissao = sc.nextDouble();
                    if (percentualComissao < 0){
                        System.out.println("Número inválido!");
                        percentualComissao = sc.nextDouble();
                    }

                    comissao = (vendas * percentualComissao) / 100;
                    bonus.add(comissao);
                    salarioFinal = SALARIO_BASE + comissao;
                    salario.add(salarioFinal);
                    break;

                case 3:
                    System.out.print("Digite o seu nome completo: ");
                    nomeCompleto = sc.nextLine();
                    nome.add(nomeCompleto);

                    System.out.print("Digite o seu número de registro: ");
                    numeroRegistro = sc.nextInt();
                    
                    if(numeroRegistro < 1){
                        System.out.println("Número de registro inválido!");
                        numeroRegistro = sc.nextInt();
                    } else {
                        matricula.add(numeroRegistro);
                    }

                    System.out.print("Informe a quantidade de peças produzidas no período: ");
                    qtdPecas = sc.nextInt();
                    if(qtdPecas < 0){
                        System.out.println("Número inválido!");
                        qtdPecas = sc.nextInt();
                    }
                    System.out.print("Informe o valor da peça: ");
                    valorPeca = sc.nextDouble();
                    if(valorPeca <= 0){
                        System.out.println("Número inválido!");
                        valorPeca = sc.nextDouble();
                    }

                    produtividade = (valorPeca * qtdPecas);
                    bonus.add(produtividade);
                    salarioFinal = SALARIO_BASE + produtividade;
                    salario.add(salarioFinal);
                    break;

                case 4:
                    System.out.println("\n");
                    System.out.println("=== FOLHA DE PAGAMENTO ===");
                    for(int i = 0; i < nome.size(); i++){
                        System.out.println("Matrícula: " + matricula.get(i));
                        System.out.println("Nome completo do funcionário: " + nome.get(i));
                        System.out.println("Bônus obtido: " + bonus.get(i));
                        System.out.println("Salário final: " + salario.get(i));
                        System.out.println("\n");
                    }
                    break;
            }
        }while(opcao != 0);

        sc.close();
    }
}
