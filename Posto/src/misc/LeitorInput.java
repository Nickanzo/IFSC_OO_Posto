package misc;

import java.util.Scanner;

public class LeitorInput {
    Scanner s = new Scanner(System.in);

    public LeitorInput() {
    }

    public Scanner LeitorInput(){
        return this.s;
    }

    public String stringInput(){
        String input = s.nextLine();
        return input;
    }
    public int intInput(){
        int input = s.nextInt();
        return input;
    }
}
