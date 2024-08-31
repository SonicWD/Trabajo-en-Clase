package org.empleados

val eventuales: MutableList<Eventual> = mutableListOf()

open class Eventual(
    val honorariosPorHora: Int,
    val numeroTotalesHorasTrabajadas: Int,
    val fechaTerminoContrato: String,
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

fun agregarEventual(eventual: Eventual) {
    eventuales.add(eventual)
    println("Empleado eventual agregado: ${eventual.cargo} en el área ${eventual.area}")
}

fun listarTodosLosEventuales() {
    if (eventuales.isNotEmpty()) {
        println("Lista de todos los empleados eventuales:")
        eventuales.forEach { eventual ->
            println("  - ${eventual.cargo} en el área ${eventual.area}, código: ${eventual.codigoEmpleados}, honorarios por hora: ${eventual.honorariosPorHora}, horas trabajadas: ${eventual.numeroTotalesHorasTrabajadas}, fecha de término de contrato: ${eventual.fechaTerminoContrato}")
        }
    } else {
        println("No hay empleados eventuales registrados.")
    }
}

fun encontrarEventualPorCodigo(codigo: Int): Eventual? {
    return eventuales.find { it.codigoEmpleados == codigo }
}

fun eliminarEventualPorCodigo(codigo: Int) {
    val eventual = encontrarEventualPorCodigo(codigo)
    if (eventual != null) {
        eventuales.remove(eventual)
        println("Empleado eventual con código $codigo eliminado.")
    } else {
        println("No se encontró un empleado eventual con el código $codigo.")
    }
}
