package cmpe.dos.config.security;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cmpe.dos.dto.UserDto;
import cmpe.dos.exception.AppExceptionHandler;
import cmpe.dos.service.UserService;

@Configuration
public class AuthConfig extends GlobalAuthenticationConfigurerAdapter {

    private final static Logger LOGGER = getLogger(AuthConfig.class);

    @Autowired
    UserService userService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService());
    }

    @Bean
    UserDetailsService userDetailsService() {
	return new UserDetailsService() {

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto userDto = userService.retrieveUserDto(username);
		if (userDto != null) {
		    LOGGER.info("Found User: " + userDto.getUsername() + " & Password: " + userDto.getPassword());
		    return new User(userDto.getUsername(), userDto.getPassword(), true, true, true, true,
			    AuthorityUtils.createAuthorityList("ROLE_USER"));
		} else {
		    LOGGER.info("Can't Find: " + username);
		    throw new UsernameNotFoundException("could not find the user '" + username + "'");
		}
	    }

	};
    }
}
