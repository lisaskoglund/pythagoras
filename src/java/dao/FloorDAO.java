
package dao;

import dao.model.Floor;
import java.util.List;

/**
 *
 * @author lisanoren
 */
public interface FloorDAO {

    public List<Floor> findAllFloors();

    public Floor addFloor(Floor floor);

    public Floor findFloorById(int floorId);

    public void updateFloorArea(int floorId, int newArea);

    public void updateFloorName(int floorId, String newName);

    public void removeFloor(int floorId);
}
