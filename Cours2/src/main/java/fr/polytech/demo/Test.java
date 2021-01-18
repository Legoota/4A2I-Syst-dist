package fr.polytech.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Test")
public class Test extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Test() { super(); }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // A l'appel du controlleur (en GET), on renvoie la page test.jsp
        // => permet de rendre le code plus propre en evitant d'avoir du HTML dans du code Java
        this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
