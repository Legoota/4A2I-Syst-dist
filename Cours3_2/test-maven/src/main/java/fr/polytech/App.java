package fr.polytech;

/**
 * Classe main
 */
public class App 
{
    public static void main( String[] args )
    {
        Calcul c = new Calcul();
        System.out.println( "Valeur de 5 + 4 = " + c.somme(5,4));
    }
}
