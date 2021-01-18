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
Dans le cas d'un projet JEE, nous avons:
 * Le *controlleur* (C) est représenté par la Servlet
 * La *vue* (V) est représentée par les JSPs
 * Le *model* (M) est représenté par des classes Java

#### Différents types de languages
 * Language compilé: Compilation obligatoire du code afin d'être utilisable
 * Language interpreté: Code directement exploitable/deployable
 * Language *intermédiaire*: Nécessite une compilation et a aussi besoin d'être interprété (par exemple: Java)

#### Struture par défaut d'un projet JEE
La partie *model* ainsi que *controlleur* est située dans le répertoire *src* du projet. La partie *vue* quant à elle est placé dans le dossier *webapp* (ou *WebContents*).

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
### Authors
* Léo Boulard
* Léo Krebs
