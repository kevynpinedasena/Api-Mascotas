package co.mascotas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.mascotas.entidad.Mascota;
import co.mascotas.service.IMascotaService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apis")
public class MascotaRest {

	@Autowired(required = true)
	IMascotaService mascotaService;
	
	@GetMapping("/mascota")
	public List<Mascota> listaMascotas(){
		return mascotaService.ListaMascotas();
	}
	
	@GetMapping("/mascota/{documento}")
	public ResponseEntity<Mascota> buscarPorDocumento(@PathVariable Long documento) {
		return ResponseEntity.ok(mascotaService.buscarMascotaDocumento(documento));
	}
	
	@PostMapping("/mascota")
	public ResponseEntity<String> guardarMascotas(@RequestBody Mascota mascota){
		mascotaService.guardarMascota(mascota);
		return new ResponseEntity<>("Mascota Registrada con exito",HttpStatus.CREATED);
	}
	
	@PutMapping("/mascota/{documento}")
	public ResponseEntity<String> actualizarMascotas(@PathVariable Long documento, @RequestBody Mascota mascotas){
		mascotaService.actualizarMascota(mascotas, documento);
		return new ResponseEntity<>("Mascota actualizado con exito", HttpStatus.CREATED);
	}
	
	@DeleteMapping("/mascota/{documento}")
	public ResponseEntity<String> eliminarMascota(@PathVariable Long documento){
		mascotaService.eliminar(documento);
		return new ResponseEntity<>("Mascota Eliminada Con Exito",HttpStatus.OK);
	}
}
