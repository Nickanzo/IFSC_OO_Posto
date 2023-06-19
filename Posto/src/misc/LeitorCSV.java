package misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorCSV{
    private String caminho;
    private final String delimitador = ";";
    public LeitorCSV(String filePath) {
        this.caminho = filePath;
    }
    public List<String[]> readCSV() {
        List<String[]> data = new ArrayList<>();
//      Ler arquivo e armazenar em Lista de Matriz de String
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(delimitador);
                data.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}

