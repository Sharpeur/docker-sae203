import iut.algo.Clavier;
import java.io.Serializable;

public class Joueur implements Serializable
{
    private Bateau[] bateaux;
    private String[][] emplacement;
    private String[][] coups;
    private String nom;


    public Joueur(String nom)
    {
        this.bateaux     = this.creationBateau();
        this.emplacement = new String[10][10];
        this.coups       = new String[10][10];
        this.nom = nom;
    }


    
    public Bateau[] creationBateau()
    {
        Bateau[] tabBateau = new Bateau[]{  new Bateau(5),
                                            new Bateau(4),
                                            new Bateau(3),
                                            new Bateau(3),
                                            new Bateau(2)
                                        };
        return tabBateau;
    }

    public String afficherCoups()
    {
        String ret =    "     A  B  C  D  E  F  G  H  I  J \n "+
                        "  ________________________________\n";

        for(int i = 0; i<this.coups.length; i++)
        {
            ret += String.format("%-2d", i+1) + " |";
            for (int j = 0; j<this.coups[0].length;j++)
            {
                if (this.coups[i][j] == null)
                    ret += " ☐ ";
                else
                    ret += " " + this.coups[i][j] + " ";
            }
            ret += "|\n";
        }

        ret += "   ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\n";
        ret += "   Coups joués de "+ this.nom+ '\n';

        return ret;
    }

    public String afficherEmplacement()
    {
        String ret =    "   Emplacement des bateaux de "+ this.nom+ '\n';
        ret +=          "     A  B  C  D  E  F  G  H  I  J \n "+
                        "  ________________________________\n";

        for(int i = 0; i<this.emplacement.length; i++)
        {
            ret += String.format("%-2d", i+1) + " |";
            for (int j = 0; j<this.emplacement[0].length;j++)
            {
                if (this.emplacement[i][j] == null)
                    ret += " ☐ ";
                else
                    ret += " " + this.emplacement[i][j] + " ";
            }
            ret += "|\n";
        }

        ret += "   ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\n";

        return ret;
    }

    public String afficherBateaux()
    {
        String bat = "Liste des Bateaux à placer :\n";
    
        for (Bateau b : this.bateaux)
            if (b.getPosition().getX() == -1)
                bat += b.toString();
        return bat;
    }

    public boolean placerBateaux()
    {
        String coord = "";
        int x, y;
        boolean bool = false;
        int nbBat = 1;
        

        for(Bateau b : this.bateaux)
        {
            do
            {
                System.out.println(this.afficherEmplacement());
                System.out.println(this.afficherBateaux());
                System.out.println(this.nom + " : Placez le bateau " + nbBat);// trim
                System.out.println("Coordonnée (ex : A1): ");

                coord = Clavier.lireString();

                y = (int)(coord.toUpperCase().charAt(0))-(int)('A');

                x = Integer.parseInt(coord.substring(1)) -1;

                
                System.out.println("orientation (N, S, E, O): ");
                char o = (Clavier.lireString().toUpperCase().charAt(0));

                bool = b.valide(x,y, o, this.emplacement);
               System.out.print("\033[H\033[2J");  
                System.out.flush(); 
            }
            while (!bool);
            emplacer(b);
            nbBat++;
            
            
        }
        
        return true;
    }

    public void emplacer(Bateau b)
    {
        int dx, dy;
        dx = dy = 0;
        String symbDebut = "";
        String symbMilieu = "";
        String symbFin = "";
        
        switch(b.getOrientation())
        {
            case 'N' : dx =  1; symbDebut = "∧";  symbMilieu = "■"; symbFin = "∨"  ; break;
            case 'O' : dy =  1; symbDebut = "<";  symbMilieu = "■"; symbFin = ">" ; break; 
            case 'S' : dx = -1; symbDebut = "∨";  symbMilieu = "■"; symbFin = "∧"  ; break;
            case 'E' : dy = -1; symbDebut = ">";  symbMilieu = "■"; symbFin = "<" ; break;
        }
    
        for(int i=0; i<b.getTaille() ;i++)
        {
            if (i == 0)
                this.emplacement[b.getPosition().getX() + dx * i][b.getPosition().getY() + dy * i ] = symbDebut;
            else
            if (i == b.getTaille()-1)
                this.emplacement[b.getPosition().getX() + dx * i][b.getPosition().getY() + dy * i ] = symbFin;
            else
                this.emplacement[b.getPosition().getX() + dx * i][b.getPosition().getY() + dy * i ] = symbMilieu;

        }
    }
//╳❌⨉✕
    
    public boolean tire(Joueur adverse)
    {
        int x, y;
        String coord ="";

        System.out.println( this.afficherCoups() );
        System.out.println(" Joueur " + this.nom + " tirez");
        System.out.println("Coordonnée (ex : A1): ");

        coord = Clavier.lireString();

        y = (int)(coord.toUpperCase().charAt(0))-(int)('A');
        x = Integer.parseInt(coord.substring(1)) -1;

        /*
        System.out.println("Coordonnée du tire : ");
        System.out.println("x: ");
        int x = (int)(Integer.parseInt(Clavier.lireString()));
        System.out.println("y: ");
        int y = (int)(Integer.parseInt(Clavier.lireString()));
        */
        
        if( x < 0 || x > 10 || y < 0 || y > 10 ) { System.out.println("les coordonnées sont en dehors du plateau"); return true; }
        if( this.coups[x][y] == "✕" || this.coups[x][y] == "✱" ) { System.out.println("Cette case à déjà été touché"); return true; }

        if( adverse.emplacement[x][y] != null )
        {
            this.coups[x][y] = "✱";
            return true;
        }
        else
        {
            this.coups[x][y] = "✕";    //  ✕  ✖   ✖
            return false; }

    }
    

    public boolean perdu (Joueur adverse)
    {
        for (Bateau b : this.bateaux)
        {
            if (!(b.getCoule()))
                if (!(b.coule(adverse.coups)))
                    return false;
        }
        return true;
    }

}