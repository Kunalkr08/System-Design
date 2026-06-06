package linkedin.model;

import java.security.Timestamp;

public class Experience {
    private final String company;
    private final String position;
    private final Timestamp startDate;
    private final Timestamp endDate;

    public Experience (String company, String position, Timestamp startDate, Timestamp endDate) {
        this.company = company;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }
}
