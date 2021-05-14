package com.teamb.project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="tbl_project", schema = "db_project")
public class Project {
    //titulo, descricao, tipo (ensino, pesquisa, extensão), data de criação e termino


    //@Column referencia o atributo a coluna do banco, devemos ter o mesmo padrão
    //Unique informa se ele é unico

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "titulo",length = 50,unique = true)
    private String titulo;

    @Column(name = "descricao",length = 100)
    private String descricao;

    @Column(name = "tipo")
    private Tipo tipo;

    public enum Tipo{
        ENSINO("Ensino"), PESQUISA("Pesquisa"), EXTENSAO("Extensão");

        String valor;
        Tipo(String valor){
            this.valor = valor;
        }
        public String getValor(){
            return valor;
        }
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    //Inseri o padrão de data pelo Json Format
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "data_termino")
    private LocalDate dataTermino;

    //Getters and Setters
    //Só declarar os Getters and Setters que forem necessários

    //Os parâmetros que não contém get e set não podem ser alterados nem
    //resgatados do banco de dados. Logo, para o método post funcionar são necessários
    //todos os get e sets exceto o setId

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }
}
