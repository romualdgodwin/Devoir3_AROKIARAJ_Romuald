package Controlers;

import Entities.Consultation;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlConsultation
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlConsultation() {
        cnx = ConnexionBDD.getCnx();
    }

    public int getLastNumberOfConsultation()
    {
        int maxNumero = 0;

        // A vous de jouer
        try {
            ps = cnx.prepareStatement("select max(numConsult) from prescrire");
            rs = ps.executeQuery();
            rs.next();
            maxNumero = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return maxNumero;
    }
    public void InsertConsultation(int idConsult, String dateConsult, int numPatient,int numMedecin)
    {
        // A vous de jouer
        try {
            ps = cnx.prepareStatement("insert into consulation values(?,?,?,?)");
            ps.setInt(1, idConsult);
            ps.setString(2, dateConsult);
            ps.setInt(3, numPatient);
            ps.setInt(4, numPatient);
            ps.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
