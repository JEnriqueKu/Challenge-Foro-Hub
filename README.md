# Proyecto Challenge Foro Hub

### Descripción del Proyecto

Este proyecto fue desarrollado como parte del curso **Java y Spring Boot**, impartido por Allura Latam. Aquí encontrarás todos los detalles y funcionalidades implementadas.

Consiste en un sistema API REST en forma de foro y desarrollado en Java utilizando Spring Boot, JPA, Flyway, Spring Security y PostgreSQL que permite la gestión de tópicos de discusión, con funcionalidades de autenticación y autorización. El objetivo principal es aplicar los conocimientos adquiridos en el curso mediante la implementación de diversas funcionalidades de gestión de requisiciones API, base de datos, autenticación de usuarios y protección de endpoints.

### Funcionalidades Implementadas

El proyecto incluye las siguientes funcionalidades principales:

- **Registrar un nuevo tópico**
  - Permite registrar un nuevo tópico en la base de datos proporcionando la información necesaria a través de una solicitud POST en formato JSON. La información del tópico se almacena y se devuelve una confirmación con los datos registrados y la URL del nuevo recurso.

- **Listar todos los tópicos con paginación**
  - Permite listar todos los tópicos registrados en la base de datos con soporte de paginación.

- **Actualizar un tópico existente**
  - Permite actualizar la información de un tópico existente en la base de datos mediante una solicitud PUT. Se busca el tópico por su ID, se actualizan los campos proporcionados y se devuelve la información actualizada.

- **Eliminar un tópico**
  - Permite eliminar un tópico específico de la base de datos mediante una solicitud DELETE utilizando el ID del tópico.

- **Obtener detalles de un tópico específico**
  - Permite obtener los detalles completos de un tópico específico mediante una solicitud GET utilizando el ID del tópico. Se devuelve toda la información relacionada con el tópico solicitado.


  También incluye funcionalidades de seguridad:


- **Autenticación de usuarios mediante JWT**
  - Implementa la autenticación de usuarios utilizando JSON Web Tokens (JWT). Los usuarios pueden autenticarse proporcionando sus credenciales a través de un endpoint de inicio de sesión. Si las credenciales son válidas, se genera un token JWT, que el usuario debe incluir en las solicitudes para acceder a los endpoints protegidos.

- **Protección de endpoints con Spring Security**
  - Utiliza Spring Security para proteger los endpoints de la aplicación. Configura reglas de seguridad que permiten el acceso solo a usuarios autenticados para ciertos recursos. Los endpoints públicos, como el de inicio de sesión, están accesibles para todos, mientras que los demás requieren un token JWT válido para acceder.

- **Encriptación de contraseñas**
  - Las contraseñas de los usuarios se encriptan utilizando un algoritmo antes de almacenarlas en la base de datos. Esto asegura que las contraseñas se guarden de manera segura y reduce el riesgo de que las contraseñas sean comprometidas en caso de una brecha de seguridad.

### Configuración y Ejecución

Para ejecutar el proyecto en tu entorno local, asegúrate de tener configurado lo siguiente:

1. **Requisitos:**
   Java 17 o superior, Maven, PostgreSQL.


2. **Base de Datos:**
  - Configura una base de datos PostgreSQL y es muy importante ajustar las configuraciones de conexión en `application.properties` para que coincidan con tu entorno.
  Ejemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:8080/blogalura
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

3. **Endpoints:**
   #### Tópicos

- **POST /topics**: Registrar un nuevo tópico.
- **GET /topics**: Listar todos los tópicos con paginación.
- **PUT /topics**: Actualizar un tópico existente.
- **DELETE /topics/{id}**: Eliminar un tópico.
- **GET /topics/{id}**: Obtener detalles de un tópico específico.

#### Ejemplo de JSON para la aplicación

```json
{
  "titulo": "Dudas del tema",
  "mensaje": "Hola estoy aprendiendo y tengo una pregunta...",
  "fechaCreacion": "2024-07-24T00:00:00",
  "status": "Activo",
  "autor": {
    "nombre": "Enrique Ku",
    "correoElectronico": "EnriqueKu@example.com",
    "contrasena": "P@ssw0rd",
    "perfiles": [
      {
        "nombre": "Enrique"
      }
    ]
  },
  "curso": {
    "nombre": "Desarrollo con Spring Boot",
    "categoria": "Spring Boot"
  },
  "respuestas": [
    {
      "mensaje": "Tienes que...",
      "topico": 5,
      "fechaCreacion": "2024-07-24T08:30:00",
      "autor": {
        "nombre": "Maria Gomez",
        "correoElectronico": "MGomez@example.com",
        "contrasena": "P@ssw0rd",
        "perfiles": [
          {
            "nombre": "Maria Gomez"
          }
        ]
      },
      "solucion": true
    },
    {
      "mensaje": "Te recomiendo que revises la documentacion",
      "topico": 5,
      "fechaCreacion": "2024-07-24T09:00:00",
      "autor": {
        "nombre": "Ricardo Rodriguez",
        "correoElectronico": "RicardoR@example.com",
        "contrasena": "P@ssw0rd3",
        "perfiles": [
          {
            "nombre": "Ricardo"
          }
        ]
      },
      "solucion": false
    }
  ]
}
```

  #### Autenticación

- **POST /login**: Autenticar usuario y obtener token JWT.

### Ejecutar la aplicación

Para ejecutar la aplicación, tienes dos opciones:

### Opción 1: Utilizando Maven

Desde la raíz del proyecto, ejecuta el siguiente comando en tu terminal:

```bash
mvn spring-boot:run
```

### Opción 2: Ejecutar desde tu entorno de desarrollo

También puedes ejecutar la aplicación directamente desde tu entorno de desarrollo integrado (IDE), abre la clase principal BlogaluraApplication y ejecuta la clase principal.