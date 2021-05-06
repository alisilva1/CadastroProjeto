package com.teamb.project.controller;

import com.teamb.project.dao.ProjectDAO;
import com.teamb.project.model.Project;
import com.teamb.project.service.ProjectImpService;
import com.teamb.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    private ProjectImpService projectImpService;

    //Função para testar: Retorna todos os itens
    @GetMapping("/projetoTeste")
    public List<Project> listAll(){
        return projectImpService.findAll();
    }

    //Função para quando Thymeleaf estiver implementado
    @GetMapping("/projeto")
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("ListaProjeto");
        modelAndView.addObject("titulo", projectImpService.findAll());
        modelAndView.addObject(new Project());
        return modelAndView;
    }
}
