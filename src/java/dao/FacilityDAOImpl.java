/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import dao.model.Building;
import dao.model.FloorData;
import dao.model.FloorDataLister;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * Class fetches floordata List from DB
 * 
 * @author lisanoren
 */
public class FacilityDAOImpl {

    public FacilityDAOImpl() {
        
    }
    
    public List<FloorData> findAllFloorData() {
        List<FloorData> floorList = new ArrayList<>();
        List<Building> buildingList;
                try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("FROM Building");
            buildingList = q.list();
            FloorDataLister fdl = new FloorDataLister();
            floorList = fdl.makeList(buildingList);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return floorList;
    }
}
