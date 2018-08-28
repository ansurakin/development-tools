package ru.alexander.development.tools.gui.view;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.alexander.development.tools.core.crud.ProjectService;
import ru.alexander.development.tools.gui.config.scope.ScopeName;
import ru.alexander.development.tools.model.entity.Project;

/**
 *
 * @author Surakin-AN
 * @date_created 13.07.2018 17:25:49
 */

@Component
@Scope(ScopeName.VIEW)
@Slf4j
public class ProjectListComponent {

    @Autowired
    private ProjectService service;

    @Getter
    @Setter
    private List<Project> list;

    @Getter
    @Setter
    private List<Project> filteredList;

    @PostConstruct
    public void init() {
        this.list = this.service.findAll();
    }

    public void onRowEdit(RowEditEvent event) {
        Project item = (Project) event.getObject();
        this.service.save(item);
        this.showMessage("Обновлено", item.getId());      
    }

    public void onRowCancel(RowEditEvent event) {
        Project item = (Project) event.getObject();
        this.showMessage("Отменено", item.getId());
    }
    
    public void delete(Project item) {
        log.info("" + item.toString());
        this.service.delete(item.getId());
        this.list.remove(item);
        this.showMessage("Удалено", item.getId());
    }
    
    private void showMessage(String message, Long id){
        FacesMessage facesMessage = new FacesMessage(message, String.valueOf(id));
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

}
