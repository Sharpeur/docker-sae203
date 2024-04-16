public class Bateau 
{
    private int        taille;
    private char       orientation;
    private Coordonnee position;
    private boolean    coule;


    public Bateau(int taille)
    {
        this.taille = taille;
        this.orientation = 'O';
        this.position = new Coordonnee (-1,-1);
        this.coule = false;

    }

    public Coordonnee getPosition   () { return this.position;    }
    public char       getOrientation() { return this.orientation; }
    public int        getTaille     () { return this.taille;      }
    public boolean    getCoule      () { return this.coule;       }

    public boolean valide (int x, int y, char o, String[][] emplacement)
    {
        int dx, dy;
        dx = dy = 0;

        if( x < 0 || x >10 || y < 0 || y >10 ) { System.out.println("Le bateau est en dehors du plateau"); return false; }

        switch(o)
        {
            case 'N' -> dx =  1;
            case 'O' -> dy =  1;
            case 'S' -> dx = -1;
            case 'E' -> dy = -1;
        }
        
        for(int i=0; i<this.taille ;i++)
        {
            if( x+dx * i < 0 || x+dx * i > 10 ||
                y+dy * i < 0 || y+dy * i > 10    ) { System.out.println("Le bateau dépasse du plateau"); return false; }

            if( emplacement[x+dx * i][y+dy * i] != null ) { System.out.println("Cases déjà prisent par un bateau"); return false; } 

        }
        
        this.position.setX(x);
        this.position.setY(y);
        this.orientation = o;
        return true;
    }

    public boolean coule(String[][] coup)
    {
        int dx, dy;
        dx = dy = 0;
        
        switch(this.orientation)
        {
            case 'N' -> dx =  1;
            case 'O' -> dy =  1;
            case 'S' -> dx = -1;
            case 'E' -> dy = -1;
        }
        
        for(int i=0; i<this.taille ;i++)
        {
            if( !(coup[this.position.getX() + dx * i][this.position.getY() + dy * i ] == "✱") )
                {
                    this.coule=false;
                    return false;
                }
        }
        this.coule = true;
        return true;
    }

    public String toString ()
    {
        String s ="";
        String symbDebut = "<";
        String symbMilieu = "■";
        String symbFin = ">";
    
        for(int i=0; i<this.getTaille() ;i++)
        {
            if (i == 0)
                s += symbDebut;
            else
            if (i == this.getTaille()-1)
            s += symbFin;
            else
            s += symbMilieu;

        }
        s+= '\n';
        return s;
    }

}
