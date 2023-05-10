package Vues;

import Controlers.*;
import Tools.ConnexionBDD;
import Tools.ModelJTable;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.event.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;


public class FrmPrescrire extends JFrame
{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblNumero;
    private JLabel lblDate;
    private JLabel lblNomMedecin;
    private JTextField txtNumeroConsultation;
    private JComboBox cboPatients;
    private JComboBox cboMedecins;
    private JButton btnInserer;
    private JTable tblMedicaments;
    private JPanel pnlDate;
    private JLabel lblNomPatient;
    private JLabel lblMedicaments;
    private JDateChooser dcDateConsultation;

    CtrlConsultation ctrlConsultation;
    CtrlMedecin ctrlMedecin;
    CtrlPatient ctrlPatient;
    CtrlMedicament ctrlMedicament;
    CtrlPrescrire ctrlPrescrire;

    ModelJTable mdl;

    public FrmPrescrire() throws SQLException, ClassNotFoundException {
        this.setTitle("Prescrire");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ConnexionBDD maCnx = new ConnexionBDD();

        ctrlConsultation = new CtrlConsultation();
        ctrlMedecin = new CtrlMedecin();
        ctrlPrescrire = new CtrlPrescrire();
        ctrlMedicament = new CtrlMedicament();
        ctrlPatient = new CtrlPatient();
        //ctrlVignette = new CtrlVignette();





            // Gestion de la date : ne pas supprimer les 3 lignes de code
            dcDateConsultation = new JDateChooser();
            dcDateConsultation.setDateFormatString("yyyy-MM-dd");
            pnlDate.add(dcDateConsultation);

            // A vous de jouer

        txtNumeroConsultation.setText(String.valueOf(ctrlConsultation.getLastNumberOfConsultation()+1));

        for (String medecin : ctrlMedecin.getAllMedecins())
        {
            cboMedecins.addItem(medecin);
        }

        for (String patient : ctrlPatient.getAllPatients())
        {
            cboPatients.addItem(patient);
        }


        mdl = new ModelJTable();
        mdl.loadDatasMedicaments(ctrlMedicament.getAllMedicaments());
        tblMedicaments.setModel(mdl);

            btnInserer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    // A vous de jouer
                    int numMed =ctrlMedecin.getIdMedecinByName(cboMedecins.getSelectedItem().toString());
                    int numLPat =ctrlPatient.getIdPatientByName(cboPatients.getSelectedItem().toString());
                    int numClt = Integer.parseInt(txtNumeroConsultation.getText());




                }
            });
        }

}
