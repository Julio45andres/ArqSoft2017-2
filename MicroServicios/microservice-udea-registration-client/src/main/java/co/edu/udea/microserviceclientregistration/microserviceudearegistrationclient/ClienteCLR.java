package co.edu.udea.microserviceclientregistration.microserviceudearegistrationclient;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class ClienteCLR implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void run(String... args) throws Exception {        
        clienteRepository.save(new Cliente("cliente1","cliente1@gmail.com"));
        clienteRepository.save(new Cliente("cliente2","cliente2@gmail.com"));
        clienteRepository.findAll().forEach(System.out::println);
    }
}
