package com.teamb.project.service;

import com.teamb.project.dao.ProjectDAO;
import com.teamb.project.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService implements ProjectImpService{

    @Autowired
    ProjectDAO project;

    @Override
    public List<Project> findAll() {
        return project.findAll();
   }

    @Override
    //Atualizacao do dia 11_05 para avaliar se o objeto n foi encontrado para o metodo PUT
    public Project findById(Integer id) {
        Optional<Project> optional = project.findById(id);
        Project novoProjeto = null;
        if(optional.isPresent()){
            novoProjeto= optional.get();
        }
        else{
            throw new RuntimeException("Projeto não encontrado para id ::" + id);
        }
        return novoProjeto;
    }

    @Override
    public Project save(Project objectProject) {
        return project.save(objectProject);
    }

    @Override
    public void delete(Integer id){ project.delete(project.getOne(id)); }

}
