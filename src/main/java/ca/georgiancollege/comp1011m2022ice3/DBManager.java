package ca.georgiancollege.comp1011m2022ice3;

// singleton
public class DBManager
{    /********************** SINGLETON SECTION **************************/
    //step 1- private static instance member variable
    private static DBManager m_instance = null;
    //step2 - make the default constructor private
    private DBManager(){}
    //step3 - create a public static entry point / instance method
    public static DBManager Instance()
    {
        //step4 - check if the private instance member variable is null
        if(m_instance == null)
        {
            //step5 - Instantiate a new DBManager instance
            m_instance = new DBManager();
        }
        return m_instance;
    }
    /********************************************************************* */



    // private instance member variables
    private String m_user = "student";
    private String m_password = "123456";
    private String m_connectURL = "jdbc:mysql://localhost:3306/comp1011m2022";

    public int insertVector2D(Vector2D vector2D)
    {
        int vectorID = -1;

        return vectorID;
    }
}
