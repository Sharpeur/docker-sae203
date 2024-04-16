import java.io.*;
import java.net.*;

public class Serveur {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // Port utilisé par le serveur
            InetAddress localHost = InetAddress. getLocalHost();
       	    System.out.println(localHost);
        
            System.out.println("Serveur en attente de connexion...");
            
            Socket clientSocket = serverSocket.accept(); // Attente d'une connexion entrante
            
            System.out.println("Client connecté !");
            
            // Flux de sortie pour envoyer des données au client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            // Flux d'entrée pour recevoir des données du client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            String inputLine;
            
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Message du client : " + inputLine);
                out.println("Message reçu : " + inputLine); // Répond au client
            }
            
            // Fermeture des flux et des sockets
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
        }
    }
}
