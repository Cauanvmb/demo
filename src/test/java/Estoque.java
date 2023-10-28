

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Estoque {
            ArrayList<Console> estoqueConsoles = new ArrayList<Console>();
            Scanner sc = new Scanner(System.in);
            int numero;
            public void EstoqueEmUso() {
                do {
                System.out.printf("%nA operação que deseja fazer: %n%nSe quiser ver apenas imprimir o estoque insira 0%n%nSe deseja adicionar console(s) ao estoque insira 1%n%nSe deseja remover um item da lista insira 2%n%n");
                numero = sc.nextInt();
                if (numero == 1) {
                    adicionar();
                }
                else if(numero == 0) {
                    verLista();
                }
                else if(numero==2) {
                    removerPorId();
                }
                } while(numero > -1 && numero < 3);
            }
        public void adicionar() {   
                    System.out.print("Insira quantas quer inserir no estoque: ");
                    int adicionando = sc.nextInt();
                    for (int i = 0; i<adicionando;i+=1) {
                    sc.nextLine();
                    System.out.print("Insira o id do console: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Insira o nome do console: ");
                    String nome = sc.nextLine();
                    System.out.print("Insira o marca do console: ");
                    String marca = sc.nextLine();
                    System.out.print("Insira o modelo do console: ");
                    String modelo = sc.nextLine();
                    System.out.print("Insira o hd(gigas de memória) do console: ");
                    double hd = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Insira a cor do console: ");
                    String cor = sc.nextLine();
                    Especificacao espec = new Especificacao(marca, modelo, hd, cor, id);
                    Console item = new Console(nome,espec);
                    estoqueConsoles.add(item);
                    System.out.printf("%n%n%n");
                    System.out.println(estoqueConsoles);
                }
        }
        public void verLista() {
            System.out.printf("%n%nAqui está o conteúdo do Estoque.%n%n");
            System.out.println(estoqueConsoles);
        }
        public void removerPorId() {
            Scanner sc = new Scanner(System.in);
            int id;
            while (true) {
                try {
                    System.out.print("Insira o ID do item a ser removido: ");
                    id = sc.nextInt();
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número válido.");
                    sc.nextLine();
                    sc.close();
                }
            }
            Iterator<Console> iterator = estoqueConsoles.iterator();
            while (iterator.hasNext()) {
                Console console = iterator.next();
                if (console.getEspec().getId() == id) {
                    iterator.remove();
                    System.out.println("Item removido com sucesso.");
                    System.out.println(estoqueConsoles);
                    return;  
                }
            }
            System.out.println("Nenhum item com o ID fornecido foi encontrado.");
            System.out.println(estoqueConsoles);
            sc.close();
        }
}