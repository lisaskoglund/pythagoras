package dao.impl;

import dao.BuildingDAO;
import java.util.List;
import dao.model.Building;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 * Class fetches all Building data from DB
 *
 * @author lisanoren
 */
public class BuildingDAOImpl implements BuildingDAO {

    @Override
    public List<Building> findAllBuildings() {
        List<Building> buildingList = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("FROM Building");
            buildingList = q.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return buildingList;
    }

    @Override
    public Building findBuildingById(int buildingId) {
        Building building = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query q = session.createQuery("FROM Building B WHERE B.id = " + buildingId);
            building = (Building) q.uniqueResult();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return building;
    }

    @Override
    public Building addBuilding(Building building) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(building);
        transaction.commit();
        session.close();

        return building;
    }

    @Override
    public void removeBuilding(int buildingId) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query q = session.createQuery("DELETE Building WHERE id = " + buildingId);
            q.executeUpdate();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
