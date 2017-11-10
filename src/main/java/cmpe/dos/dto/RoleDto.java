package cmpe.dos.dto;

public class RoleDto {

    private boolean isAdmin;
    
    private boolean isCustomer;
    
    private boolean isWorker;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isCustomer() {
        return isCustomer;
    }

    public void setCustomer(boolean isCustomer) {
        this.isCustomer = isCustomer;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean isWorker) {
        this.isWorker = isWorker;
    }
    
    

}
