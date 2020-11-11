# Programmation 2 TP1

*Auteur: Philippe Gabriel, 20120600*

### Introduction

Mes choix pour ce projet sont les suivants:
- Mon projet est entièrement en anglais;
    - La raison pour cette décision est que je pensais rendre ce projet public
    sur GitHub, et l'anglais est assez universelle dans le monde de la
    programmation.
- J'ai complété ce projet individuellement;
    - Mon coéquipier n'avait pas apporté quoi que ce soit d'utile pour le
    le projet. J'avais complètement rédigé les fichiers dans les packages
    *store* et *inventory*, et signalé mon coéquipier dans mon dernier message
    commit de continuer avec la seconde partie du projet pour avoir une idée
    de ce qu'il y aurait à modifier dans les autres fichiers si besoin est.
    Mais celui-ci a décidé de plutôt "corriger" ce que j'avais écrit sans
    vraiment être certain lui-même des corrections qu'il apportait. Et il n'a
    rien apporté de supplémentaire par après. Donc j'ai décidé d'entreprendre
    le projet par moi-même.

### L'interface

Il se peut que mon interface ne suive pas tout à fait les directives exactes
énoncées dans le fichier pdf. Cela est dû au fait que je voyais que les
directives dans le fichier pouvait sembler parfois contre-intuitive et même
contradictoire.

Voici les différentes fonctionnalités de mon programme:
- Lorsqu'exécuté, une première fenêtre apparaît;
    - Cette fenêtre est la fenêtre principale;
    - Elle contient la liste des comptes créés et leurs détails;
    - Elle contient 7 différents boutons décrivant l'action que chacun
    entreprend sur son libellé:
        - Le bouton *Add Account* permet l'ajout d'un compte - Un dialogue
        est généré et contient les différents attributs d'un compte que
        l'usager devrait remplir. Certains des attributs n'acceptent que des
        lettres (ou que des nombres) et certains possèdent un nombre maximal
        de caractères. La non-complétion des attributs induit un boîte de
        message signalant à l'usager de remplir chaque donnée;
        - Le bouton *Delete Account* permet de supprimer une liste de comptes
        sélectionnés dans la liste affichée;
        - Le bouton *Advanced Search* permet à l'usager de faire une
        **recherche simple** ou une **recherche multiple**;
            - La **recherche simple** requiert de l'usager de remplir toutes
            les données relatives à un compte pour ensuite lui afficher les
            informations de cette personne donnée dans une nouvelle fenêtre(ou
            une boîte de message indiquant que le compte n'existe pas);
            - La **recherche multiple** requiert simplement de l'usager
            d'entrer une lettre et une liste lui est retournée contenant tous
            les usagers dont leur nom de famille commence avec cette lettre
            dans une nouvelle fenêtre (ou aucun résultat s'il n'y a aucun
            compte commençant par cette lettre).
        - Le bouton *Add Balance* permet d'ajouter de l'argent au compte
        sélectionné à travers un petit dialogue;
        - Le bouton *Deduct Balance* permet d'enlever de l'argent au compte
        sélectionné à travers un petit dialogue - Cette action n'est pas
        permise pour les comptes clients;
        - Le bouton *View Favorite Products* génère une nouvelle fenêtre
        contenant la liste des produits favoris du compte sélectionné. Cette
        fenêtre contient aussi deux boutons permettant l'ajout ou la
        supprimation de produits;
            - Le bouton *Add Product* permet d'ajouter des produits parmi ceux
            disponibles. Une nouvelle fenêtre s'affiche contenant la liste des
            produits disponibles et un bouton pour transférer de cette liste à
            la liste des produits favoris du compte en question;
            - Le bouton *Remove Product* permet de supprimer la liste de
            produits sélectionnés.
        - Le bouton *View Available Products* génère une nouvelle fenêtre
        contenant la liste de produits disponibles et contient également deux
        boutons permettant l'ajout ou la supprimation de produits.
            - Le bouton *Add Product* permet d'ajouter un aliment ou un meuble
            au moyen d'un dialogue et de certains attributs à remplir. Cette
            action est permise uniquement à travers un compte directeur;
            - Le bouton *Delete Product* permet de supprimer la liste de
            produits sélectionnés. Cette action est permise uniquement à
            travers un compte directeur.

Ceci résume les fonctionnalités du programme.

### Détails

Je voudrais adresser maintenant quelques détails sur la fonctionnalités du
programme:
1. La duplication de produits dans la liste de produits disponibles n'a pas été
permise. Cela veut dire que le même directeur ne peut pas créer deux mêmes
produits. Cependant, un directeur différent pourrait créer le même produit
qu'a créer un autre directeur.
1. L'ajout de produits dans la liste de produits favoris d'un compte dépend de
la présence de produits disponibles à un certain degré. Cela veut dire qu'un
produit disponible peut être ajouté à la liste de produits favoris d'un compte
sans problème. Par contre, si par après, un directeur décide de supprimer un
produit présent dans la liste de produits disponibles, ce produit demeurera
dans la liste de produits favoris du compte qui la possède. Cette
implémentation spécifique a été permise dans le cas où le produit se
réaffichera et dans l'état d'esprit de ne pas s'immiscer dans la liste des
différents comptes (un degré de respect de leurs choix par exemple). De plus,
cela pourrait permettre aux directeurs d'avoir une idée que sont les produits
demandé par les comptes pour qu'il puisse en commander et l'ajouter dans la
liste de produits disponibles.

### Idées supplémentaires

J'aurais aimé implémenter quelques fonctionnalités supplémentaires à mon
projet, mais le manque de temps et les autres cours ne m'ont pas permis de
faire cela. Voici une liste d'idées dont j'avais commencé à implémenter mais
que je devais abandonné car le temps ne me permettait pas de les développer:
- Pour la création d'un aliment, la couleur pourrait être choisi à travers un
JColorChooser et la couleur serait sauvegarder dans un libellé pour l'afficher
dans la liste de produits disponibles. En raison de manque de temps, la couleur
est simplement spécifié dans un JTextfield par l'usager.
- Pour le choix de dates de naissance, un calendrier permettant de sélectionner
d'une manière plus graphique les informations relatives au compte à créer ou
à rechercher. Cependant, un JCalendar ou JDatePicker n'existe pas dans les
packages de Java et il aurait été nécessaire de télécharger ces fichiers
pour en faire usage. Donc cette information est récupéré à la place au moyen de
3 JTextField.