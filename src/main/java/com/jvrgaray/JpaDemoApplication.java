package com.jvrgaray;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.jvrgaray.model.Categoria;
import com.jvrgaray.model.Vacante;
import com.jvrgaray.repository.CategoriasRepository;
import com.jvrgaray.repository.VacantesRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{
	@Autowired
	private CategoriasRepository repoCategorias;
	
	@Autowired
	private VacantesRepository repoVacantes;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		buscarVacantes();
	}
	
	private void guardar() {
		Categoria c = new Categoria();
		c.setNombre("Ingenieria de software");
		c.setDescripcion("Desarrollo de sistemas");
		
		repoCategorias.save(c);
		System.out.println(c);
	}
	
	private void eliminar() {
		int idCategoria = 1;
		repoCategorias.deleteById(idCategoria);
	}
	
	private void buscarPorId() {
		Optional<Categoria> optional = repoCategorias.findById(1);
		if(optional.isPresent()) {
			System.out.println(optional.get());
		}
	}
	
	private void modificar() {
		Optional<Categoria> optional = repoCategorias.findById(1);
		if(optional.isPresent()) {
			Categoria c = optional.get();
			c.setNombre("Ingenieria de software");
			c.setDescripcion("Desarrollo de sistemas");
			repoCategorias.save(c);
			System.out.println(optional.get());
		}
	}
	
	private void conteo() {
		long count = repoCategorias.count();
		System.out.println("total categorias = "+count);
	}
	
	private void eliminarTodos() {
		repoCategorias.deleteAll();
	}

	private void encontrarPorIds() {
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(1);
		ids.add(4);
		ids.add(10);
		Iterable<Categoria> categorias = repoCategorias.findAllById(ids);
		
		for(Categoria c:categorias) {
			System.out.println(c);

		}
	}
	
	private void buscarTodos() {
		Iterable<Categoria> categorias= repoCategorias.findAll();
		for(Categoria c:categorias) {
			System.out.println(c);

		}
	}
	
	private void existeId() {
		boolean existe = repoCategorias.existsById(881);
		System.out.println("La categoria existe: "+existe);
	}
	
	private void guardarTodas() {
		List<Categoria> entities = getListaCategorias();
		repoCategorias.saveAll(entities);
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
		List<Categoria> categorias = repoCategorias.findAll();
		for (Categoria c:categorias) {
			System.out.println(c.toString());
		}
	}
	
	private void borrarTodosEnBloque() {
		repoCategorias.deleteAllInBatch();
	}
	
	private void buscarTodosOrdenados() {
		List<Categoria> categorias = repoCategorias.findAll(Sort.by("nombre").descending());
		for (Categoria c:categorias) {
			System.out.println(c.toString());
		}
	}
	
	private void buscarTodosPaginacion() {
		Page<Categoria> categorias = repoCategorias.findAll(PageRequest.of(0, 5));
		for (Categoria c: categorias.getContent()) {
			System.out.println(c.toString());
		}
	}
	
	private void buscarTodosPaginacionOrdenados() {
		Page<Categoria> categorias = repoCategorias.findAll(PageRequest.of(0, 5, Sort.by("nombre")));
		for (Categoria c: categorias.getContent()) {
			System.out.println(c.toString());
		}
	}
	
	private void buscarVacantes() {
		List<Vacante> lista = repoVacantes.findAll();
		for(Vacante v:lista) {
			System.out.println(v.getId()+" "+v.getNombre()+" "+v.getCategoria().getNombre());
		}
	}
}
