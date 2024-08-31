# Proyecto de Gestión Hospitalaria

Este ejercicio en clase está diseñado para gestionar la información de pacientes dentro de un sistema hospitalario. Incluye clases para manejar la información de los pacientes, junto con funcionalidades para agregar, listar, buscar y eliminar pacientes por su DNI.

## Estructura del Proyecto

El proyecto está organizado en diferentes paquetes para separar las responsabilidades de cada módulo:

- `org.paciente`: Contiene la clase `Paciente` y las funciones relacionadas para la gestión de pacientes.
- `org.hospital`: Contiene la clase `Hospital`, que interactúa con la información de los pacientes.

## Problema Encontrado

### Descripción del Error

Al intentar compilar y ejecutar el proyecto, me encontré con el siguiente error:

```plaintext
Type mismatch.
Required:
org.empleados.Paciente
Found:
org.paciente.Paciente
```
No pude solucionarlo y entiendo que es porque no se esta llamando el objeto, pero ya lo intente y al parecer es error de las importaciones. 