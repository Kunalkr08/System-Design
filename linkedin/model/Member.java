package linkedin.model;

import java.util.Set;

public class Member {
    private final String id;
    private final String name;
    private final Set<Member> connections; 
    private final Profile profile;
    private final String email;

    public Member (String id, String name, Set<Member> connections, Profile profile, String email) {
        this.id = id;
        this.name = name;
        this.connections = connections;
        this.profile = profile;
        this.email = email;
    }

    public String getId () {
        return id;
    } 

    public String getName () {
        return name;
    }

    public Set<Member> getConnections () {
        return connections;
    }

    public Profile getProfile() {
        
        return profile;
    }

    public String getEmail() {
        return email;
    }

    public void addConnection(Member member) {
        connections.add(member);
    }
 }
