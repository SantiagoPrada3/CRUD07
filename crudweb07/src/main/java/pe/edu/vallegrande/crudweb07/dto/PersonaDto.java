package pe.edu.vallegrande.crudweb07.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class PersonaDto {

    private int id;
    private String tipoPersona;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String gmail;
    private String celular;
    private LocalDate fechaNacimiento;
    private String tipoDocumento;
    private String numeroDocumento;

    public PersonaDto(String tipoPersona, String nombres, String apellidos, String direccion, String gmail, String celular, LocalDate fechaNacimiento, String tipoDocumento, String numeroDocumento) {
        this.tipoPersona = tipoPersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.gmail = gmail;
        this.celular = celular;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }



}