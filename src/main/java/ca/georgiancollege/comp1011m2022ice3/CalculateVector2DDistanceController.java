package ca.georgiancollege.comp1011m2022ice3;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculateVector2DDistanceController {

    @FXML
    private TextField ResultTextField;

    @FXML
    private TextField X1TextField;

    @FXML
    private TextField X2TextField;

    @FXML
    private TextField Y1TextField;

    @FXML
    private TextField Y2TextField;

    @FXML
    void OnCalculateButtonClicked(ActionEvent event)
    {
        //Setup Variables
        try
        {
            float x1 = Float.parseFloat(X1TextField.getText());
            float y1 = Float.parseFloat(Y1TextField.getText());
            float x2 = Float.parseFloat(X2TextField.getText());
            float y2 = Float.parseFloat(Y2TextField.getText());

            Vector2D point1 = new Vector2D(x1, y1);
            Vector2D point2 = new Vector2D(x2, y2);

            float distance = Utility.Distance(point1,point2);
            ResultTextField.setText(String.valueOf(distance));
        }
        catch (Exception e){
            ResultTextField.setText("Please Enter Valid Numbers");
        }


    }
    @FXML
    void OnResetButtonClicked(ActionEvent event){
        X1TextField.clear();
        Y1TextField.clear();
        X2TextField.clear();
        Y2TextField.clear();
        ResultTextField.clear();

        X1TextField.requestFocus();
    }

}
