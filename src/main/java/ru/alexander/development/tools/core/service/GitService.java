package ru.alexander.development.tools.core.service;

import java.io.IOException;
import java.text.MessageFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alexander.development.tools.config.Constant;

/**
 *
 * @author Surakin-AN
 * @date_created 30.07.2018 17:50:31
 */
@Service
@Slf4j
public class GitService {

    private static final String CLONE = "git clone " + Constant.REPOSITORY_URL + "/{0}.git";

    private static final String CHECKOUT = "git checkout {0}";

    @Autowired
    private ProcessService processService;

    public Integer gitClone(String projectName, String dir) throws IOException {
        String cmd = MessageFormat.format(CLONE, projectName);
        return this.processService.cmd(cmd, dir);
    }

    public Integer gitCheckout(String branch, String dir) throws IOException {
        String cmd = MessageFormat.format(CHECKOUT, branch);
        return this.processService.cmd(cmd, dir) ;
    }

}
