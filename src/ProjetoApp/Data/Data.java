package ProjetoApp.Data;

public class Data {

    private int dia;
    private int mes;

    public Data(int dia, int mes) throws Exception {
        if(dia < 1 || dia > 31 || mes < 1 || mes > 12 || (mes == 2 && dia > 29) ||(mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30){
            throw new Exception("Data inválida para 2024.");
        }
        this.dia = dia;
        this.mes = mes;
    }
    public int getMes(){
        return mes;
    }

    @Override
    public String toString() {return String.format("%02d/%02d/2024", dia , mes);}
}
