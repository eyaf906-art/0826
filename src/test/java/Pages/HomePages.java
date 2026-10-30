
package Pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Config;

public class HomePages {

    WebDriverWait wait;

    @FindBy(xpath = "/html/body/main/div/header/div[2]/div/div/div/div[1]/div/div[1]/nav/ul/li/a/span[1]")
    List<WebElement> menus;

    @FindBy(xpath = "/html/body/main/div/header/div[2]/div/div/div/div[1]/div/div[1]/nav/ul/li[4]/ul/li/div/div/div[1]/ul/li/a/span")
    List<WebElement> submenus;

    @FindBy(xpath = "/html/body/main/div/div[2]/div/ul/li[3]/strong")
    WebElement verifpage;

    public HomePages() {

        PageFactory.initElements(Config.driver, this);

        wait = new WebDriverWait(
            Config.driver,
            Duration.ofSeconds(15)
        );
    }

    public void mousehoverMenuAndClickSubmenu(
            String menutitle, String submenuTitle) {

        boolean menuFound = false;
        boolean submenuFound = false;

        wait.until(
            ExpectedConditions.visibilityOfAllElements(menus)
        );

        for (WebElement menu : menus) {

            if (menu.getText().trim().contains(menutitle)) {

                menuFound = true;

                Actions actions = new Actions(Config.driver);

                actions.moveToElement(menu).perform();

                wait.until(
                    ExpectedConditions.visibilityOfAllElements(submenus)
                );

                for (WebElement submenu : submenus) {

                    if (submenu.getText().trim().contains(submenuTitle)) {

                        wait.until(
                            ExpectedConditions.elementToBeClickable(submenu)
                        ).click();

                        submenuFound = true;

                        break;
                    }
                }

                break;
            }
        }

        Assert.assertTrue(
            "Menu introuvable : " + menutitle,
            menuFound
        );

        Assert.assertTrue(
            "Sous-menu introuvable : " + submenuTitle,
            submenuFound
        );
    }

    public void verifPage(String msg) {

        WebElement element = wait.until(
            ExpectedConditions.visibilityOf(verifpage)
        );

        Assert.assertTrue(
            "Page attendue : " + msg
                + " ; page obtenue : " + element.getText(),
            element.getText().contains(msg)
        );
    }
}
