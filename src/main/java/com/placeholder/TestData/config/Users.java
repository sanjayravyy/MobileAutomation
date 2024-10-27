package com.placeholder.TestData.config;

import java.util.HashMap;

public class Users {

    protected final HashMap<String, Account> users = new HashMap<String, Account>();

    /**
     * @param key the name of the account
     * @return the account
     */

    public Account getUser(String key) {
        return users.get(key);
    }


    /**
     * @param key   the name of the account
     * @param users
     */
    public void setUser(String key, Account users) {
        this.users.put(key, users);
    }
}
