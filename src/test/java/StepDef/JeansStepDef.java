
package StepDef;

import Helper.Config;
import Pages.JeanBaggy;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class JeansStepDef {

    JeanBaggy jeanBaggy;

    @Given("utilisateur est sur la page de Jeans")
    public void utilisateur_est_sur_la_page_de_jeans() {

        Config.driver.get("https://celio.tn/collection/jeans.html");

        jeanBaggy = new JeanBaggy();
    }

    @When("utilisateur clique sur le produit {string}")
    public void utilisateur_clique_sur_le_produit(String produit) {

        jeanBaggy.clikProduit(produit);
    }

    @Then("la page de produit est affiché {string}")
    public void la_page_de_produit_est_affiche(String produit) {

        jeanBaggy.verifProduct(produit);
    }
}
