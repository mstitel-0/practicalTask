package com.example.practicaltask.Models;

public class BranchModel {
    private String name;
    private Commit commit;

    public String getName() {
        return name;
    }

    public Commit getCommit() {
        return commit;
    }

    public String getSha() {
        return commit == null ? null : commit.getSha();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }
}

class Commit {
    private String sha;

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }
}
