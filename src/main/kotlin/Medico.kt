package org.empleados

// Lista de médicos
val medicos: MutableList<Medico> = mutableListOf()

// Lista de citas médicas
val citasMedicas: MutableList<CitaMedica> = mutableListOf()

// Clase Paciente
data class Paciente(
    val dni: String,
    val nombre: String,
    val apellido: String,
    val fechaNacimiento: String,
    val direccion: String,
    val ciudadProcedencia: String,
    val numeroHistoriaClinica: Int,
    val sexo: String,
    val grupoSanguineo: String,
    val medicamentosAlergicos: List<String>
)

// Clase Medico que extiende Empleados
open class Medico(
    val especialidad: Especialidad,
    val servicio: Servicio,
    val numeroDeConsultorio: Int,
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

// Clase CitaMedica
data class CitaMedica(
    val paciente: Paciente,
    val medico: Medico,
    val fecha: String,
    val hora: String
)

// Enum para Especialidad
enum class Especialidad {
    CIRUJANO,
    OFTALMOLOGO,
    PEDIATRA,
    CARDIOLOGO,
    GINECOLOGO,
    NEUROLOGO,
    DERMATOLOGO,
    PSIQUIATRA,
    ORTOPEDISTA,
    UROLOGO
}

// Enum para Servicio
enum class Servicio {
    CIRUGIA,
    OFTALMOLOGIA,
    PEDIATRIA,
    CARDIOLOGIA,
    GINECOLOGIA,
    NEUROLOGIA,
    DERMATOLOGIA,
    PSIQUIATRIA,
    ORTOPEDIA,
    UROLOGIA
}

// Función para agregar un médico a la lista
fun agregarMedico(medico: Medico) {
    medicos.add(medico)
    println("Médico agregado: ${medico.cargo} en especialidad ${medico.especialidad}")
}

// Función para listar médicos por especialidad
fun listarMedicosPorEspecialidad(especialidad: Especialidad) {
    val medicosEspecialidad = medicos.filter { it.especialidad == especialidad }
    if (medicosEspecialidad.isNotEmpty()) {
        println("Médicos con especialidad ${especialidad.name}:")
        medicosEspecialidad.forEach { medico ->
            println("  - ${medico.cargo}, Consultorio: ${medico.numeroDeConsultorio}")
        }
    } else {
        println("No hay médicos con la especialidad ${especialidad.name}.")
    }
}

// Función para listar todos los médicos
fun listarTodosLosMedicos() {
    if (medicos.isNotEmpty()) {
        println("Lista de todos los médicos:")
        medicos.forEach { medico ->
            println("  - ${medico.cargo} (${medico.especialidad}) en servicio ${medico.servicio}, consultorio ${medico.numeroDeConsultorio}")
        }
    } else {
        println("No hay médicos registrados.")
    }
}

// Función para encontrar un médico por su código
fun encontrarMedicoPorCodigo(codigo: Int): Medico? {
    return medicos.find { it.codigoEmpleados == codigo }
}

// Función para eliminar un médico por su código
fun eliminarMedicoPorCodigo(codigo: Int) {
    val medico = encontrarMedicoPorCodigo(codigo)
    if (medico != null) {
        medicos.remove(medico)
        println("Médico con código $codigo eliminado.")
    } else {
        println("No se encontró un médico con el código $codigo.")
    }
}

// Función para registrar una cita médica
fun registrarCitaMedica(paciente: Paciente, medico: Medico, fecha: String, hora: String) {
    val cita = CitaMedica(paciente, medico, fecha, hora)
    citasMedicas.add(cita)
    println("Cita médica registrada: Paciente ${paciente.nombre} ${paciente.apellido}, Médico ${medico.cargo}, Fecha: $fecha, Hora: $hora")
}


// Función para listar pacientes atendidos por un médico
fun listarPacientesPorMedico(codigoMedico: Int) {
    val medico = encontrarMedicoPorCodigo(codigoMedico)
    if (medico != null) {
        val pacientesAtendidos = citasMedicas.filter { it.medico == medico }.map { it.paciente }
        if (pacientesAtendidos.isNotEmpty()) {
            println("Pacientes atendidos por el médico con código $codigoMedico:")
            pacientesAtendidos.forEach { paciente ->
                println("  - ${paciente.nombre} ${paciente.apellido}")
            }
        } else {
            println("No hay pacientes atendidos por el médico con código $codigoMedico.")
        }
    } else {
        println("No se encontró un médico con el código $codigoMedico.")
    }
}
