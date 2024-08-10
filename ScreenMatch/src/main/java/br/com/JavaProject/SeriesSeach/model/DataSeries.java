package br.com.JavaProject.SeriesSeach.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSeries(@JsonAlias ("Title") String titulo,
                         @JsonAlias ("totalSeasons") Integer totalTemporadas,
                         @JsonAlias ("imdbRating") String avaliacao,
                         @JsonAlias ("Genre") String generoDoFilme,
                         @JsonAlias ("Actors") String atoresDoFilme,
                         @JsonAlias ("Poster") String poster,
                         @JsonAlias ("Plot") String ResumoDoFilme){




}


