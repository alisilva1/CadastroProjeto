package com.teamb.project.dao;

import com.teamb.project.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectDAO extends CrudRepository<Project,Integer> {
}
