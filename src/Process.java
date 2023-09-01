public class Process {
    private Boolean isCoordinator; 
    private Boolean isActive; 
    private Integer id; 
    private Process currentCoordinator;

    public Process(Integer id) {
        this.isCoordinator = false;
        this.isActive = true;
        this.id = id;
    }

    public Boolean getIsCoordinator() {
        return isCoordinator;
    }

    public void setIsCoordinator(Boolean isCoordinator) {
        this.isCoordinator = isCoordinator;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public Integer getId() {
        return id;
    }

    public Process getCurrentCoordinator() {
        return currentCoordinator;
    }

    public void setCurrentCoordinator(Process currentCoordinator) {
        this.currentCoordinator = currentCoordinator;
    }
}
