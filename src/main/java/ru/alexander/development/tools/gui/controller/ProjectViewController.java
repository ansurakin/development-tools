package ru.alexander.development.tools.gui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Surakin-AN
 * @date_created 13.07.2018 12:20:49
 */

@Controller
@RequestMapping("/projects")
public class ProjectViewController {    

    @RequestMapping("")
    public String list() {
        return "forward:/view/projectList.xhtml";
    }
    
    @RequestMapping("/create")
    public String create() {
        return "forward:/view/projectCreate.xhtml";
    }
    
}
