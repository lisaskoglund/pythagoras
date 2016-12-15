package dao.model;

import java.io.Serializable;

/**
 * Class that creates an instance of FloorData to be used from FloorDataLister
 *
 * @author lisanoren
 */
public class FloorData implements Serializable {

    private static final long serialVersionUID = 1L;
    private String floorName, buildingName;
    private int area;

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public FloorData(String buildingName, String floorName, int area) {
        this.buildingName = buildingName;
        this.floorName = floorName;
        this.area = area;
    }
}
