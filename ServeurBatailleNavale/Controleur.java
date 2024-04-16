public class Controleur
{
    public static void main(String[] a)
    {
        boolean val1 = false;
        boolean val2 = false;
        System.out.println("Bienvenue à la bataille navale.\nLa partie commence :");
        
        Joueur j1 = new Joueur("j1");
        Joueur j2 = new Joueur("j2");

        do
        {
            do
                val1 = j1.placerBateaux();
            while (val1 == false);

            do
                val2 = j2.placerBateaux();
            while (val2 == false);
 
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
                    }
                }
                while(touche && fin);

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



    
}