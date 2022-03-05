package Package1;

public class Conta {
    
    private String nome;
    private int idade;
    private int agencia;
    private String data_abertura;
    private String tipo_conta;
    public double saldo;
    public double tarifa;

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public String getData(){
        return data_abertura;
    }
    public void setData(String data){
        this.data_abertura = data;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(Double saldo){
        this.saldo = saldo;
    }
    public double getTarifa(){
        return tarifa;
    }
    public void setTarifa(Double tarifa){
        this.tarifa = tarifa;
    }

    public String getTipo(){
        return tipo_conta;
    }
    public void setTipo(String tipo_conta){
        this.tipo_conta = tipo_conta;
    }

    public int getAgen(){
        return agencia;
    }
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double saque(double valor){
        if(valor<=saldo){
            saldo = saldo - valor;
            System.out.printf("Saque realizado com sucesso!");
            return saldo;
        }
        else{System.out.printf("Saldo insuficiente!\n"); return saldo;}
    }
    public double deposito(double valor){
        saldo = saldo+valor;
        saldo = saldo-this.tarifa;
        System.out.printf("Deposito concluido!");
        return saldo;
    }

    public void transferir(Conta a, Conta b, double transferencia){
        if(a.getSaldo()<transferencia){
            System.out.printf("Saldo insuficiente!\n");
        }
        else{
            a.saldo = a.saldo - transferencia;
            b.saldo = b.saldo + transferencia;
            System.out.println("Transferencia concluida!\n");
        }
    }


    

}
