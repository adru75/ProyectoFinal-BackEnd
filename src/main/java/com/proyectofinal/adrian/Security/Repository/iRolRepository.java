
package com.proyectofinal.adrian.Security.Repository;

import com.proyectofinal.adrian.Security.Entity.Rol;
import com.proyectofinal.adrian.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
