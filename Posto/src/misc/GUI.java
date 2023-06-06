package misc;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI {
    public static String procuraCaminho(){

        JFileChooser fc = new JFileChooser();

        fc.setDialogTitle("Seleccione arquivo CSV");
        fc.setFileFilter(new FileNameExtensionFilter("Arquivos CSV (*.csv)", "csv"));

        int arquivoSelecionado = fc.showOpenDialog(null);

        if (arquivoSelecionado == JFileChooser.APPROVE_OPTION){
            return fc.getSelectedFile().getAbsolutePath();
        }else if(arquivoSelecionado == JFileChooser.CANCEL_OPTION) {
            return "Nenhum arquivo selecionado";
        }else{
            return null;
        }
    }
}
