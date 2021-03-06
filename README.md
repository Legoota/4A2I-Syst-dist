# 4A2I - Systèmes distribués<img align="right" width="200" height="100" src="https://github.com/Legoota/4A2I-Syst-dist/blob/main/logo.png" alt="Logo Polytech">
---

4<sup>th</sup> year distributed systems course at the Polytech Nancy's Engineering School.

---

### Sommaire des dossiers
 * [25janvier2021](https://github.com/Legoota/4A2I-Syst-dist/tree/main/25janvier2021) : TP comprenant un backend Java + un client Python
 * [Cours2](https://github.com/Legoota/4A2I-Syst-dist/tree/main/Cours2) : TP réalisé pendant le cours 2 avec différents Servlets
 * [Cours3](https://github.com/Legoota/4A2I-Syst-dist/tree/main/Cours3) : TP réalisé pendant le cours 3 qui réalise la sérialisation et la désérialisation d'un objet *Personne*
 * [Cours3_2](https://github.com/Legoota/4A2I-Syst-dist/tree/main/Cours3_2) : Tests de Maven avec calculs et tests unitaires
 * [TPFinalRest](https://github.com/Legoota/4A2I-Syst-dist/tree/main/TPFinalRest) : Le TP à rendre avec l'utilisation de *Hibernate* et les annotations ```OneToOne```, ```ManyToOne``` et ```OneToMany```
 * [TPRest](https://github.com/Legoota/4A2I-Syst-dist/tree/main/TPRest) : Le TP complété introduisant l'architecture *Rest*, avec les Pokemon
 * [demospring](https://github.com/Legoota/4A2I-Syst-dist/tree/main/demospring) : Le TP introduisant à *Spring boot*

---

### Sommaire du cours
[Notes cours 1](#Notes-cours-1)

[Notes cours 2](#Notes-cours-2)

[Notes cours 3](#Notes-cours-3)

[Notes cours 4](#Notes-cours-4)

[Notes cours 5](#Notes-cours-5)

[Notes cours 6](#Notes-cours-6)

[Notes cours 7](#Notes-cours-7)

[Authors](#authors)

---

### Notes cours 1

#### Présentation de l'outil Git
 * Push/pull
 * PR/Branches
 * Commits

#### Fonctions de hachage
 * Irréversibilité des fonctions
 * Permet d'obtenir une clé
 * Peut servir de signature (checksums)

---
### Notes cours 2
#### Design pattern MVC
 * Bonne pratique reprise par beaucoup de frameworks
 * Permet de séparer la vue, le controlleur (=l'aiguilleur) et le calcul
 * Evite d'avoir tout le code dans un seul fichier
 * Le rôle du controlleur est de transmettre les informations demandées par l'utilisateur par le biais du controlleur, vers une vue rendue à l'utilisateur
 * Dans le cas d'un projet JEE, nous avons:
   * Le *controlleur* (C) est représenté par la Servlet
   * La *vue* (V) est représentée par les JSPs
   * Le *model* (M) est représenté par des classes Java

#### Différents types de languages
 * Language compilé: Compilation obligatoire du code afin d'être utilisable
 * Language interpreté: Code directement exploitable/deployable
 * Language *intermédiaire*: Nécessite une compilation et a aussi besoin d'être interprété (par exemple: Java)

#### Struture par défaut d'un projet JEE
La partie *model* ainsi que *controlleur* est située dans le répertoire *src* du projet. La partie *vue* quant à elle est placée dans le dossier *webapp* (ou *WebContents*).

Voici un exemple de *controlleur* (en JEE: **Servlet**). Nous pouvons voir que cette classe étend *HttpServlet* et qu'elle contient l'annotation *@WebServlet*. Il est nécessaire d'avoir un constructeur vide ```Sd() { super(); }``` ainsi que les fonctions ```doGet(HttpServletRequest req, HttpServletResponse resp)``` et ```doPost(HttpServletRequest req, HttpServletResponse resp)```.
```java
@WebServlet("/sd")
public class Sd extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Sd() { super(); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/sd.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

```
Ensuite, les fichiers *vue* sont des fichiers **.jsp**: il s'agit de fichiers *HTML* permettant de réaliser des insertions de code Java et d'autres logiques Java à l'intérieur. Voici un exemple de fichier JSP:
```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<html>
<head>
    <title>Page test</title>
</head>
<body>
    <h1>Page de test</h1>
    <span>Voici les catégories disponibles:</span>
    <%@ include file="menu.jsp"%>
</body>
</html>
```
Nous pouvons voir des balises ```<% %>```, qui sont des balises spécifiques aux *jsps*. Par exemple, la balise ```<%@ include file="menu.jsp"%>``` permet d'insérer la page *menu.jsp* à l'intérieur de cette propre page.

---
### Notes cours 3

#### API et interopérabilité
* Permet de transmettre des informations du *front-end* vers le *back-end* à l'aide de la **sérialisation** puis de la **désérialisation** des données
* XML:
  * Fonctionne avec des balises pour structurer les données
  * Exemple de structure:
    ```xml
    <etudiant>
        <id>1234</id>
        <nom>Onyme</nom>
        <prenom>Anne</prenom>
        <moyenne>12</moyenne>
    </etudiant>
    ```
  * Utilisable pour faire des requetes
* SOAP: Simple Object Access Protocol

#### Structure projet JEE: JAXB et JAX-WS
* Permet de structurer le code à l'aide d'annotations ```@```
* Peut remplacer les balises de ```web.xml```

#### Serialization
* En Java, la sérialisation d'une classe se fait en implémentant *Serializable*
* Nécessité d'avoir un constructeur vide

#### Maven
* Permet de gérer les dépendances externes au projet
* On se concentre juste sur notre projet
* Configure a notre place
* ```mvn archetype:generate``` permet de générer un projet Java simple
* Un projet *Maven* contient un fichier **pom.xml**, qui contient l'ensemble des dépendances
* Convention: un projet *Maven* a une structure donnée
* ```mvn eclipse:ecplise``` est un plugin *goal*. ```mvn idea:idea``` pour *IntelliJ IDEA* est obsolète
* Cycle de vie de *Maven*:
  * ```mvn validate```: validation
  * ```mvn compile```: compilation
  * ```mvn test```: lancement des tests unitaires
  * ```mvn package```: packaging
  * ```mvn install```: création du *.jar*
  * ```mvn deploy```: déploiement
  * ```mvn site```: générer le site du projet

#### JUnit
* Tests unitaires
* Format spécifique des tests
* Permet de tester le code automatiquement
* Lors des tests unitaires, la fonction ```SetUp()``` est exécutée avant le début des tests. Elle permet d'initialiser les éléments à tester
* Les annotations permettent de définir le comportement de chaque méthode:
  * ```@Before```: avant chaque test
  * ```@After```: après chaque test
  * ```@Test```: un test
* Plusieurs types de tests différents:
  * Les *asserts*: permettent de vérifier l'état ou la valeur d'un objet après une méthode, ...
  * Les tests de lancement d'erreur: permettent de vérifier qu'une fonction lance bien une erreur si elle est mal utilisée


---
### Notes cours 4

#### WebServices & SOAP (Simple Object Access Protocol)
* Plusieurs *annotations* sont utilisées afin de créér un service web SOAP:
  * ```@WebService(targetNamespace = 'ns')```: A mettre sur la classe de *Service*
  * ```@WebMethod(operationName = 'on')```: A mettre sur une methode dont on souhaite avoir accès
* Nécessité d'utiliser la classe ```Endpoint``` avec la méthode ```publish(url,service)``` afin de rendre accessible le service

---
### Notes cours 5

#### REST
* Web = ressources + URL + HTTP
* API: *Application programming interface*: Permet de faire des interfaces disponibles de programme à programme
* <u>UDDI</u> : Universal Description Discovery and Integration
* <u>WSDL</u> : WebService Description Language (spécifications détaillées des entrées / sorties, l'url d'accès, ... ⚠️On a pas la description des méthodes côté serveur)
* <u>API REST</u> : façon d'exposer et de consommer les ressources 
  Dans les API REST, l'échange de message ce fait en format JSON (il n'est pas basé sur le balisage contrairement au XML, il se base sur les méthodes ```"clé" : "valeur"```)
  * Nécessaire de définir le format échangé (*JSON*, *XML*, ...)
  * Utilise les protocoles HTTP telles que:
    * GET: lecture de ressources (représentation publique de la ressource)
    * POST: envoi de messages à une ressource existante
    * PUT: insertion d'une nouvelle ressource
    * DELETE: suppression d'une ressource
    * ...
  * Plusieurs couches:
    * Présentation
    * Session
    * Entity

---
### Notes cours 6

#### Hibernate
* Framework gérant la persistance des objets en BDD relationnelle

#### Persistance
 * Permettre de faire le lien entre une classe *Model* et une table de base de données
 * Configuration hibernate:
   * Fichier de configuration ```hibernate.cfg.xml```
   * Propriétés importantes:
     * ```hibernate.connection.driver_class```: driver de base de données
     * ```connection.url```: lien vers la base de données
     * ```connection.username```: nom de l'utilisateur se loggant
   * Mappings:
     * Permet de déclarer les classes a relier avec des tables de la BDD
 * Classe *HibernateFactory*:
   * Est une classe *factory* (un peu similaire a un *singleton*) permettant d'ouvrir une connexion à la BDD
 * Classe *PokemonManager*:
   * Permet de déclarer les différentes méthodes sur des objets *Pokemon*, qui seront ensuite traduites vers les objets de la BDD
   * Utilisation de *sessions* et d'objets *Query* afin d'écrire du code Java qui sera ensuite transformé en code SQL
 * Classe *Pokemon*:
   * Classe *Model*, définie a l'aide des annotations ```@Entity``` et ```@Table```
   * Les attributs de la classe sont définis par l'annotation ```@Column```
   * L'attribut clé primaire est défini par l'annotation ```@Id```. On peut lui donner la possibilité d'être une valeur auto-incrémentale avec l'annotation ```@GeneratedValue(strategy = GenerationType.IDENTITY)```
 * Classe *PokemonServlet*:
   * Utilisation de l'instance de *PokemonManager* afin d'effectuer les appels à la BDD
   * Pour une meilleure optimisation, il est bon de déclarer la classe manager en tant qu'attribut de la classe servlet plutôt que de l'instancier dans chaque endpoint.

---

### Notes cours 7

#### Spring boot
 * [Spring Initializr](https://start.spring.io/)
 * *Spring boot* est un framework permettant de générer et de définir automatiquement l'infrastructure d'une application Java
 * Permet de faciliter la vie, évite certains bugs
 * Il ne reste presque plus de fichiers de propriétés, le plus important étant: ```application.properties```
   * ```server.port```: permet de changer le port d'écoute du serveur
 * 3 annotations:
   * ```Configuration```
   * ```EnableAutoConfiguration```
   * ```ComponentScan```

---
### Authors
* Léo Boulard
* Léo Krebs
