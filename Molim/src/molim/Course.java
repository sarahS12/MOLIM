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
@Table(name = "course")
public class Course implements java.io.Serializable {

    @Id
    @Column(name = "courseID")
    private int courseId;
     
    @Column(name="courseName")
    private String courseName;
     
    @Column(name="courseDescription")
    private String courseDescription;
     
    @Column(name="courseDate")
    private String courseDate;
                 
    @Column(name="departmentName")
    private String departmentName;
                    
    @Column(name="imgurl")
    private String imgurl;

    
    public Course() {
        
    }

    public Course(String courseName, String courseDescription, String departmentName, String courseDate, String imgurl) {
       this.courseName = courseName;
       this.courseDescription = courseDescription;
       this.departmentName = departmentName;
       this.courseDate = courseDate;
       this.imgurl = imgurl;
    }
   
    public int getCourseId() {
        return this.courseId;
    }
    
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return this.courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public String getCourseDescription() {
        return this.courseDescription;
    }
    
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
    
    public String getDepartmentName() {
        return this.departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    public String getCourseDate() {
        return this.courseDate;
    }
    
    public void setCourseDate(String courseDate) {
        this.courseDate = courseDate;
    }
    
    public String getImgurl() {
        return this.imgurl;
    }
    
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }


}
