# Backend de eventos

## Listado de endpoints

* `GET /eventos`
   
   Trae todos los eventos y se puede filtrar por diferentes query-params:
   
   * `destacados=[true|false]`
   * `publicados=[true|false]`
   * `tipo=[charla|curso|feria|jornada|taller|festival|voluntariado]`
   * `busqueda=<término-de-búsqueda>` (busca el texo case-insensitive en el título y la descripción del evento)
   
* `GET /eventos/{id}`

  Trae un evento en particular
  
* `POST /eventos`

  Crea un evento. Se le debe pasar un body con un evento válido:
  ```json
  {
    "titulo": "Un evento",
    "descripcion": "Una descripción cualquiera",
    "destacado": true,
    "localidad": "Calle false 123",
    "precio": 15.40,
    "link": "http://mi-pagina.com.ar/mi-evento",
    "fechaYHoraDeInicio": "2018-10-20T19:47:50.78",
    "tipo": "charla",
    "contacto": {
      "nombre": "John",
      "apellido": "Snow",
      "email": "jsnow@winterfell.com"
    }
  }
  ```
  * Destacado es opcional (`false` por defecto).
  * Precio es opcional (si no se le pasa nada, el evento es gratis)
  * `tipo` es un string que tiene que ser uno de:
      * "charla"
      * "curso"
      * "feria"
      * "jornada"
      * "taller"
      * "voluntariado"
      * "festival"
  * `contacto` es obligatorio. Si ya hay un email registrado se usa el guardado (no se pisa)
  
* `POST /contactos`

  Crea un contacto nuevo. Body (todos campos obligatorios):
  ```json
  {
    "nombre": "John",
    "apellido": "Snow",
    "email": "jsnow@winterfell.com"
  }
  ```
  
## Entorno de desarrollo
Este backend está hecho con Spring Boot. ¿Qué vas a necesitar para levantarlo?
* Ganas
* Java >= 8
* Maven
* Docker y docker-compose (para la base de datos)

Para levantar el server de desarrollo, primero hay que levantar la base de datos:
```bash
docker-compose up # quizás necesites sudo adelante, depende de tu instalación de docker
```
Esto crea una instancia de Postgres, con una base de datos con los siguentes parámetros:
```
POSTGRES_DB=agenda
POSTGRES_USER=agenda
POSTGRES_PASSWORD=agenda
```

Una vez levantada la base, para subir el server, deberíamos correr
```bash
mvn clean install
```