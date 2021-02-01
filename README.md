# 4A2I - Systèmes distribués<img align="right" width="200" height="100" src="https://github.com/Legoota/4A2I-Syst-dist/blob/main/logo.png" alt="Logo Polytech">
---
### Summary

4<sup>th</sup> year distributed systems course at the Polytech Nancy's Engineering School.

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
* API REST: 
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
### Authors
* Léo Boulard
* Léo Krebs
