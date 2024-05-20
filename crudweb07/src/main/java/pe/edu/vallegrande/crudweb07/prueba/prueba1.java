package pe.edu.vallegrande.crudweb07.prueba;

import pe.edu.vallegrande.crudweb07.dto.PersonaDto;
import pe.edu.vallegrande.crudweb07.service.PersonaService;

import java.util.List;
public class prueba1 {
    public static void main(String[] args) {
        // Proceso
        PersonaService service = new PersonaService();
        List<PersonaDto> lista = service.listar();
        // Reporte
        for(PersonaDto bean: lista){
            System.out.println(bean);
        }
    }
}
