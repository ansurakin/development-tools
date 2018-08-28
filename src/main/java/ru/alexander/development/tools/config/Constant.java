package ru.alexander.development.tools.config;

import java.text.MessageFormat;

/**
 *
 * @author Surakin-AN
 * @date_created 30.07.2018 12:22:33
 */
public class Constant {
    
    public static final Integer EXIT_CODE_SUCCESS = 0;

    public static final String ROOT_DIR = "D:\\111";

    public static final String SRC_DIR = "src";
    
    public static final String BUILD_DIR = "build";
    
    public static final String RUN_DIR = "run";
    
    public static final String GRADLE_PROJECT_BUILD_DIR = "build\\libs";

    public static String SRC_DIR_PATH = MessageFormat.format("{0}\\{1}", ROOT_DIR, SRC_DIR);
    
    public static String BUILD_DIR_PATH = MessageFormat.format("{0}\\{1}", ROOT_DIR, BUILD_DIR);
    
    public static String RUN_DIR_PATH = MessageFormat.format("{0}\\{1}", ROOT_DIR, RUN_DIR);

    public static final String CMD_COMMAND = "cmd /C";
    
    public static final String REPOSITORY_URL = "https://stash.ca.sbrf.ru/scm/cars";

}
