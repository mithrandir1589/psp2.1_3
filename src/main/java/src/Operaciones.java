import java.util.LinkedList;
/**
 * Clase encargada de realizar los calculos de rangos y significancia
 * @author Miguel Angel Quintero
 * @version 1/05/2017
 */
public class Operaciones {
	/**Variables de la clase**/
	private double desviacion; 
	private double upi;
	private double lpi;
	private double rango;
	private double significancia;
	private double n;
	private Coeficientes coeficiente = new  Coeficientes();
	private Derivacion derivacionP;
	private Derivacion derivacionX;
	private double xK;
	private Datos d = new Datos();
		
	/**
	 * Consructor de la clase, recibe la ruta del archivo cargado y Xk
	 * @param ruta
	 */
	public Operaciones(String ruta, double xK){//Declaracion metodo
		d.obtenerListasNumeros(ruta);
		n = d.devolverListaX().size();
		this.xK = xK;
		this.coeficiente.setXK(xK);
		this.coeficiente.inicializarValores(ruta);
		calcularSignificancia();
		calcularDesviacion();
		calcularRangos();
	}
	/**Fin del metodo**/
	
	/**
	 * Clase encargada de realizar el calculo de la significancia 
	 */
	private void calcularSignificancia(){//Declaracion metodo
		double numeradorX = Math.abs(coeficiente.getCoeficiente()) * Math.sqrt(this.n - 2);
		double denominadorX = Math.sqrt(1 - Math.pow(coeficiente.getCoeficiente(), 2));
		double x = numeradorX / denominadorX;		
		
		this.derivacionP = new Derivacion(20, 0.0001, this.n - 2, x);
		double p = derivacionP.getP();
		this.significancia = 1 - (2 * p);
	}
	/**Fin del metodo**/
	
	/**
	 * Calcula rango, UPI y LPI
	 */
	private void calcularRangos(){//Declaracion metodo
		this.derivacionX = new Derivacion(20, 0.00001, this.n - 2, 1.0, 0.35);
		double sumatoria = 0;
		LinkedList<Double> listaX = d.devolverListaX();
		double restaX = Math.pow( (this.xK - this.coeficiente.getPromedioX()), 2);
		double raiz = 0;
		for (int i = 0; i<this.n; i++){
			sumatoria = sumatoria + Math.pow((listaX.get(i) - this.coeficiente.getPromedioX()), 2);
		}

		raiz = Math.sqrt(1 + (1/this.n) + (restaX / sumatoria) );
		
		this.rango = derivacionX.getX() * this.desviacion * raiz;
		this.upi = this.coeficiente.getYK() + this.rango;
		this.lpi = this.coeficiente.getYK() - this.rango;
	}
	/**Fin del metodo**/
	
	/**
	 * Metodo encargado de calcular la desviacion para el calculo del rango
	 */
	private void calcularDesviacion(){//Declaracion metodo
		double betaCero = this.coeficiente.getBetaCero();
		double betaUno = this.coeficiente.getBetaUno();
		LinkedList<Double> listaX = d.devolverListaX();
		LinkedList<Double> listaY = d.devolverListaY();
		double sumatoria = 0;
		
		for(int i = 0; i < this.n; i++){
			sumatoria = sumatoria + Math.pow((listaY.get(i) - betaCero - (betaUno * listaX.get(i))), 2);
		}
		
		this.desviacion = Math.sqrt( (1 / (this.n - 2)) * sumatoria );
	}
	/**Fin del metodo**/
	
	/**
	 * Retorna el valor calculado para UPI
	 * @return LPI
	 */
	public double getUPI(){//Declaracion metodo
		return this.upi;
	}
	/**Fin del metodo**/
	
	
	/**
	 * Retorna el valor calculado para LPI
	 * @return LPI
	 */
	public double getLPI(){//Declaracion metodo
		return this.lpi;
	}
	/**Fin del metodo**/
	
	/**
	 * Retorna el valor calculado para rango
	 * @return rango
	 */
	public double getRango(){//Declaracion metodo
		return this.rango;
	}
	/**Fin del metodo**/
	
	/**
	 * Retorna el valor calculado para la significancia
	 * @return significancia
	 */
	public double getSignificancia(){//Declaracion metodo
		return this.significancia;
	}
	/**Fin del metodo**/
}
