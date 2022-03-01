/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_world;



import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

 



@Entity
@Table(name="userInfo")
public class User implements java.io.Serializable {
    
    @Id
    @Column(name="username")
    private String name;
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
    @Transient
    private String vpassword;

    
    
    public void setVpassword(String vpassword) {
        this.vpassword = vpassword;
    }
 
    
    public User(){
       
        
    }
    
    
    public User(String email, String name, String password) {
        this.email = email;
        this.name = name; 
        this.password = password;
    }
    
    
    public String getEmail() {
        return this.email;}
    public void setEmail(String email) {
        this.email = email;}
    
    public String getName() {
        return this.name;}
    public void setName(String name) {
        this.name = name;}
    
    public String getPassword() {
        return this.password;}
    public void setPassword(String password) {
        this.password = password;}
    
    
    
}
