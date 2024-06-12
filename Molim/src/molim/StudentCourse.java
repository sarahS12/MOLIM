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
@Table(name="studentCourse")
public class StudentCourse implements java.io.Serializable {

     @Id
     @Column(name="st_courseID")
     private int stCourseId;
     
     @Column(name="st_id")
     private int studentid;
      
     @Column(name="coursename")
     private String coursename;
    
     @Column(name="courseDescription")
     private String courseDescription;
    
     @Column(name="courseDate")
     private String courseDate;
     
     @Column(name="departmentName")
     private String departmentName;
     
     @Column(name="imgurl")
     private String imgurl;

      
    public StudentCourse() {
    }

	
    public StudentCourse(int stCourseId, int student) {
        this.stCourseId = stCourseId;
        this.studentid = student;
    }
    
    public StudentCourse(int stCourseId, int student, String coursename, String courseDescription, String courseDate, String departmentName, String imgurl) {
       this.stCourseId = stCourseId;
       this.studentid = student;
       this.coursename = coursename;
       this.courseDescription = courseDescription;
       this.courseDate = courseDate;
       this.departmentName = departmentName;
       this.imgurl = imgurl;
    }
   
    public int getStCourseId() {
        return this.stCourseId;
    }
    
    public void setStCourseId(int stCourseId) {
        this.stCourseId = stCourseId;
    }
    public int getStudent() {
        return this.studentid;
    }
    
    public void setStudent(int student) {
        this.studentid = student;
    }
    public String getCoursename() {
        return this.coursename;
    }
    
    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
    public String getCourseDescription() {
        return this.courseDescription;
    }
    
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
    public String getCourseDate() {
        return this.courseDate;
    }
    
    public void setCourseDate(String courseDate) {
        this.courseDate = courseDate;
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

