package de.unidue.iem.tdr.nis.util.apicon;

import de.unidue.iem.tdr.nis.client.Connection;

public class ServerConnector {

    private Connection connection;

    public void connectToServer() throws Exception {
        ConnectionBuilder connectionBuilder = ConnectionBuilder.fromStaticCredentials();
        if (connectionBuilder.isAuthenticated()) this.connection = connectionBuilder.build();
        else throw new Exception("couldn't connect to server or authenticate");
    }

    public Connection getConnection() {
    return this.connection;
    }
}
