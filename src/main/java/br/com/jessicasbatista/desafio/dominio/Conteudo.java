package br.com.jessicasbatista.desafio.dominio;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

    public abstract double calcularXP();
}
