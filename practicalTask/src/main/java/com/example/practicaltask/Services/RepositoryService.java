package com.example.practicaltask.Services;

import com.example.practicaltask.DTOs.RepositoryDTO;
import com.example.practicaltask.Mappers.RepositoryMapper;
import com.example.practicaltask.Models.BranchModel;
import com.example.practicaltask.Models.RepositoryModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepositoryService {
    private final RepositoryMapper repositoryMapper;

    private final RestClient restClient;

    private final String repos = "https://api.github.com/users/{user}/repos";

    private final String braches = "https://api.github.com/repos/{username}/{repo}/branches";


    public RepositoryService(RepositoryMapper repositoryMapper, RestClient restClient) {
        this.repositoryMapper = repositoryMapper;
        this.restClient = restClient;
    }

    public List<RepositoryDTO> getRepositoriesInfo(String username) {
        List<RepositoryModel> repositories = restClient.get()
                .uri(repos, username)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });

        if (repositories == null) {
            return null;
        }
        repositories = repositories.stream().filter(repo -> !repo.isFork()).toList();

        for (RepositoryModel repo : repositories) {
            List<BranchModel> branches = restClient.get()
                    .uri(braches, username, repo.getName())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            repo.setBranches(branches);
        }
        return repositories.stream().map(repositoryMapper::map).collect(Collectors.toList());
    }
}
