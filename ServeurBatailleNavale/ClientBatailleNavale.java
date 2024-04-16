import java.io.*;
import java.net.*;

public class ClientBatailleNavale
{
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("15fe9c3d08e3", 8080); // Connexion au serveur
            
            // Flux de sortie pour envoyer des données au serveur
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            // Flux d'entrée pour recevoir des données du serveur
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            ObjectInputStream inObj = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outObj = new ObjectOutputStream(socket.getOutputStream());
            
            String m;
            String nomJoueur;
            
            // Reçois d'un message au serveur
            m = in.readLine();
            nomJoueur = m;



            Joueur j1 = new Joueur ("j1");
            Joueur j2 = new Joueur ("j2");

            if (nomJoueur == "j1")
            {
                boolean val1 = false;
                boolean val2 = false;
                System.out.println("Bienvenue à la bataille navale.\nLa partie commence :");
    
                
                    do
                    {
                        do
                            val1 = j1.placerBateaux();
                        while (val1 == false);
                            outObj.writeObject(j1);

                            System.out.println("En attente du j1");
                            j2 = (Joueur)inObj.readObject();
                            val2 =true;
            
                    }
                    while (val1 == false && val2 == false);
    
                    int joueur = 1;
                    boolean touche = true;
                    boolean fin = true;
                    do
                    {
                        if (joueur == 1)
                        {
                            do
                            {
                                touche = j1.tire(j2);
                                if ( j2.perdu(j1))
                                {
                                    j1.afficherCoups();
                                    fin = false;
                                    out.println(fin);
                                }
                            }
                            while(touche && fin);
                            outObj.writeObject(j1);
    
                            joueur = 2;
                        }
                        else
                        if (joueur == 2)
                        {

                            j2 = (Joueur)inObj.readObject();
                            if (in.readLine() == "true")
                                fin = true;
                            else 
                                fin = false;
                            joueur = 1;
                            
                        }

                        
                    }
                    while (fin);
    
            if( joueur == 1 )
                System.out.println( "Joueur 2 à gagné ! \n" );
            else
                System.out.println( "Joueur 1 à gagné ! \n" );
    
    
            System.out.println( "PARTIE TERMIÉE  ඞ" );
    


            }

            
            if(nomJoueur == "j2")
            {
                
                boolean val1 = false;
                boolean val2 = false;
                System.out.println("Bienvenue à la bataille navale.\nLa partie commence :");

            
                do
                {
                        
                    do
                        val2 = j2.placerBateaux();
                    while (val2 == false);
                    outObj.writeObject(j1);
                    
                    System.out.println("En attente du j1");
                    j1 = (Joueur)inObj.readObject();
                    val1 =true;
        
                }
                while (val1 == false && val2 == false);

                int joueur = 1;
                boolean touche = true;
                boolean fin = true;
                do
                {
                    if (joueur == 1)
                    {
                        j1 = (Joueur)inObj.readObject();
                        if (in.readLine() == "true")
                            fin = true;
                         else 
                            fin = false;
                        joueur = 2;

                        
                    }
                    else
                    if (joueur == 2)
                    {
                        do
                        {
                            touche = j2.tire(j1);
                            if ( j1.perdu(j2) )
                            {
                                j2.afficherCoups();
                                fin = false;
                                out.println(fin);
                            }
                        }
                        while(touche && fin);
                        joueur = 1;
                    }
                }
                while (fin);

        if( joueur == 1 )
            System.out.println( "Joueur 2 à gagné ! \n" );
        else
            System.out.println( "Joueur 1 à gagné ! \n" );


        System.out.println( "PARTIE TERMIÉE  ඞ" );

    }

            

            
            
            
            // Fermeture des flux et de la socket
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
        }
    }
}
