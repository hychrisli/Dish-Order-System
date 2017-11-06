package cmpe.dos.controller;

import static cmpe.dos.constant.UrlConstant.USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cmpe.dos.dto.UserDto;
import cmpe.dos.response.JsonResponse;
import cmpe.dos.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@CrossOrigin
@RestController
@Api(tags = {"User Controller"})
@SwaggerDefinition(tags = { @Tag(name="User Controller", description="User Controller Endpoints")})
public class UserController extends AbstractController{
    
    @Autowired
    UserService userService;
    
    @GetMapping(USER + "/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<JsonResponse> getUser(@PathVariable String username) {
	UserDto userDto = userService.retrieveUserDto(username);
	if (userDto != null)
	    return success("user", userDto);
	return notFound();
    }
    
}
