package Pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper.Config;

public class JeanBaggy {
	
	@FindBy (xpath="/html/body/main/div/section/div[3]/div[1]/div[4]/ol/li/div[2]/h5/a")
	List<WebElement> produits ;
	
	@FindBy(xpath="/html/body/main/div/section/div[2]/div/div[5]/div[2]/div/div/h1")
	
	WebElement verifArticle;
	
	public JeanBaggy () {
		
		PageFactory.initElements(Config.driver, this);
	}
	
	public void clikProduit(String nomProd) {
		
		Config.attente(10);
		
		try {
			
			for (WebElement produit:produits) {
				
				System.out.println(produit.getText());
				
				if(produit.getText().contains(nomProd)) {
					
					Actions actions= new Actions (Config.driver);
					
					actions.moveToElement(produit).perform();
					
					produit.click();
					
					
				}
				
				
			}
				
				
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void verifProduct(String Productname) {
		
		Assert.assertEquals(verifArticle.getText(), Productname);
		
		
	}

	public void choisirCouleur() {
		// TODO Auto-generated method stub
		
	}

	public void choisirTaille() {
		// TODO Auto-generated method stub
		
	}

	public void ajouterPanier() {
		// TODO Auto-generated method stub
		
	}

	public void verifierPanier(String produit) {
		// TODO Auto-generated method stub
		
	}
}
