package com.jvrgaray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jvrgaray.model.Categoria;
import com.jvrgaray.repository.CategoriasRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{
	@Autowired
	private CategoriasRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		guardar();
	}
	
	private void guardar() {
		Categoria c = new Categoria();
		c.setNombre("Finanzas");
		c.setDescripcion("Trabajo relacionado con finanzas y contabilidad");
		
		repo.save(c);
		System.out.println(c);
	}
	
	private void eliminar() {
		System.out.println("Eliminado un registro");
	}

}
