package com.example.practicaltask.Controllers;

import com.example.practicaltask.Services.RepositoryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/github")
public class GithubAPIController {

    private final RepositoryService repositoryService;

    public GithubAPIController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping(path = "/repos/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserRepos(@PathVariable String username) {
        return ResponseEntity.ok(repositoryService.getRepositoriesInfo(username));
    }
}
