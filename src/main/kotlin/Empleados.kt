package org.empleados

// Clase abstracta Empleados
abstract class Empleados(
    val codigoEmpleados: Int,
    var numeroHorasExtra: Int,
    val fechaIngreso: String,
    val area: String,
    val cargo: String
)
