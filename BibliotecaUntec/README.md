# Sistema de Biblioteca Digital UNTEC

## Descripción
Aplicación web para la gestión de una biblioteca universitaria. Permite al bibliotecario administrar el catálogo de libros (insertar, listar, actualizar estado de préstamo) y gestionar los usuarios del sistema. El sistema de login valida las credenciales contra una lista en memoria (ArrayList), mientras que el catálogo de libros persiste en una base de datos relacional MySQL.

## Tecnologías Utilizadas
- **Lenguaje:** Java 21
- **Framework:** Jakarta EE 10 (Servlets, JSP, JSTL)
- **Gestor de dependencias:** Apache Maven
- **Base de datos:** MySQL 8.0
- **Servidor de aplicaciones:** Apache Tomcat 10.1
- **Frontend:** HTML5, CSS3, Bootstrap 5

## Requisitos Previos
- JDK 21 instalado y configurado en el PATH.
- Apache Maven 3.9 o superior.
- Apache Tomcat 10.1.x.
- MySQL Server 8.0 corriendo en el puerto 3306.

## Instrucciones de Instalación y Uso

### 1. Configuración de la Base de Datos
1. Abre tu cliente de MySQL (MySQL Workbench, phpMyAdmin, etc.).
2. Ejecuta el script SQL incluido en la raíz del proyecto llamado `script.sql`. 
   - Esto creará la base de datos `biblioteca_untc`, la tabla `libros` e insertará 12 libros de prueba.

### 2. Configuración de la Aplicación
1. Abre el proyecto en **Eclipse IDE** (File -> Import -> Existing Maven Projects).
2. Navega a la clase `com.untec.dao.ConexionDB`.
3. Modifica la constante `PASSWORD` con la contraseña de tu usuario `root` de MySQL:
   ```java
   private static final String PASSWORD = "1234";