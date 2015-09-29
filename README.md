# V-V-TP1

## Preliminary questions

 * Question 1 : On ne peut pas savoir si la méthode `remove` est responsable de l'échec alors que la méthode `add` est aussi utilisée mais non testée.
 * Question 2 : Pour la même raison, il est impossible à ce stade de distinguer les méthodes fautives.
 * Question 3 : Il faut faire un test sur la méthode `add`.
 * Question 4 : Cela n'a pas d'importance dans la mesure où les tests sont sensés être indépendant (Contexte recréé avant chaque test)
 * Question 5 : Ce peut être considéré comme suffisant au regard du périmètre fonctionnel de `add`. Cependant, il serait préférable de tester également la méthode `addBefore`.
