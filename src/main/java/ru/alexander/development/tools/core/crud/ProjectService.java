package ru.alexander.development.tools.core.crud;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alexander.development.tools.model.entity.Project;

/**
 *
 * @author Surakin-AN
 * @date_created 16.07.2018 13:33:35
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public List<Project> findAll() {
        return this.repository.findAllByOrderByOrderNumberAsc();
    }
    
    public List<Project> findByIsClone(Boolean isClone) {
        return this.repository.findByIsCloneOrderByOrderNumberAsc(isClone);
    }

    public Project findOne(Long id) {
        return this.repository.findOne(id);
    }    
    
    public Project findByName(String name) {        
        return this.repository.findByName(name);
    }

    public Project save(Project entity) {
        return this.repository.save(entity);
    }

    public Long delete(Long id) {
        this.repository.delete(id);
        return id;
    }

}
