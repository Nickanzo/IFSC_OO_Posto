package misc;

public class OpcaoInvalida extends Exception{
//  Excecao para Opcao Invalida
    public OpcaoInvalida(String msg){
        super(msg);
    }
    @Override
    public String toString() {
        return super.getMessage();
    }
}
