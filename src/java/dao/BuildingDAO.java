package dao;

import dao.model.Building;
import java.util.List;

/**
 *
 * @author lisanoren
 */
public interface BuildingDAO {

    public List<Building> findAllBuildings();

    public Building findBuildingById(int buildingId);

    public Building addBuilding(Building building);

    public void removeBuilding(int buildingId);
}
