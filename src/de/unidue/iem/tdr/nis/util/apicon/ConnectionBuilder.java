package de.unidue.iem.tdr.nis.util.apicon;

import de.unidue.iem.tdr.nis.client.Connection;

public class ConnectionBuilder {


    private String password;
    private int matrikelnummer;
    private final Connection con;
    private boolean isAuthenticated;

    public static ConnectionBuilder fromStaticCredentials() {
        return new ConnectionBuilder()
                .setMatrikelnummer(Credentials.MATRIKELNUMMER)
                .setPassword(Credentials.PASSWORD)
                .tryAuth();
    }

    public ConnectionBuilder() {
        this.con = new Connection();
    }

    public ConnectionBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public ConnectionBuilder setMatrikelnummer(int matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
        return this;
    }

    public ConnectionBuilder tryAuth() {
        this.isAuthenticated = this.con.auth(this.matrikelnummer, this.password);
        return this;
    }

    public boolean isAuthenticated(){
        return this.isAuthenticated;
    }

    public Connection build() {
        return this.con;
    }

}
