package cmpe.dos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import cmpe.dos.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@CrossOrigin
@RestController
@Api(tags = {"User Controller"})
@SwaggerDefinition(tags = { @Tag(name="User Controller", description="User Controller Endpoints")})
public class UserController {
    
    @Autowired
    UserService userService;
    
    
    
}
