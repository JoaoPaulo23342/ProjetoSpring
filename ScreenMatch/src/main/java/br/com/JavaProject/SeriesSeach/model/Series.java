package br.com.JavaProject.SeriesSeach.model;

import br.com.JavaProject.SeriesSeach.model.Category.Category;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.OptionalDouble;

public class Series {
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    private Category generoDoFilme;
    private String atoresDoFilme;
    private String poster;
    private String ResumoDoFilme;

    public Series (DataSeries dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0);
        this.generoDoFilme = Category.fromString(dadosSerie.generoDoFilme().split(",")[0].trim());
        this.atoresDoFilme = dadosSerie.atoresDoFilme();
        this.poster = dadosSerie.poster();
        this.ResumoDoFilme = dadosSerie.ResumoDoFilme();


    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Category getGeneroDoFilme() {
        return generoDoFilme;
    }

    public void setGeneroDoFilme(Category generoDoFilme) {
        this.generoDoFilme = generoDoFilme;
    }

    public String getResumoDoFilme() {
        return ResumoDoFilme;
    }

    public void setResumoDoFilme(String resumoDoFilme) {
        ResumoDoFilme = resumoDoFilme;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getAtoresDoFilme() {
        return atoresDoFilme;
    }

    public void setAtoresDoFilme(String atoresDoFilme) {
        this.atoresDoFilme = atoresDoFilme;
    }

    @Override
    public String toString() {
        return
                "generoDoFilme=" + generoDoFilme +
                ", titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", avaliacao=" + avaliacao +

                ", atoresDoFilme='" + atoresDoFilme + '\'' +
                ", poster='" + poster + '\'' +
                ", sinopse='" + ResumoDoFilme + '\'' +
                '}';
    }
}
