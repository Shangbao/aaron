package com.aaron.system.permission.model;

/**
 * Created by pzw on 2/9/2016.
 */
public class Permission {

    private String id;
    private String permToken;
    private String permDescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermToken() {
        return permToken;
    }

    public void setPermToken(String permToken) {
        this.permToken = permToken;
    }

    public String getPermDescription() {
        return permDescription;
    }

    public void setPermDescription(String permDescription) {
        this.permDescription = permDescription;
    }
}
