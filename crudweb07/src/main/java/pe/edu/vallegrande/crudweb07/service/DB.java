package pe.edu.vallegrande.crudweb07.service;


import pe.edu.vallegrande.crudweb07.dto.PersonaDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class DB {
    private DB(){}

    static List<PersonaDto> personas;
    static int contador;

    static {
        personas = new ArrayList<>();
        // Agregar los datos de la tabla PERSONA
        personas.add(new PersonaDto("EMPLEADO", "Michaell", "Ibarra", "mz c lote 46", "michaell.ibarra@gmail.com", "97933393", LocalDate.parse("1990-05-15"), "DNI", "123456789012"));
        personas.add(new PersonaDto("CLIENTE", "Adolfo", "Berrocal", "adolfo.berrocal@vallegrande.edu.pe", "Dirección de Adolfo", "972740755", LocalDate.parse("1988-10-20"), "CNE", "987654321098"));
        personas.add(new PersonaDto("EMPLEADO", "Isael", "Fatama", "isael.fatama@vallegrande.edu.pe", "Dirección de Isael", "922843355", LocalDate.parse("1995-03-10"), "DNI", "456789012345"));
        personas.add(new PersonaDto("CLIENTE", "Luis", "Valle", "luis.valle@vallegrande.edu.pe", "Dirección de Luis", "985928062", LocalDate.parse("1992-07-18"), "CNE", "789012345678"));
        personas.add(new PersonaDto("EMPLEADO", "Gustavo", "Coronel", "gustavo@gmail.com", "Dirección de Gustavo", "984576876", LocalDate.parse("1987-12-25"), "DNI", "321098765432"));
        personas.add(new PersonaDto("EMPLEADO", "Deyton", "Garcia", "deyton.garcia@vallegrande.edu.pe", "Dirección de Deyton", "945328101", LocalDate.parse("1994-08-30"), "DNI", "234567890123"));
        personas.add(new PersonaDto("CLIENTE", "Jose", "Perez", "jose.perez@gmail.com", "Dirección de Jose", "987654321", LocalDate.parse("1980-06-05"), "CNE", "567890123456"));
        contador = 7; // Este valor se debe actualizar con el número de registros en la tabla PERSONA
    }

    }
