Autor: Jhonny Montoya. Descripción: Proyecto de automatización para realizar reto sobre el sitio: https://www.bancolombia.com/personas, se realizaron 3 casos de 
prueba sobre el conversor de tasas.

Herramientas utilizadas: IDE: Intellij IDEA, Selenium, ChromeDriver versión 96.0.4664.55, Maven, TestNG, ExtendReport
Notas generales:
1. Se debe verificar la versión de Chrome, en caso de no tener la versión 96, se debe actualizar a esta versión para poder realizar la ejecución de todos los test.
  Además el chromedriver está con la versión para mac, de necesitar la de windows o linux se debe descargar y dejar en la ruta: src/main/resources/chromedriver
2. Se realiza la implementación de un origen de datos (DataDriven) para que funcione desde un archivo de Excel, este se encuentra en la ruta del proyecto: "src/test/resources/data/DataDriven.xlsx". Esta implementación simula la hoja de excel como una tabla de base de datos, es decir que para realizar cualquier consulta sobre ella se debe realizar por medio de un query.
3. Dentro de todos los test se solicita como parámetro un id (strId), este id hace referencia al campo ID del archivo DataDriven.xlsx, es decir, que dentro de la prueba va a utilizar el registro relacionado a ese id.
4. Luego de realizar la ejecución de cada uno de los test, la automatización genera un archivo html con el reporte del test ejecutado en la carpeta: "ExtentReports", el nombre del archivo de la siguiente manera: "ReportResultsyyyyMMdd HHmmss.html"
5. Para los test de Update Profile se crea la carpeta images en la ruta: \src\test\resources\images, en esta carpeta se pueden subir las imágenes que se desean relacionar al perfil dentro de cada prueba, el nombre del archivo debe ir en el DataDriven en la hoja: "Users" en el campo: "NameImageProfile". Esto en caso de querer cambiar la imagen a subir en el perfil.
6. Los reportes de cada uno de los test fueron implementados con ExtentReports.

Nota: Se realizo el reto con maven y POM ya que es la herramienta que se tenia en el computador configurado previamente,
utilizar la que se pedia ( gradle yScreenplay) tomaria mas tiempo. O haber informado de esta configuracion en el correo del examen.
