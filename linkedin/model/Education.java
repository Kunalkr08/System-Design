package linkedin.model;

import java.security.Timestamp;

public class Education {
    private final String school;
    private final String degree;
    private final Timestamp startYear;
    private final Timestamp endYear;

    public Education(String school, String degree, Timestamp startYear, Timestamp endYear) {
        this.school = school;
        this.degree = degree;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public String getSchool() {
        return school;
    }

    public String getDegree() {
        return degree;
    }

    public Timestamp getStartYear() {
        return startYear;
    }

    public Timestamp getEndYear() {
        return endYear;
    }
}
