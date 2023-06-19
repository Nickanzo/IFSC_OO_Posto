package misc;

public class RotaInvalida extends Exception{
//  Excecao para Rota de Arquivo
    public RotaInvalida(String msg){
        super(msg);
    }
    @Override
    public String toString() {
        return super.getMessage();
    }
}
