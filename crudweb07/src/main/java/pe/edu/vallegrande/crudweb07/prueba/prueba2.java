package pe.edu.vallegrande.crudweb07.prueba;

import pe.edu.vallegrande.crudweb07.dto.PersonaDto;
import pe.edu.vallegrande.crudweb07.service.PersonaService;

public class prueba2 {

        public static void main(String[] args) {
            // Proceso
            PersonaService service = new PersonaService();
            PersonaDto bean = service.agregar(new PersonaDto());
            // Reporte
            System.out.println(bean);
        }
    }
