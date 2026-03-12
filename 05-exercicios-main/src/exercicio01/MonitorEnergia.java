package exercicio01;

public class MonitorEnergia {


    double [] consumo;
    int indice;

    // Método construtor ( Inicializa o vetor com o tamanho desejado)

    public MonitorEnergia(int tamanho) {
        this.consumo = new double[tamanho];
    }

    // Método para registrar o (consumo de energia)

    public void registrarConsumo( double valor){

        if (indice < consumo.length){
            consumo[indice] = valor;
            indice++;
        }
    }

    //Método para calcular a média total

    public double calcularMedia(){

       return calcularMedia(1, indice);
    }

    //Método para calcular a média entre os dias (2 e 4)

    public double calcularMedia(int inicio, int fim) {
        double media = 0;

        for (int i = inicio - 1; i < fim; i++){
            media += consumo[i];
        }
        return  media / (fim - inicio + 1);
    }

}









