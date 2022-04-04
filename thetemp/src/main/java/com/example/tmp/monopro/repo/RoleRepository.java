package com.example.tmp.monopro.repo;




import com.example.tmp.monopro.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

}


