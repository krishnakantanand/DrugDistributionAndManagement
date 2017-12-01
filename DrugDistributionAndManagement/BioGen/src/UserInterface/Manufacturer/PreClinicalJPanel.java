/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Manufacturer;

import Business.ClinicalPackage.Treatment;
import Business.DrugPackage.Drug;
import Business.EcoSystem;
import Business.EnterprisePackage.Enterprise;
import Business.EnterprisePackage.ManufacturerEnterprise;
import Business.NetworkPackage.Network;
import Business.PreClinicalPackage.Animal;
import Business.PreClinicalPackage.AnimalDirectory;
import Business.PreClinicalPackage.AnimalTreatment;
import Business.PreClinicalPackage.AnimalTreatmentHistory;
import Business.UserAccountPackage.UserAccount;
import Business.WorkRequestPackage.ForTestingByManuToPreclinical;
import Business.WorkRequestPackage.SendReportToManuFromPreclinical;
import Business.WorkRequestPackage.WorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rishabh
 */
public class PreClinicalJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorPanel
     */
    private AnimalDirectory animalDirectory;
    private JPanel userProcessContainer;
    private AnimalTreatmentHistory animalTreatmentHistory;
    private ManufacturerEnterprise manufacturerEnterprise;
    private UserAccount userAccount;

    public PreClinicalJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount account) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.manufacturerEnterprise=(ManufacturerEnterprise)enterprise;
        this.animalTreatmentHistory=manufacturerEnterprise.getPreClinicalTesterOrgnization().getAnimalTreatmentHistory();
        this.userAccount=userAccount;
        this.animalDirectory=manufacturerEnterprise.getPreClinicalTesterOrgnization().getAnimalDirectory();
        
        refresh();
        
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy");
        String dateNow = formatter.format(currentDate.getTime());
        lblDate.setText(dateNow);
        
      
        //To change body of generated methods, choose Tools | Templates.
    }
    
    public void refresh(){
        int rowCount=tblAnimalDirectory.getRowCount();
        DefaultTableModel dtm=(DefaultTableModel)tblAnimalDirectory.getModel();
        for(int i=rowCount-1;i>=0;i--){
            
            dtm.removeRow(i);
        }
        for(Animal animal:animalDirectory.getAnimalDirectory()){
            Object row[] = new Object[4];
            row[0] = animal.getAnimalId();
            row[1] = animal;
            row[2]=animal.getBodyPart();
            row[3] = animal.getGeneMatch();
            
            dtm.addRow(row);
        }
        
        int rowCount1=tblAnimalTreatmentHistory.getRowCount();
        DefaultTableModel dtm1=(DefaultTableModel)tblAnimalTreatmentHistory.getModel();
        for(int i=rowCount1-1;i>=0;i--){
            
            dtm1.removeRow(i);
        }
        for(AnimalTreatment animalTreatment:animalTreatmentHistory.getAnimalTreatmentHistory()){
            Object row[] = new Object[5];
            row[0] = animalTreatment;
            row[1] = animalTreatment.getAnimal().getAnimalType();
            row[2] = animalTreatment.getResponse();
            row[3] = animalTreatment.getDrug().getDrugName();
            row[4] = animalTreatment.getSideEffect();
            
            
            dtm1.addRow(row);
        }
        
        cmbxDrugs.removeAllItems();
        for(AnimalTreatment at: animalTreatmentHistory.getAnimalTreatmentHistory())
        {
            cmbxDrugs.addItem(at.getDrug());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnimalDirectory = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAddAnimal = new javax.swing.JButton();
        btnRemoveAnimal = new javax.swing.JButton();
        btnTreatAnimal = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAnimalTreatmentHistory = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnTreatmentDetail = new javax.swing.JButton();
        btnDeleteTreatment = new javax.swing.JButton();
        lblDate = new javax.swing.JLabel();
        cmbxDrugs = new javax.swing.JComboBox();
        btnSendReport = new javax.swing.JButton();

        setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));

        tblAnimalDirectory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AnimalID", "Type", "Body Part", "Gene Match"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAnimalDirectory);
        if (tblAnimalDirectory.getColumnModel().getColumnCount() > 0) {
            tblAnimalDirectory.getColumnModel().getColumn(0).setResizable(false);
            tblAnimalDirectory.getColumnModel().getColumn(1).setResizable(false);
            tblAnimalDirectory.getColumnModel().getColumn(2).setResizable(false);
            tblAnimalDirectory.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("PreClinical Testing Stage");

        btnAddAnimal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddAnimal.setText("Add Animal");
        btnAddAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAnimalActionPerformed(evt);
            }
        });

        btnRemoveAnimal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRemoveAnimal.setText("Remove Animal");
        btnRemoveAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAnimalActionPerformed(evt);
            }
        });

        btnTreatAnimal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTreatAnimal.setText("Treat Animal");
        btnTreatAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTreatAnimalActionPerformed(evt);
            }
        });

        tblAnimalTreatmentHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TreatmentID", "Animal Type", "Response", "Drug", "Side effects"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblAnimalTreatmentHistory);
        if (tblAnimalTreatmentHistory.getColumnModel().getColumnCount() > 0) {
            tblAnimalTreatmentHistory.getColumnModel().getColumn(0).setResizable(false);
            tblAnimalTreatmentHistory.getColumnModel().getColumn(1).setResizable(false);
            tblAnimalTreatmentHistory.getColumnModel().getColumn(2).setResizable(false);
            tblAnimalTreatmentHistory.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Animal Directory");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Animal Treatment History");

        btnTreatmentDetail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTreatmentDetail.setText("View Details");
        btnTreatmentDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTreatmentDetailActionPerformed(evt);
            }
        });

        btnDeleteTreatment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteTreatment.setText("Remove");
        btnDeleteTreatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTreatmentActionPerformed(evt);
            }
        });

        lblDate.setText("jLabel5");

        cmbxDrugs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbxDrugs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSendReport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSendReport.setText("Send Report of");
        btnSendReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(jLabel1)
                                .addGap(91, 91, 91)
                                .addComponent(lblDate)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                                .addComponent(btnRemoveAnimal)
                                .addGap(173, 173, 173)
                                .addComponent(btnTreatAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTreatmentDetail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeleteTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(btnSendReport)
                                .addGap(18, 18, 18)
                                .addComponent(cmbxDrugs, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddAnimal)
                    .addComponent(btnRemoveAnimal)
                    .addComponent(btnTreatAnimal))
                .addGap(90, 90, 90)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTreatmentDetail)
                    .addComponent(btnDeleteTreatment)
                    .addComponent(btnSendReport)
                    .addComponent(cmbxDrugs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTreatAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTreatAnimalActionPerformed
        TreatAnimalJPanel treatAnimalJPanel=new TreatAnimalJPanel(userProcessContainer, manufacturerEnterprise, userAccount);
        userProcessContainer.add("TreatAnimalJPanel",treatAnimalJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
         // TODO add your handling code here:
    }//GEN-LAST:event_btnTreatAnimalActionPerformed

    private void btnTreatmentDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTreatmentDetailActionPerformed
        int selectedRow= tblAnimalTreatmentHistory.getSelectedRow();
        if(selectedRow<0){
            
            JOptionPane.showMessageDialog(null,"Please Select any Row");
        }
        else{
            
        AnimalTreatment animalTreatment=(AnimalTreatment)tblAnimalTreatmentHistory.getValueAt(selectedRow, 0);
        AnimalTreatmentDetails animalTreatmentDetails=new AnimalTreatmentDetails(userProcessContainer,animalTreatment);
        userProcessContainer.add("TreatmentDetails",animalTreatmentDetails);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        } // TODO add your handling code here:
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTreatmentDetailActionPerformed

    private void btnDeleteTreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTreatmentActionPerformed
        int selectedRow= tblAnimalTreatmentHistory.getSelectedRow();
        if(selectedRow<0){
            
            JOptionPane.showMessageDialog(null,"Please Select any Row");
        }
        else{
            
            AnimalTreatment animalTreatment=(AnimalTreatment)tblAnimalTreatmentHistory.getValueAt(selectedRow, 0);
            animalTreatmentHistory.deleteAnimalTreatment(animalTreatment);
            refresh();
        }// TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteTreatmentActionPerformed

    private void btnRemoveAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAnimalActionPerformed
        int selectedRow= tblAnimalDirectory.getSelectedRow();
        if(selectedRow<0){

            JOptionPane.showMessageDialog(null,"Please Select any Row");
        }
        else{

            Animal animal=(Animal)tblAnimalDirectory.getValueAt(selectedRow, 1);
            animalDirectory.deleteAnimal(animal);
            refresh();
        } // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveAnimalActionPerformed

    private void btnAddAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAnimalActionPerformed
        AddAnimalJPanel addAnimalJPanel=new AddAnimalJPanel(userProcessContainer,manufacturerEnterprise.getPreClinicalTesterOrgnization().getAnimalDirectory());
        userProcessContainer.add("AddAnimalJPanel",addAnimalJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);// TODO add your handling code here:
    }//GEN-LAST:event_btnAddAnimalActionPerformed

    private void btnSendReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendReportActionPerformed
        //        // TODO add your handling code here:
        AnimalTreatmentHistory sendTreatmentHistory= new AnimalTreatmentHistory();
        Drug d=(Drug)cmbxDrugs.getSelectedItem();
        d.setIsApprovedByPreClinical(true);

        for(AnimalTreatment t: animalTreatmentHistory.getAnimalTreatmentHistory())
        {
            if(d.equals(t.getDrug()))
            {
                sendTreatmentHistory.addExistingTreatment(t);
            }
        }

        SendReportToManuFromPreclinical wr = new SendReportToManuFromPreclinical();
        wr.setAnimalTreatmentHistory(sendTreatmentHistory);
        wr.setSender(userAccount);
        wr.setSendingDate(lblDate.getText());
        wr.setStatus(WorkRequest.Sent);
        manufacturerEnterprise.getDrugManagerOrganization().getWorkQueue().getWorkRequestQueue().add(wr);
        JOptionPane.showMessageDialog(null, "Drug report sent successfully");
        
            
    }//GEN-LAST:event_btnSendReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAnimal;
    private javax.swing.JButton btnDeleteTreatment;
    private javax.swing.JButton btnRemoveAnimal;
    private javax.swing.JButton btnSendReport;
    private javax.swing.JButton btnTreatAnimal;
    private javax.swing.JButton btnTreatmentDetail;
    private javax.swing.JComboBox cmbxDrugs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDate;
    private javax.swing.JTable tblAnimalDirectory;
    private javax.swing.JTable tblAnimalTreatmentHistory;
    // End of variables declaration//GEN-END:variables
}
