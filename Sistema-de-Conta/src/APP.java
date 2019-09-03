/* A classe "App" Usa a classe "Conta" 
 * Vetor lista do tipo conta, onde cada índice é um objeto do tipo Conta;
 * Um arrey é um objeto;
 * O conteúdo do vertor é o endereço do objeto em memória;
 * A posição de cada elemento do Arrey é null, 
 * então para exluir teria que varrer o vetor e no indice i atribuir null
 * F3- direciona para a função
 * system.gc - garbage colector - para limpar os objetos perdidos em memória - performático 
 * brak ta fora do else - listar lista (ERRO)
 * */
import java.util.Scanner;

public class APP {
    
    //Constante
    static final int MAXCONTA = 20;
   
    //variavel comum
    static int index = 0;
    
    //Lista de contas
    static Conta[] lista = new Conta[MAXCONTA];
    
    static Scanner tecla = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        do {                
            System.out.println("*** MENU PRINCIPAL ***");
            System.out.println("1-Incluir conta");
            System.out.println("2-Sacar");
            System.out.println("3-Depositar");
            System.out.println("4-Listar saldo das Contas");
            System.out.println("5-Excluir conta");
            System.out.println("6-Sair");
            System.out.println("Digite sua Opção: ");
            op = tecla.nextInt(); 
            switch(op){
                case 1: incluirConta(); break;
                case 2: sacarValor(); break;
                case 3: depositarValor(); break;    
                case 4: listarContas(); break;
                case 5: excluirConta(); break;
                case 6: break;
            }
        } while (op!=5);       
    }
    
    
    public static void incluirConta(){
        //Entrada
        System.out.println("Digite o nÃºmero da conta:");
        int num = tecla.nextInt();
        System.out.println("Digite o saldo da conta:");
        double saldo = tecla.nextDouble();
        //Criar o objeto e inserir na lista
        lista[index++] = new Conta(num, saldo);
        System.out.println("Conta cadastrada com sucesso!");
    }
    
    public static void sacarValor(){
        //Entrada
        System.out.println("Digite o número da conta:");
        int num = tecla.nextInt();
        System.out.println("Digite o valor do saque:");
        double valor = tecla.nextDouble();
        
        //Procurar a conta na lista
        for (int i = 0; i < lista.length-1; i++) {
            if (num == lista[i].getNumero()){
                lista[i].sacar(valor);
                break;
            }
        }
    }
    
    public static void excluirConta(){
        //Entrada
        System.out.println("Digite o número da conta:");
        int num = tecla.nextInt();
        
        //Procurar a conta na lista
        for (int i = 0; i < lista.length-1; i++) {
            if (num == lista[i].getNumero()){
                lista[i] = null;
                System.out.println("Conta excluida com sucesso:");
                System.gc();
                break;
            }
        }
    }
    
    public static void depositarValor(){
        //Entrada
        System.out.println("Digite o número da conta:");
        int num = tecla.nextInt();
        System.out.println("Digite o valor do depósito:");
        double valor = tecla.nextDouble();
        
        //Procurar a conta na lista
        for (int i = 0; i < lista.length-1; i++) {
            if (num == lista[i].getNumero()){
                lista[i].depositar(valor);
                break;
            }
        }
    }
    
    public static void listarContas(){
        double total = 0;
        System.out.println("Número da Conta:........ SALDO:");
        for (int i = 0; i < lista.length-1; i++) {
            if (lista[i] != null){
                System.out.println(lista[i].getNumero()
                                   + "........" +
                                   lista[i].getSaldo());
                //total += lista[i].getSaldo();
                total = total + lista[i].getSaldo();
            }else{
                break;
            }
        }
        System.out.println("Total:........" + total);
    }
    
    
}
