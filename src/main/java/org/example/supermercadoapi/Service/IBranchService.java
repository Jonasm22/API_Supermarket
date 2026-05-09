package org.example.supermercadoapi.Service;

import org.example.supermercadoapi.DTO.BranchDTO;
import org.example.supermercadoapi.Entity.Branch;

import java.util.List;

public interface IBranchService {


    //Thinks the methodos
    //ONLY DTOS
    //CRUD
    List<BranchDTO> showBranches();
    BranchDTO createBranch (BranchDTO branchDTO);
    BranchDTO updateBranch (Long id, BranchDTO branchDTO);
    void deleteBranch(Long id);


}
