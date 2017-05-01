import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class Tests {

	@Test
	public void pruebaObtenerListaX() {//Prueba método devolverListaX() de la clase Datos
		Datos d = new Datos();
		d.obtenerListasNumeros("src\\site\\resources\\PSP2.1_3\\test\\numeros.txt");//Debe ser una ruta valida en el equipo
		LinkedList<Double> listaPruebaNumerosX = new LinkedList();
		listaPruebaNumerosX.add((double) 130);
		listaPruebaNumerosX.add((double) 650);
		listaPruebaNumerosX.add((double) 99);
		listaPruebaNumerosX.add((double) 150);
		listaPruebaNumerosX.add((double) 128);
		listaPruebaNumerosX.add((double) 302);
		listaPruebaNumerosX.add((double) 95);
		listaPruebaNumerosX.add((double) 945);
		listaPruebaNumerosX.add((double) 368);
		listaPruebaNumerosX.add((double) 961);
		
		assertEquals(listaPruebaNumerosX, d.devolverListaX());
		
	}
	
	@Test
	public void pruebaObtenerListaY() {//Prueba método devolverListaX() de la clase Datos
		Datos d = new Datos();
		d.obtenerListasNumeros("src\\site\\resources\\PSP2.1_3\\test\\numeros.txt");//Debe ser una ruta valida en el equipo
		LinkedList<Double> listaPruebaNumerosY = new LinkedList();
		listaPruebaNumerosY.add((double) 15);
		listaPruebaNumerosY.add((double) 69.9);
		listaPruebaNumerosY.add((double) 6.5);
		listaPruebaNumerosY.add((double) 22.4);
		listaPruebaNumerosY.add((double) 28.4);
		listaPruebaNumerosY.add((double) 65.9);
		listaPruebaNumerosY.add((double) 19.4);
		listaPruebaNumerosY.add((double) 198.7);
		listaPruebaNumerosY.add((double) 38.8);
		listaPruebaNumerosY.add((double) 138.2);
		
		assertEquals(listaPruebaNumerosY, d.devolverListaY());
		
	}
	
	@Test
	public void pruebaObtenerBetaUno(){
		Coeficientes c = new Coeficientes();
		c.inicializarValores("src\\site\\resources\\PSP2.1_3\\test\\numeros.txt");//Debe ser una ruta valida en el equipo
		assertEquals(0.1681, c.getBetaUno(),0.0001);
	}
	
	@Test
	public void pruebaObtenerBetaCero(){
		Coeficientes c = new Coeficientes();
		c.inicializarValores("src\\site\\resources\\PSP2.1_3\\test\\numeros.txt");//Debe ser una ruta valida en el equipo
		assertEquals(-4.0388, c.getBetaCero(),0.0001);
	}
	
	@Test
	public void pruebaObtenerCoeficiente(){
		Coeficientes c = new Coeficientes();
		c.inicializarValores("src\\site\\resources\\PSP2.1_3\\test\\numeros.txt");//Debe ser una ruta valida en el equipo
		assertEquals(0.9333, c.getCoeficiente(),0.0001);
	}
	
	@Test
	public void pruebaObtenerPromedioX(){
		Coeficientes c = new Coeficientes();
		c.inicializarValores("src\\site\\resources\\PSP2.1_3\\test\\numeros.txt");//Debe ser una ruta valida en el equipo
		assertEquals(382.8, c.getPromedioX(),0.0001);
	}
	
	/**
	 * Test para caso de prueba 1
	 */
	@Test
	public void testDerivacion(){
		Derivacion Derivacion = new Derivacion(20, 0.0001, 6.0, 1.0, 0.35);
		assertEquals(1.1337, Derivacion.getX(),0.0001);
	}
	

	
	/**
	 * Test para caso de prueba #1
	 */
	@Test 
	public void testDerivacion2() {
		Derivacion calculos = new Derivacion(10, 0.00001, 9, 1.1);
		assertEquals(0.350006,calculos.getP(), 0.0001);		
	}
	
	@Test
	public void testOperaciones1(){
		Operaciones operaciones = new Operaciones("src\\site\\resources\\PSP2.1_3\\test\\numeros2.txt", 386);
		assertEquals(1.77517E-05, operaciones.getSignificancia(), 0.0001);
	}
	
	@Test
	public void testOperaciones2(){
		Operaciones operaciones = new Operaciones("src\\site\\resources\\PSP2.1_3\\test\\numeros2.txt", 386);
		assertEquals(230.00172, operaciones.getRango(), 0.01);
	}
	
	@Test
	public void testOperaciones3(){
		Operaciones operaciones = new Operaciones("src\\site\\resources\\PSP2.1_3\\test\\numeros2.txt", 386);
		assertEquals(874.4311, operaciones.getUPI(), 0.01);
	}
	
	@Test
	public void testOperaciones4(){
		Operaciones operaciones = new Operaciones("src\\site\\resources\\PSP2.1_3\\test\\numeros2.txt", 386);
		assertEquals(414.42, operaciones.getLPI(), 0.01);
	}
}
