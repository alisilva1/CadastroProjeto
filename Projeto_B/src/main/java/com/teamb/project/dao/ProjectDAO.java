package com.teamb.project.dao;

import com.teamb.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDAO extends JpaRepository <Project,Integer> {
}
