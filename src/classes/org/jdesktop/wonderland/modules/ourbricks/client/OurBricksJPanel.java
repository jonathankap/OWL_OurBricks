/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * OurBricksJPanel.java
 *
 * Created on 26-Jul-2011, 11:29:03
 */

package org.jdesktop.wonderland.modules.ourbricks.client;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.jdesktop.wonderland.client.jme.dnd.FileListDataFlavorHandler;
import org.jdesktop.wonderland.client.jme.dnd.URLDataFlavorHandler;
import org.jdesktop.wonderland.modules.ourbricks.client.ourbricks.OurBricksList;

/**
 *
 * @author jos
 */
public class OurBricksJPanel extends javax.swing.JPanel {

    private OurBricksList bricksList;;
    //TODO this hardcoded 4 should come from a constant and be used in OurBricksDataProvider
    private JButton[] buttonArray = new JButton[4];
    private JLabel[] labelArray = new JLabel[4];

    /** Creates new form OurBricksJPanel */
    public OurBricksJPanel() {
        
        initComponents();
        search(null, null);
        
    }

    private void search(String query, Integer next){
        try {
            bricksList = OurBricksDataProvider.requestDataFromExternalService(query, next); //On error just return an empty list for now.
        } catch (MalformedURLException ex) {
            Logger.getLogger(OurBricksJPanel.class.getName()).log(Level.SEVERE, null, ex);
            bricksList = new OurBricksList();
        } catch (IOException ex) {
            Logger.getLogger(OurBricksJPanel.class.getName()).log(Level.SEVERE, null, ex);
            bricksList = new OurBricksList();
        }
        addButtonsAndLabelsToArray();
        OurBricksDataProvider.setButtonData(bricksList, buttonArray, labelArray);
        enableNavigation();
    }

    private void searchFromOffset(Integer offset){
        System.out.println("The value of searchTextField.getText() is : " + searchTextField.getText());
        //TODO deal with http://ourbricks.com/api/search?q=truck&start=1&limit=5
        if (searchTextField.getText() == null || searchTextField.getText().equals(""))
            search(null, offset);
        else
            search(searchTextField.getText(), offset);
    }

    /**
     * Adding all buttons to and array so that they can be manipulated automatically
     */
    private void addButtonsAndLabelsToArray(){
        buttonArray[0] = jButton1; buttonArray[1] = jButton2; 
        buttonArray[2] = jButton3; buttonArray[3] = jButton4;

        labelArray[0] = jLabel1; labelArray[1] = jLabel2;
        labelArray[2] = jLabel3; labelArray[3] = jLabel4;
    }

