package test;

import misc.*;

public class Main {



    public static void main(String[] args) {

        String filePath = "";

        try{
            while (filePath.isBlank()){
                filePath = GUI.procuraCaminho();
            }
        }catch (RotaInvalida e){
            e.getMessage();
        }


        System.out.println(filePath);

        if (!filePath.isEmpty()){
            LeitorCSV csv = new LeitorCSV(filePath);
        }


    }

}