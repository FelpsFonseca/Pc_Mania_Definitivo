package computador;

public class Computador {
    private String marca;
    private double preco;
    private SistemaOperacional so;
    private HardwareBasico[] hardwares;
    private MemoriaUSB brinde;

    public Computador(String marca, double preco) {
        this.marca = marca;
        this.preco = preco;
        this.hardwares = new HardwareBasico[3]; // Processador, RAM e HD
    }

    public void setSo(SistemaOperacional so) {
        this.so = so;
    }

    public void setHardware(HardwareBasico h1, HardwareBasico h2, HardwareBasico h3) {
        this.hardwares[0] = h1;
        this.hardwares[1] = h2;
        this.hardwares[2] = h3;
    }

    public void setBrinde(MemoriaUSB brinde) {
        this.brinde = brinde;
    }

    public double getPreco() {
        return preco;
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$ " + preco);

        if (hardwares[0] != null) {
            System.out.println("Processador: " + hardwares[0].getNome() + " (" + hardwares[0].getCapacidade() + " Mhz)");
        }
        if (hardwares[1] != null) {
            System.out.println("Memória: " + hardwares[1].getNome() + " (" + hardwares[1].getCapacidade() + " Gb)");
        }
        if (hardwares[2] != null) {
            System.out.println("Armazenamento: " + hardwares[2].getNome() + " (" + hardwares[2].getCapacidade() + " Gb)");
        }
        if (so != null) {
            System.out.println("Sistema Operacional: " + so.getNome() + " (" + so.getTipo() + " bits)");
        }
        if (brinde != null) {
            System.out.println("Brinde: " + brinde.getNome() + " (" + brinde.getCapacidade() + " Gb)");
        }
    }
}
