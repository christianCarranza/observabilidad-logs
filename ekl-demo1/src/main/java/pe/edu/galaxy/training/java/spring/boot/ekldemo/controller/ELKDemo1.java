package pe.edu.galaxy.training.java.spring.boot.ekldemo.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/demos")
public class ELKDemo1 {

	//Logger log= Logger.getLogger(ELKDemo1.class.getName());
	
	@GetMapping
	public String demo() {
		String message = "ELK Demo 1 " + LocalDate.now();
		log.info(message);
		return message;
	}
	
	@GetMapping("/demo1")
	public String demo1() {
		String message = "Spring Boot Demo 1 " + LocalDate.now();
		log.info(message);
		return message;
	}
	
	@GetMapping(value = "/excep")
	public String exception() {
		String response = "";
		try {
			throw new Exception("Exception 1 ...");
		} catch (Exception e) {

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			
			String stackTrace = sw.toString();
			log.error("Exception - " + stackTrace);
			response = stackTrace;
		}

		return response;
	}
}
