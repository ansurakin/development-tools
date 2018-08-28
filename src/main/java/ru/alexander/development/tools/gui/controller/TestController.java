package ru.alexander.development.tools.gui.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Surakin-AN
 * @date_created 16.07.2018 11:08:23
 */

@Controller
@Slf4j
public class TestController {

    @RequestMapping("/test")
    public String page() {
        log.info("asdf");
        return "forward:/index.xhtml";
    }

}