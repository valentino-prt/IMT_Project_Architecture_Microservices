# IMT_Project_Architecture_Microservices POIROT Valentin OHAYON Samuel ZUMSTEIN Paulin
Nous allons faire une application qui embarque un système comparable a Pokemon a quelques exceptions prêt:
- Les utilisateurs sont des combattants qui possèdent jusqu’à 6 Pokemon.
- Les utilisateurs ne capturent pas de Pokemon mais achètent des œufs.
- Les utilisateurs peuvent vendre leurs œufs
- Les œufs peuvent être places dans des incubateurs. Les œufs éclosent après une période de temps différente pour chaque œuf.
- Les Pokemon sortant des œufs sont définis avant éclosion mais les statistiques du Pokemon sont générées au moment de l’éclosion.
- Les utilisateurs récupèrent les Pokemon au moment de l’éclosion. Si jamais l’utilisateur a plus de 6 Pokemon il doit choisir de se séparer d’un avant de récupérer le nouveau.

# Services 
- Hatching service : 8082
- Inventaire service : 8081
- Random service : 8083
- Store service : 8084
- User service : 8080

# Front
- Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.
En cas de problème d'affichage, rafraichir la page.


