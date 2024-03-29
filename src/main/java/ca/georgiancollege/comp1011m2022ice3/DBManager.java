package ca.georgiancollege.comp1011m2022ice3;

import javafx.fxml.FXML;

import java.sql.*;

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

    /**
     * This method inserts a Vector2D object to the Database
     * @param vector2D
     * @return
     * @throws SQLException
     */
    public int insertVector2D(Vector2D vector2D) throws SQLException {
        int vectorID = -1; // if this method returns -1 - it means that something went wrong
        //initializing the result set object
        ResultSet resultSet = null;

        //create  a query string
        String sql = "Insert into vectors(X,Y) values(?,?);";

        try
        ( /*head of the try / catch block */
            Connection connection = DriverManager.getConnection(m_connectURL, m_user, m_password);
            PreparedStatement statement = connection.prepareStatement(sql, new String[] {"vectorID"});

        )
        {

            // configure prepared  statement
            statement.setFloat(1,vector2D.getX());
            statement.setFloat(2, vector2D.getY());

            //run the command on the Database

            statement.executeUpdate();

            //get the vectorID
            resultSet = statement.getGeneratedKeys();
            while (resultSet.next())
            {
                //get the VectorID from the database
                vectorID = resultSet.getInt(1);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (resultSet != null)
            {
                resultSet.close();
            }
        }

        return vectorID;
    }
}
