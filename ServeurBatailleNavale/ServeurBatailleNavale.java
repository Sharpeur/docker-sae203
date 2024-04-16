import java.io.*;
import java.net.*;

public class ServeurBatailleNavale {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // Port utilisé par le serveur
            InetAddress addr = InetAddress.getByName("127.0.0.1");
            InetAddress localHost = InetAddress. getLocalHost();
            System.out.println(addr);
       	    System.out.println(localHost);

            for (int i =1; i<= 2; i++)
            {
                System.out.println("Serveur en attente de connexion...");
                
                Socket clientSocket = serverSocket.accept(); // Attente d'une connexion entrante
                
                System.out.println("Joueur 1 connecté !");
                
                // Flux de sortie pour envoyer des données au client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                
                // Flux d'entrée pour recevoir des données du client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                ObjectInputStream inObj = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream outObj = new ObjectOutputStream(clientSocket.getOutputStream());
                
                String message;
                String messageJ;
                
                messageJ = ""+i;

                out.println(messageJ);
            }

            
            while ((message = in.readLine()) != null) {
                System.out.println("Message du client : " + message);
                out.println("Message reçu : " + message); // Répond au client
                
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