    private void enableNavigation(){
        
        if (bricksList.getNext_start() != null){
            next.setEnabled(true);
        }
        else {
            next.setEnabled(false);
        }

        if (bricksList.getPrev_start() != null){
            previous.setEnabled(true);
        }
        else {
            previous.setEnabled(false);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        allModels = new javax.swing.JButton();
        jLabelSearch = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        button1Panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        button2Panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        button3Panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        button4Panel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        next = new javax.swing.JButton();

        setAutoscrolls(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));
        jPanel1.setToolTipText("Search");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        allModels.setText("All Models");
        allModels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allModelsActionPerformed(evt);
            }
        });

        jLabelSearch.setText("Search for Models:");

        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 387, Short.MAX_VALUE)
                .addComponent(allModels)
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelSearch)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(searchButton)
                .addComponent(allModels))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Results"));
        jPanel2.setToolTipText("Results");

        jLabel1.setText("no model found");

        jButton1.setText("jButton1");
        jButton1.setMaximumSize(new java.awt.Dimension(200, 133));
        jButton1.setMinimumSize(new java.awt.Dimension(200, 133));
        jButton1.setPreferredSize(new java.awt.Dimension(200, 133));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout button1PanelLayout = new javax.swing.GroupLayout(button1Panel);
        button1Panel.setLayout(button1PanelLayout);
        button1PanelLayout.setHorizontalGroup(
            button1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(button1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        button1PanelLayout.setVerticalGroup(
            button1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("no model found");

        jButton2.setText("jButton2");
        jButton2.setMaximumSize(new java.awt.Dimension(200, 133));
        jButton2.setMinimumSize(new java.awt.Dimension(200, 133));
        jButton2.setPreferredSize(new java.awt.Dimension(200, 133));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout button2PanelLayout = new javax.swing.GroupLayout(button2Panel);
        button2Panel.setLayout(button2PanelLayout);
        button2PanelLayout.setHorizontalGroup(
            button2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(button2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        button2PanelLayout.setVerticalGroup(
            button2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("no model found");

        jButton3.setText("jButton3");
        jButton3.setMaximumSize(new java.awt.Dimension(200, 133));
        jButton3.setMinimumSize(new java.awt.Dimension(200, 133));
        jButton3.setPreferredSize(new java.awt.Dimension(200, 133));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout button3PanelLayout = new javax.swing.GroupLayout(button3Panel);
        button3Panel.setLayout(button3PanelLayout);
        button3PanelLayout.setHorizontalGroup(
            button3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button3PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(button3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        button3PanelLayout.setVerticalGroup(
            button3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button3PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("no model found");

        jButton4.setText("jButton4");
        jButton4.setMaximumSize(new java.awt.Dimension(200, 133));
        jButton4.setMinimumSize(new java.awt.Dimension(200, 133));
        jButton4.setPreferredSize(new java.awt.Dimension(200, 133));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout button4PanelLayout = new javax.swing.GroupLayout(button4Panel);
        button4Panel.setLayout(button4PanelLayout);
        button4PanelLayout.setHorizontalGroup(
            button4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button4PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(button4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        button4PanelLayout.setVerticalGroup(
            button4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button4PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4))
        );

        previous.setText("Previous");
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });

        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(button1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(previous)
                        .addGap(31, 31, 31)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(button3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(next))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {next, previous});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {button3Panel, button4Panel});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(previous)
                            .addComponent(next)))
                    .addComponent(button4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {button2Panel, button3Panel, button4Panel});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(36, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        importModel( bricksList.getItems().get(0).getDownload_link(), bricksList.getItems().get(0).getTitle() );
//        importModel( "http://localhost/drupal/ourbricks.zip", "scene2" );
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //TODO Change the harcoded item numbers
        importModel( bricksList.getItems().get(1).getDownload_link(), bricksList.getItems().get(1).getTitle() );
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        handleSearch();
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        handleSearch();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        searchFromOffset(bricksList.getPrev_start());
    }//GEN-LAST:event_previousActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        searchFromOffset(bricksList.getNext_start());
    }//GEN-LAST:event_nextActionPerformed

    private void allModelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allModelsActionPerformed
        searchTextField.setText("");
        search(null, null);
    }//GEN-LAST:event_allModelsActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        importModel( bricksList.getItems().get(3).getDownload_link() , bricksList.getItems().get(3).getTitle() );
}//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        importModel( bricksList.getItems().get(2).getDownload_link(), bricksList.getItems().get(2).getTitle() );
    }//GEN-LAST:event_jButton3ActionPerformed

    private void handleSearch(){
        if ( searchTextField.getText() != null && !searchTextField.getText().equals("")) {
            search(searchTextField.getText(), null);
        }

    }

    private void importModel(String urlOfModel, String modelName){
        
        try {
            File fileToImport = OurBricksDataProvider.fileToImport(urlOfModel, modelName);

            if (fileToImport != null){
                List<File> fileList = new ArrayList<File>();
                fileList.add(fileToImport);
                System.out.println("Trying to upload the model");
                FileListDataFlavorHandler.importFile(fileList, true, null);
            } else {
                //TODO provide feedback to the user that the file is not available
            }
        }
        catch (Exception e){
            //TODO HANDLE ME NOW!!!!!!!!!!!!!!
            //Malformed URL Exceptiopn and IOException
            //TODO provide feedback to the user that the file is not available
            Logger.getLogger(OurBricksJPanel.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allModels;
    private javax.swing.JPanel button1Panel;
    private javax.swing.JPanel button2Panel;
    private javax.swing.JPanel button3Panel;
    private javax.swing.JPanel button4Panel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton next;
    private javax.swing.JButton previous;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables

}
