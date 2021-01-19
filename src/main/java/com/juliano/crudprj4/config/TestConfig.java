package com.juliano.crudprj4.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.juliano.crudprj4.entities.Client;
import com.juliano.crudprj4.repositories.ClientRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public void run(String... args) throws Exception {


        Client c1 = new Client(null, "João Augusto", "012345678910", 1000.00, Instant.parse("1974-04-21T15:21:22Z"), 2);
        Client c2 = new Client(null, "Maria Augusta", "057415253970", 2500.00, Instant.parse("1976-03-23T15:21:22Z"), 3);
        Client c3 = new Client(null, "João Augusto", "03771945623", 8750.00, Instant.parse("1978-11-28T15:21:22Z"), 4);
        Client c4 = new Client(null, "Carlos Lenine", "3938452398", 6000.00, Instant.parse("1980-10-15T15:21:22Z"), 1);
        Client c5 = new Client(null, "Rafael Peixoto", "45874512369", 1299.00, Instant.parse("1984-05-25T15:21:22Z"), 2);
        Client c6 = new Client(null, "Joana Ribeiro", "963256314414", 7428.35, Instant.parse("1963-07-23T15:21:22Z"), 4);
        Client c7 = new Client(null, "Monica Azevedo", "47852314569", 3658.00, Instant.parse("1972-08-10T15:21:22Z"), 3);
        Client c8 = new Client(null, "Sandra Serra", "12356986325", 1478.52, Instant.parse("1982-11-14T15:21:22Z"), 2);
        Client c9 = new Client(null, "Fausto Nunes", "14523647896", 5896.00, Instant.parse("1959-12-18T15:21:22Z"), 1);
        Client c10 = new Client(null, "Claudia Mendes", "63254169874", 10828.00, Instant.parse("1988-03-29T15:21:22Z"), 5);
        
        
        clientRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));
		
	}

}
