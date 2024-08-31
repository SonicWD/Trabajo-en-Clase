package org.paciente

data class Paciente(
    val dni: String,
    val nombre: String,
    val apellido: String
)

val pacientes: MutableList<Paciente> = mutableListOf()

fun agregarPaciente(paciente: Paciente) {
    pacientes.add(paciente)
    println("Paciente agregado: ${paciente.nombre} ${paciente.apellido}, DNI: ${paciente.dni}")
}

fun listarTodosLosPacientes() {
    if (pacientes.isNotEmpty()) {
        println("Lista de todos los pacientes:")
        pacientes.forEach { paciente ->
            println("  - ${paciente.nombre} ${paciente.apellido}, DNI: ${paciente.dni}")
        }
    } else {
        println("No hay pacientes registrados.")
    }
}

fun encontrarPacientePorDni(dni: String): Paciente? {
    return pacientes.find { it.dni == dni }
}

fun eliminarPacientePorDni(dni: String) {
    val paciente = encontrarPacientePorDni(dni)
    if (paciente != null) {
        pacientes.remove(paciente)
        println("Paciente con DNI $dni eliminado.")
    } else {
        println("No se encontró un paciente con el DNI $dni.")
    }
}
