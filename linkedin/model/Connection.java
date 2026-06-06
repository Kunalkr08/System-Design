package linkedin.model;

import java.security.Timestamp;

import linkedin.enums.ConnectionStatus;

public class Connection {
    private final String from;
    private final String to;
    private final Timestamp acceptedAt;
    private final Timestamp requestedAt;
    private final ConnectionStatus connectionStatus;

    public Connection(String from, String to, Timestamp acceptedAt, Timestamp requestedAt, ConnectionStatus connectionStatus) {
        this.from = from;
        this.to = to;
        this.acceptedAt = acceptedAt;
        this.requestedAt = requestedAt;
        this.connectionStatus = connectionStatus;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Timestamp getAcceptedAt() {
        return acceptedAt;
    }

    public Timestamp getRequestedAt() {
        return requestedAt;
    }

    public ConnectionStatus getConnectionStatus() {
        return connectionStatus;
    }
}
