import javax.swing.JOptionPane;

public class Vista {
	/**
	 * Metodo main invoca el metodo cargarPantalla 
	 * @param args
	 */
	public static void main(String[] args) {//Declaracion metodo
		cargarPantalla();

	}
	/**Fin del metodo**/
	
	/**
	 * Metodo encargado de instanciar la clase Calculos, para realizar la invocacion del metodo inicializarValores, al que 
	 * le pasa como parametro la ruta ingresada en el campo de texto que aparece en pantalla, que de ser correcta devuelve 
	 * el promedio y la desviacion de los numeros presentes en la lista ingresada. 
	 */
	public static void cargarPantalla(){//Declaracion metodo
		Coeficientes coeficientes = new Coeficientes();
		String rutaArchivo = JOptionPane.showInputDialog("Ingrese la ruta del archivo");
		if(rutaArchivo == null || rutaArchivo.isEmpty()){
			JOptionPane.showMessageDialog(null, "Debe ingresar una ruta en el campo de texto");
			System.exit(0);
		}
		String xK = JOptionPane.showInputDialog("Ingrese Xk");
		if(xK == null || xK.isEmpty()){
			JOptionPane.showMessageDialog(null, "Xk debe ser un numero valido y el campo no debe estar vacio");
			System.exit(0);
		}
		try {
			coeficientes.setXK(Double.parseDouble(xK));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al ingresar Xk. Xk debe ser un numero valido");
			System.exit(0);
		}
		double xKNumero = Double.parseDouble(xK);
		Operaciones operaciones = new Operaciones(rutaArchivo, xKNumero);
		coeficientes.inicializarValores(rutaArchivo);
		
		System.out.println("Coeficiente correlacion: " + coeficientes.getCoeficiente() + " | Coeficiente al cuadrado: " + Math.pow(coeficientes.getCoeficiente(), 2) + " | Significancia: " + operaciones.getSignificancia() + " | Bo: " + coeficientes.getBetaCero() + " | B1: " + coeficientes.getBetaUno() +  " | Yk: " + coeficientes.getYK()
		+ " | Rango: " + operaciones.getRango() + " | uPI: " + operaciones.getUPI() + " | LPI: " + operaciones.getLPI());
		
	}
	/**Fin del metodo **/
}
