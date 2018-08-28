package ru.alexander.development.tools.core.crud;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexander.development.tools.model.entity.Project;

/**
 *
 * @author Surakin-AN
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

    public List<Project> findAllByOrderByOrderNumberAsc();
    
    public List<Project> findByIsCloneOrderByOrderNumberAsc(Boolean isClone);
    
    public Project findByName(String name);
    
}
