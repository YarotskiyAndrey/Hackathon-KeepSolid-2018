package controller;

import dto.UserDto;
import service.UserService;
import service.UserServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/user")
public class UserControllerImpl implements UserController {
    @Inject
    public UserService userService;

    @GET
    @Path("list")
    public List<UserDto> getAllUserList() {
        return userService.getAllUserList();
    }
}
