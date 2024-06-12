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
@Table(name = "activities")
public class Activities implements java.io.Serializable {

     @Id
     @Column(name="activitiesID")
     private int activitiesId;
     
     @Column(name="activitiesName")
     private String activitiesName;
     
     @Column(name="activities_description")
     private String activitiesDescription;
     
     @Column(name="activitiesdate")
     private String activitiesdate;
     
     @Column(name="DepartmentName")
     private String departmentName;
     
     @Column(name="imgurl")
     private String imgurl;

     
    public Activities() {
        
    }

    public Activities(int activitiesId) {
        this.activitiesId = activitiesId;
    }
    
    public Activities(int activitiesId, String activitiesName, String activitiesDescription, String activitiesdate, String departmentName, String imgurl) {
       this.activitiesId = activitiesId;
       this.activitiesName = activitiesName;
       this.activitiesDescription = activitiesDescription;
       this.activitiesdate = activitiesdate;
       this.departmentName = departmentName;
       this.imgurl = imgurl;
    }
   
    public int getActivitiesId() {
        return this.activitiesId;
    }
    
    public void setActivitiesId(int activitiesId) {
        this.activitiesId = activitiesId;
    }
    public String getActivitiesName() {
        return this.activitiesName;
    }
    
    public void setActivitiesName(String activitiesName) {
        this.activitiesName = activitiesName;
    }
    public String getActivitiesDescription() {
        return this.activitiesDescription;
    }
    
    public void setActivitiesDescription(String activitiesDescription) {
        this.activitiesDescription = activitiesDescription;
    }
    public String getActivitiesdate() {
        return this.activitiesdate;
    }
    
    public void setActivitiesdate(String activitiesdate) {
        this.activitiesdate = activitiesdate;
    }
    public String getDepartmentName() {
        return this.departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getImgurl() {
        return this.imgurl;
    }
    
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

}
