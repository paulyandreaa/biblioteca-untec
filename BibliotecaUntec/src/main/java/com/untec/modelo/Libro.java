package com.untec.modelo;

public class Libro {
    
    private int id;
    private String titulo;
    private String idioma;
    private String autor;
    private String editorial;
    private int paginas;
    private boolean prestado;

    public Libro() {
    }

    public Libro(int id, String titulo, String idioma, String autor, 
                 String editorial, int paginas, boolean prestado) {
        this.id = id;
        this.titulo = titulo;
        this.idioma = idioma;
        this.autor = autor;
        this.editorial = editorial;
        this.paginas = paginas;
        this.prestado = prestado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }

    public int getPaginas() { return paginas; }
    public void setPaginas(int paginas) { this.paginas = paginas; }

    public boolean isPrestado() { return prestado; }
    public void setPrestado(boolean prestado) { this.prestado = prestado; }
}