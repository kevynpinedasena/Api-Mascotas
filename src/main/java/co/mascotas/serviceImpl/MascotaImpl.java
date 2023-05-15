package co.mascotas.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.mascotas.entidad.Mascota;
import co.mascotas.exepciones.MascotaExepciones;
import co.mascotas.exepciones.ResourceNotFoundExepciones;
import co.mascotas.repository.IMascotaRepository;
import co.mascotas.service.IMascotaService;

@Service
@Transactional
public class MascotaImpl implements IMascotaService{
	
	@Autowired(required = true)
	private IMascotaRepository mascotaRepository;

	@Override
	public void guardarMascota(Mascota mascota) {
		boolean mascotas = mascotaRepository.findById(mascota.getDocMascota()).isPresent();

		if (mascotas == true) {
			throw new MascotaExepciones(HttpStatus.BAD_REQUEST, "La Mascota ya existe con este documento");
		}
		else {
			mascotaRepository.save(mascota);
		}
	}

	@Override
	public List<Mascota> ListaMascotas() {
		List<Mascota> mascotas = mascotaRepository.findAll();
		return mascotas;
	}

	@Override
	public Mascota actualizarMascota(Mascota mascota, Long documento) {
		Mascota mascotas = mascotaRepository.findById(documento).orElseThrow(() -> new ResourceNotFoundExepciones("Mascota", "Documento", documento));
		
		mascotas.setNomMascota(mascota.getNomMascota());
		mascotas.setEdad(mascota.getEdad());
		mascotas.setAltura(mascota.getAltura());
		mascotas.setPeso(mascota.getPeso());
		mascotas.setImagenMasc(mascota.getImagenMasc());
		
		if (mascota.getNomMascota() == "" || mascota.getEdad() == "" || mascota.getAltura() == "" || mascota.getPeso() == "" ){
			throw new MascotaExepciones(HttpStatus.NOT_FOUND, "Llene todos los campós");
		}
		else {
			
			Mascota mascotaActu = mascotaRepository.save(mascotas);
			return mascotaActu;			
		}
	}

	@Override
	public void eliminar(Long documento) {
		Mascota mascotas = mascotaRepository.findById(documento).orElseThrow(() -> new ResourceNotFoundExepciones("Mascota", "Documento", documento));
		mascotaRepository.delete(mascotas);
	}

	@Override
	public Mascota buscarMascotaDocumento(Long documento) {
		Mascota mascota = mascotaRepository.findById(documento).orElseThrow(() -> new ResourceNotFoundExepciones("Mascota", "documento", documento));
		return mascota;
	}

}
