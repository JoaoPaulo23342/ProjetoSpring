package br.com.JavaProject.ScreenMatch.server;

public interface IConvertData {
    <T> T obterDados(String json, Class<T> classe);
}
