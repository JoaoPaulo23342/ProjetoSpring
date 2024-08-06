package br.com.JavaProject.SeriesSeach.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataEpisodes(@JsonAlias ("Title") String titulo,
                           @JsonAlias ("Episode") Integer NumeroEpisode,
                           @JsonAlias ("imdbRating") String avaliacao,
                           @JsonAlias ("Released") String dataLAncamento
                           ) {
}
