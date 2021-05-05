package com.teamb.project.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import java.util.Date;

public class Project {
    //titulo, descricao, tipo (ensino, pesquisa, extensão), data de criação e termino


    //@Column referencia o atributo a coluna do banco, devemos ter o mesmo padrão
    //Unique informa se ele é unico
    @Column(name = "titulo",length = 50,unique = true)
    private String titulo;

    @Column(name = "descricao",length = 100)
    private String descricao;

    @Column(name = "tipo",length = 10)
    private String tipo;


    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(name = "nomeDaColuna")
    private Date dataCriacao;

    //Inseri o padrão de data pelo Json Format
    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(name = "nomeDaColuna")
    private Date dataTermino;

    //Getters and Setters
    //Só declarar os Getters and Setters que forem necessários


}
