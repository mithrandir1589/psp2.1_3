C�digo asignatura: 201710_CSOF5101_01
Nombre Asignatura: Conceptos avanzados de ingenier�a de software
Tarea 7: Program 7
Nombre estudiante: Miguel �ngel Quintero Pi�eros
Fecha de env�o: 1 Mayo 2017
**********************************************************************

Instrucciones ejecuci�n programa: 
1. Ingrese a simbolo de sistema (Tecla inicio + cmd + Enter)

2. Ubicarse en la ruta en la cual est� el archivo Program7.jar psp2.1_3\src\main\java\src (Carpeta del proyecto descargada de gitHub) o Program 7 PSP_Miguel Quintero\src (.zip subibo a sicua)
3. Ejecutar el comando java -jar Program7.jar y pulsar la tecla Enter
4. Ingresar la ruta del directorio a evaluar y presionar la tecla Enter o dar Click en el bot�n Aceptar de la ventana de mensaje que recibe el dato de entrada y pulsar enter. En la ruta 
Program 7 PSP_Miguel Quintero\test (.zip subido a sicua) o psp2.1_3\src\site\resources\PSP2.1_3\test (Carpeta del proyecto descargada de gitHub) se encuentra el archivo numeros2.txt para facilitar
las pruebas. La estructura del archivo que recibe el programa es un par de n�meros (x,y) separados por coma, por cada l�nea del archivo. Ejemplo:

6,3
5,2
8,5
8,8
12.3,63
.
.
.


5. Ingresar el valor de Xk
6. Visualizar el resultado en la ventana de S�mbolo de Sistema 		     

***************************************************************************
Ruta de los directorios pspdata, pspforms y test 
GitHub:https://github.com/mithrandir1589/psp2.1_3/tree/master/src/site/resources/PSP2.1_3
Carpeta: ..\Program 7 PSP_Miguel Quintero


Nota: Teniendo en cuenta las instrucciones para esta tarea, la estructura del .zip contiene los directorios psp data, psp forms, src, test y readme
Por otro lado el repositorio en GitHub contiene la estructura acostumbrada en GIT src, target, .gitignore, LICENCE.txt, pom.xml y README.xml 
***************************************************************************

ruta del repositorio en gitHub https://github.com/mithrandir1589/psp2.1_3

ruta de la aplicaci�n desplegada en heroku https://afternoon-shelf-24213.herokuapp.com/psp2.1_3

***************************************************************************
Para empaquetar el programa con Maven, se debe ejecutar la sentencia "mvn package" en la carpeta ra�z de donde se haga el pull del
repositorio git, la cual es la que se descargar� desde el repositorio GitHub y donde se encuentra el pom.xml. Para correr las pruebas unitarias usando maven, es necesario correr el comando
mvn -Dtest=Tests test , donde Tests es la clase con las pruebas en JUnit. 

