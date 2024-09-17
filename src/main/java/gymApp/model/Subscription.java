package gymApp.model;

import java.util.Date;

public class Subscription {
    private int id;
    private int userId;
    private String planName;
    private Date startDate;
    private Date endDate;
    private String status;

    public Subscription(int i, int userId2, String planName2, Date startDate2, Date endDate2, String string) {
        this.id = i;
        this.userId = userId2;
        this.planName = planName2;
        this.startDate = startDate2;
        this.endDate = endDate2;
        this.status = string;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
