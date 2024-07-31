package com.example.practicaltask.Models;

import java.util.List;

public class RepositoryModel {
    private String name;
    private Owner owner;
    private List<BranchModel> branches;
    private boolean fork;

    public String getName() {
        return name;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getLogin() {
        return owner == null ? null : owner.getLogin();
    }

    public List<BranchModel> getBranches() {
        return branches;
    }

    public boolean isFork() {
        return fork;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setBranches(List<BranchModel> branches) {
        this.branches = branches;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }
}

class Owner {
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
