public class Coordonnee
{
    private int x;
    private int y;

    public Coordonnee (int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX () {return this.x; }
    public int getY () {return this.y; }

    public boolean setX (int x)
    {
        if (x < 0 || x > 10)
            return false;
        this.x = x;
        return true;
    }

    public boolean setY (int y)
    {
        if (y < 0 || y > 10)
            return false;
        this.y = y;
        return true;
    }

	
}