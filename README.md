#Dockerfile Bataille Navale (créer une image et lancer le serveur de jeu)

## Instructions pour lancer l'application

- Vérifiez si docker est installé :
```shell
docker --version
```

- Cloner le référentiel :
 ```shell
git clone git@github.com:Sharpeur/docker-sae203.git
```

- Aller au référentiel :
```shell
cd docker-sae203
```

- Construisez l'image décrite dans dockerfile avec docker build : 
```shell
docker build -t <choisir-un-nom-pour-l'image> .
```

- Lancer le serveur de jeu :
```shell
docker run -d -p 8080:8080 <nom-de-l'image-choisie>
```

- Vérifier que le conteneur associé est actif :
```shell
docker ps
```

- La sortie de ```docker ps``` doit être similaire à :
```shell
CONTAINER ID   IMAGE                 COMMAND              CREATED          STATUS          PORTS                                   NAMES
b8f8f406b03c   bataille-navale-img   "httpd-foreground"   30 minutes ago   Up 30 minutes   0.0.0.0:8080->8080/tcp, :::8080->8080/tcp   quirky_tesla
```
- Une fois le serveur de jeu prêt, compilez et executer le fichier ClientBatailleNavale.java:
  ```shell
  cd ServeurBatailleNavale
  ```
  ```shell
  javac CLientBatailleNavale.java
  ```
  ```shell
  java CLientBatailleNavale
  ```
- Ici le premier jouer à se connecter prendra la place j1, et le second j2.
  Ainsi les duex joeurs peuvent jouer chacun leur tour depuis leur poste et les données seront échangées à travers le serveur.

- Finalement, arrêtez le conteneur avec la commande suivante (les dernières chiffres sont le code de hachage affiché par docker ps):
```shell
docker stop b8f8f406b03c
```

- Encore, si on souhaite supprimer le conteneur, on peut taper :
```shell
docker rm b8f8f406b03c
```

**NOTE :** Au lieu du code de hachage, on peut toujours taper le nom du conteneur. Dans le cas d'exemple ce nom est ```quirky_tesla```

- Ici le lien vers notre dépot.
https://github.com/Sharpeur/docker-sae203.git

- Ici le lien vers le site de notre projet.
https://sharpeur.github.io/docker-sae203/




