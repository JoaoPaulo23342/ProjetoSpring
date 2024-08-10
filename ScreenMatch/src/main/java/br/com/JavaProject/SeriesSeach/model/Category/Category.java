package br.com.JavaProject.SeriesSeach.model.Category;

public enum Category {
    ACAO("Action"),
    ROMANCE("Romance"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    CRIME("Crime"),
    ANIME("Animation");

    private String categoriaOmdb;

    Category(String categoriaOmdb) {
        this.categoriaOmdb = categoriaOmdb;

    }
    public String getCategoriaOmdb() {
        return categoriaOmdb;
    }
    public static Category fromString(String text) {
        for (Category categoria : Category.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

}
