package com.example.practicaltask.DTOs;

import java.util.List;

public class RepositoryDTO {
    private String name;
    private String ownerLogin;
    private List<BranchDTO> branches;
    private boolean fork;

    public String getName() {
        return name;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public List<BranchDTO> getBranches() {
        return branches;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }

    public void setBranches(List<BranchDTO> branches) {
        this.branches = branches;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }
}
