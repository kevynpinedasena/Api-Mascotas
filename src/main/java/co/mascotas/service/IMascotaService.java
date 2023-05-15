package co.mascotas.service;

import java.util.List;

import co.mascotas.entidad.Mascota;

public interface IMascotaService {

	void guardarMascota(Mascota mascota);
	
	List<Mascota> ListaMascotas();
	
	Mascota buscarMascotaDocumento(Long documento);
	
	Mascota actualizarMascota(Mascota mascota, Long documento);
	
	void eliminar(Long documento);
}
