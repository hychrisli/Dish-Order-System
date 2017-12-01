package cmpe.dos.controller;

import static cmpe.dos.constant.UrlConstant.USER;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import static cmpe.dos.config.security.UserRole.PRIV_ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cmpe.dos.dto.UserDto;
import cmpe.dos.entity.User;
import cmpe.dos.response.JsonResponse;
import cmpe.dos.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@Api(tags = {"User"})
@SwaggerDefinition(tags = { @Tag(name="User Controller", description="User Controller Endpoints")})
@Transactional(rollbackFor = Exception.class)
public class UserController extends AbstractController{
    
    @Autowired
    UserService userService;
    
    @ApiOperation(value = "Get User", response = JsonResponse.class)
    @GetMapping( USER + "/{username}")
    @PreAuthorize(PRIV_ADMIN)
    public ResponseEntity<JsonResponse> getUser(@PathVariable String username) {
	UserDto userDto = userService.retrieveUserDto(username);
	if (userDto != null)
	    return success("user", userDto);
	return notFound();
    }
    
    @ApiOperation(value = "Get My Username")
    @GetMapping(USER + "/self")
    public ResponseEntity<JsonResponse> getMyUserName(Principal principal){
	return success("self", principal.getName());
    }
    
    @ApiOperation(value = "Add A User")
    @PostMapping(USER)
    public ResponseEntity<JsonResponse> addUser(@RequestBody UserDto userDto){
	if (userService.createUser(userDto))
		return created("created", userDto.getUsername());
	
	return conflict();
    }   
    
    @ApiOperation(value = "Delete A User")
    @PreAuthorize(PRIV_ADMIN)
    public ResponseEntity<JsonResponse> deleteUser(@PathVariable String username){
	if (userService.deleteUser(username))
	    return success("deleted", username);
	
	return notFound();
    }
    
    @ApiOperation(value = "Get All Users", response = JsonResponse.class)
    @GetMapping( USER + "/all")
    @PreAuthorize(PRIV_ADMIN)
    public ResponseEntity<JsonResponse> getUser() {
	List<User> users = userService.getAllUsers();
	if (users != null && !users.isEmpty())
	    return success("users", users);
	return notFound();
    }
    
}
