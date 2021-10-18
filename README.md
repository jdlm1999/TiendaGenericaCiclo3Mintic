# TiendaGenerica_Grupo8
 
 ## Integrantes:
 
 1. Brayan Alexis Villamizar Montañez
 1. Brandon Sneyder Urbano Salamanca
 1. William Suárez Escobar
 1. Juan David Lozano Moreno

## Softwares Requeridos:

 1. Java Development Kit - JDK11
 1. Tener un IDE como Eclipse o Netbeans
 1. Dependecias Maven 3.6+
 1. Apache Tomcat - Apache Tomcat 9
 1. MySQL Workbench Community Edition 8.0.25

## Pasos para correr servidor Backend

Crear la base de datos en MYSQL Workbench sin olvidar el usaurio, clave y puerto para poder conectar el servidor.

Luego de haber creado la base de datos, es necesario realizar un ajuste en la carpeta resource se debe modificar el archivo ```application.properties``` con lo siguiente:

``` spring.jpa.database = MYSQL
spring.jpa.show-sql= true
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/tiendagenerica?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC 
spring.datasource.username=
spring.datasource.password=
server.port = 5000
```

En necesario que en la línea ```spring.datasource.username=``` se bebe colocar el usurio creado al momento de instalar MySQL Workbench al igual que en ```spring.datasource.password=``` colocar el password, o esto podría generar errores de conexión. Ademas, asegurarse del puerto de conexión y nombre de la base de datos coincidan. 

Al haber configurado la conexión con la base de datos, se debe correr el servidor. Para ello se debe seleccionar la opción Run As y en la ventana que despliega colocar en el apartado de Goals:

```
clean install spring-boot:run
```

Si cada una de las instalaciones fue logradas con exito y la conexión a la base de datos no tuvo ningún tipo de problema, el servidor daría inicio y quedaría en espera de peticiones. 

## Pasos para correr Frontend

Para correr el Front unicamente es necesario tener el servidor Tomcat instalado, no es necesario iniciarlo, se hará de manera automática. Se debe seleccionar Run As y en las opciones seleccionar ```Run on Server``` esto despliegara la apliación y podrá ser visitada en:
```
localhost:8080/
```
