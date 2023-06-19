package misc;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class GUI {
    public static String procuraCaminho() throws RotaInvalida{
//      Janela para selecao de caminho do arquivo
        JFileChooser fc = new JFileChooser();
//      Titulo da Janela
        fc.setDialogTitle("Seleccione arquivo CSV");
//      Tipos de arquivos para somente apresentar CSV
        fc.setFileFilter(new FileNameExtensionFilter("Arquivos CSV (*.csv)", "csv"));
//      Setar diretorio base da Janela na raiz do Projeto
        fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
//      Abre Janela e valida resposta do usuario
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
