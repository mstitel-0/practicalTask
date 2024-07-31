package com.example.practicaltask.Mappers;

import com.example.practicaltask.DTOs.RepositoryDTO;
import com.example.practicaltask.Models.RepositoryModel;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RepositoryMapper {

    private final BranchMapper branchMapper;

    public RepositoryMapper(BranchMapper branchMapper) {
        this.branchMapper = branchMapper;
    }

    public RepositoryDTO map(RepositoryModel repositoryModel) {
        RepositoryDTO repositoryDTO = new RepositoryDTO();
        repositoryDTO.setName(repositoryModel.getName());
        repositoryDTO.setOwnerLogin(repositoryModel.getLogin());
        repositoryDTO.setFork(repositoryModel.isFork());
        repositoryDTO.setBranches(repositoryModel.getBranches().stream().map(branchMapper::map).collect(Collectors.toList()));
        return repositoryDTO;
    }
}
