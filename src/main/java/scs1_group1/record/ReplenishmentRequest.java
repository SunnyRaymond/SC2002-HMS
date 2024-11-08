package scs1_group1.record;

public class ReplenishmentRequest extends Record {
    private String medicineName;
    private int quantity;
    private String status = "Pending";

    public ReplenishmentRequest(String medicineName, int quantity) {
        super();
        this.medicineName = medicineName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return medicineName + " (" + quantity + ")";
    }

    public String getMedicineName() {
        return medicineName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }    
    
}
