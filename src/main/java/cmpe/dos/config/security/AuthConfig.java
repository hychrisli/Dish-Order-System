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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import cmpe.dos.dto.UserDto;
import cmpe.dos.service.RoleService;
import cmpe.dos.service.UserService;

/*BCrypt Generator: https://www.browserling.com/tools/bcrypt*/

@Configuration
public class AuthConfig extends GlobalAuthenticationConfigurerAdapter {

    private final static Logger LOGGER = getLogger(AuthConfig.class);

    @Autowired
    UserService userService;
    
    @Autowired
    RoleService roleService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Bean
    UserDetailsService userDetailsService() {
	return new UserDetailsService() {

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto userDto = userService.retrieveUserDto(username);

		if (userDto == null) {
		    LOGGER.info("Can't Find: " + username);
		    throw new UsernameNotFoundException("could not find the user '" + username + "'");
		}

		return new User(userDto.getUsername(), 
			userDto.getPassword(), 
			true, true, true, true,
			AuthorityUtils.createAuthorityList(roleService.getRoles(username)));
	    }

	};
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
    }
}
