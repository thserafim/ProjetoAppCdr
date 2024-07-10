package ProjetoApp.Hora;

public class Hora {

    private int horaInicio;
    private int horaFim;

    public Hora( int horaInicio, int horaFim) throws Exception {
        if (horaFim - horaInicio <  5 || horaFim - horaInicio > 12){
            throw new Exception("Horas trabalhadas devem ser no minimo 5 e no maximo 12");
        }
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public int getHorasTrabalhadas(){
        return horaFim - horaInicio;
    }
    @Override

    public String toString() {return String.format("Inicio: %02d:00, Fim: %02d:00", horaInicio, horaFim);

    }
}
