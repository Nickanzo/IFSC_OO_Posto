package misc;

import java.util.Scanner;

public class LeitorInput {
//  Instancia de Scanner
    Scanner s = new Scanner(System.in);
//  Construtor vazio
    public LeitorInput() {
    }
//  Retorna valor de String do Input de Usuário
    public String stringInput(){
        String input = s.nextLine();
        return input;
    }
//  Retorna valor de Int do Input do Usuário
    public int intInput(){
        int input = s.nextInt();
        return input;
    }
}
