package misc;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI {
    public static String procuraCaminho() throws RotaInvalida{

        JFileChooser fc = new JFileChooser();

        fc.setDialogTitle("Seleccione arquivo CSV");
        fc.setFileFilter(new FileNameExtensionFilter("Arquivos CSV (*.csv)", "csv"));

        int selecao = fc.showOpenDialog(null);

        if (selecao == JFileChooser.APPROVE_OPTION){
            return fc.getSelectedFile().getAbsolutePath();
        }else if(selecao == JFileChooser.CANCEL_OPTION) {
            System.err.println("Acao cancelada pelo usuário !");
            return " ";
        }else{
            throw new RotaInvalida("Não foi possível determinar a rota do arquivo !");
        }
    }
}
