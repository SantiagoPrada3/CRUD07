package pe.edu.vallegrande.crudweb07.prueba;

import pe.edu.vallegrande.crudweb07.dto.PersonaDto;
import pe.edu.vallegrande.crudweb07.service.PersonaService;

import java.time.LocalDate;

public class prueba4 {
        public static void main(String[] args) {
            try {
                // Datos de la persona
                String tipoPersona = "EMPLEADO";
                String nombres = "Luis";
                String apellidos = "Palomino";
                String direccion = "Dirección de Luis Palomino";
                String correo = "luis@gmail.com";
                String celular = "997722881";
                LocalDate fechaNacimiento = LocalDate.of(1990, 1, 1);
                String tipoDocumento = "DNI";
                String numeroDocumento = "123456789012";

                // Crear el objeto de la persona
                PersonaDto bean = new PersonaDto(tipoPersona, nombres, apellidos, direccion, correo,
                        celular, fechaNacimiento, tipoDocumento, numeroDocumento);

                // Proceso: Crear la persona en el servicio
                PersonaService service = new PersonaService();
                bean = service.agregar(bean);

                // Reporte: Mostrar la información de la persona creada
                System.out.println("Persona creada exitosamente:");
                System.out.println("ID: " + bean.getId());
                System.out.println("Tipo de persona: " + bean.getTipoPersona());
                System.out.println("Nombres: " + bean.getNombres());
                System.out.println("Apellidos: " + bean.getApellidos());
                System.out.println("Dirección: " + bean.getDireccion());
                System.out.println("Gmail: " + bean.getGmail());
                System.out.println("Celular: " + bean.getCelular());
                System.out.println("Fecha de nacimiento: " + bean.getFechaNacimiento());
                System.out.println("Tipo de documento: " + bean.getTipoDocumento());
                System.out.println("Número de documento: " + bean.getNumeroDocumento());
            } catch (RuntimeException e) {
                System.err.println("Error al crear la persona: " + e.getMessage());
            }
        }
    }


