# author: proservice

Feature: Page Jeans

  Scenario: Utilisateur clique sur un produit

    Given utilisateur est sur la page de Jeans

    When utilisateur clique sur le produit "Jean baggy 100% coton - bleu bleached"

    Then la page de produit est affiché "Jean baggy 100% coton - bleu bleached"