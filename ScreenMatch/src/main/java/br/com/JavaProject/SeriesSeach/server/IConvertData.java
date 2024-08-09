package br.com.JavaProject.SeriesSeach.server;

public interface IConvertData {
    <T> T obterDados(String json, Class<T> classe);
}
