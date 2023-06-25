package com.projecto.ola.java.model.error;

public class ErrorMensagem {
    private String titulo;
    private Integer status;
    private String mensagem;

    public ErrorMensagem(String titulo, Integer status, String mensagem){
        this.mensagem=mensagem;
        this.titulo=titulo;
        this.status=status;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
