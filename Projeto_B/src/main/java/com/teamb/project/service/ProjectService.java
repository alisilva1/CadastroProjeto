package com.teamb.project.service;

import com.teamb.project.dao.ProjectDAO;
import com.teamb.project.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements ProjectImpService{

    @Autowired
    ProjectDAO project;

    @Override
    public List<Project> findAll() {
        return project.findAll();
   }

    @Override
    public Project findById(Integer id) {
        return project.findById(id).get();
    }

    @Override
    public Project save(Project objectProject) {
        return project.save(objectProject);
    }

}
