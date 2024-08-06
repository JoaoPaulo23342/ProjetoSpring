package br.com.JavaProject.SeriesSeach.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {
    private Integer season;
    private String titulo;
    private Integer NumeroEpisode;
     private Double avaliacao;
    private LocalDate dataLancamento;

    public Episode(Integer numberSeason, DataEpisodes dateEpisodes) {
        this.season = numberSeason;
        this.titulo = dateEpisodes.titulo();
        this.NumeroEpisode = dateEpisodes.NumeroEpisode();
        try {
            this.avaliacao = Double.valueOf(dateEpisodes.avaliacao());
        } catch (NumberFormatException ex) {
            this.avaliacao = 0.0;
        }
        try {
            this.dataLancamento = LocalDate.parse(dateEpisodes.dataLAncamento());
        } catch (DateTimeParseException ex) {
            this.dataLancamento = null;

        }


            }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroEpisode() {
        return NumeroEpisode;
    }

    public void setNumeroEpisode(Integer numeroEpisode) {
        NumeroEpisode = numeroEpisode;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    @Override
    public String toString() {
        return "season=" + season +
                ", titulo='" + titulo + '\'' +
                ", NumeroEpisode=" + NumeroEpisode +
                ", avaliacao=" + avaliacao +
                ", dataLAncamento=" + dataLancamento
                ;
    }

    public void setDataLAncamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
