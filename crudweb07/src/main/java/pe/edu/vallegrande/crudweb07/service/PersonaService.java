package pe.edu.vallegrande.crudweb07.service;

import pe.edu.vallegrande.crudweb07.bd.AccesoDB;
import pe.edu.vallegrande.crudweb07.dto.PersonaDto;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonaService {

    public List<PersonaDto> listar() {
        List<PersonaDto> lista = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT id_persona, Tipo_persona, Nombres, Apellidos, Direccion, Gmail, Celular, Fecha_nacimiento, Tipo_documento, Numero_documento FROM PERSONA";
        try {
            cn = AccesoDB.getConnection();
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                PersonaDto bean = new PersonaDto();
                bean.setId(rs.getInt("id_persona"));
                bean.setTipoPersona(rs.getString("Tipo_persona"));
                bean.setNombres(rs.getString("Nombres"));
                bean.setApellidos(rs.getString("Apellidos"));
                bean.setDireccion(rs.getString("Direccion"));
                bean.setGmail(rs.getString("Gmail"));
                bean.setCelular(rs.getString("Celular"));
                bean.setFechaNacimiento(LocalDate.parse(rs.getString("Fecha_nacimiento"))); // Convertir String a LocalDate
                bean.setTipoDocumento(rs.getString("Tipo_documento"));
                bean.setNumeroDocumento(rs.getString("Numero_documento"));
                lista.add(bean);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            closeResources(cn, pstm, rs);
        }
        return lista;
    }

    public PersonaDto agregar(PersonaDto bean) {
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "INSERT INTO PERSONA(Tipo_persona, Nombres, Apellidos, Direccion, Gmail, Celular, Fecha_nacimiento, Tipo_documento, Numero_documento) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            cn = AccesoDB.getConnection();
            pstm = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, String.valueOf(bean.getTipoPersona()));
            pstm.setString(2, bean.getNombres());
            pstm.setString(3, bean.getApellidos());
            pstm.setString(4, bean.getDireccion());
            pstm.setString(5, bean.getGmail());
            pstm.setString(6, bean.getCelular());

// Convertir LocalDate a java.sql.Date para la fecha de nacimiento
            Date fechaNacimiento = Date.valueOf(bean.getFechaNacimiento());
            pstm.setDate(7, fechaNacimiento);

            pstm.setString(8, bean.getTipoDocumento());
            pstm.setString(9, bean.getNumeroDocumento());
            pstm.executeUpdate();
            rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                bean.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            closeResources(cn, pstm, rs);
        }
        return bean;
    }

    public void actualizar(PersonaDto bean) {
        Connection cn = null;
        PreparedStatement pstm = null;
        String sql = "UPDATE PERSONA SET Tipo_persona=?, Nombres=?, Apellidos=?, Direccion=?, Gmail=?, Celular=?, Fecha_nacimiento=?, Tipo_documento=?, Numero_documento=? WHERE id_persona=?";
        try {
            cn = AccesoDB.getConnection();
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, String.valueOf(bean.getTipoPersona()));
            pstm.setString(2, bean.getNombres());
            pstm.setString(3, bean.getApellidos());
            pstm.setString(4, bean.getDireccion());
            pstm.setString(5, bean.getGmail());
            pstm.setString(6, bean.getCelular());
            pstm.setDate(7, Date.valueOf(bean.getFechaNacimiento())); // Convertir LocalDate a java.sql.Date
            pstm.setString(8, bean.getTipoDocumento());
            pstm.setString(9, bean.getNumeroDocumento());
            pstm.setInt(10, bean.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            closeResources(cn, pstm, null);
        }
    }

    public void eliminar(int id) {
        Connection cn = null;
        PreparedStatement pstm = null;
        String sql = "DELETE FROM PERSONA WHERE id_persona=?";
        try {
            cn = AccesoDB.getConnection();
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            closeResources(cn, pstm, null);
        }

    }

    // Método utilitario para cerrar recursos JDBC
    private void closeResources(Connection cn, PreparedStatement pstm, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            // Manejo de errores al cerrar recursos
        }


    }



}
