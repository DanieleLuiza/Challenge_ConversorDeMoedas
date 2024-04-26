package br.com.conversormoedas.principal;

import br.com.conversormoedas.service.ConversorService;

import java.math.BigDecimal;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        String primeiraMoeda = null;
        String segundaMoeda = null;

        System.out.println("#################################");
        System.out.println("Sejam Bem Vindos ao Conversor de Moedas!");
        System.out.println("Escolha uma opção válida");
        System.out.println("1 - DÓLAR para PESO ARGENTINO");
        System.out.println("2 - PESO ARGENTINO para DÓLAR");
        System.out.println("3 - DÓLAR para REAL BRASILEIRO");
        System.out.println("4 - REAL BRASILEIRO para DÓLAR");
        System.out.println("5 - DÓLAR para PESO COLOMBIANO");
        System.out.println("6 - PESO COLOMBIANO para DÓLAR");
        System.out.println("7 - SAIR");
        System.out.println("#################################");

        var opcao = leitura.nextLine();

        System.out.println("Digite o valor a ser convertido: ");
        var valor = leitura.nextBigDecimal();

        switch (opcao) {
            case "1":
                primeiraMoeda = "USD";
                segundaMoeda = "ARS";
                break;
            case "2":
                primeiraMoeda = "ARS";
                segundaMoeda = "USD";
                break;
            case "3":
                primeiraMoeda = "USD";
                segundaMoeda = "BRL";
                break;
            case "4":
                primeiraMoeda = "BRL";
                segundaMoeda = "USD";
                break;
            case "5":
                primeiraMoeda = "USD";
                segundaMoeda = "COP";
                break;
            case "6":
                primeiraMoeda = "COP";
                segundaMoeda = "USD";
                break;
            case "7":
                System.out.println("Saindo do sistema, até logo ...");
                break;

            default:
                System.out.println("Por favor informe uma Opção valida de 1 a 7...");
                break;
        }

        ConversorService service = new ConversorService();
        BigDecimal cotacao = service.converterMoeda(primeiraMoeda, segundaMoeda);
        BigDecimal resultado = service.converter(valor , cotacao);
        System.out.println("Total Convertido: " + resultado);

    }

}