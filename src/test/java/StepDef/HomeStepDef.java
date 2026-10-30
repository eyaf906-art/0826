
package StepDef;

import Helper.Config;
import Pages.HomePages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class HomeStepDef {

    HomePages homePages;

    @Given("utilisateur sur la page dacceuil")
    public void utilisateur_sur_la_page_dacceuil() {

        Config.driver.get("https://celio.tn/");

        homePages = new HomePages();
    }

    @When("utilisateur survol sur le menu {string} et clique sur le sous menu {string}")
    public void utilisateur_survol_sur_le_menu_et_clique_sur_le_sous_menu(
            String menu, String submenu) {

        homePages.mousehoverMenuAndClickSubmenu(menu, submenu);
    }

    @Then("utilisateur est derigé vers la page de {string}")
    public void utilisateur_est_derige_vers_la_page_de(String page) {

        homePages.verifPage(page);
    }
}
