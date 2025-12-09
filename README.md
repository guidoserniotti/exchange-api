# Exchange API - Conversor Simple de Monedas

Aplicación de consola en Java que permite convertir entre diferentes monedas utilizando tasas de cambio en tiempo real a través de la API de ExchangeRate-API.

Este proyecto fue desarrollado como parte del **Challenge #2 - Exchange API** del curso **ONE (Oracle Next Education)**.

## Descripción General

Exchange API es un conversor de monedas interactivo que permite realizar conversiones entre Dólar estadounidense (USD), Peso Argentino (ARS), Real Brasileño (BRL) y Peso Colombiano (COP). La aplicación consume datos en tiempo real de la API de ExchangeRate-API y utiliza la librería Gson para el procesamiento de JSON.

### Características Principales

- ✅ Conversión en tiempo real entre 4 monedas diferentes
- ✅ Interfaz de consola intuitiva y fácil de usar
- ✅ Manejo de errores y validación de entrada
- ✅ Uso de variables de entorno para proteger la API Key
- ✅ Ejemplo de solicitud API incluido

## Instalación y Ejecución Local

### Requisitos Previos

- **Java JDK 11** o superior
- **Maven** (opcional, si se usa gestión de dependencias)
- Conexión a Internet para realizar las consultas a la API

### Dependencias Necesarias

El proyecto utiliza las siguientes librerías: 

```xml
<!-- Gson para procesamiento JSON -->
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>

<!-- Dotenv para manejo de variables de entorno -->
<dependency>
    <groupId>io.github.cdimascio</groupId>
    <artifactId>dotenv-java</artifactId>
    <version>3.0.0</version>
</dependency>
```

### Pasos de Instalación

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/guidoserniotti/exchange-api.git
   cd exchange-api
   ```

2. **Obtener una API Key:**
   - Visita [ExchangeRate-API](https://www.exchangerate-api.com/)
   - Regístrate y obtén tu API Key gratuita

3. **Configurar las variables de entorno:**
   - Copia el archivo `.env-example` y renómbralo a `.env`
   ```bash
   cp .env-example .env
   ```
   - Abre el archivo `.env` y reemplaza el valor con tu API Key: 
   ```
   API_KEY = "tu_api_key_aqui"
   ```

4. **Compilar el proyecto:**
   ```bash
   javac -cp ".:gson. jar: dotenv-java.jar" src/*.java
   ```

5. **Ejecutar la aplicación:**
   ```bash
   java -cp ".: gson.jar:dotenv-java.jar:src" Principal
   ```

## Estructura del Proyecto

```
exchange-api/
│
├── src/
│   ├── Principal.java              # Clase principal con el menú interactivo
│   ├── Conversor.java              # Clase que gestiona las conversiones
│   ├── Helper.java                 # Clase auxiliar con funciones de ayuda
│   └── ExchangeRateResponse.java   # Modelo de datos para la respuesta API
│
├── .env-example                    # Plantilla para variables de entorno
├── . gitignore                      # Archivos y carpetas ignoradas por Git
└── README.md                       # Este archivo
```

## Funcionalidad de Cada Clase

### `Principal.java`
**Propósito:** Clase principal que contiene el método `main` y gestiona la interfaz de usuario.

**Funcionalidades:**
- Muestra el menú interactivo con 8 opciones
- Captura la entrada del usuario
- Coordina las llamadas a las clases `Conversor` y `Helper`
- Maneja el flujo principal de la aplicación
- Implementa validación de opciones y manejo de excepciones

### `Conversor.java`
**Propósito:** Clase encargada de realizar las conversiones de moneda.

**Funcionalidades:**
- Método `convertir(String firstPair, String secondPair)`: Realiza la conversión entre dos monedas
- Carga la API Key desde las variables de entorno usando Dotenv
- Realiza peticiones HTTP a la API de ExchangeRate-API
- Procesa la respuesta JSON utilizando Gson
- Solicita al usuario la cantidad a convertir
- Calcula y devuelve el resultado de la conversión
- Maneja errores de conexión y respuestas inválidas

### `ExchangeRateResponse.java`
**Propósito:** Clase modelo (POJO) que representa la estructura de la respuesta JSON de la API. 

**Atributos:**
- `base_code`: Código de la moneda base
- `target_code`: Código de la moneda objetivo
- `conversion_rate`: Tasa de conversión entre las monedas
- `result`: Estado de la respuesta ("success" o error)

**Métodos:** Getters para acceder a los valores de los atributos privados.

### `Helper.java`
**Propósito:** Clase auxiliar que proporciona funciones de ayuda. 

**Funcionalidades:**
- Método `showApiReqExample()`: Muestra un ejemplo detallado de cómo funciona una solicitud a la API y su respuesta, ayudando a comprender el proceso de conversión

## Uso de la Aplicación

Al ejecutar la aplicación, verás un menú con las siguientes opciones:

```
**********************************************************************
1) Dólar -> Peso Argentino
2) Peso Argentino -> Dólar
3) Dólar -> Real Brasileño
4) Real Brasileño -> Dólar
5) Dólar -> Peso Colombiano
6) Peso Colombiano -> Dólar
7) Mostrar ejemplo de solicitud API
8) Salir
**********************************************************************
```

### Ejemplo de Conversión: 

1.  Selecciona una opción (por ejemplo:  `1` para convertir USD a ARS)
2. Ingresa la cantidad a convertir
3. La aplicación mostrará el resultado con el formato: 
   ```
   El valor 100.0 USD equivale a 143858.0 ARS
   ```

## Tecnologías Utilizadas

- **Java**:  Lenguaje de programación principal
- **HttpClient**: Para realizar peticiones HTTP
- **Gson**: Librería para parsear JSON
- **Dotenv-Java**:  Gestión de variables de entorno
- **ExchangeRate-API**: API externa para obtener tasas de cambio

## Autor

**Guido Serniotti**
- GitHub: [@guidoserniotti](https://github.com/guidoserniotti)
- LinkedIn: https://www.linkedin.com/in/guidoserniotti/
- Proyecto desarrollado como parte del programa **Oracle Next Education (ONE)**

---

## Licencia

Este proyecto es de código abierto y está disponible para fines educativos. 

---
