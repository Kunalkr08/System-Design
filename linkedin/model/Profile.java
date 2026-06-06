package linkedin.model;

public class Profile {
    private final String summary;
    private final Education education;
    private final Experience experience;
    
    public Profile(String summary, Education education, Experience experience) {
        this.summary = summary;
        this.education = education;
        this.experience = experience;
    }

    public String getSummary() {
        return summary;
    }

    public Education getEducation() {
        return education;
    }

    public Experience getExperience() {
        return experience;
    }
}
