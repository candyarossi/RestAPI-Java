package com.demo.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Configuracion implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // Permitir CORS en todas las rutas
				.allowedOrigins("http://127.0.0.1:5500") // Permitir solicitudes solo desde este origen
				.allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
				.allowedHeaders("*"); // Permitir cualquier encabezado
	}
}