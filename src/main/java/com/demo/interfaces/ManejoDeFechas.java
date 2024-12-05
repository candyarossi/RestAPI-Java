package com.demo.interfaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface ManejoDeFechas {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	default LocalDate formatearFecha(String fecha) {
		LocalDate date = LocalDate.parse(fecha, formatter);
		return date;
	}
}
