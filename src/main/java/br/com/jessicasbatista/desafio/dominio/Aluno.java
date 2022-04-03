package br.com.jessicasbatista.desafio.dominio;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
public class Aluno {
    private String nome;
    private StatusCurso statusCurso;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();


    public void matricularBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void cancelarMatriculaBootcamp(Bootcamp bootcamp){
        this.getConteudosInscritos().removeAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().remove(this);
        System.out.println("Matrícula cancelada com sucesso!");
    }

    public void gerarCertificado() {
        if (statusCurso == StatusCurso.CONCLUIDO) {
            System.out.println("Parabéns! Você concluiu o curso com sucesso! Em breve receberá o seu certificado");
        } else {
            System.err.println("Você precisa concluir o curso antes de gerar o certificado!");
        }
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo");
        }
    }



    public Double calcularTotalXP() {
        return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXP).sum();
    }
}
