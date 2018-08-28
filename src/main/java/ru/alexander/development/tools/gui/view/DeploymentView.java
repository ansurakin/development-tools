package ru.alexander.development.tools.gui.view;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.alexander.development.tools.core.service.DeploymentService;
import ru.alexander.development.tools.gui.config.scope.ScopeName;

/**
 *
 * @author Surakin-AN
 * @date_created 13.07.2018 17:25:49
 */
@Component
@Scope(ScopeName.VIEW)
@Slf4j
public class DeploymentView {

    @Autowired
    private DeploymentService deploymentService;

    public void cleanSrcDir(ActionEvent actionEvent) {
        try {
            this.deploymentService.cleanSrcDir();
        } catch (Exception ex) {
            this.errorHandler(ex);
            return;
        }
        this.successHandler();
    }
    
    public void cleanBuildDir(ActionEvent actionEvent) {
        try {
            this.deploymentService.cleanBuildDir();
        } catch (Exception ex) {
            this.errorHandler(ex);
            return;
        }
        this.successHandler();
    }
    
    public void cleanRunDir(ActionEvent actionEvent) {
        try {
            this.deploymentService.cleanRunDir();
        } catch (Exception ex) {
            this.errorHandler(ex);
            return;
        }
        this.successHandler();
    }

    public void clone(ActionEvent actionEvent) {
        try {
            this.deploymentService.gitClone();
        } catch (Exception ex) {
            this.errorHandler(ex);
            return;
        }
        this.successHandler();
    }
    
    public void build(ActionEvent actionEvent) {
        try {
            this.deploymentService.build();
        } catch (Exception ex) {
            this.errorHandler(ex);
            return;
        }
        this.successHandler();
    }
    
    public void startService(ActionEvent actionEvent) {
        try {
//            this.deploymentService.deploy();
        } catch (Exception ex) {
            this.errorHandler(ex);
            return;
        }
        this.successHandler();
    }

    private void successHandler() {
        addMessage(FacesMessage.SEVERITY_INFO, "Выполнено");
    }

    private void errorHandler(Exception ex) {
        log.error(ex.getMessage());
        addMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage());
    }

    private void addMessage(Severity severity, String summary) {
        FacesMessage message = new FacesMessage(severity, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
