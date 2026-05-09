package org.example.supermercadoapi.Service.impl;

import org.example.supermercadoapi.DTO.BranchDTO;
import org.example.supermercadoapi.Entity.Branch;
import org.example.supermercadoapi.Exception.NotFoundException;
import org.example.supermercadoapi.Mappers.Mappers;
import org.example.supermercadoapi.Repository.BranchRepository;
import org.example.supermercadoapi.Service.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BranchService implements IBranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public List<BranchDTO> showBranches() {
        return branchRepository.findAll().stream()
                .map(Mappers::toDto).toList();
    }

    @Override
    public BranchDTO createBranch(BranchDTO branchDTO) {

        var branch = Branch.builder()
                .name(branchDTO.getName())
                .address(branchDTO.getAddress())
                .build();

        return Mappers.toDto(branchRepository.save(branch));
    }

    @Override
    public BranchDTO updateBranch(Long id, BranchDTO branchDTO) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Branch not found"));

        branch.setName(branch.getName());
        branch.setAddress(branch.getAddress());
        branch.setTelephoneNumber(branch.getTelephoneNumber());

        return Mappers.toDto(branchRepository.save(branch));
    }

    @Override
    public void deleteBranch(Long id) {

        if(!branchRepository.existsById(id)){
            System.out.println("branch to delete not found");
            throw new NotFoundException("branch to delete not found");
        }
        branchRepository.deleteById(id);


    }
}
