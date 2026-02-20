package com.zaruc.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	@DisplayName("A ideia é salvar um usuário no banco de dados")
	void deveSalvarUsuario() {
		User usuario = new User();
		usuario.setName("Estagiario Teste");
		usuario.setLogin("teste_ti");

		User usuarioSalvo = userRepository.save(usuario);

		Assertions.assertNotNull(usuarioSalvo.getId());
		Assertions.assertEquals("Estagiário Teste", usuarioSalvo.getName());
	}

}
