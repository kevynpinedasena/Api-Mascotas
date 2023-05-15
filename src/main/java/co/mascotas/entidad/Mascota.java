package co.mascotas.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Mascota {

	@Id
	@Column(name = "documento_mascota", nullable = false)
	private Long docMascota;
	
	@Column(name = "nombre_mascota", nullable = false)
	private String nomMascota;
	
	@Column(name = "edad_mascota", nullable = false)
	private String edad;
	
	@Column(name = "peso_mascota", nullable = false)
	private String peso;
	
	@Column(name = "altura_mascota", nullable = false)
	private String altura;
	
	@Column(name = "img_mascota", nullable = false)
	private String imagenMasc;

	public Mascota() {
		
	}

	public Mascota(Long docMascota, String nomMascota, String edad, String peso, String altura, String imagenMasc) {
		super();
		this.docMascota = docMascota;
		this.nomMascota = nomMascota;
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;
		this.imagenMasc = imagenMasc;
	}

	public Long getDocMascota() {
		return docMascota;
	}

	public void setDocMascota(Long docMascota) {
		this.docMascota = docMascota;
	}

	public String getNomMascota() {
		return nomMascota;
	}

	public void setNomMascota(String nomMascota) {
		this.nomMascota = nomMascota;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getImagenMasc() {
		return imagenMasc;
	}

	public void setImagenMasc(String imagenMasc) {
		this.imagenMasc = imagenMasc;
	}

	
}
