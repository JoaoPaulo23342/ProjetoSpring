package br.com.JavaProject.ScreenMatch;

import br.com.JavaProject.ScreenMatch.model.DataEpisodes;
import br.com.JavaProject.ScreenMatch.model.DataSeason;
import br.com.JavaProject.ScreenMatch.model.DataSeries;
import br.com.JavaProject.ScreenMatch.server.DataConvert;
import br.com.JavaProject.ScreenMatch.server.server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var Server = new server();
		var json = Server.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=5dd27116");
		System.out.println(json);
//		json = Server.obterDados("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);
		DataConvert conversor = new DataConvert();
		DataSeries dados = conversor.obterDados(json, DataSeries.class);
		System.out.println(dados);
		json = Server.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=5dd27116");
		DataEpisodes dadosEpisodio = conversor.obterDados(json, DataEpisodes.class);
		System.out.println(dadosEpisodio);

		List<DataSeason> temporadas = new ArrayList<>();

		for (int i = 1; i<=dados.totalTemporadas(); i++) {
			json = Server.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=5dd27116");
			DataSeason dadosTemporada = conversor.obterDados(json, DataSeason.class);
			temporadas.add(dadosTemporada);

		}
		temporadas.forEach(System.out::println);



	}
}
