package ru.alexander.development.tools.core.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alexander.development.tools.common.util.FileUtil;
import ru.alexander.development.tools.config.Constant;
import ru.alexander.development.tools.core.crud.ProjectService;
import ru.alexander.development.tools.model.entity.Project;

/**
 *
 * @author Surakin-AN
 * @date_created 26.07.2018 15:04:44
 */
@Service
@Slf4j
public class DeploymentService {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private GitService gitService;

    @Autowired
    private GradleService gradleService;

    @Autowired
    private WindowsService windowsService;

    // <editor-fold desc="Clean" defaultstate="collapsed">
    public void cleanSrcDir() throws IOException {
        FileUtil.cleanDirectory(Constant.SRC_DIR_PATH);
    }

    public void cleanBuildDir() throws IOException {
        FileUtil.cleanDirectory(Constant.BUILD_DIR_PATH);
    }

    public void cleanRunDir() throws IOException {
        FileUtil.cleanDirectory(Constant.RUN_DIR_PATH);
    }
    // </editor-fold>

    // <editor-fold desc="Clone" defaultstate="collapsed">
    public void gitClone() throws IOException {
        List<Project> list = this.projectService.findByIsClone(Boolean.TRUE);
        for (Project project : list) {
            this.gitService.gitClone(project.getName(), Constant.SRC_DIR_PATH);
        }
    }
    // </editor-fold>

    // <editor-fold desc="Build" defaultstate="collapsed">
    public Integer build() throws IOException {
        List<String> projectNames = this.getProjectsInDir(Constant.SRC_DIR_PATH);
        for (String projectName : projectNames) {
            Project project = this.projectService.findByName(projectName);
            String projectSrcPath = Constant.SRC_DIR_PATH + "\\" + projectName;
            String projectBuildDir = projectSrcPath + "\\" + Constant.GRADLE_PROJECT_BUILD_DIR;
            if (project.getIsBuild()) {
                this.gitService.gitCheckout(project.getBuildBranch(), projectSrcPath);

                //С установкой
                if (project.getIsInstall()) {
                    if (project.getIsInitScript()) {
                        this.gradleService.cleanBuildInstallInitScript(projectSrcPath);
                    } else {
                        this.gradleService.cleanBuildInstall(projectSrcPath);
                    }

                //Без установки
                } else {
                    if (project.getIsInitScript()) {
                        this.gradleService.cleanBuildInitScript(projectSrcPath);
                    } else {
                        this.gradleService.cleanBuild(projectSrcPath);
                    }                    
                }

                List<File> files = FileUtil.getJarFiles(projectBuildDir);

                if (files.size() != 1) {
                    throw new RuntimeException("Должен быть найден 1 файл. Найдено файлов: " + files.size());
                }

                String filePath = files.get(0).getAbsolutePath();
                FileUtil.copyFileToDirectory(filePath, Constant.BUILD_DIR_PATH);

                //Перекладываем запускаемые файлы в отдельную папку
                if (project.getIsRunable()) {
                    String runFilePath = Constant.RUN_DIR_PATH + "\\" + projectName + ".jar";
                    FileUtil.copyFile(filePath, runFilePath);
                }
            }
        }
        return 0;
    }
    // </editor-fold>

    // <editor-fold desc="Deploy" defaultstate="collapsed">
//    public Integer deploy() throws IOException {
//        List<String> projectNames = this.getProjectsInDir(Constant.RUN_DIR_PATH);
//        for (String projectName : projectNames) {
//            Project project = this.projectService.findByName(projectName);
//            
//            if (project.getIsRunable()) {
//                this.windowsService.stop(projectName);
//                copy();
//                this.windowsService.start(projectName);
//            }
//        }
//        return 0;
//    }
    public void stopService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // </editor-fold>

    private List<String> getProjectsInDir(String dir) {
        return FileUtil.getSubDirectoryNames(dir);
    }

}
