package ProjetoApp.Modalidade;

public class Modalidade {

    private String tipo;

    public Modalidade(String tipo) throws Exception {
        if (!tipo.equals("RM") && !tipo.equals("TC") && !tipo.equals("RX")){
            throw new Exception("Modalidade Invalida. Use RM, TC ou RX ");
        }
        this.tipo = tipo;
    }
    public String getTipo(){
        return tipo;
    }
}
