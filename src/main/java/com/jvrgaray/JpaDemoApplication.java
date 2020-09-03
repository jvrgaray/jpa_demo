package com.jvrgaray;

import java.util.Date;
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
import com.jvrgaray.model.Perfil;
import com.jvrgaray.model.Usuario;
import com.jvrgaray.model.Vacante;
import com.jvrgaray.repository.CategoriasRepository;
import com.jvrgaray.repository.PerfilesRepository;
import com.jvrgaray.repository.UsuariosRepository;
import com.jvrgaray.repository.VacantesRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{
	@Autowired
	private CategoriasRepository repoCategorias;
	
	@Autowired
	private VacantesRepository repoVacantes;
	
	@Autowired
	private PerfilesRepository repoPerfiles;
	
    @Autowired
    private UsuariosRepository repoUsuarios;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		crearUsuarioConUnPerfil();
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
	
	private void guardarVacante() {
		Vacante vacante = new Vacante();
		vacante.setNombre("Profesor de matematicas");
		vacante.setDescripcion("Escuela primaria solicita profesor para curso de matematicas");
		vacante.setFecha(new Date());
		vacante.setSalario(8500.0);
		vacante.setEstatus("Aprobada");
		vacante.setDestacado(0);
		vacante.setImagen("escuela.jpg");
		vacante.setDetalles("<h1>Los requisitos para profesor de matematicas</h1>");
		
		Categoria c = new Categoria();
		c.setId(15);
		vacante.setCategoria(c);
		repoVacantes.save(vacante);
	}
	
	private void crearPerfilesAplicacion() {
		repoPerfiles.saveAll(getPerfilesAplicacion());
	}
	
	private List<Perfil> getPerfilesAplicacion(){
		List<Perfil> lista = new LinkedList<Perfil>();
		Perfil p1 = new Perfil();
		p1.setPerfil("Supervisor");
		
		Perfil p2 = new Perfil();
		p2.setPerfil("Adminitrador");
		
		Perfil p3 = new Perfil();
		p3.setPerfil("Usuario");
		
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		return lista;
	}
	
	private void crearUsuarioConUnPerfil() {
		Usuario user = new Usuario();
		user.setNombre("Javier Garay");
		user.setEmail("jgaray@gmail.com");
		user.setFechaRegistro(new Date());
		user.setUsername("jgaray");
		user.setPassword("1234");
		user.setEstatus(1);
		
		Perfil p1 = new Perfil();
		p1.setId(2);
		
		Perfil p2 = new Perfil();
		p2.setId(3);
		
		user.agregar(p1);
		user.agregar(p2);
		
		repoUsuarios.save(user);
	}
}
