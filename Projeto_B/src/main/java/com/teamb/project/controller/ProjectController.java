package com.teamb.project.controller;

import com.teamb.project.dao.ProjectDAO;
import com.teamb.project.model.Project;
import com.teamb.project.service.ProjectImpService;
import com.teamb.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProjectController {
    @Autowired
    private ProjectImpService projectImpService;

    //Função para testar: Retorna todos os itens
    @GetMapping("/projetoTeste")
    public List<Project> listAll() {
        return projectImpService.findAll();
    }

    //Função para quando Thymeleaf estiver implementado
    @GetMapping("/projeto")
    public ModelAndView Listar() {
        ModelAndView modelAndView = new ModelAndView("ListaProjeto");
        modelAndView.addObject("titulo", projectImpService.findAll());
        modelAndView.addObject(new Project());
        return modelAndView;
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

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Project project){
        return new ResponseEntity<>(projectImpService.save(project), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deletePost(@PathVariable Integer id){
        projectImpService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity update(@RequestBody Project project){
        return new ResponseEntity<>(projectImpService.save(project), HttpStatus.OK);
    }


}
