
package StepDef;

import Helper.Config;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void ouvrirNavigateur() {
        Config.ouvrirNavigateur();
    }

    @After
    public void fermerNavigateur() {
        Config.stopBrowser();
    }
}

