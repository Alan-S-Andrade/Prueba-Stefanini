# Prueba-Stefanini

## Para generar el proyecto base con Spring:
curl https://start.spring.io/starter.zip \
  -d dependencies=web,security,jpa,postgresql,lombok \
  -d language=java \
  -d type=maven-project \
  -d name=user-api \
  -o user-api.zip

unzip user-api.zip && cd src

## Para ejecutar la API

./mvnw clean package
./mvnw clean install
./mvnw spring-boot:run

docker-compose up --build

## Para ejecutar los unit tests
./mvnw test

### Acceder al UI de Swagger 
http://localhost:8080/swagger-ui/index.html

### Registrar un Usuario con JWT

curl -X POST -H "Content-Type: application/json" -d \
'{"name":"Alan Andrade", "email":"alansa2@illinios.edu", "role":"ADMIN", "password":"passw0rd"}' \
http://localhost:8080/api/auth/register

### Iniciar Sesión y Obtener JWT

curl -X POST -H "Content-Type: application/json" -d \
'{"email":"alansa2@illinios.edu", "password":"passw0rd"}' \
http://localhost:8080/api/auth/login

### entrar al endpoint protegido.

curl -H "Authorization: Bearer <JWT_TOKEN>" http://localhost:8080/api/users

## Crear un usuario y verificar con Postman
curl -X POST -H "Content-Type: application/json" -d \
'{"name":"Alan Andrade", "email":"alansa2@illinios.edu", "role":"ADMIN", "password":"passw0rd"}' \
http://localhost:8080/api/users

## la clave del JWT está en el application.yml

## Pasos para despliegue en OCI

### Autenticarse con OCI CLI
oci session authenticate

### Formato para iniciar sesión en OCIR
docker login (region).ocir.io

Ingresa el OCID de usuario y la contraseña/token de autenticación.

### Construir la imagen Docker
docker build -t user-api:latest .

### Etiquetar la imagen para subirla a OCIR
docker tag user-api:latest iad.ocir.io/tenancy-prueba/user-api:latest

### Subir la Imagen a OCIR
docker push iad.ocir.io/tenancy-prueba/user-api:latest