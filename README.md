# V-V-TP1

## Question 1

On ne peut pas savoir si la méthode `remove` est responsable de l'échec alors que la méthode `add` est aussi utilisée mais non testée.

## Question 2

Pour la même raison, il est impossible à ce stade de distinguer les méthodes fautives.

## Question 3

Il faut faire un test sur la méthode `add`.

## Question 4

Cela n'a pas d'importance dans la mesure où les tests sont sensés être indépendant (Contexte recréé avant chaque test)

## Question 5

Dans une optique de test de type "boite noire", ce peut être considéré comme suffisant au regard du périmètre fonctionnel de `add`. 

## Question 6

Nous considérons les tests suffisants en terme de fonctionnalités testées et de temps passé. Le code ne peux pas être testé à 100% car certaines propriétés sont inaccessibles.
Exemple : La propriété MAX_VALUE permettant de calculer la taille maximum d'une liste est très élevé et dépendante du système au runtime, les résultats objectifs du test risquent d'en être affectées.
