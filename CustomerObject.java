/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customermanagementgui;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Poorav Sharma
 */
public class CustomerObject {

    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty email;
    private SimpleStringProperty mobile;

    public CustomerObject(int inId, String inName, String inEmail, String inMobile) {
        this.id = new SimpleIntegerProperty(inId);
        this.name = new SimpleStringProperty(inName);
        this.email = new SimpleStringProperty(inEmail);
        this.mobile = new SimpleStringProperty(inMobile);
    }

    public int getId() {
        return id.get();
    }

    public void setId(SimpleIntegerProperty setId) {
        this.id = setId;
    }

    public String getName() {
        return name.get();
    }

    public void setName(SimpleStringProperty setName) {
        this.name = setName;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(SimpleStringProperty setEmail) {
        this.email = setEmail;
    }

    public String getMobile() {
        return mobile.get();
    }

    public void setMobile(SimpleStringProperty setMobile) {
        this.mobile = setMobile;
    }

}
