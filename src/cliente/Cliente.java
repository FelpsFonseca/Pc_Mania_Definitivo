package cliente;
import computador.Computador;

public class Cliente {
    private String nome;
    private int cpf;

    private Computador[] carrinho;
    private int qnt;

    public Cliente(String nome, int cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.carrinho = new Computador[20];
        this.qnt = 0;
    }

    public void comprar(Computador pc) {
        if (pc == null) return;
        if (qnt < carrinho.length) {
            carrinho[qnt] = pc;
            qnt++;
        } else {
            System.out.println("Carrinho cheio");
        }
    }

    public void mostraCarrinho() {
        if (qnt == 0) {
            System.out.println("Carrinho vazio");
            return;
        }
        for (int i = 0; i < qnt; i++) {
            System.out.println("\nItem " + (i + 1) + ":");
            carrinho[i].mostraPCConfigs();
        }
    }

    public double calculaTotalCompra() {
        double total = 0.0;
        for (int i = 0; i < qnt; i++) {
            total += carrinho[i].getPreco();
        }
        return total;
    }

    public void mostraInfo() {
        System.out.println("Cliente: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Quantidade de PCs: " + qnt);
    }

    // Getter ProcessarPedido
    public Computador[] getCarrinho() {
        Computador[] usados = new Computador[qnt];
        for (int i = 0; i < qnt; i++) {
            usados[i] = carrinho[i];
        }
        return usados;
    }
}