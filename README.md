# Automatización SauceDemo - Menú de Navegación

## Equipo

- Sebastian Aristizabal
- Juan Sebastian Munoz

## Módulo

Calidad de Software - Universidad de Antioquia
Semestre 2025-1

## Página Automatizada

**SauceDemo**: https://www.saucedemo.com/

- Aplicación demo de e-commerce
- Utilizada para prácticas de automatización
- Provee diferentes tipos de usuarios y funcionalidades

## Descripción

Este proyecto implementa pruebas automatizadas para el menú de navegación de SauceDemo utilizando Serenity BDD con el patrón Screenplay.

## Retos y Problemas Enfrentados

1. **Ventanas Emergentes de Chrome**:

   - Problema: Popups bloqueando la navegación
   - Solución: Configuración específica en serenity.properties para manejar ventanas emergentes

2. **Navegación a About**:

   - Problema: Manejo de múltiples ventanas/pestañas
   - Solución: Simplificación de la validación para verificar solo la URL

3. **Reset App State**:

   - Problema: La funcionalidad no opera como se espera en la aplicación
   - Solución: Adaptación de las pruebas para validar el comportamiento actual

4. **Configuración del Proyecto**:
   - Problema: Gestión de dependencias y versiones
   - Solución: Configuración específica en build.gradle y serenity.properties

## Estructura del Proyecto

```
src/
├── main/java/co/edu/udea/certificacion/menu/
│   ├── interactions/      # Acciones atómicas
│   ├── questions/         # Validaciones
│   ├── tasks/            # Tareas compuestas
│   └── userinterfaces/   # Localizadores de elementos
└── test/
    ├── java/.../stepdefinitions/  # Definiciones de pasos
    └── resources/features/         # Archivos feature
```

## Escenarios Implementados

### 1. Navegación a About

- Verifica la navegación exitosa a la sección About
- Valida que la URL contenga "saucelabs.com"

### 2. Cerrar Sesión

- Verifica el proceso de logout
- Valida el retorno a la página de login

### 3. Reset App State

- Agrega un producto al carrito
- Intenta resetear el estado
- Valida el comportamiento actual (el reset no funciona como se espera)

## Tecnologías Utilizadas

- Serenity BDD
- Cucumber
- Selenium WebDriver
- Gradle
- Java

## Patrón de Diseño

El proyecto utiliza el patrón Screenplay, que organiza el código en:

- **Interactions**: Acciones básicas como clicks y entradas de texto
- **Tasks**: Agrupaciones de interacciones que forman una tarea completa
- **Questions**: Validaciones del estado de la aplicación
- **User Interfaces**: Mapeo de elementos de la página

## Configuración

La configuración principal se encuentra en:

- `serenity.properties`: Configuración de Serenity y WebDriver
- `build.gradle`: Dependencias y configuración del proyecto

## Ejecución

Para ejecutar las pruebas:

```bash
./gradlew clean test
```

## Notas

- El proyecto usa el usuario "standard_user" para las pruebas
- Se identificó que la funcionalidad de Reset App State no funciona como se espera
- Las pruebas están configuradas para ejecutarse en Chrome
