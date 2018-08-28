package ru.alexander.development.tools.core.service;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Surakin-AN
 * @date_created 30.07.2018 18:18:41
 */

@Service
@Slf4j
public class GradleService {
    
    private static final String CLEAN_BUILD = "gradle clean build";
    
    private static final String CLEAN_BUILD_INSTALL = "gradle clean build install";
    
    private static final String CLEAN_BUILD_INIT_SCRIPT = "gradle --init-script init.gradle clean build";
    
    private static final String CLEAN_BUILD_INSTALL_INIT_SCRIPT = "gradle --init-script init.gradle clean build install";
        
    @Autowired
    private ProcessService processService;
    
    public Integer cleanBuild(String path) throws IOException{
        return this.processService.cmd(CLEAN_BUILD, path);
    }
    
    public Integer cleanBuildInstall(String path) throws IOException {
        return this.processService.cmd(CLEAN_BUILD_INSTALL, path);
    }
    
    public Integer cleanBuildInitScript(String path) throws IOException{
        return this.processService.cmd(CLEAN_BUILD_INIT_SCRIPT, path);
    }
    
    public Integer cleanBuildInstallInitScript(String path) throws IOException {
        return this.processService.cmd(CLEAN_BUILD_INSTALL_INIT_SCRIPT, path);
    }

}
