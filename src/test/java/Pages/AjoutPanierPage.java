
package Pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Config;

public class AjoutPanierPage {

    WebDriverWait wait;

    @FindBy(xpath="/html/body/main/div/section/div[2]/div/div[5]/div[2]/div/div/div[2]/form/div[2]/div/div/div[1]/div/div[4]")
    WebElement couleur;

    @FindBy(xpath="/html/body/main/div/section/div[2]/div/div[5]/div[2]/div/div/div[2]/form/div[2]/div/div/div[2]/div/div[3]")
    WebElement taille;

    @FindBy(xpath="/html/body/main/div/section/div[2]/div/div[5]/div[2]/div/div/div[2]/form/div[3]/div[4]/div[2]/div[2]/button/span")
    WebElement ajouterPanier;

    @FindBy(xpath="/html/body/div[2]/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div/button")
    WebElement voirPanier;

    @FindBy(xpath="/html/body/main/div/section/div[2]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[1]/div/strong/a")
    WebElement verifPanier;

    public AjoutPanierPage() {

        PageFactory.initElements(Config.driver, this);

        wait = new WebDriverWait(
            Config.driver,
            Duration.ofSeconds(15)
        );
    }

    public void ajoutProduct() {

       
        wait.until(
            ExpectedConditions.elementToBeClickable(couleur)
        ).click();

      
        wait.until(
            ExpectedConditions.elementToBeClickable(taille)
        ).click();

        // Scroll vers le bouton Ajouter au panier
        ((JavascriptExecutor) Config.driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            ajouterPanier
        );

        
        wait.until(
            ExpectedConditions.elementToBeClickable(ajouterPanier)
        ).click();

        
        wait.until(
            ExpectedConditions.elementToBeClickable(voirPanier)
        ).click();
    }

    public void VerifPanier(String nameProd) {

        wait.until(
            ExpectedConditions.visibilityOf(verifPanier)
        );

        Assert.assertEquals(
            nameProd.trim(),
            verifPanier.getText().trim()
        );
    }
}

