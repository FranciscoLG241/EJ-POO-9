

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


data class Tarea(
    val id: Int,
    val descripcion: String,
    var estado: String
)



class GestionTareas {
    private val tareas = mutableListOf<Tarea>()


    fun agregarTarea(id: Int, descripcion: String) {
        val nuevaTarea = Tarea(id = id, descripcion = descripcion, estado = "Pendiente")
        tareas.add(nuevaTarea)
        println("Tarea agregada: ${nuevaTarea.descripcion}")
    }



    fun eliminarTarea(id: Int) {
        val tarea = tareas.find { it.id == id }
        if (tarea != null) {
            tareas.remove(tarea)
            println("Tarea eliminada: ${tarea.descripcion}")
        } else {
            println("No se encontró una tarea con el ID $id")
        }
    }



    fun cambiarEstadoTarea(id: Int) {
        val tarea = tareas.find { it.id == id }
        if (tarea != null) {
            if (tarea.estado == "Pendiente") {
                tarea.estado = "Realizada"
                println("Tarea marcada como realizada: ${tarea.descripcion}")
            } else {
                println("La tarea ya está marcada como realizada.")
            }
        } else {
            println("No se encontró una tarea con el ID $id")
        }
    }




    fun mostrarTodasLasTareas() {
        if (tareas.isEmpty()) {
            println("No hay tareas disponibles.")
        } else {
            println("Lista de todas las tareas:")
            tareas.forEach {
                println("ID: ${it.id}, Descripción: ${it.descripcion}, Estado: ${it.estado}")
            }
        }
    }



    fun mostrarTareasPendientes() {
        val pendientes = tareas.filter { it.estado == "Pendiente" }
        if (pendientes.isEmpty()) {
            println("No hay tareas pendientes.")
        } else {
            println("Lista de tareas pendientes:")
            pendientes.forEach {
                println("ID: ${it.id}, Descripción: ${it.descripcion}")
            }
        }
    }



    fun mostrarTareasRealizadas() {
        val realizadas = tareas.filter { it.estado == "Realizada" }
        if (realizadas.isEmpty()) {
            println("No hay tareas realizadas.")
        } else {
            println("Lista de tareas realizadas:")
            realizadas.forEach {
                println("ID: ${it.id}, Descripción: ${it.descripcion}")
            }
        }
    }
}

fun main() {
    val gestionTareas = GestionTareas()


    while (true) {
        println("\n--- Menú de Gestión de Tareas ---")
        println("1. Agregar tarea")
        println("2. Eliminar tarea")
        println("3. Cambiar estado de tarea")
        println("4. Mostrar todas las tareas")
        println("5. Mostrar tareas pendientes")
        println("6. Mostrar tareas realizadas")
        println("7. Salir")
        print("Selecciona una opción: ")

        when (readLine()) {
            "1" -> {
                print("Ingresa el ID de la nueva tarea: ")
                val id = readLine()?.toIntOrNull() ?: 0
                print("Ingresa la descripción de la nueva tarea: ")
                val descripcion = readLine() ?: ""
                gestionTareas.agregarTarea(id, descripcion)
            }


            "2" -> {
                print("Ingresa el ID de la tarea a eliminar: ")
                val id = readLine()?.toIntOrNull() ?: 0
                gestionTareas.eliminarTarea(id)
            }


            "3" -> {
                print("Ingresa el ID de la tarea a cambiar de estado: ")
                val id = readLine()?.toIntOrNull() ?: 0
                gestionTareas.cambiarEstadoTarea(id)
            }


            "4" -> gestionTareas.mostrarTodasLasTareas()

            "5" -> gestionTareas.mostrarTareasPendientes()

            "6" -> gestionTareas.mostrarTareasRealizadas()

            "7" -> {
                println("¡Hasta luego!")
                break
            }
            else -> println("Opción no válida.")
        }
    }
}

