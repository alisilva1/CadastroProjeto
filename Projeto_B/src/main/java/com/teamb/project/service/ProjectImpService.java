package com.teamb.project.service;

import com.teamb.project.model.Project;

import java.util.List;

public interface ProjectImpService {
    List<Project> findAll();
    Project findById(Integer id);
    Project save(Project project);
}
