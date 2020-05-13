/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.xml.NhanVien;
import entity.xml.Students;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Administrator
 */
public class NhanvienDAO {
    public static List<NhanVien> layDanhSachNV(String ten){
        List<NhanVien> list = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql="from NhanVien";
        if(ten.length()>0){
            sql += " where hoten like '%"+ten+"%'";
        }
        Query query = session.createQuery(sql);
        list = query.list();
        return list;
    }    
    public static List<Students> LayDanhSachNhanVien(){
        List<Students> dsKhachHang=null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql="from NhanVien";
        Query query = session.createQuery(hql);
        dsKhachHang = query.list();
        return dsKhachHang;
    }
    public static NhanVien layThongTinNhanVien(int maNV){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        NhanVien kh = (NhanVien)session.get(NhanVien.class, maNV);
        session.close();
        return kh;
    }
    public static boolean themSinhVien(NhanVien nv){
        if(NhanvienDAO.layThongTinNhanVien(nv.getManv())!=null)
            return false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.getTransaction().begin();
            session.save(nv);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            System.out.println(e);
            return false;
        }
//        }finally{
//            session.close();
//        }
    }
    public static boolean updateThongTinSinhVien(NhanVien nv){
        if(NhanvienDAO.layThongTinNhanVien(nv.getManv())==null)
            return false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.getTransaction().begin();
            session.update(nv);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            System.out.println(e);
            return false;
        }
    }
    public static boolean deleteSinhVien(int maSV){
        NhanVien nv = NhanvienDAO.layThongTinNhanVien(maSV);
        if(nv==null)
            return false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.getTransaction().begin();
            session.delete(nv);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            System.out.println(e);
            return false;
        }
    }
}
