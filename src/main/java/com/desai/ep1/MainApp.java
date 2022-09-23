package com.desai.ep1;
import java.sql.*;

public class MainApp {

    public static void main(String[] args) throws Exception {

        //Load Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Crear conexión.
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/DESAI_EP1",
                "root",
                "root"
        );

        //Listar registros - Statement
        Statement st = con.createStatement();

        //Ejecutar sentencia
        ResultSet st_resultado = st.executeQuery("SELECT * FROM EMPLEADOS");

        //Recorrer los resultados
        while (st_resultado.next()){
            System.out.println( st_resultado.getString("cod") + "\n"+
                    st_resultado.getString("nombre") + " "+
                    st_resultado.getString("apellido") + "\n"+
                    "Puesto: " + st_resultado.getString("puesto")+"\n"+
                    "Departamento: " + st_resultado.getString("depart"));
        }


        //Actualizar registros - Prepared Statement

        PreparedStatement pt = con.prepareStatement("update EMPLEADOS set nombre='Julio' where cod=?");
        pt.setInt(1,5);

        int filasActualizadas = pt.executeUpdate();

        System.out.println("Filas actualizadas: "+filasActualizadas);


        //Eliminar registros - CallableStatement

        CallableStatement cs = con.prepareCall("{call deleteDoc(?)}");
        cs.setString(1, "79053377");

        int filasEliminadas = cs.executeUpdate();
        System.out.println("Filas eliminadas: "+filasEliminadas);


        //Cerrar conexión
        con.close();

    }
}

