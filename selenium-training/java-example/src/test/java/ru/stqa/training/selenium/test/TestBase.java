package ru.stqa.training.selenium.test;

import org.junit.After;
import org.junit.Before;
import ru.stqa.training.selenium.appmanager.ApplicationManager;

/**
 * Created by luk on 2017-04-09.
 */
public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @Before
    public void start() {
        app.init();
    }

    @After
    public void stop() {
        app.quitAndNull();
    }

}
