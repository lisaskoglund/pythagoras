package util;

import java.util.ArrayList;
import java.util.List;
import dao.model.Building;
import dao.model.Floor;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * Initializes DB and sets data
 *
 * @author lisanoren
 */
public class InitializeDB {

    public static void setData() {
        Session session;

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Building buildingA = new Building();
        Building buildingB = new Building();
        buildingA.setBuildingName("ByggnadA");
        buildingB.setBuildingName("ByggnadB");

        Floor floorA1 = new Floor();
        Floor floorA2 = new Floor();
        Floor floorB1 = new Floor();
        Floor floorB2 = new Floor();
        Floor floorB3 = new Floor();

        floorA1.setFloorName("PlanA1");
        floorA2.setFloorName("PlanA2");
        floorB1.setFloorName("PlanB1");
        floorB2.setFloorName("PlanB2");
        floorB3.setFloorName("PlanB3");

        floorA1.setArea(2500);
        floorA2.setArea(4000);
        floorB1.setArea(1500);
        floorB2.setArea(500);
        floorB3.setArea(400);

        List<Floor> floorListBA = new ArrayList<>();
        floorListBA.add(floorA1);
        floorListBA.add(floorA2);
        buildingA.setFloorList(floorListBA);

        List<Floor> floorListBB = new ArrayList<>();
        floorListBB.add(floorB1);
        floorListBB.add(floorB2);
        floorListBB.add(floorB3);
        buildingB.setFloorList(floorListBB);

        session.save(buildingA);
        session.save(buildingB);

        session.save(floorA1);

        session.getTransaction().commit();
        session.close();
    }
}
