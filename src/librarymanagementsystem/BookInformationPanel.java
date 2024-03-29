/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package librarymanagementsystem;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Oluwatobi
 */
public class BookInformationPanel extends javax.swing.JFrame {
    private final SystemManager Manage = new SystemManager();

    /**
     * Creates new form BookInformationPanel
     */
    public BookInformationPanel(ResultSet rst) {
        initComponents();
        updateList(rst);
    }
    
    public void updateTable(String bookID) {
        ArrayList <String>temp = Manage.retriveGenreUsingBookID(bookID);
        for(String temp2 : temp){
            ResultSet rst =Manage.retriveGenre(temp2);
            if(rst==null)
                JOptionPane.showMessageDialog(null,"Retrive code did not work");
            else{
                DefaultTableModel model = (DefaultTableModel) jTableGenre.
                        getModel();
                model.setRowCount(0);
                try {
                    if(rst.next()){
                        model.addRow(new String[] {rst.getString(2)});
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Retrive code Error");
                }
            }
                
        }
    }
    
    public void updateList(ResultSet rst){
        try{
            if(rst.next()){
                String title = rst.getString(2);
                String author = rst.getString(3);
                String publisher = rst.getString(4);
                String publisherDate = rst.getString(5);
                String DeweyDecNum = rst.getString(7);
                jtxtTitle.setText(title);
                jTxtAuthor.setText(author);
                jtxtPublisher.setText(publisher);
                jTxtPublicationDate.setText(publisherDate);
                jtextDeweyDecimalNumber.setText(DeweyDecNum);
                updateTable(rst.getString(1));
            }
            else
                JOptionPane.showMessageDialog(null,"Retrive code did not work");
        }
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Retrive code did not work");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        jtextDeweyDecimalNumber = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        jtxtPublisher = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        jTxtAuthor = new javax.swing.JTextField();
        jtxtTitle = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        jTxtPublicationDate = new javax.swing.JTextField();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGenre = new javax.swing.JTable();
        jBGoBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Book Information Panel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Dewey Decimal Number");

        jtextDeweyDecimalNumber.setEditable(false);
        jtextDeweyDecimalNumber.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtextDeweyDecimalNumber.setBorder(null);
        jtextDeweyDecimalNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextDeweyDecimalNumberActionPerformed(evt);
            }
        });
        jtextDeweyDecimalNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtextDeweyDecimalNumberKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Publisher");

        jtxtPublisher.setEditable(false);
        jtxtPublisher.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtxtPublisher.setBorder(null);
        jtxtPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtPublisherActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Author");

        jTxtAuthor.setEditable(false);
        jTxtAuthor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxtAuthor.setBorder(null);
        jTxtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtAuthorActionPerformed(evt);
            }
        });

        jtxtTitle.setEditable(false);
        jtxtTitle.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jtxtTitle.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtxtTitle.setBorder(null);
        jtxtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtTitleActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tittle");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Publication Date");

        jTxtPublicationDate.setEditable(false);
        jTxtPublicationDate.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxtPublicationDate.setBorder(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Genre");

        jTableGenre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableGenre);

        jBGoBack.setText("Go Back");
        jBGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGoBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtPublisher, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtAuthor))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtxtTitle)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(322, 322, 322)
                                .addComponent(jBGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtextDeweyDecimalNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTxtPublicationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addComponent(jLabel3))
                .addGap(0, 494, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtxtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextDeweyDecimalNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtPublicationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtextDeweyDecimalNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextDeweyDecimalNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextDeweyDecimalNumberActionPerformed

    private void jtextDeweyDecimalNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextDeweyDecimalNumberKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextDeweyDecimalNumberKeyPressed

    private void jtxtPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtPublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtPublisherActionPerformed

    private void jTxtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtAuthorActionPerformed

    private void jtxtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtTitleActionPerformed

    private void jBGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGoBackActionPerformed
        // TODO add your handling code here:
        Manage.runRoleFrame("User");
        dispose();
    }//GEN-LAST:event_jBGoBackActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGoBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGenre;
    private javax.swing.JTextField jTxtAuthor;
    private javax.swing.JTextField jTxtPublicationDate;
    private javax.swing.JTextField jtextDeweyDecimalNumber;
    private javax.swing.JTextField jtxtPublisher;
    private javax.swing.JTextField jtxtTitle;
    // End of variables declaration//GEN-END:variables
}
