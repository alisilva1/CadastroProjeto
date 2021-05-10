package com.teamb.project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tbl_project", schema = "db_project")
public class Project {
    //titulo, descricao, tipo (ensino, pesquisa, extensão), data de criação e termino


    //@Column referencia o atributo a coluna do banco, devemos ter o mesmo padrão
    //Unique informa se ele é unico

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "titulo",length = 50,unique = true)
    private String titulo;

    @Column(name = "descricao",length = 100)
    private String descricao;

    @Column(name = "tipo",length = 10)
    private String tipo;

    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(name = "dataCriacao")
    private Date dataCriacao;

    //Inseri o padrão de data pelo Json Format
    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(name = "dataTermino")
    private Date dataTermino;

    //Getters and Setters
    //Só declarar os Getters and Setters que forem necessários

    //Os parâmetros que não contém get e set não podem ser alterados nem
    //resgatados do banco de dados. Logo, para o método post funcionar são necessários
    //todos os get e sets exceto o setId

    public Integer getId() {
        return id;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
}
