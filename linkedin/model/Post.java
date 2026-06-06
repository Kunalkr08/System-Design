package linkedin.model;

public class Post {
    private final String id;
    private final String details;
    private final Member postedBy;

    public Post(String id, String details, Member postedBy) {
        this.id = id;
        this.details = details;
        this.postedBy = postedBy;
    }

    
}
