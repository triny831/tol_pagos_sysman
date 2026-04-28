# 🏛️ TOL - Estado de Cuenta Predial

Sistema de consulta de estado de cuenta para la plataforma TOL (Trámites en Línea).

Permite consultar información del contribuyente mediante código catastral y documento de identidad.

---

# 🧱 Arquitectura

Usuario → Servlet (Tomcat) → Service → DAO → PostgreSQL (Docker) → JSON Response

---

# 🚀 Tecnologías

- Java 8 / 17
- Servlets (Java EE)
- Apache Tomcat 9
- PostgreSQL 14 (Docker)
- Docker & Docker Compose
- Maven
- Gson
- Log4j

---

# 📦 Ejecución del proyecto (DOCKER)

## 1. Compilar proyecto
mvn clean package

## 2. Levantar infraestructura (APP + DB)
docker compose up -d

## 3. Detener servicios
docker compose down

---

# 🌐 Endpoint

## Consulta estado de cuenta

GET http://localhost:8080/tol_pagos/api/estado-cuenta

---

## Parámetros

- codigoCatastral (String)
- documento (String)

---

## Ejemplo

http://localhost:8080/tol_pagos/api/estado-cuenta?codigoCatastral=123&documento=999

---

# 📤 Respuesta exitosa

{
  "status": "SUCCESS",
  "message": "OK",
  "data": {
    "nombre": "Juan Perez",
    "valorDeuda": 1500000,
    "estado": "EN MORA"
  }
}

---

# ⚠️ Manejo de errores

- 400 → Datos inválidos
- 404 → No encontrado
- 500 → Error interno del servidor

---

# 🐘 Base de datos (Docker)

- Host: db
- Puerto: 5432
- DB: tol
- User: postgres
- Password: 1234

---

# 📄 Script base de datos

Ejecutar archivo:
database.sql

---

# 🐳 Docker Architecture

Frontend (Postman)
   ↓
Tomcat (Servlet API)
   ↓
JDBC
   ↓
PostgreSQL (Docker)

---

# ⚙️ Variables de entorno

DB_URL=jdbc:postgresql://db:5432/tol  
DB_USER=postgres  
DB_PASSWORD=1234  

---

# 🐳 Docker commands

docker build -t tol-pagos-app .  
docker compose up -d  
docker compose down  

---

# 📁 Estructura del proyecto

tol_pagos/
 ├── src/main/java/
 ├── src/main/resources/
 ├── src/main/webapp/
 ├── database.sql
 ├── Dockerfile
 ├── docker-compose.yml
 ├── README.md
 └── postman/

---

# 🧠 Buenas prácticas

- Arquitectura en capas (Controller / Service / DAO)
- Manejo centralizado de excepciones
- Logging con Log4j
- Configuración externa
- Contenerización con Docker
- API REST con JSON estándar

---

# 👨‍💻 Autor

Prueba técnica - TOL (Trámites en Línea)
