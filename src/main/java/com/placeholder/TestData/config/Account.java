package com.placeholder.TestData.config;

import com.placeholder.managers.ScenarioManager;

import java.util.ArrayList;
import java.util.List;


public class Account {

    protected String name;

    protected String email;

    protected Integer id;

    protected List<String> numbers = new ArrayList<>();

    protected List<String> names = new ArrayList<>();

    /**
     * @return
     */
    public String getName() {
        ScenarioManager.getScenario().log("Name selected -> " + name);
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getEmail() {
        ScenarioManager.getScenario().log("Email selected ->" + email);
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return
     */
    public Integer getId() {
        ScenarioManager.getScenario().log("Id selected -> " + id);
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return
     */
    public List<String> getNumbers() {
        ScenarioManager.getScenario().log("Numbers selected -> " + numbers);
        return numbers;
    }

    /**
     * @param numbers
     */
    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    /**
     * @return
     */
    public List<String> getNames() {
        ScenarioManager.getScenario().log("Names selected -> " + names);
        return names;
    }

    /**
     * @param names
     */
    public void setNames(List<String> names) {
        this.names = names;
    }
}
