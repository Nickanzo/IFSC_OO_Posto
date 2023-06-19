package misc;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class GUI {
    public static String procuraCaminho() throws RotaInvalida{

        JFileChooser fc = new JFileChooser();

        fc.setDialogTitle("Seleccione arquivo CSV");
        fc.setFileFilter(new FileNameExtensionFilter("Arquivos CSV (*.csv)", "csv"));
        fc.setCurrentDirectory(new File(System.getProperty("user.dir")));

        int selecao = fc.showOpenDialog(null);

        switch (selecao){
            case JFileChooser.APPROVE_OPTION:
                return fc.getSelectedFile().getAbsolutePath();
            case JFileChooser.CANCEL_OPTION:
                System.err.println("Acao cancelada pelo usuário !");
                return "";
            default:
                throw new RotaInvalida("Não foi possível determinar a rota do arquivo !");
        }
    }
}
