package test;

import misc.*;
import Posto.Posto;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        String filePath = "Posto.Posto/src/gasolina-etanol.csv";
        String filePath = "";
        if (filePath.isEmpty()){
            try{
                filePath = GUI.procuraCaminho();
            }catch (RotaInvalida e){
                e.getMessage();
                System.exit(0);
            }
        }

        if (!filePath.isEmpty()){
            System.out.println("Processando arquivo...");
            List<String []> dadosPosto= new LeitorCSV(filePath).readCSV();
            ArrayList<Posto> postos = carregaDados(dadosPosto);
            listaDados(postos);
        }
    }

    public static ArrayList<Posto> carregaDados(List<String[]> dados){
        ArrayList<Posto> postos = new ArrayList<>();
//      Utilizado sublist para ignorar cabecalho
        for (String[] s : dados.subList(5, dados.size())){
            for (int i = 0; i < s.length; i++ ){
                Posto p = new Posto(s[i], s[i+1], s[i+2], s[i+3], s[i+4]);
                postos.add(p);
                break;
            }
        }
        return postos;
    }
    public static void listaDados(ArrayList<Posto> dados){
        for (Posto p : dados){
            System.out.println(p.toString());
        }
    }
}