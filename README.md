# Calculadora PoC
 
Esta pequeña prueba de concepto de una API REST se ha realizado usando las siguientes tecnologías:
  - Java 17
  - Spring Boot
  - Maven
  - JUnit 
  - Swagger
  - Lombok

La API sólo dispone de 2 servicios, **/sumar** y **/restar**, que suman y restan 2 números respectivamente.

## Compilación

Para compilar el proyecto, simplemente se debe descargar, abrir una ventana de comandos en la carpeta raíz del proyecto y ejecutar el comando: 

  > mvn clean install

Esto hará que maven compile el proyecto, lance los tests unitarios y lo empaquete todo en un fichero .jar.
	
![1](https://user-images.githubusercontent.com/10712481/233465743-f94436cf-3eef-4aee-bbe6-87a6a6b7d32c.png)

## Ejecución

Para ejecutar el proyecto, una vez compilado, se debe abrir una ventana de comandos en la carpeta /target donde se encuentra el fichero calculadora.jar (generado anteriormente durante la compilación) y ejecutar el siguiente comando:
  
  > java -jar calculadora.jar
  
Esto hará que se lance el tomcat embebido de la aplicación y despliegue la API en local.

![2](https://user-images.githubusercontent.com/10712481/233465924-83f50f4d-9a55-48bf-a18a-cbafec7f814f.png)


El punto de acceso predeterminado es: 
  ** http://localhost:8080/calculadora/ **
Esto nos redirigirá al Swagger de la API donde se definirá las 2 operaciones disponibles (e incluso nos permitirá lanzar peticiones desde la propia interfaz del Swagger).

Las rutas de las operaciones son:
  - sumar --> *http://localhost:8080/calculadora/sumar*
  - restar --> *http://localhost:8080/calculadora/restar*

![3](https://user-images.githubusercontent.com/10712481/233466025-35e8f3de-89d1-4cea-8b45-58506f1b833e.png)

