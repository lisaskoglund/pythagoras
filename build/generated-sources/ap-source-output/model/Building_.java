package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Floor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-15T00:12:02")
@StaticMetamodel(Building.class)
public class Building_ { 

    public static volatile SingularAttribute<Building, String> buildingName;
    public static volatile ListAttribute<Building, Floor> floorList;
    public static volatile SingularAttribute<Building, Long> id;

}