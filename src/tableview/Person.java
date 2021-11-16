/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableview;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Angel Medina Cantos
 */
public class Person 
{
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty email;
 
    Person(String fName, String lName, String email) 
    {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.email = new SimpleStringProperty(email);
    }
    
    // Gets and Sets
    public String getFirstName() 
    {
        return firstName.get();
    }
    public void setFirstName(String fName) 
    {
        firstName.set(fName);
    }
        
    public String getLastName() 
    {
        return lastName.get();
    }
    public void setLastName(String fName) 
    {
        lastName.set(fName);
    }
    
    public String getEmail() 
    {
        return email.get();
    }
    public void setEmail(String fName) 
    {
        email.set(fName);
    }
    
    
    
    
}
