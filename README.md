### **Ejercicio 4.9**

   1. Realizar un programa para gestionar una Lista de tareas con POO.

   2. El programa debe mostrar un menú en el que se pueda agregar (por defecto una nueva tarea tendrá el estado pendiente), eliminar y cambiar el estado de una tarea. También será posible mostrar la lista de tareas (todas las tareas), mostrar la lista de tareas pendientes y la lista de tareas ya realizadas.

   3. Una tarea debe tener un identificador (podrá indicarlo o generarlo automáticamente), una descripción y un estado que indique si está pendiente o ya fue realizada (en este caso, deberá mostrar la fecha, con formato DD-MM-AAAA HH:MM:SS, en la que se marcó cómo realizada)

   4. Os muestro un ejemplo de cómo generar una fecha:

      ```
      import java.time.LocalDateTime
      import java.time.format.DateTimeFormatter
      fun main() {
          val fechaHoraActual: LocalDateTime = LocalDateTime.now()
          // Formatear la fecha y hora para imprimir
          val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
          val fechaFormateada: String = fechaHoraActual.format(formatter)
          println("Fecha y Hora Actual: $fechaFormateada")
