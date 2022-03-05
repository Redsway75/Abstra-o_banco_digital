import Package1.Conta;
import Package1.ContaCorrente;
import Package1.ContaPoupanca;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;
import javax.sound.midi.Soundbank;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
public class App {
    public static void main(String[] args) throws Exception {

        Scanner lernome = new Scanner(System.in);
        Scanner lerid = new Scanner(System.in); 
        Scanner ler = new Scanner(System.in);
        Conta[] listaContas = new Conta[2];

        ContaCorrente contaCorrente;
        ContaPoupanca contaPoupanca;

        int OPCAO;
        double valores;
        int j=0;

        while(true){
            
            System.out.printf("SELECIONE UMA OPCAO:\n");
            System.out.printf("1- Criar uma conta\n");
            System.out.printf("2- Extratos\n");
            System.out.printf("3- Sacar\n");
            System.out.printf("4- Depositar\n");
            System.out.printf("5- Transferir\n");
            System.out.printf("6- Sair\n");
            OPCAO = ler.nextInt();

            switch(OPCAO){
                case 1:

                    System.out.printf("SELECIONE O TIPO DE CONTA:\n");
                    System.out.println();
                    System.out.printf("1- Conta corrente\n");
                    System.out.println();
                    System.out.printf("2- Conta poupanca\n");
                    System.out.println();
                    OPCAO = ler.nextInt();

                    switch(OPCAO){
                        case 1:

                            if(j==2){System.out.printf("Capacidade cheia!");break;}

                            int idade;
                            String nome;
                            int agencia;
                            contaCorrente = new ContaCorrente();

                            System.out.printf("Nome:\n");
                            nome = lernome.nextLine();
                            System.out.printf("Idade:\n");
                            idade = lerid.nextInt();
                            System.out.printf("Agencia:\n");
                            agencia = lerid.nextInt();

                            contaCorrente.setIdade(idade);
                            contaCorrente.setNome(nome);
                            contaCorrente.setAgencia(agencia);
                            listaContas[j] = contaCorrente;
                            j++;

                        break;
                        case 2:
                            if(j==2){System.out.printf("Capacidade cheia!\n");break;}

                            String nome2;
                            int idade2;
                            int agencia2;
                            contaPoupanca = new ContaPoupanca();

                            System.out.printf("Nome:\n");
                            nome2 = lernome.nextLine();
                            System.out.printf("Idade:\n");
                            idade2 = lerid.nextInt();
                            System.out.printf("agencia: \n");
                            agencia2 = lerid.nextInt();

                            contaPoupanca.setIdade(idade2);
                            contaPoupanca.setNome(nome2);
                            contaPoupanca.setAgencia(agencia2);
                            listaContas[j] = contaPoupanca;
                            j++;
                        break;
                    }
                break;
                case 2:
                 try{
                    if(listaContas[0] == null)
                        System.out.printf("Nenhuma conta criada\n");

                    else{
                            for(int i=0;i<listaContas.length; i++){
                                System.out.println("======== EXTRATO BANCARIO ========");
                                System.out.print("Nome: "+listaContas[i].getNome()+"\n");
                                System.out.print("Idade: "+listaContas[i].getIdade()+"\n");
                                System.out.print("Saldo: "+listaContas[i].getSaldo()+"\n");
                                System.out.print("Tarifa: R$"+listaContas[i].tarifa+"\n");
                                System.out.print("Tipo: "+listaContas[i].getTipo()+"\n");
                                System.out.println("Agencia: "+listaContas[i].getAgen()+"\n");
                                System.out.println("==================================");
                            
                            System.out.println();}  
                        }}catch(java.lang.NullPointerException e){
                            System.out.println("\n");
                        }
                        
                break;
                case 3:
                    if(listaContas[0] == null && listaContas[1] == null){
                        System.out.println("Nenhuma conta foi criada ainda!\n");
                        break;
                    }
                    Scanner valor = new Scanner(System.in);
                    try{
                    System.out.print("Conta para executar saque:\n");
                    System.out.print("0- "+listaContas[0].getNome()+"\n");
                    System.out.print("1- "+listaContas[1].getNome()+"\n");

                    }catch(java.lang.NullPointerException e){System.out.println("\n");}

                    OPCAO = ler.nextInt();

                    System.out.print("Insira um valor que queira sacar: \n");
                    valores = valor.nextDouble();

                    if(OPCAO == 0){
                        if(listaContas[0] == null){System.out.print("Vazio!");}

                        else{
                            listaContas[0].saque(valores);}
                        }
                    else{
                        if(listaContas[1]== null){System.out.printf("Vazio!\n");}

                        else{

                            listaContas[1].saque(valores);}
                    }
                break;
                case 4:
                    if(listaContas[0]==null && listaContas[1]== null){
                        System.out.printf("Nenhuma Conta foi criada!\n");
                        break;
                    }
                    Scanner valor_depo = new Scanner(System.in);
                    try{
                    System.out.print("Conta para executar deposito:\n");
                    System.out.print("0- "+listaContas[0].getNome()+"\n");
                    System.out.print("1- "+listaContas[1].getNome()+"\n");
                    }catch(java.lang.NullPointerException e){System.out.printf("\n");}
                    OPCAO = ler.nextInt();

                    System.out.print("Insira um valor que queira depositar: \n");
                    valores = valor_depo.nextDouble();

                    if(OPCAO == 0){
                        if(listaContas[0] == null){System.out.print("Vazio!");}

                        else{
                            listaContas[0].deposito(valores);}
                    }
                    else{
                        if(listaContas[1]== null){System.out.printf("Vazio!\n");}

                        else{

                            listaContas[1].deposito(valores);}
                    }
                break;
                case 5:
                    if(listaContas[0] == null || listaContas[1] == null){
                        System.out.printf("Crie pelo menos duas contas para executar trasferencia de um para outro\n");
                        break;
                    }
                    else{
                        Scanner valor_trans = new Scanner(System.in);
                        System.out.println("Escolha uma conta para transferir para outra:");
                        System.out.print("0- "+listaContas[0].getNome()+"\n");
                        System.out.print("1- "+listaContas[1].getNome()+"\n");
                        OPCAO = ler.nextInt();

                        switch (OPCAO) {
                           case 0:

                            System.out.println("Valor da tranferencia:");
                            valores = valor_trans.nextDouble();

                            listaContas[0].transferir(listaContas[0], listaContas[1], valores);
                        break;
                        case 1:

                            System.out.println("Valor da tranferencia:");
                            valores = valor_trans.nextDouble();

                            listaContas[1].transferir(listaContas[1], listaContas[0], valores);
                        break;
                        default:
                            System.out.println("Digito invalido!");
                    }
                }
                break;

                case 6:
                    System.exit(0);
                break;
                default:
                    System.out.printf("Digite um valor valido!\n");
                break;

            }



        }
    }
}
