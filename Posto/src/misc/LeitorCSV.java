package misc;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorCSV {
    private String caminho;
    private String delimitador;

    public LeitorCSV(String filePath, String delimiter) {
        this.caminho = filePath;
        this.delimitador = delimiter;
    }

    public List<String[]> readCSV() {
        List<String[]> data = new ArrayList<>();

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

    public String procuraCaminho(){

        JFileChooser fc = new JFileChooser();

        fc.setDialogTitle("Seleccione arquivo CSV");
        fc.setFileFilter(new FileNameExtensionFilter("Arquivos CSV (*.csv)", "csv"));

        int arquivoSelecionado = fc.showOpenDialog(null);

        if (arquivoSelecionado == JFileChooser.APPROVE_OPTION){
            return fc.getSelectedFile().getAbsolutePath();
        }else {
            return null;
        }
    }
}

