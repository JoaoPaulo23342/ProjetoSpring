package br.com.JavaProject.ScreenMatch.Main;

import br.com.JavaProject.ScreenMatch.model.DataEpisodes;
import br.com.JavaProject.ScreenMatch.model.DataSeason;
import br.com.JavaProject.ScreenMatch.model.DataSeries;
import br.com.JavaProject.ScreenMatch.model.Episode;
import br.com.JavaProject.ScreenMatch.server.DataConvert;
import br.com.JavaProject.ScreenMatch.server.server;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private server Server = new server();
    private DataConvert conversor = new DataConvert();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=5dd27116";


    public void exibeMenu() {
        System.out.println("Digite o nome da série para busca");
        var nome = scanner.nextLine();

        var json = Server.obterDados(ENDERECO + nome.replace(" ", "+") + API_KEY);

        DataSeries dados = conversor.obterDados(json, DataSeries.class);
        System.out.println(dados);
//        List<DataSeason> temporadas = new ArrayList<>();
//
//		for (int i = 1; i<=dados.totalTemporadas(); i++) {
//			json = server.obterDados(ENDERECO + nome.replace("", "+") +"&season=" + i + API_KEY);
//			DataSeason dadosTemporada = conversor.obterDados(json, DataSeason.class);
//		    temporadas.add(dadosTemporada);
//
//		}
//		temporadas.forEach(System.out::println);

        List<DataSeason> temporadas = new ArrayList<>();

        for(int i = 1; i<=dados.totalTemporadas(); i++) {
            json = Server.obterDados(ENDERECO + nome.replace(" ", "+") +"&season=" + i + API_KEY);
            DataSeason dadosTemporada = conversor.obterDados(json, DataSeason.class);
            temporadas.add(dadosTemporada);

        }
        temporadas.forEach(System.out::println);

//        for(int i = 0; i < dados.totalTemporadas(); i++) {
//            List<DataEpisodes> episodiosTemporada = temporadas.get(i).episodes();
//            for(int j = 0; j < episodiosTemporada.size(); j++) {
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//        }

        temporadas.forEach(t -> t.episodes().forEach(e -> System.out.println(e.titulo())));

        List<DataEpisodes> data_episodes = temporadas.stream()
                .flatMap(t -> t.episodes().stream())
                .collect(Collectors.toList());


        System.out.println("\nTop 5 Episodes");
        data_episodes.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DataEpisodes::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episode> episodes = temporadas.stream()
                .flatMap(t -> t.episodes().stream()
                    .map(d -> new Episode(t.number(), d))
                ).collect(Collectors.toList());
    episodes.forEach(System.out::println);
    }

}




