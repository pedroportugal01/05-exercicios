package exercicio01;

public class Main {

    public static void main(String[] args) {
        // Criando o monitor para 5 dias
        MonitorEnergia monitor = new MonitorEnergia(5);

        monitor.registrarConsumo(32.5);
        monitor.registrarConsumo(30.1);
        monitor.registrarConsumo(29.8);
        monitor.registrarConsumo(33.0);
        monitor.registrarConsumo(31.7);

        // Exibindo os consumos registrados para conferência
        for (int i = 0; i < monitor.indice; i++) {
            System.out.println("Consumo registrado no dia " + (i + 1) + ": " + monitor.consumo[i] + " kWh");

            System.out.println("------------------------------------");
            System.out.printf("Média total de consumo: %.2f kWh\n", monitor.calcularMedia());
            System.out.printf("Média entre dia 2 e dia 4: %.2f kWh\n", monitor.calcularMedia(2, 4));




        }


    }
}