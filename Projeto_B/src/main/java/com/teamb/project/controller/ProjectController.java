package com.teamb.project.controller;

import com.teamb.project.model.Project;
import com.teamb.project.service.ProjectImpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProjectController {
    @Autowired
    private ProjectImpService projectImpService;

        /*   GET -> apresentar dados no datalist */
    /////////////////////////////////////////////////
    /////////////////////////////////////////////////

    //Função para quando Thymeleaf estiver implementado
    @GetMapping("/projeto")
    public ModelAndView Listar() {
        ModelAndView modelAndView = new ModelAndView("ListaProjeto");
        modelAndView.addObject("titulo", projectImpService.findAll());

        //Esse comando é usado para inserir objeto no listar
        modelAndView.addObject(new Project());
        return modelAndView;
    }

    /////////////////////////////////////////////////
    /////////////////////////////////////////////////




    /*   POST -> Atualiza a chave */
    /////////////////////////////////////////////////
    /////////////////////////////////////////////////

    //Pelo ListaProjeto.html fiz um apontamento para ao clicar em Update irá para o HTML atualiza_projeto
    //Função responsável por pegar o objeto selecionado e levar para a próxima tela de update
    @GetMapping("/telaUpdateProjeto/{id}")
    public ModelAndView telaUpdateProjeto(@PathVariable (value = "id") Integer id){

        //Pegar objeto da tela
        Project project = projectImpService.findById(id);

        //Direcionar html e objetos necessários
        ModelAndView modelAndView = new ModelAndView("atualiza_projeto");
        modelAndView.addObject("project", project);

        //Envia para o servidor o Objeto e pagina necessários
        return modelAndView;
    }
    /////////////////////////////////////////////////
    /////////////////////////////////////////////////


    /*   PUT-> Salva a chave */
    /////////////////////////////////////////////////
    /////////////////////////////////////////////////
    //Post usado no projeto
    @PostMapping("/projeto")
    public RedirectView save(Project project){
        this.projectImpService.save(project);
        return new RedirectView("/projeto");
    }
    /////////////////////////////////////////////////
    /////////////////////////////////////////////////




             /*   DELETE -> Deleta a chave */
    /////////////////////////////////////////////////
    /////////////////////////////////////////////////
    @GetMapping("/deleteNew/{id}")
    public RedirectView deleteProjeto(@PathVariable (value="id")Integer id){
        //Deleta chave
        this.projectImpService.delete(id);
        return new RedirectView("/projeto");
    }

    /*
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Integer> deletePost(@PathVariable Integer id){
            projectImpService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
     */
    /////////////////////////////////////////////////
    /////////////////////////////////////////////////





    /*   Teste */
    /////////////////////////////////////////////////
/*
    //Função para testar: Retorna todos os itens
    @GetMapping("/projetoTeste")
    public List<Project> listAll() {
        return projectImpService.findAll();
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Project project){
        return new ResponseEntity<>(projectImpService.save(project), HttpStatus.OK);
    }



    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getProjectByid(@PathVariable("id") Integer id) {
        Project project;
        try {
            project = projectImpService.findById(id);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Elemento não encontrado", HttpStatus.NOT_FOUND);//Não sei se há problema
        }                                                                                 //em retornar um valor String
        return new ResponseEntity<>(project, HttpStatus.OK);

    }


 */
    /////////////////////////////////////////////////
}
