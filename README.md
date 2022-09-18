# challenge-backend-java-spring-boot

Al iniciar la aplicación pueden testear los endpoints con Swagger UI en: http://localhost:8080/swagger-ui.html.

## Spring Security
<h3>Permisos asociados a los roles de usuarios:</h3>
    <p>* Peticiones GET, todos los usuarios (sin validación).</p>
    <p>* Peticiones POST, Roles(USER, ADMIN).</p>
    <p>* Peticiones PUT, Role(ADMIN).</p>
    <p>* Peticiones DELETE, Role(ADMIN).</p>

<H3>Usuarios cargados al iniciar la aplicación:</H3>
    <p>* Username: Miguel Bada, Password: 123, Role: ADMIN.</p>
    <p>* Username: Nancy Nagel, Password: 123, Role: USER.</p>
