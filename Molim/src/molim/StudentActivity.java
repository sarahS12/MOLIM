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
@Table(name = "studentactivity")
public class StudentActivity implements java.io.Serializable {
     @Id
     @Column(name="st_activityID")
     private int stActivityId;
     
     @Column(name="st_id")
     private int student;
     
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

    public StudentActivity() {
    }

	
    public StudentActivity(int stActivityId, int student) {
        this.stActivityId = stActivityId;
        this.student = student;
    }
    
    public StudentActivity(int stActivityId, int student, String activitiesName, String activitiesDescription, String activitiesdate, String departmentName, String imgurl) {
       this.stActivityId = stActivityId;
       this.student = student;
       this.activitiesName = activitiesName;
       this.activitiesDescription = activitiesDescription;
       this.activitiesdate = activitiesdate;
       this.departmentName = departmentName;
       this.imgurl = imgurl;
    }
   
    public int getStActivityId() {
        return this.stActivityId;
    }
    
    public void setStActivityId(int stActivityId) {
        this.stActivityId = stActivityId;
    }
    public int getStudent() {
        return this.student;
    }
    
    public void setStudent(int student) {
        this.student = student;
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
