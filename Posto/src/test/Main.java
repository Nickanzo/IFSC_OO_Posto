package test;

import misc.*;

public class Main {



    public static void main(String[] args) {

        String filePath = "";


        while (filePath.isEmpty()){
            filePath = GUI.procuraCaminho();
        }

        System.out.println(filePath);

        if (!filePath.isEmpty()){
            LeitorCSV csv = new LeitorCSV(filePath);
        }


    }

}