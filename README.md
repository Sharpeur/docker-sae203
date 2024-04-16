# Projet SAE 2.03 Equipe 7

## Bataille Navale

### **Membre du groupe**

B1-Sefil Matys

B1-Remi Viez

B1-Alexandre Freret

## Liens vers le dépôt github du projet

[docker-sae203](https://github.com/Matematis/docker-sae203)

## Présentation Projet de groupe

**Lors de cette SAE nous avons créé un jeu de [Bataille Navale](https://fr.wikipedia.org/wiki/Bataille_navale_(jeu)) en java**

```
Pour cela : 
  Nous avons créé 4 classes pour créé notre jeu 

1 Joueur.java
2 Bateau.java-
3 Coordonnee.java
4 Controleur.java
```

#### **Que font les classes :**

La classe **Joueur.java** : Pour chaque joueur nous créons 5 bateaux de tailles différentes

La classe **Coordonnee.java** : La classe est utilisé lorsque nous plaçons un bateau sur le plateau

La classe **Bateau.java** : Elle permet de déterminer la taille du bateau, l'orientation, la position du bateau ainsi que de savoir si le bateau est coulé ou non

La classe **Controleur.java** : Elle permet de déterminé si tout les joueurs on poer leur bateau, de créer le système de rotation entre chaque joueur et si la partie est finit qui a gagné

## **Demonstration de notre projet**

### Placement des bateaux :

![1713272674621](images/Index/1713272674621.png)

### Tire échoué :

![1713272833654](images/Index/1713272833654.png)

### tir réussi :

![1713272886134](images/Index/1713272886134.png)

## **Utilisation du DockerFile**

### A quoi sert un dockerFile ?

Un Dockerfile est un élément clé dans le processus de création d'images  Docker, ce qui permet de définir de manière reproductible et automatisée  les configurations et les dépendances nécessaires à une application.

### Quelle est l'utilité du dockerfile dans notre projet

Pour notre projet nous avons eu besoin d'un dockerfile pour créer un pond entre deux machines pour quelles jouent entre elles

## **Difficulté rencontré**

### Quel difficulté avons nous eu

Durant la SAE nous avons eu plusieur diffulté à :

* Création du dockerfile
* Quelque difficulté de programmation
* Création du serveur
