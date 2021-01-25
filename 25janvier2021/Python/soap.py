from zeep import Client

def besides():
    print("\n")
    print("* * * * * * * * * * * * * * * * * * * * * ")
    print("\n")

client = Client("http://localhost:8989/?wsdl")
print("Bonjour dans la console de test SOAP. Que voulez vous faire ?")
res = 0
while(res != 8):
    res = int(input('''Que choisissez-vous parmi les tests suivants ? 
        1) Affichage de l\'ensemble des produits
        2) Ajout d\'un produit
        3) Affichage d\'un seul produit
        4) Suppression d\'un produit
        5) Affichage de la liste des produits dont le prix est supérieur à...
        6) Service d\'addition
        7) Service de conversion
        8) Quitter\n'''))
    if res == 1:
        print("\n * Affichage de l'ensemble des produits (manière brute):")
        print(client.service.afficherProduits())
    elif res == 2:
        print("\n * Ajout d'un produit:")
        code = int(input("Quel est le code du produit à ajouter ? : "))
        desc = str(input("Quelle est la description du produit à ajouter ? : "))
        prix = float(input("Quel est le prix du produit à ajouter ? : "))
        retour = client.service.ajouterProduit(code,desc,prix)
        print("Produit ajouté !" if retour else "Erreur ajout.")
    elif res == 3:
        print("\n * Affichage d'un produit:")
        code = int(input("Quel est le code du produit à visualiser ? : "))
        print(client.service.affichage(code))
    elif res == 4:
        print("\n * Suppression d'un produit:")
        code = int(input("Quel est le code du produit à supprimer ? : "))
        retour = client.service.supprimerProduit(code)
        print("Produit supprimé !" if retour else "Erreur suppression.")
    elif res == 5:
        print("\n * Affichage personnalisé de la liste des produits:")
        prix = float(input("Quel est le prix minimal que vous souhaitez voir ? : "))
        print("Affichage des produits dont le prix est supérieur à ", prix, " : ")
        print(client.service.produitSuperieurAuPrix(prix))
    elif res == 6:
        print("\n * Service d'addition:")
        a = float(input("Premier nombre : "))
        b = float(input("Second nombre : "))
        print("Le résultat de ",a," + ",b," = ",client.service.methodeSomme(a,b))
    elif res == 7:
        print("\n * Service de conversion:")
        a = float(input("Nombre à convertir : "))
        b = float(input("Taux de conversion : "))
        print("Le résultat de la conversion de ",a," au taux ",b," est ",client.service.methodeConv(a,b))
    besides()