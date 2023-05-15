package co.mascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.mascotas.entidad.Mascota;

@Repository
public interface IMascotaRepository extends JpaRepository<Mascota, Long>{

}
