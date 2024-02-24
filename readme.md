# Périmètre de responsabilité de l'application

Postulats : 
- l'application a une instance par gérant. On considère que le gérant est connecté depuis l'extérieur et qu'il
ne peut accéder à l'application qu'à cette condition.
- elle n'est disponible qu'en France pour l'instant, donc les prix sont en €

## Itération 1

- Le `gérant` crée une `offre` de type `mensuelle` avec un `prix de base par mois` de 30€
- Un `futur client` souscrit à l'offre
- Le `gérant` consulte le `chiffre d'affaires` lié à ses `souscriptions` depuis la création de la salle
- Il obtient "30 €"
