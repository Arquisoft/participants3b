package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.Encriptador;

public class EncriptadorTest {

	StringBuilder sB1 =new StringBuilder();
	StringBuilder sB2= new StringBuilder();
	@Before
	public void setSB(){
		sB1.append("Texto a encriptar y desencriptar para test");
		sB2.append("Segundo texto a encriptar que deberia ser diferente");
	}
	@Test
	public void test() {
		String encriptado = Encriptador.encriptar(sB1.toString());
		String encriptado2 = Encriptador.encriptar(sB2.toString());
		
		assertEquals(encriptado, Encriptador.encriptar(sB1.toString()));
		String desencriptado1="";
		String desencriptado2="";
		try {
			desencriptado1 = Encriptador.Desencriptar(encriptado);
			desencriptado2 = Encriptador.Desencriptar(encriptado2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(desencriptado1,sB1.toString());
		assertEquals(desencriptado2,sB2.toString());
	}

}
