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
public class img  implements java.io.Serializable {
     private int imgid;
     private String imgurl;

    public img() {
    }

    public img(int imgid) {
        this.imgid = imgid;
    }
    
    public img(int imgid, String imgurl) {
       this.imgid = imgid;
       this.imgurl = imgurl;
    }
   
    public int getImgid() {
        return this.imgid;
    }
    
    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
    public String getImgurl() {
        return this.imgurl;
    }
    
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
