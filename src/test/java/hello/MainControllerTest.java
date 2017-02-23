package hello;


import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.net.URL;





import model.UserInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import controller.Application;


@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class MainControllerTest {

    @Value("${local.server.port}")
    private int port;

    private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
	
	}


//	/**
//	 * Test que se asegura que envia una peticion para mostrar un usuario de prueba y 
//	 * asegura que infoUsuario muestra correctamente la informacion 
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	public void testUserInfo() throws Exception {
//		String userURI = base.toString() + "/testUsuario";  
//		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
//		assertThat(response.getBody(), containsString("<h1>Informacion personal de testUser</h"));
//		assertThat(response.getBody(), containsString("Nombre: TestUser TestApp"));
//		assertThat(response.getBody(), containsString("DNI: 123T"));
//		assertThat(response.getBody(), containsString("Email: correo@tes.com"));
//		assertThat(response.getBody(), containsString("Fecha de nacimiento: 1899-12-31"));
//		assertThat(response.getBody(), containsString("Direccion: C/test"));
//		assertThat(response.getBody(), containsString("Nacionalidad: España"));
//	}
//	


//	@Test
//	public void getError() throws Exception{
//		String userURI = base.toString() + "/user";  
//		ResponseEntity<String> response = template.getForEntity(userURI, String.class);
//		template.
//		assertThat(response.getBody(), containsString("no encontrado"));
//	}
}
