package com.hutech.bai_1.Services;

import com.hutech.bai_1.Entities.Role;
import com.hutech.bai_1.Repositories.RoleRepository;
import com.hutech.bai_1.RequestEntities.RoleCreate;
import com.hutech.bai_1.RequestEntities.RoleUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }

    public Role getRoleById(String id){
        return roleRepository.findById(id).orElseThrow(
                () -> {
                    throw  new RuntimeException("Khong tim thay ID");
                }
        );
    }

    public Role createRole(RoleCreate roleCreate){
        try{
            Role role = new Role();
            role.setName_Role(roleCreate.getRoleName());
            roleRepository.save(role);
            return role;
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    public Role UpdateRole(RoleUpdate roleUpdate){
        try{
            Role role = new Role();
            role.setName_Role(roleUpdate.getRoleName());
            roleRepository.save(role);
            return role;
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    public void Deleteuser(String id){
        roleRepository.deleteById(id);
    }
}
