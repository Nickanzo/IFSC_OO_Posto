package Posto;

import misc.*;

import java.util.ArrayList;
import java.util.List;

import static test.Main.carregaDados;

public class Main {
    public static void main(String[] args) throws OpcaoInvalida{
        /*
            Variaveis para execucao
         */
        String filePath = "";
        String resposta = "";
        /*
            Listas para execucao
         */
        List<String[]> dadosPosto;
        ArrayList<Posto> postos = new ArrayList<>();
//      Mensagem inicial
        System.out.println("Bem vindo ao sistema de Postos");
//      Busca Caminho
        try {
            filePath = GUI.procuraCaminho();
            if (!filePath.isEmpty()){
//              Resgata dados de arquivo CSV
                dadosPosto = new LeitorCSV(filePath).readCSV();
//              Repassa dados do CSV para ArrayList de Postos
                postos = carregaDados(dadosPosto);
            }else{
                System.exit(0);
            }
        }catch (RotaInvalida rotErr){
//          Apresenta erro de Rota
            System.err.println(rotErr.getMessage());
            System.exit(0);
        }
//      Mensagem de opcao
        System.out.print("""
                Selecione uma das opcoes:
                1 - Listar todos os Dados
                2 - Listar com base em filtro
                """);
//      Resgata resposta do usuario
        resposta = new LeitorInput().stringInput();
//      Trata resposta do usuario
        try{
//          Lista todos os dados do CSV
            if (resposta.equals("1") && postos.size() != 0){
                listaDados(postos);
//          Lista a partir de Filtros
            } else if (resposta.equals("2")) {
                filtraDados(postos);
//          Opcao invalida
            }else{
                throw new OpcaoInvalida("Opcao invalida !!");
            }
        }catch (OpcaoInvalida opcInvErr){
            System.out.println(opcInvErr.getMessage());
        }
    }
//  Metodo para listagem de dados completa
    private static void listaDados(ArrayList<Posto> dados){
        for (Posto p : dados){
            System.out.println(p.toString());
        }
    }
//  Metodo para listar dados a partir de Filtros
    private static void filtraDados(ArrayList<Posto> dados) throws OpcaoInvalida{
//      Instancia de Scanner
        LeitorInput leDados = new LeitorInput();
//      String para tratamento de resposta do usuario
        String respostaFiltro = "";
//      Mensagem de opcao
        System.out.println("""
                Selecione filtro para listagem de dados:
                1 - Filtrar por Bairro
                2 - Filtrar por Tipo de Combustivel
                3 - Filtrar por Bandeira""");
//      resgata resposta do usuario
        respostaFiltro = leDados.stringInput();
//      trata resposta do usuario
        if (respostaFiltro.equals("1")){
            System.out.println("Digite o nome do Bairro");
            respostaFiltro = leDados.stringInput();
//          Listagem de dados do CSV a partir do Bairro
            listaPorBairro(dados,respostaFiltro);
        } else if (respostaFiltro.equals("2")) {
//          Mensagem de opcao
            System.out.println("""
                    Selecione o Tipo de Combustivel:
                    1 - GASOLINA
                    2 - GASOLINA ADITIVADA
                    3 - ETANOL 
                    """);
            respostaFiltro = leDados.stringInput();
//          Tratamento de resposta do usuario
            if (respostaFiltro.equals("1")){
//              Lista dados de Gasolina
                listaPorCombustiveis(dados,"GASOLINA");
            } else if (respostaFiltro.equals("2")) {
//              Lista dados de Gasolina Aditivada
                listaPorCombustiveis(dados,"GASOLINA ADITIVADA");
            } else if (respostaFiltro.equals("3")) {
//              Lista dados de Etanol
                listaPorCombustiveis(dados,"ETANOL");
            }else {
//              Opcao nao valida
                throw new OpcaoInvalida("Opcao inválida !!");
            }
        }else if(respostaFiltro.equals("3")){
            System.out.println("Digite a Bandeira");
            respostaFiltro = leDados.stringInput();
//          Listagem a partir de Bandeira
            listaPorBandeira(dados, respostaFiltro);
        }else {
            throw new OpcaoInvalida("Opcao invalida !!");
        }
    }
//  Metodo de Listagem por Filtro de Bandeira
    private static void listaPorBandeira(ArrayList<Posto> dados, String bandeira) {
//      Contador para validar registros encontrados
        int count = 0;
//      Leitura dos dados de ArrayList
        for (Posto p : dados){
//          Verifica se a Bandeira coincide com o inserido pelo usuario
            if (p.getBandeira().equalsIgnoreCase(bandeira)){
//              Apresenta no Console
                System.out.println(p.toString());
                count++;
            }
        }
//      Mensagem de erro para dados nao encontrados
        if (count < 1){
            System.err.println("Nenhum dado encontrado com o filtro indicado !");
        }
    }
// Metodo de Listagem por Filtro de Bairro
    private static void listaPorBairro(ArrayList<Posto> dados, String bairro) {
//      Contador para validar registros encontrados
        int count = 0;
//      Leitura dos dados de ArrayList
        for (Posto p : dados){
//          Verifica se o Bairro coincide com o inserido pelo usuario
            if (p.getBairro().equalsIgnoreCase(bairro)){
                System.out.println(p.toString());
            }
        }
//      Mensagem de erro para dados nao encontrados
        if (count < 1){
            System.err.println("Nenhum dado encontrado com o filtro indicado !");
        }
    }
//  Metodo de Listagem por Filtro de Combustiveis
    private static void listaPorCombustiveis(ArrayList<Posto> dados, String combustivel) {
//      Leitura dos dados de ArrayList
        for (Posto p : dados){
//          Verifica se o Combustivel coincide com a opcao da lista apresentada para o usuario
            if (p.getProduto().equals(combustivel)){
                System.out.println(p.toString());
            }
        }
    }
}
