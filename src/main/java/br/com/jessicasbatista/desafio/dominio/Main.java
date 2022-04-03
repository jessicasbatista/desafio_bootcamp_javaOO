package br.com.jessicasbatista.desafio.dominio;

import br.com.jessicasbatista.desafio.dominio.Bootcamp;
import br.com.jessicasbatista.desafio.dominio.Curso;
import br.com.jessicasbatista.desafio.dominio.Aluno;
import br.com.jessicasbatista.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Curso curso1 = new Curso("Curso Java", "descrição curso Java", 8);
        Curso curso2 = new Curso("Curso Java OO", "descrição curso JavaOO", 16);


        Mentoria mentoria = new Mentoria("Mentoria de Java", "descrição mentoria Java", LocalDate.now());

        Bootcamp bootcamp1 = new Bootcamp("Bootcamp Java", "Descrição Bootcamp Java");
        bootcamp1.getConteudos().add(curso1);
        bootcamp1.getConteudos().add(curso2);
        bootcamp1.getConteudos().add(mentoria);

        Aluno alunoJessica = new Aluno();
        alunoJessica.setNome("Jéssica");
        alunoJessica.matricularBootcamp(bootcamp1);
        System.out.println("Conteúdos inscritos do dev: " + alunoJessica.getNome() + alunoJessica.getConteudosInscritos());
        alunoJessica.progredir();
        alunoJessica.setStatusCurso(StatusCurso.CONCLUIDO);
        alunoJessica.gerarCertificado();
        alunoJessica.progredir();
//        System.out.println("XP: " + alunoJessica.calcularTotalXP());
//        alunoJessica.cancelarMatriculaBootcamp(bootcamp1);
//        System.out.println("Conteúdos inscritos do dev: " + alunoJessica.getNome() + alunoJessica.getConteudosInscritos());


        System.out.println("\n*********************\n");

        Aluno alunoMatheus = new Aluno();
        alunoMatheus.setNome("Matheus");
        alunoMatheus.matricularBootcamp(bootcamp1);
        System.out.println("Conteúdos inscritos do dev: " + alunoMatheus.getNome() + alunoMatheus.getConteudosInscritos());
        alunoMatheus.progredir();
        alunoMatheus.progredir();
        System.out.println("Conteúdos concluidos do dev: " + alunoMatheus.getNome() + alunoMatheus.getConteudosConcluidos());
        System.out.println("XP: " + alunoMatheus.calcularTotalXP());


    }
}
