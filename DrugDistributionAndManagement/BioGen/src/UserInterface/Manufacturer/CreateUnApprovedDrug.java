/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Manufacturer;

import Business.DrugPackage.Drug;
import Business.EnterprisePackage.ManufacturerEnterprise;
import Business.UserAccountPackage.UserAccount;
import Business.WorkRequestPackage.ForTestingByManuToPreclinical;
import Business.WorkRequestPackage.WorkRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Rishabh
 */
public class CreateUnApprovedDrug extends javax.swing.JPanel {

    JPanel userProcessContainer;
    UserAccount userAccount;
    ManufacturerEnterprise manufacturerEnterprise;
    /**
     * Creates new form CreateUnApprovedDrug
     */
    

    CreateUnApprovedDrug(JPanel userProcessContainer, ManufacturerEnterprise manufacturerEnterprise, UserAccount userAccount) {
        initComponents();
        this.userAccount=userAccount;
        this.userProcessContainer= userProcessContainer;
        this.manufacturerEnterprise=manufacturerEnterprise;
        
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy");
        String dateNow = formatter.format(currentDate.getTime());
        lblDate.setText(dateNow);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCreateDrug = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtExpiryDate = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCreateDrug.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCreateDrug.setText("Create Drug And Send to PreClinical Stage");
        btnCreateDrug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateDrugActionPerformed(evt);
            }
        });
        add(btnCreateDrug, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 339, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Create Drug");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 55, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 118, 1030, 10));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Drug Name");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 217, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Expires In");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 270, -1, -1));
        add(txtExpiryDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 270, 140, -1));
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 217, 135, -1));

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 110, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateDrugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateDrugActionPerformed

        if (txtExpiryDate.getText().equals("") || txtName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Some fields are Empty");
            return;
        }
        
       
        
        if(!(txtName.getText().trim().matches("^[A-Za-z]+$")))
        {
            JOptionPane.showMessageDialog(null, "Please enter name in proper format");
            return;
        }

        Drug drug = manufacturerEnterprise.getUnApprovedDrugDirectory().newDrug();
        drug.setDrugName(txtName.getText());
        drug.setManufacturerName(manufacturerEnterprise.getOrganizationName());
        drug.setExpiryDate(txtExpiryDate.getText());
        
        ForTestingByManuToPreclinical wr = new ForTestingByManuToPreclinical();
        wr.setDrug(drug);
        wr.setManufacturerEnterprise(manufacturerEnterprise);
        wr.setSender(userAccount);
        wr.setSendingDate(lblDate.getText());
        wr.setStatus(WorkRequest.UnderPro);
        
        manufacturerEnterprise.getPreClinicalTesterOrgnization().getWorkQueue().getWorkRequestQueue().add(wr);

        JOptionPane.showMessageDialog(null, "Drug " + drug.getDrugName() + " Create Succsessfully and sent fot testing");

        txtExpiryDate.setText("");
        txtName.setText("");

        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateDrugActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateDrug;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JTextField txtExpiryDate;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
