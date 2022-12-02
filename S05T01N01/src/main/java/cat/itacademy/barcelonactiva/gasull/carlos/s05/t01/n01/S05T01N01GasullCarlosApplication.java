package cat.itacademy.barcelonactiva.gasull.carlos.s05.t01.n01;

import cat.itacademy.barcelonactiva.gasull.carlos.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.gasull.carlos.s05.t01.n01.model.Sucursal;
import cat.itacademy.barcelonactiva.gasull.carlos.s05.t01.n01.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S05T01N01GasullCarlosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(S05T01N01GasullCarlosApplication.class, args);
	}

	@Autowired
	private SucursalRepository sucursalRepository;

	@Override
	public void run(String... args) throws Exception {

		Sucursal sucursal1 = new Sucursal("Lápices Barcelona", "españa");
		sucursalRepository.save(sucursal1);

		Sucursal sucursal2 = new Sucursal("Draws Carlitos", "mexico");
		sucursalRepository.save(sucursal2);
	}
}
