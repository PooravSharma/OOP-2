/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customersortandsearch;

/**
 *
 * @author Poorav Sharma
 */
public class Customer implements Comparable<Customer> {

    private int id;
    private String name;
    private String email;
    private String mobile;

    public Customer() {

    }

    public Customer(int inId, String inName, String inEmail, String inMobile) {
        id = inId;
        name = inName;
        email = inEmail;
        mobile = inMobile;
    }

    /**
     * Displays the object information when toString is called
     *
     * @return
     */
    @Override
    public String toString() {
        return "Id = " + getId() + "\nName = " + getName() + "\nEmail = " + getEmail()
                + "\nMobile = " + getMobile();
    }

    /**
     *
     * compares the id in ascending order
     *
     * @param cus
     * @return
     */
    @Override
    public int compareTo(Customer cus) {
        int compareId = cus.getId();

        return this.id - compareId;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
