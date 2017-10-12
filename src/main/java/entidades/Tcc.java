
package entidades;

import java.io.File;

/**
 *
 * @author Reginaldo
 */
public class Tcc {
    private String sessionId;
    private String titulo;
    private String autor;
    private String orientador;
    private String palavrasChave;
    private String resumo;
    private int ano;
    private String area;
    private File pdf;

    public Tcc() {
    }

    public Tcc(String sessionId, String titulo, String autor, String orientador, String palavrasChave, String resumo, int ano, String area, File pdf) {
        this.titulo = titulo;
        this.autor = autor;
        this.orientador = orientador;
        this.palavrasChave = palavrasChave;
        this.resumo = resumo;
        this.ano = ano;
        this.area = area;
        this.pdf = pdf;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public File getPdf() {
        return pdf;
    }

    public void setPdf(File pdf) {
        this.pdf = pdf;
    }

    
    
    
    
}
