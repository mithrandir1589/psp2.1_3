import java.util.LinkedList;

/**
 * Clase encargada de realizar los calculos y la comunicacion entre la clase Interfaz y la clase Datos. Realiza
 * los calculos de parametros de regresion, coeficiente de correlacion. 
 * @author Miguel Angel Quintero 
 * @version 30/04/2017
 * 
 **/

public class Coeficientes {
	/**Variables de la clase **/
	private double promedioX;
	private double promedioY;
	private String rutaArchivo;
	private double betaCero;
	private double betaUno;
	private double coeficienteCorrelacion;
	private double yK;
	private double xK;	
	private LinkedList<Double> listaNumerosX;
	private LinkedList<Double> listaNumerosY;
	
	/**
	 * Metodo que obtiene la ruta del archivo y se la asigna a la variable rutaArchivo de esta clase para que sea usada por 
	 * cualquiera de los metodos de la misma.
	 * @param rutaArchivo Ruta del archivo
	 */
	private void obtenerRutaArchivo(String rutaArchivo){//Declaracion metodo
		this.rutaArchivo = rutaArchivo;		
	}
	/**Fin del metodo**/
	
	/**
	 * Metodo encargado de obtener las lista de numeros, obtenida de invocar el metodo obtenerListasNumeros de la clase Datos
	 */
	private void configurarListaNumeros(){//Declaracion metodo
		Datos datos = new Datos();
		datos.obtenerListasNumeros(this.rutaArchivo);
		this.listaNumerosX = datos.devolverListaX();
		this.listaNumerosY = datos.devolverListaY();
	}
	/**Fin del metodo **/
	
	/**
	 * Metodo que invoca los metodos que permiten obtener la ruta del archivo y la lista de numeros
	 * @param ruta Ruta del archivo
	 */
	public void inicializarValores(String ruta){//Declaracion metodo
		obtenerRutaArchivo(ruta);
		configurarListaNumeros();
		calcularPromedio();
		calcularBetaUnoYCoeficiente();
		calcularBetaCero();
		calcularYK();
	}
	/**Fin del metodo**/
	
	/**
	 * Metodo encargado de calcular el promedio, usando los datos presentes en la lista de numeros listaNumerosX y listaNumerosY
	 */
	private void calcularPromedio(){//Declaracion metodo
		double sumaX = 0;
		double sumaY = 0;
		int cantidadNumeros = this.listaNumerosX.size();
		for (int i = 0; i < cantidadNumeros ; i++){
			sumaX = sumaX + this.listaNumerosX.get(i);
			sumaY = sumaY + this.listaNumerosY.get(i);
		}
		this.promedioX = (double) sumaX / cantidadNumeros;
		this.promedioY = (double) sumaY / cantidadNumeros;
	}
	/** Fin del metodo **/
	
	/**
	 * Metodo encargado de calcular el parametro beta sub uno y el coeficiente de correlacion
	 */
	private void calcularBetaUnoYCoeficiente(){//Declaracion metodo
		double sumaProductoXY = 0;
		double cantidadNumeros = this.listaNumerosX.size();
		double sumaX = 0;
		double sumaY = 0;
		double sumaCuadradosY = 0;
		double productoPromediosCantidadNumeros = cantidadNumeros * this.promedioX * this.promedioY;
		double sumaCuadradosX = 0;
		double productoPromedioXCuadrado = cantidadNumeros * Math.pow(this.promedioX,2);
		
		double numeradorCoeficiente = 0;
		double denominadorCoeficiente = 0;
		for ( int i = 0; i< cantidadNumeros; i++){
			sumaProductoXY = sumaProductoXY + (this.listaNumerosX.get(i) * this.listaNumerosY.get(i));
			sumaX = sumaX + this.listaNumerosX.get(i);
			sumaY = sumaY + this.listaNumerosY.get(i);			
			sumaCuadradosX = sumaCuadradosX + (Math.pow(this.listaNumerosX.get(i),2));
			sumaCuadradosY = sumaCuadradosY + (Math.pow(this.listaNumerosY.get(i),2));
		}
		numeradorCoeficiente = (cantidadNumeros * sumaProductoXY) - (sumaX * sumaY);
		denominadorCoeficiente = Math.sqrt( ((cantidadNumeros * sumaCuadradosX) - Math.pow(sumaX, 2)) * ((cantidadNumeros * sumaCuadradosY) - Math.pow(sumaY, 2)) );
		this.coeficienteCorrelacion = numeradorCoeficiente / denominadorCoeficiente;
		this.betaUno = (sumaProductoXY - productoPromediosCantidadNumeros) / (sumaCuadradosX - productoPromedioXCuadrado);		
	}
	/**Fin del metodo**/
	
	/**
	 * Metodo encargado de retornar el parametro beta sub uno
	 * @return betaUno Valor del parametro beta sub uno
	 */
	public double getBetaUno(){//Declaracion metodo
		return this.betaUno;
	}
	/**Fin del metodo**/
	
	/**
	 * Metodo encargado de calcular el parametro beta sub cero 
	 */
	private void calcularBetaCero(){//Declaracion metodo
		this.betaCero = this.promedioY - (this.betaUno * this.promedioX);
	}
	/**Fin del metodo**/
	
	/**
	 * Metodo encargado de retornar el parametro beta sub uno
	 * @return betaUno Valor del parametro beta sub uno
	 */
	public double getBetaCero(){//Declaracion metodo
		return this.betaCero;
	}
	/**Fin del metodo**/
	
	/**
	 * Metodo encargado de retornar el parametro xK
	 * @param xK
	 */
	public void setXK(double xK){//Declaracion metodo
		this.xK = xK;
	}
	/**Fin del metodo**/
	
	/**
	 * Metodo encargado de calcular el parametro yK
	 */
	private void calcularYK(){//Declaracion metodo 
		this.yK = this.betaCero + (this.betaUno * this.xK);
	}
	/**Fin del metodo**/
	
	/**
	 * Metodo encargado de retornar el parametro yK
	 * @return yK
	 */
	public double getYK(){//Declaracion metodo
		return this.yK;
	}
	/**Fin del metodo**/
	
	/**
	 * Metodo encargado de retornar el coeficiente de correlacion
	 * @return coeficienteCorrelacion
	 */
	public double getCoeficiente(){//Declaracion metodo
		return this.coeficienteCorrelacion;
	}
	
	/**
	 * Retorna el valor del promedio para x
	 * @return promedioX
	 */
	public double getPromedioX(){//Declaracion metodo
		return this.promedioX;
	}
	/**Fin del metodo**/
}
