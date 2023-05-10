package Controlers;

import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlMedecin
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlMedecin() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<String> getAllMedecins()
    {
        ArrayList<String> lesMedecins = new ArrayList<>();

        // A vous de jouer
        try {
            ps = cnx.prepareStatement("SELECT  nomMedecin FROM medecin");
            rs = ps.executeQuery();

            while (rs.next()){
                String unmedecin = rs.getString(1);
                lesMedecins.add(unmedecin);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lesMedecins;
    }

    public int getIdMedecinByName(String nomMed)
    {
        int numMed = 0;

        // A vous de jouer
        try {
            ps = cnx.prepareStatement("select idMedecin from medecin where nomMedecin = ?");
            ps.setString(1, nomMed);
            rs = ps.executeQuery();
            rs.next();
            numMed = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return numMed;
    }
}
