package com.jvrgaray;

import java.util.LinkedList;
import java.util.List;
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
		buscarTodosJpa();
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

	private void encontrarPorIds() {
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(1);
		ids.add(4);
		ids.add(10);
		Iterable<Categoria> categorias = repo.findAllById(ids);
		
		for(Categoria c:categorias) {
			System.out.println(c);

		}
	}
	
	private void buscarTodos() {
		Iterable<Categoria> categorias= repo.findAll();
		for(Categoria c:categorias) {
			System.out.println(c);

		}
	}
	
	private void existeId() {
		boolean existe = repo.existsById(881);
		System.out.println("La categoria existe: "+existe);
	}
	
	private void guardarTodas() {
		List<Categoria> entities = getListaCategorias();
		repo.saveAll(entities);
	}
	
	private List<Categoria> getListaCategorias(){
		List<Categoria> lista = new LinkedList<Categoria>();
		
		//categoria 1
		Categoria cat1 = new Categoria();
		cat1.setNombre("Programador de Blockchain");
		cat1.setDescripcion("Trabajos relacionados con Bitcoin y criptomonedas");
		
		//categoria 2
		Categoria cat2 = new Categoria();
		cat2.setNombre("Soldador/Pintura");
		cat2.setDescripcion("Trabajos relacionados con soldadura, pintura y enderezado");
		
		//categoria 3
		Categoria cat3 = new Categoria();
		cat3.setNombre("Ingeniero industrial");
		cat3.setDescripcion("Trabajos relacionados con ingenieria industrial");
		
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		
		return lista;
	}
	
	private void buscarTodosJpa() {
		List<Categoria> categorias = repo.findAll();
		for (Categoria c:categorias) {
			System.out.println(c.toString());
		}
	}
}
