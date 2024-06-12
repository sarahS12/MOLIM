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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="certificates")
public class Certificates  implements java.io.Serializable {
     @Id
     @Column(name="st_certificatesID")
     private int stCertificatesId;
         @Column(name="st_id")
     private int st_id;
      @Column(name="certificatesname")
     private String certificatesname;
       @Column(name="certificatesdescript")
     private String certificatesdescript;
      @Column(name="department")  
       private String department;
       @Column(name="certificatedate")  
       private String certificatedate;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCertificatedate() {
        return certificatedate;
    }

    public void setCertificatedate(String certificatedate) {
        this.certificatedate = certificatedate;
    }

    public Certificates(int stCertificatesId, int student, String certificatesname, String certificatesdescript, String department, String certificatedate) {
        this.stCertificatesId = stCertificatesId;
        this.st_id = student;
        this.certificatesname = certificatesname;
        this.certificatesdescript = certificatesdescript;
        this.department = department;
        this.certificatedate = certificatedate;
    }

    public Certificates() {
    }

	
    public Certificates(int stCertificatesId, int student) {
        this.stCertificatesId = stCertificatesId;
        this.st_id = student;
    }
    public Certificates(int stCertificatesId, int student, String certificatesname, String certificatesdescript) {
       this.stCertificatesId = stCertificatesId;
       this.st_id = student;
       this.certificatesname = certificatesname;
       this.certificatesdescript = certificatesdescript;
    }
   
    public int getStCertificatesId() {
        return this.stCertificatesId;
    }
    
    public void setStCertificatesId(int stCertificatesId) {
        this.stCertificatesId = stCertificatesId;
    }
    public int getStudent() {
        return this.st_id;
    }
    
    public void setStudent(int student) {
        this.st_id = student;
    }
    public String getCertificatesname() {
        return this.certificatesname;
    }
    
    public void setCertificatesname(String certificatesname) {
        this.certificatesname = certificatesname;
    }
    public String getCertificatesdescript() {
        return this.certificatesdescript;
    }
    
    public void setCertificatesdescript(String certificatesdescript) {
        this.certificatesdescript = certificatesdescript;
    }
}
