

public class Especificacao {
    private int id;
    private String marca;
    private String modelo;
    private double hd;
    private String cor;
    
    
    public Especificacao(String marca, String modelo, double hd, String cor, int id) {
        this.marca = marca;
        this.modelo = modelo;
        this.hd = hd;
        this.cor = cor;
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public double getHd() {
        return hd;
    }
    public String getCor() {
        return cor;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setHd(double hd) {
        this.hd = hd;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public Especificacao(int id) {
        this.id = id;
    }

}