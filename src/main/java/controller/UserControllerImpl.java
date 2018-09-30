package controller;

import dto.UserDto;
import service.UserService;
import service.UserServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/user")
public class UserControllerImpl {
//    @Inject
//    public UserService userService;
//
//    //@GET
//    //@Path("list")
//    public String getAllUserList() {
//        return "Start";
//    }

    @GET
    @Path("test")
    public String getTest() {
        return "42";
    }
}
