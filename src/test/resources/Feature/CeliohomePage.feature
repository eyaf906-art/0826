#Author : proservice

Feature: Celio Tunisie vêtement homme home page

  Scenario: clique sur le menu et le sous menu

    Given utilisateur sur la page dacceuil

    When utilisateur survol sur le menu "Collection" et clique sur le sous menu "Jeans"

    Then utilisateur est derigé vers la page de "Jeans"