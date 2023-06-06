package misc;

public class RotaInvalida extends Exception{

    public RotaInvalida(String msg){
        super(msg);
    }
    @Override
    public String toString() {
        return super.getMessage();
    }
}
