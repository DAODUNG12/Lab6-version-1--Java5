package entity.xml;
// Generated Mar 10, 2017 8:25:27 PM by Hibernate Tools 4.3.1



/**
 * Students generated by hbm2java
 */
public class Students  implements java.io.Serializable {


     private int masv;
     private String name;
     private Double mark;
     private String major;

    public Students() {
    }

    public Students(String name, Double mark, String major) {
       this.name = name;
       this.mark = mark;
       this.major = major;
    }
   public Students(int masv, String name, Double mark, String major) {
       this.masv=masv;
       this.name = name;
       this.mark = mark;
       this.major = major;
    }
    public int getMasv() {
        return this.masv;
    }
    
    public void setMasv(int masv) {
        this.masv = masv;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Double getMark() {
        return this.mark;
    }
    
    public void setMark(Double mark) {
        this.mark = mark;
    }
    public String getMajor() {
        return this.major;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }




}

