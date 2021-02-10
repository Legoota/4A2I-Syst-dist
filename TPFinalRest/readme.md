### Projet REST
L'objectif de ce devoir est de réaliser un projet utilisant l'API **REST** ainsi que le *framework* **Hibernate**.

Notre base de test ```rest``` se compose de 5 tables:
 * ```client```: *id*, *nom*, *prenom*, *adresse*
 * ```commande```: *id*, *id_client*, *paye*
 * ```ligne_commande```: *id*, *id_commande*, *id_produit*
 * ```produit```: *id*, *nom*, *prix*, *fabrication*
 * ```fabrication```: *id*, *prix_coutant*, *matiere*, *temps_fabrication*

Nous avons fait les choix de liens entre les tables pour permettre d'avoir des associations de différents types, à savoir:
 * ```@OneToOne```
 * ```@OneToMany```
 * ```@ManyToOne```

Voir le diagramme UML à la fin de cette page pour les détails concernant ces liens.

##### Endpoints et possibilités:
 * [client/clients/](http://localhost:8080/TPFinalRest_war_exploded/client/clients)
   * Disponible en **GET**, **PUT**, **POST**, **DELETE**
   * Possibilité de sélectionner un élément spécifique: ```client/clients/{n}```
 * [commande/commmandes/](http://localhost:8080/TPFinalRest_war_exploded/commande/commandes)
   * Disponible en **GET**, **PUT**, **POST**, **DELETE**
   * Possibilité de sélectionner un élément spécifique: ```commande/commandes/{n}```
   * Possibilité d'obtenir les commandes impayées uniquement [commande/pending](http://localhost:8080/TPFinalRest_war_exploded/commande/pending)
   * Possibilité d'obtenir les commandes payées uniquement [commande/paid](http://localhost:8080/TPFinalRest_war_exploded/commande/paid)
   * Possibilité d'éditer une commande existante comme payée ```commande/commmandes/validate/{n}```
 * [produit/produits/](http://localhost:8080/TPFinalRest_war_exploded/produit/produits)
   * Disponible en **GET**, **PUT**, **POST**, **DELETE**
   * Possibilité de sélectionner un élément spécifique: ```produit/produits/{n}```
 * [fabrication/fabrications/](http://localhost:8080/TPFinalRest_war_exploded/fabrication/fabrications)
   * Disponible en **GET**, **PUT**, **POST**, **DELETE**
   * Possibilité de sélectionner un élément spécifique: ```fabrication/fabrications/{n}```

### UML diagram
![Diagramme UML](https://github.com/Legoota/4A2I-Syst-dist/blob/main/TPFinalRest/UML.png?raw=true)
