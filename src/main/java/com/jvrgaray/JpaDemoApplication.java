package com.jvrgaray;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		guardar();
	}
	
	private void guardar() {
		System.out.println("Insertando un registro");
	}
	
	private void eliminar() {
		System.out.println("Eliminado un registro");
	}

}
