package Posto;

public class Posto {

    String Revenda,
            Bairro,
            Produto,
            Bandeira;
    float valorVenda;

    public Posto(String revenda, String bairro, String produto, String valorVenda, String bandeira) {
        Revenda = revenda;
        Bairro = bairro;
        Produto = produto;
        Bandeira = bandeira;
        String valVenda = valorVenda.replace(',','.');
        this.valorVenda = Float.parseFloat(valVenda);
    }

    public String getRevenda() {
        return Revenda;
    }

    public void setRevenda(String revenda) {
        Revenda = revenda;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public void setProduto(String produto) {
        Produto = produto;
    }

    public void setBandeira(String bandeira) {
        Bandeira = bandeira;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getBairro() {
        return Bairro;
    }

    public String getProduto() {
        return Produto;
    }

    public String getBandeira() {
        return Bandeira;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    @Override
    public String toString() {

        String valVenda = String.valueOf(valorVenda).replace('.',',');
        return Revenda + " | " +
               "Bairro: " + Bairro + " | " +
               Produto + " | " +
               Bandeira + " | " +
               "R$" + valVenda;
    }
}
