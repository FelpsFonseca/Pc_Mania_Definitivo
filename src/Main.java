import cliente.Cliente;
import computador.Computador;
import computador.HardwareBasico;
import computador.MemoriaUSB;
import computador.SistemaOperacional;
import processarpedido.ProcessarPedido;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double matricula = 1898;

        // Cliente
        Cliente cliente = new Cliente("Felipe", 123456789);

        // Promoções
        Computador promo1 = new Computador("Apple", matricula);
        promo1.setSo(new SistemaOperacional("macOS Sequoia", 64));
        promo1.setHardware(new HardwareBasico("Pentium Core i3", 2200), new HardwareBasico("Memória RAM", 8), new HardwareBasico("HD", 500));
        promo1.setBrinde(new MemoriaUSB("Pen-drive", 16));

        Computador promo2 = new Computador("Samsung", matricula + 1234);
        promo2.setSo(new SistemaOperacional("Windows 8", 64));
        promo2.setHardware(new HardwareBasico("Pentium Core i5", 3370), new HardwareBasico("Memória RAM", 16), new HardwareBasico("HD", 1000));
        promo2.setBrinde(new MemoriaUSB("Pen-drive", 32));

        Computador promo3 = new Computador("Dell", matricula + 5678);
        promo3.setSo(new SistemaOperacional("Windows 10", 64));
        promo3.setHardware(new HardwareBasico("Pentium Core i7", 4500), new HardwareBasico("Memória RAM", 32), new HardwareBasico("HD", 2000));
        promo3.setBrinde(new MemoriaUSB("HD Externo", 1000));

        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção de 1 a 3.Aperte 0 para finalizar:");
            System.out.println("Promoção 1 Apple R$ " + promo1.getPreco());
            System.out.println("Promoção 2 Samsung R$ " + promo2.getPreco());
            System.out.println("Promoção 3 Dell R$ " + promo3.getPreco());
            opcao = input.nextInt();

            if (opcao == 1) {
                cliente.comprar(promo1);
            }
            else if (opcao == 2) {
                cliente.comprar(promo2);
            }
            else if (opcao == 3) {
                cliente.comprar(promo3);
            }
            else if (opcao == 0) {
                System.out.println("Compra finalizada.");
            }
            else {
                System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        input.close();

        // Resumo da compra
        System.out.println("\nPedido: ");
        cliente.mostraInfo();
        System.out.println("\nPCs comprados: ");
        cliente.mostraCarrinho();

        double total = cliente.calculaTotalCompra();
        System.out.println("\nTotal: R$ " + total);

        // Processar Pedido
        ProcessarPedido.enviar(cliente.getCarrinho());
    }
}