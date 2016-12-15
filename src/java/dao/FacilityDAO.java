package dao;

import dao.model.FloorData;
import java.util.List;

/**
 *
 * @author lisanoren
 */
public interface FacilityDAO {

    public List<FloorData> findAllFloorData();
}
