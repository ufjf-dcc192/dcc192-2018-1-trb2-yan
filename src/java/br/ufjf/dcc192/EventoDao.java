package br.ufjf.dcc192;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventoDao {

    private static EventoDao instancia;
    private static Connection conexao;

    public static EventoDao getInstace() {
        if (instancia == null) {
            instancia = new EventoDao();
        }
        return instancia;
    }

    public EventoDao() {
        try {
            if (conexao == null) {
                conexao = DriverManager.
                        getConnection("jdbc:derby://localhost:1527/testeSQLTrab2",
                                "usuario", "usuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Evento> listAll() {
        List<Evento> eventos = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT * from EVENTO");
            while (resultado.next()) {
                Evento evento = new Evento();
                evento.setTitulo(resultado.getString("TITULO"));
                evento.setMinimo(resultado.getDouble("MINIMO"));
                evento.setDataEvento(resultado.getDate("DATAEVENTO"));
                evento.setDataSorteio(resultado.getDate("SORTEIO"));
                evento.setId(resultado.getString("CODIGO"));
                eventos.add(evento);

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return eventos;

    }

    

    void delete(String id) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM Evento WHERE Codigo=%S",
                    id));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addEvento(Evento e) {
        try {
            Statement comando = conexao.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            
            
             comando.executeUpdate("INSERT INTO EVENTO(CODIGO,TITULO,MINIMO,DATAEVENTO,SORTEIO) VALUES('"+e.getId()+"','"+e.getTitulo()+"'," + e.getMinimo() 
                     + ",'"+ sdf.format(e.getDataEvento())+"','"+sdf.format(e.getDataSorteio())+"')");
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
