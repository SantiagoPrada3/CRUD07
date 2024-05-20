package pe.edu.vallegrande.crudweb07.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.vallegrande.crudweb07.dto.PersonaDto;
import pe.edu.vallegrande.crudweb07.service.PersonaService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet({"/ContGetAll", "/ContProcesar", "/ContEliminar"})
public class PersonaController extends HttpServlet {

    private final PersonaService personaService = new PersonaService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String path = request.getServletPath();
        switch (path) {
            case "/ContGetAll":
                contGetAll(request, response);
                break;
            case "/ContProcesar":
                contProcesar(request, response);
                break;
            case "/ContEliminar":
                contEliminar(request, response);
                break;
        }
    }

    private void contProcesar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int accion = Integer.parseInt(request.getParameter("accion"));
        switch (accion) {
            case 1:
            case 2:
                agregarOActualizar(request, response);
                break;
        }
    }

    private void agregarOActualizar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Obtener parámetros del formulario
        int id = Integer.parseInt(request.getParameter("id"));
        String tipoPersona = request.getParameter("tipoPersona");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String celular = request.getParameter("celular");
        String fechaNacimientoParam = request.getParameter("fechaNacimiento");
        LocalDate fechaNacimiento = fechaNacimientoParam != null && !fechaNacimientoParam.isEmpty() ?
                LocalDate.parse(fechaNacimientoParam) : null;
        String tipoDocumento = request.getParameter("tipoDocumento");
        String numeroDocumento = request.getParameter("numeroDocumento");

        // Crear objeto PersonaDto con los datos del formulario
        PersonaDto personaDto = new PersonaDto(id, tipoPersona, nombres, apellidos, direccion, correo,
                celular, fechaNacimiento, tipoDocumento, numeroDocumento);

        // Verificar si el ID es igual a 0
        // Si es 0, significa que se está agregando un nuevo usuario
        // Si no es 0, significa que se está actualizando un usuario existente
        if (id == 0) {
            // Llamar al servicio para agregar la persona
            personaService.agregar(personaDto);
        } else {
            // Llamar al servicio para actualizar la persona
            personaService.actualizar(personaDto);
        }

        // Redireccionar a la página de lista de personas
        response.sendRedirect(request.getContextPath() + "/ContGetAll");
    }


    private void contGetAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener lista de personas
        List<PersonaDto> lista = personaService.listar();

        // Setear lista en el request
        request.setAttribute("lista", lista);

        // Redireccionar a la página de lista de personas
        RequestDispatcher rd = request.getRequestDispatcher("Persona.jsp");
        rd.forward(request, response);
    }

    private void contEliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Obtener ID de la persona a eliminar
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);

            // Llamar al servicio para eliminar la persona
            personaService.eliminar(id);

            // Redireccionar a la página de lista de personas
            response.sendRedirect(request.getContextPath() + "/ContGetAll");
        }
    }
}

