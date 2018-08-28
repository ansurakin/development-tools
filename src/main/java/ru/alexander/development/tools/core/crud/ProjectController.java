package ru.alexander.development.tools.core.crud;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alexander.development.tools.model.entity.Project;

/**
 *
 * @author Surakin-AN
 */
@RestController
@RequestMapping("api/project")
public class ProjectController {
    
    @Autowired
    private ProjectService service;    
    
    @RequestMapping(value = "/list", method = GET)
    public List<Project> list() {
        return this.service.findAll();
    }
    
    @RequestMapping(value = "/get", params = {"id"}, method = GET)
    public Project get(@RequestParam Long id) {
        return this.service.findOne(id);
    }
    
    @RequestMapping(value = "/save", method = POST)
    public Project save(@RequestBody Project input) {
        return this.service.save(input);
    }
    
    @RequestMapping(value = "/delete", params = {"id"}, method = DELETE)
    public ResponseEntity<Long> delete(@RequestParam Long id) {
        this.service.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    
}
