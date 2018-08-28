package ru.alexander.development.tools.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author Surakin-AN
 * @date_created 13.07.2018 15:02:18
 */
@Entity
@Table(name = "project")
@Data
@ToString
@EqualsAndHashCode
public class Project implements Serializable {
           
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_number")
    private Integer orderNumber;
    
    @Column(name = "is_clone")
    private Boolean isClone;    
            
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    
    @Size(max = 255)
    @Column(name = "description")
    private String description;

    @Column(name = "is_build")
    private Boolean isBuild;
    
    @Size(max = 255)
    @Column(name = "build_branch")
    private String buildBranch;
    
    @Column(name = "is_install")
    private Boolean isInstall;
    
    @Column(name = "is_init_script")
    private Boolean isInitScript;
    
    @Column(name = "is_runable")
    private Boolean isRunable;

}
