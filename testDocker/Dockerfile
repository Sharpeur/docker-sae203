# Utiliser l'image debian officielle comme image parent
FROM debian:latest

# Installer des services et des packages java

RUN apt-get update && apt-get install -y default-jdk

# Copier les fichiers de l'hôte vers l'image
WORKDIR /app
COPY ./serveur /app

# Lancer le service apache au démarrage du conteneur
run javac -encoding UTF-8 Serveur.java
CMD ["java","Serveur"]