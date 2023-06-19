package misc;

public class OpcaoInvalida extends Exception{

    public OpcaoInvalida(String msg){
        super(msg);
    }
    @Override
    public String toString() {
        return super.getMessage();
    }
}
