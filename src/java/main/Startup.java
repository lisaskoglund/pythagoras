package main;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Initilizes the servlet
 *
 * @author lisanoren
 */
public class Startup implements ServletContextListener {

    private void initialize() {
        util.InitializeDB.setData();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        initialize();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
