/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import dao.model.Floor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 * Class fetches all floor data from DB
 * 
 * @author lisanoren
 */
public class FloorDAOImpl implements FloorDAO {

    //Floor acceess
    @Override
    public List<Floor> findAllFloors() {
        List<Floor> floorList = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query q = session.createQuery("FROM Floor");
            floorList = q.list();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return floorList;
    }

    @Override
    public Floor addFloor(Floor floor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(floor);
        transaction.commit();
        session.close();

        return floor;
    }

    @Override
    public Floor findFloorById(int floorId) {
        Floor floor = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query q = session.createQuery("FROM Floor F WHERE F.id = " + floorId);
            floor = (Floor) q.uniqueResult();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return floor;
    }

    @Override
    public void updateFloorArea(int floorId, int newArea) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("UPDATE Floor F set F.area = " + newArea
                    + " WHERE F.id = " + floorId);
            query.executeUpdate();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            System.err.println("No floor found with id " + floorId
                    + " when trying to uupdate area to " + newArea);
            e.printStackTrace();
        }
    }

    @Override
    public void updateFloorName(int floorId, String newName) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("UPDATE Floor F set F.area = " + newName
                    + " WHERE F.id = " + floorId);
            query.executeUpdate();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            System.err.println("No floor found with id " + floorId
                    + " when trying to update  name to " + newName);
            e.printStackTrace();
        }
    }

    @Override
    public void removeFloor(int floorId) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query q = session.createQuery("DELETE Building WHERE id = " + floorId);
            q.executeUpdate();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
