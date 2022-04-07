package wholeworthsgrocery;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class FXMLController implements Initializable {

    @FXML
    private TextField BreadinputTextbox;

    @FXML
    private TextField MilkinputTextbox;

    @FXML
    private TextField egginputTextbox;

    @FXML
    private TextField overallCost;

    @FXML
    private TextField totalbreadCost;

    @FXML
    private TextField totaleggCost;

    @FXML
    private TextField totalmilkCost;

    @FXML
    private Label myLabel;

   static int egg = 0;
   static double eggCost = 0.00;

    static int milk = 0;
   static double milkCost = 0.00;

    static int bread = 0;
    static double breadCost = 0.00;

    double totalCost;

    @FXML
    void BreadinputTextbox(KeyEvent event) {
        bread=0;
        try {
            bread = Integer.parseInt(BreadinputTextbox.getText());

            if (bread >= 0) {
                myLabel.setText("Calculating...");
            } else {
                myLabel.setText("Enter a positive whole number");
            }
        } catch (NumberFormatException ex) {
            myLabel.setText("ERROR: Enter number amount!!");
        } catch (Exception ex) {
            myLabel.setText("ERROR: Enter correct amount!!");
        }
        double single = (bread % 2) * 3.50;
        double dozen = (bread / 2) * 6.00;
        breadCost = dozen + single;
        totalbreadCost.setText("$" + breadCost);
    }

    @FXML
    void MilkinputTextbox(KeyEvent event) {
       milk=0;
        try {
            milk = Integer.parseInt(MilkinputTextbox.getText());

            if (milk >= 0) {
                myLabel.setText("Calculating...");
            } else {
                myLabel.setText("Enter a positive whole number");
            }
        } catch (NumberFormatException ex) {
            myLabel.setText("ERROR: Enter number amount!!");
        } catch (Exception ex) {
            myLabel.setText("ERROR: Enter correct amount!!");
        }
        double single = (milk % 3) * 2.50;
        double dozen = (milk / 3) * 7.00;
        milkCost = dozen + single;
        totalmilkCost.setText("$" + milkCost);
    }

    @FXML
    void egginputTextbox(KeyEvent event) {
        egg=0;
        try {
            egg = Integer.parseInt(egginputTextbox.getText());

            if (egg >= 0) {
                myLabel.setText("Calculating...");
            } else {
                myLabel.setText("Enter a positive whole number");
            }
        } catch (NumberFormatException ex) {
            myLabel.setText("ERROR: Enter number amount!!");
        } catch (Exception ex) {
            myLabel.setText("ERROR: Enter correct amount!!");
        }

        double single = (egg % 12) * 0.50;
        double dozen = (egg / 12) * 5.00;
        eggCost = dozen + single;
        totaleggCost.setText("$" + eggCost);
    }

    @FXML
    void calculate(ActionEvent event) {
        totalCost = eggCost + breadCost + milkCost;
        overallCost.setText("$" + totalCost);
        myLabel.setText("Done");
    }
        

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
