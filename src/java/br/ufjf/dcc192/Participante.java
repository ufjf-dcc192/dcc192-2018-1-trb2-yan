package br.ufjf.dcc192;

public class Participante {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private Participante sorteado;
    private Evento amigoOculto;

    public Participante(int id, String nome, String email,
            String senha, Participante sorteado, Evento sorteio) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.sorteado = sorteado;
        this.amigoOculto = sorteio;
    }

    public Participante() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Participante getSorteado() {
        return sorteado;
    }

    public void setSorteado(Participante sorteado) {
        this.sorteado = sorteado;
    }

    public Evento getAmigoOculto() {
        return amigoOculto;
    }

    public void setAmigoOculto(Evento amigoOculto) {
        this.amigoOculto = amigoOculto;
    }

}
