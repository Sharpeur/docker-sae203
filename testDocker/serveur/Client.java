import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.73.119", 8080); // Connexion au serveur
            
            // Flux de sortie pour envoyer des données au serveur
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            // Flux d'entrée pour recevoir des données du serveur
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            // Envoi d'un message au serveur
            out.println("Bonjour, serveur !");
            
            // Lecture de la réponse du serveur
            String response = in.readLine();
            System.out.println("Réponse du serveur : " + response);
            
            // Fermeture des flux et de la socket
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
        }
    }
}
