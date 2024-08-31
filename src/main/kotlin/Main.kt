import org.empleados.*
import org.planilla.Planilla
import org.paciente.*
import org.paciente.Paciente
import org.planilla.agregarEmpleadoPlanilla
import org.planilla.eliminarEmpleadoPlanillaPorCodigo
import org.planilla.listarTodosLosEmpleadosPlanilla

fun main() {
    while (true) {
        println("==========================================")
        println("          Bienvenido al Sistema           ")
        println("==========================================")
        println("Seleccione una opción del menú:")
        println("1. Agregar Empleado Eventual")
        println("2. Agregar Empleado de Planilla")
        println("3. Registrar Cita Médica")
        println("4. Listar Médicos por Especialidad")
        println("5. Listar Pacientes Atendidos por Médico")
        println("6. Registrar Paciente")
        println("7. Listar Todos los Pacientes")
        println("8. Eliminar Paciente por DNI")
        println("9. Listar Todos los Empleados Eventuales")
        println("10. Eliminar Empleado Eventual por Código")
        println("11. Listar Todos los Empleados de Planilla")
        println("12. Eliminar Empleado de Planilla por Código")
        println("13. Salir")
        println("==========================================")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("==> Agregar Empleado Eventual")
                println("Ingrese los siguientes datos:")
                print("Código de Empleado: ")
                val codigoEmpleados = readLine()?.toIntOrNull() ?: continue
                print("Número de Horas Extra: ")
                val numeroHorasExtra = readLine()?.toIntOrNull() ?: continue
                print("Fecha de Ingreso (dd/mm/yyyy): ")
                val fechaIngreso = readLine() ?: continue
                print("Área: ")
                val area = readLine() ?: continue
                print("Cargo: ")
                val cargo = readLine() ?: continue
                print("Honorarios por Hora: ")
                val honorariosxHora = readLine()?.toIntOrNull() ?: continue
                print("Número Total de Horas Trabajadas: ")
                val numeroTotalesHorasTrabajadas = readLine()?.toIntOrNull() ?: continue
                print("Fecha de Término del Contrato (dd/mm/yyyy): ")
                val fechaTerminoContrato = readLine() ?: continue

                val eventual = Eventual(honorariosxHora, numeroTotalesHorasTrabajadas, fechaTerminoContrato, codigoEmpleados, numeroHorasExtra, fechaIngreso, area, cargo)
                agregarEventual(eventual)
                println("Empleado Eventual agregado exitosamente.")
            }
            2 -> {
                println("==> Agregar Empleado de Planilla")
                println("Ingrese los siguientes datos:")
                print("Código de Empleado: ")
                val codigoEmpleados = readLine()?.toIntOrNull() ?: continue
                print("Número de Horas Extra: ")
                val numeroHorasExtra = readLine()?.toIntOrNull() ?: continue
                print("Fecha de Ingreso (dd/mm/yyyy): ")
                val fechaIngreso = readLine() ?: continue
                print("Área: ")
                val area = readLine() ?: continue
                print("Cargo: ")
                val cargo = readLine() ?: continue
                print("Salario Mensual: ")
                val salarioMensual = readLine()?.toIntOrNull() ?: continue
                print("Porcentaje Adicional por Hora Extra: ")
                val porcentajeAdicionalxHora = readLine()?.toFloatOrNull() ?: continue

                val planilla = Planilla(salarioMensual, porcentajeAdicionalxHora, codigoEmpleados, numeroHorasExtra, fechaIngreso, area, cargo)
                agregarEmpleadoPlanilla(planilla)
                println("Empleado de Planilla agregado exitosamente.")
            }
            3 -> {
                println("==> Registrar Cita Médica")
                println("Ingrese los siguientes datos:")
                print("DNI del Paciente: ")
                val dniPaciente = readLine() ?: continue

                // Buscar el paciente en la lista
                var paciente = pacientes.find { it.dni == dniPaciente }

                // Si no existe, instanciar uno nuevo
                if (paciente == null) {
                    println("Paciente no encontrado. Ingrese los datos del paciente.")
                    print("Nombre del Paciente: ")
                    val nombrePaciente = readLine() ?: continue
                    print("Apellido del Paciente: ")
                    val apellidoPaciente = readLine() ?: continue

                    // Crear e agregar a la lista
                    paciente = Paciente(dniPaciente, nombrePaciente, apellidoPaciente)
                    agregarPaciente(paciente) // Agrega el paciente a la lista
                }

                print("Código del Médico: ")
                val codigoMedico = readLine()?.toIntOrNull() ?: continue
                print("Fecha de la Cita (dd/mm/yyyy): ")
                val fechaCita = readLine() ?: continue
                print("Hora de la Cita (HH:mm): ")
                val horaCita = readLine() ?: continue

                // Buscar el médico
                val medico = medicos.find { it.codigoEmpleados == codigoMedico }

                if (medico != null) {
                    registrarCitaMedica(paciente, medico, fechaCita, horaCita)
                    println("Cita médica registrada exitosamente.")
                } else {
                    println("Error: Médico no encontrado.")
                }
            }
            4 -> {
                println("==> Listar Médicos por Especialidad")
                println("Ingrese la especialidad del médico:")
                Especialidad.values().forEachIndexed { index, especialidad ->
                    println("${index + 1}. ${especialidad.name}")
                }
                val opcionEspecialidad = readLine()?.toIntOrNull()
                val especialidadSeleccionada = if (opcionEspecialidad != null && opcionEspecialidad in 1..Especialidad.values().size) {
                    Especialidad.values()[opcionEspecialidad - 1]
                } else {
                    println("Especialidad no válida.")
                    continue
                }
                listarMedicosPorEspecialidad(especialidadSeleccionada)
            }
            5 -> {
                println("==> Listar Pacientes Atendidos por Médico")
                print("Ingrese el código del médico: ")
                val codigoMedico = readLine()?.toIntOrNull() ?: continue
                listarPacientesPorMedico(codigoMedico)
            }
            6 -> {
                println("==> Registrar Paciente")
                println("Ingrese los siguientes datos:")
                print("DNI: ")
                val dni = readLine() ?: continue
                print("Nombre: ")
                val nombre = readLine() ?: continue
                print("Apellido: ")
                val apellido = readLine() ?: continue

                val paciente = Paciente(dni, nombre, apellido)
                agregarPaciente(paciente)
                println("Paciente registrado exitosamente.")
            }
            7 -> {
                println("==> Listar Todos los Pacientes")
                listarTodosLosPacientes()
            }
            8 -> {
                println("==> Eliminar Paciente por DNI")
                print("Ingrese el DNI del paciente a eliminar: ")
                val dni = readLine() ?: continue
                eliminarPacientePorDni(dni)
            }
            9 -> {
                println("==> Listar Todos los Empleados Eventuales")
                listarTodosLosEventuales()
            }
            10 -> {
                println("==> Eliminar Empleado Eventual por Código")
                print("Ingrese el código del empleado eventual a eliminar: ")
                val codigo = readLine()?.toIntOrNull() ?: continue
                eliminarEventualPorCodigo(codigo)
            }
            11 -> {
                println("==> Listar Todos los Empleados de Planilla")
                listarTodosLosEmpleadosPlanilla()
            }
            12 -> {
                println("==> Eliminar Empleado de Planilla por Código")
                print("Ingrese el código del empleado de planilla a eliminar: ")
                val codigo = readLine()?.toIntOrNull() ?: continue
                eliminarEmpleadoPlanillaPorCodigo(codigo)
            }
            13 -> {
                println("Gracias por usar el sistema. ¡Hasta luego!")
                break
            }
            else -> {
                println("Opción no válida. Por favor, intente nuevamente.")
            }
        }
        println("Presione Enter para continuar...")
        readLine()
    }
}
