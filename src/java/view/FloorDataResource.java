package view;

import dao.FacilityDAOImpl;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import dao.model.FloorData;

/**
 * Creates a JSON-object from HTTP GET request
 * 
 * @author lisanoren
 */
@Path("/facilities")
public class FloorDataResource {

    FacilityDAOImpl dao = new FacilityDAOImpl();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
        public Response findAllFloorData() {
        List<FloorData> floorDataList = dao.findAllFloorData();
        GenericEntity<List<FloorData>> entity  = new GenericEntity<List<FloorData>>(floorDataList){};
        return Response.ok(entity).build();
    }
}
