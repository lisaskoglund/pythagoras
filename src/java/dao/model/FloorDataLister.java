package dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that transforms a buildingList to floorDataList
 *
 * @author lisanoren
 */
public class FloorDataLister implements Serializable {

    private static final long serialVersionUID = 1L;
    private String buildingName;
    private String floorName;
    private int area;

    public List<FloorData> makeList(List<Building> buildingList) {
        List<FloorData> floorDataList = new ArrayList<>();

        for (int i = 0; i < buildingList.size(); i++) {
            buildingName = buildingList.get(i).getBuildingName();
            List<Floor> currentFloorList = buildingList.get(i).getFloorList();
            for (int j = 0; j < currentFloorList.size(); j++) {
                floorName = currentFloorList.get(j).getFloorName();
                area = currentFloorList.get(j).getArea();

                floorDataList.add(new FloorData(buildingName, floorName, area));
            }
        }
        return floorDataList;
    }
}
