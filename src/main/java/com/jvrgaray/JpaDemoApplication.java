package com.jvrgaray;

import java.util.Optional;

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
		eliminarTodos();
	}
	
	private void guardar() {
		Categoria c = new Categoria();
		c.setNombre("Ingenieria de software");
		c.setDescripcion("Desarrollo de sistemas");
		
		repo.save(c);
		System.out.println(c);
	}
	
	private void eliminar() {
		int idCategoria = 1;
		repo.deleteById(idCategoria);
	}
	
	private void buscarPorId() {
		Optional<Categoria> optional = repo.findById(1);
		if(optional.isPresent()) {
			System.out.println(optional.get());
		}
	}
	
	private void modificar() {
		Optional<Categoria> optional = repo.findById(1);
		if(optional.isPresent()) {
			Categoria c = optional.get();
			c.setNombre("Ingenieria de software");
			c.setDescripcion("Desarrollo de sistemas");
			repo.save(c);
			System.out.println(optional.get());
		}
	}
	
	private void conteo() {
		long count = repo.count();
		System.out.println("total categorias = "+count);
	}
	
	private void eliminarTodos() {
		repo.deleteAll();
	}

}
