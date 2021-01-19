package fr.polytech;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de tests unitaires pour Calcul
 */
public class AppTest 
{
    private Calcul c;

    @Before
    public void SetUp() {
        c = new Calcul();
    }

    @Test
    public void testSomme() {
        assertTrue(c.somme(4,5)==9);
    }

    @Test
    public void testProduit() {
        assertTrue(c.produit(4,5)==20);
    }
}
