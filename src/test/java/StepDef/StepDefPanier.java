
package StepDef;

import Helper.Config;
import Pages.JeanBaggy;
import Pages.AjoutPanierPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefPanier {

    JeanBaggy jeanBaggy;
    AjoutPanierPage ajoutPanierPage;

    @Given("utilisateur sur la page du produit")
    public void utilisateur_sur_la_page_du_produit() {

     
        Config.driver.get("https://celio.tn/collection/jeans.html");

        
        jeanBaggy = new JeanBaggy();

        jeanBaggy.clikProduit(
            "Jean baggy 100% coton - bleu bleached"
        );

       
        ajoutPanierPage = new AjoutPanierPage();
    }

    @When("utilisateur clique sur couleur et clique sur la taille et clique sur ajouterpanier")
    public void utilisateur_clique_sur_couleur_et_clique_sur_la_taille_et_clique_sur_ajouterpanier()
            throws Exception {

      
        ajoutPanierPage.ajoutProduct();
    }

    @Then("le produit {string} est au panier")
    public void le_produit_est_au_panier(String produit) {

        
        ajoutPanierPage.VerifPanier(produit);
    }
}

