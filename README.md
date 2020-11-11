# Programmation 2 TP1

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

### L'Interface

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
            informations de cette personne donnée (ou une boîte de message
            indiquant que le compte n'existe pas);
            - La **recherche multiple** requiert simplement de l'usager
            d'entrer une lettre et une liste lui est retournée contenant tous
            les usagers dont leur nom de famille commence avec cette lettre (ou
            aucun résultat s'il n'y a aucun compte commençant par cette
            lettre).
        - Le bouton