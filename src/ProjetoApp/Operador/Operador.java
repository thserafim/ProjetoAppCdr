package ProjetoApp.Operador;


import java.util.UUID;

public class Operador {

    private String nome;
    private String id;

    public Operador(String nome) {
        this.nome = nome;
        this.id = UUID.randomUUID().toString(); //gera um id único
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }
}
