package br.com.JavaProject.SeriesSeach.Main;

import br.com.JavaProject.SeriesSeach.model.*;
import br.com.JavaProject.SeriesSeach.server.DataConvert;
import br.com.JavaProject.SeriesSeach.server.server;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private server Server = new server();
    private DataConvert conversor = new DataConvert();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=5dd27116";
    private List<DataSeries> dataseries = new ArrayList<>();


    public void exibeMenu() {
        var option = -1;
        while(option != 0) {
            var menu = """
                    1 - Buscar séries
                    2 - Buscar episódios
                    3 - Salvar séries buscadas              
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;

                case 3:
                    listarSeriesBuscadas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarSerieWeb() {
        DataSeries dados = getDadosSerie();
        dataseries.add(dados);
        System.out.println(dados);
    }

    private DataSeries getDadosSerie() {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = scanner.nextLine();
        var json = Server.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DataSeries dados = conversor.obterDados(json, DataSeries.class);
        return dados;
    }

    private void buscarEpisodioPorSerie(){
        DataSeries dadosSerie = getDadosSerie();
        List<DataSeason> temporadas = new ArrayList<>();

        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            var json = Server.obterDados(ENDERECO + dadosSerie.titulo().replace(" ", "+") + "&season=" + i + API_KEY);
            DataSeason dadosTemporada = conversor.obterDados(json, DataSeason.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);
    }
    private void listarSeriesBuscadas(){
        List<Series> series = new ArrayList<>();
        series = dataseries.stream()
                .map(d -> new Series(d))
                .collect(Collectors.toList());
        series.stream()
                .sorted(Comparator.comparing(Series::getGeneroDoFilme))
                .forEach(System.out::println);

    }

}



