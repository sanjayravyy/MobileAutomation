package com.placeholder.TestData.config;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Configuration {

    @JsonDeserialize(using = UsersDeserializer.class)
    public Users users;
}
