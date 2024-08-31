package org.planilla

import org.empleados.Empleados

val empleadosPlanilla: MutableList<Planilla> = mutableListOf()

open class Planilla(
    val salarioMensual: Int,
    val porcentajeAdicionalHoraExtra: Float,
    codigoEmpleados: Int,
    numeroHorasExtra: Int,
    fechaIngreso: String,
    area: String,
    cargo: String
) : Empleados(
    codigoEmpleados,
    numeroHorasExtra,
    fechaIngreso,
    area,
    cargo
)

fun agregarEmpleadoPlanilla(planilla: Planilla) {
    empleadosPlanilla.add(planilla)
    println("Empleado de planilla agregado: ${planilla.cargo} en el área ${planilla.area}")
}

fun listarTodosLosEmpleadosPlanilla() {
    if (empleadosPlanilla.isNotEmpty()) {
        println("Lista de todos los empleados de planilla:")
        empleadosPlanilla.forEach { planilla ->
            println("  - ${planilla.cargo} en el área ${planilla.area}, código: ${planilla.codigoEmpleados}, salario mensual: ${planilla.salarioMensual}, porcentaje adicional por hora extra: ${planilla.porcentajeAdicionalHoraExtra}")
        }
    } else {
        println("No hay empleados de planilla registrados.")
    }
}

fun encontrarEmpleadoPlanillaPorCodigo(codigo: Int): Planilla? {
    return empleadosPlanilla.find { it.codigoEmpleados == codigo }
}

fun eliminarEmpleadoPlanillaPorCodigo(codigo: Int) {
    val planilla = encontrarEmpleadoPlanillaPorCodigo(codigo)
    if (planilla != null) {
        empleadosPlanilla.remove(planilla)
        println("Empleado de planilla con código $codigo eliminado.")
    } else {
        println("No se encontró un empleado de planilla con el código $codigo.")
    }
}
