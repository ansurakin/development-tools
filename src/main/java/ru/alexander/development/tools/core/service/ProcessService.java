package ru.alexander.development.tools.core.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.alexander.development.tools.config.Constant;

/**
 *
 * @author Surakin-AN
 * @date_created 30.07.2018 18:26:46
 */
@Service
@Slf4j
public class ProcessService {

    private static final String CHANGE_DIR = Constant.CMD_COMMAND + " cd /D {0}";

    public Integer cmd(String cmd, String dir) throws IOException {
        String changeDirCmd = MessageFormat.format(CHANGE_DIR, dir);
        String command = MessageFormat.format("{0} && {1}", changeDirCmd, cmd);
        Process process = Runtime.getRuntime().exec(command);

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String output = "";
        String line;
        while ((line = reader.readLine()) != null) {
            log.debug(line);
            output += line + "\n";
        }

        Integer exitValue = process.exitValue();
        process.destroy();

        log.debug(MessageFormat.format("exitValue: {0}; command: {1}; output: {2}", exitValue, command, output));

        if (exitValue != Constant.EXIT_CODE_SUCCESS) {
            throw new RuntimeException(MessageFormat.format("Команда выполнилась неуспешно. exitValue: {0}; command: {1}; output: {2}", exitValue, command, output));
        }

        return exitValue;
    }

}
