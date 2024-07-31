package com.example.practicaltask.Mappers;

import com.example.practicaltask.DTOs.BranchDTO;
import com.example.practicaltask.Models.BranchModel;
import org.springframework.stereotype.Service;

@Service
public class BranchMapper {
    public BranchDTO map(BranchModel branchModel) {
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setName(branchModel.getName());
        branchDTO.setSha(branchModel.getSha());
        return branchDTO;
    }
}
