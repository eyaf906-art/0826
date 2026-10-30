#Author : proservice

Feature: ajout produit au panier

  Scenario: ajouter un produit au panier

    Given utilisateur sur la page du produit

    When utilisateur clique sur couleur et clique sur la taille et clique sur ajouterpanier

    Then le produit "Jean baggy 100% coton - bleu bleached" est au panier