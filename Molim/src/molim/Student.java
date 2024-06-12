/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molim;

/**
 *
 * @author whyyy
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student implements java.io.Serializable {

     @Id
     @Column(name="st_id")
     private int stId;
     @Column(name="st_name")
     private String stName;
     @Column(name="st_email")
     private String stEmail;
     @Column(name="st_password")
     private String stPassword;

    public Student() {
    }

	
    public Student(int stId, String stPassword) {
        this.stId = stId;
        this.stPassword = stPassword;
    }
    public Student(int stId, String stName, String stEmail, String stPassword) {
       this.stId = stId;
       this.stName = stName;
       this.stEmail = stEmail;
       this.stPassword = stPassword;
    }
   
    public int getStId() {
        return this.stId;
    }
    
    public void setStId(int stId) {
        this.stId = stId;
    }
    public String getStName() {
        return this.stName;
    }
    
    public void setStName(String stName) {
        this.stName = stName;
    }
    public String getStEmail() {
        return this.stEmail;
    }
    
    public void setStEmail(String stEmail) {
        this.stEmail = stEmail;
    }
    public String getStPassword() {
        return this.stPassword;
    }
    
    public void setStPassword(String stPassword) {
        this.stPassword = stPassword;
    }

    
    
}

