package Posto;

public class Posto {
//  Atributos vindos do CSV
    String Revenda,
            Bairro,
            Produto,
            Bandeira;
//  Valor em R$
    float valorVenda;
//  Construtor completo com tratamento de String para Float
    public Posto(String revenda, String bairro, String produto, String valorVenda, String bandeira) {
        Revenda = revenda;
        Bairro = bairro;
        Produto = produto;
        Bandeira = bandeira;
        String valVenda = valorVenda.replace(',','.');
        this.valorVenda = Float.parseFloat(valVenda);
    }
  /*
  *  Getters
  */
    public String getRevenda() {
        return Revenda;
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
