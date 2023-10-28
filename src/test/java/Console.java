

public class Console{
    private String nome;
    private Especificacao espec;

    public Console(String nome, Especificacao espec) {
        this.nome = nome;
        this.espec = espec;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especificacao getEspec() {
        return espec;
    }
    public void setEspec(Especificacao espec) {
        this.espec = espec;
    }
    @Override
    public String toString() {
    return "id : " + espec.getId() + System.lineSeparator() +
            "Nome: " + nome + System.lineSeparator() +
           "Marca: " + espec.getMarca() + System.lineSeparator() +
           "Modelo: " + espec.getModelo() + System.lineSeparator() +
           "HD: " + espec.getHd() + " GB" + System.lineSeparator() +
           "Cor: " + espec.getCor() + System.lineSeparator();
    }
}

