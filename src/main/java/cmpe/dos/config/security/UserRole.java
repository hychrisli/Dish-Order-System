package cmpe.dos.config.security;

public interface UserRole {
    
    String ROLE_USER = "ROLE_USER";
    String ROLE_ADMIN = "ROLE_ADMIN";
    String ROLE_CUSTOMER = "ROLE_CUSTOMER";
    String ROLE_WORKER = "ROLE_WORKER";
    
    
    String PRIV_USER = "hasRole('"+ROLE_USER+"')";
    String PRIV_ADMIN = "hasRole('"+ROLE_ADMIN+"')";
    String PRIV_CUSTOMER = "hasRole('"+ROLE_CUSTOMER+"')";
    String PRIV_WORKER = "hasRole('"+ROLE_WORKER+"')";
}
