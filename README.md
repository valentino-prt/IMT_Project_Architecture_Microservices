# IMT_Project_Architecture_Microservices
- Nous allons faire une application qui embarque un système comparable a Pokemon a quelques exceptions prêt:
- Les utilisateurs sont des combattants qui possèdent jusqu’à 6 Pokemon.
- Les utilisateurs ne capturent pas de Pokemon mais achètent des œufs.
- Les utilisateurs peuvent vendre leurs œufs
- Les œufs peuvent être places dans des incubateurs. Les œufs éclosent après une période de temps différente pour chaque œuf.
- Les Pokemon sortant des œufs sont définis avant éclosion mais les statistiques du Pokemon sont générées au moment de l’éclosion.
- Les utilisateurs récupèrent les Pokemon au moment de l’éclosion. Si jamais l’utilisateur a plus de 6 Pokemon il doit choisir de se séparer d’un avant de récupérer le nouveau.
- Les utilisateurs peuvent demander à affronter un Pokemon au hasard, si victoire, le combat donne un nombre défini d’experience et d’or.
- Les utilisateurs peuvent monter une tour. Chaque étage contient un boss. Les utilisateurs peuvent combattre les boss. Les boss ont un nombre de Pokemon entre 1 et 6.
- L’utilisateur ne peut combattre que le boss de l’étage auquel il est actuellement. Lorsqu’il gagne, il avance d’un étage et peux rencontrer le boss suivant.
- Un rapport des Pokemon, combats, œufs et éclosions est disponible. Il n’a pas besoin d’être à jour à l’instant T et ne doit pas faire appel à d’autres micro-services au moment de la lecture. Il peut cependant faire appel à d’autre micro-service au moment de la génération du rapport.
- Les combats n’ont pas besoin d’être complexe. Si votre système est simplement de dire que le Pokemon avec le plus grand niveau gagne c’est un système valide. Le gain d’expérience peut être simplifié par gagner un niveau à chaque combat gagné.

# Port 
Hatching service : 8082
Inventaire service : 8081
Random service : 8083
Store service : 8084
User service : 8080