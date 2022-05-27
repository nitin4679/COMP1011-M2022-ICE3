package ca.georgiancollege.comp1011m2022ice3;

/*Singleton*/
public final class Utility
{
    // step1 - create a private static instance member
    private static Utility m_instance = null;
    //step2- make the default constructor private
    private Utility() {}
    // step3 - create a public static access method that returns an instance to the class
    public static Utility Instance()
    {
        // step 4 - ensure that your instance member variable is null
        if(m_instance == null)
        {
            //step5- create an instance of the class and save reference int private variable
            m_instance = new Utility();
        }
        //step 6 - return an instance (reference) of the class
        return m_instance;
    }





    /*
    This method returns the distance from start to end
    * @param start - start vector2D
    * @param end - ending vector2D
    * */
    public float Distance(Vector2D start, Vector2D end)
    {
        float diffXs = end.getX() - start.getX();
        float diffYs = end.getY() - start.getY();

        return (float) Math.sqrt(diffXs * diffXs + diffYs * diffYs);
    }

    public float Distance(float x1, float y1, float x2, float y2)
    {
        float diffXs = x2 - x1;
        float diffYs = y2 - y1;
        return (float) Math.sqrt(diffXs * diffXs + diffYs * diffYs);

    }
}