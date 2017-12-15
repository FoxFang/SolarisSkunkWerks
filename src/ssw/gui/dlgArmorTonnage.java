/*
Copyright (c) 2008~2009, Justin R. Bengtson (poopshotgun@yahoo.com)
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice,
        this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice,
        this list of conditions and the following disclaimer in the
        documentation and/or other materials provided with the distribution.
    * Neither the name of Justin R. Bengtson nor the names of contributors may
        be used to endorse or promote products derived from this software
        without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package ssw.gui;

import filehandlers.Media;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dlgArmorTonnage extends javax.swing.JDialog {
    private boolean NewTonnage = false;
    private double result;
    
    /** Creates new form dlgArmorTonnage */
    public dlgArmorTonnage(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setResizable( false );
        setTitle( "Set Armor Tonnage" );
        setDefaultCloseOperation( javax.swing.JDialog.HIDE_ON_CLOSE );
        double max = ((ifMechForm) parent).GetMech().GetArmor().GetMaxTonnage();
        lblMaxArmor.setText( "Max Armor Tonnage: " + max );
    }

    public double GetResult() {
        return result;
    }

    public boolean NewTonnage() {
        return NewTonnage;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblInfo = new javax.swing.JLabel();
        txtArmorTons = new javax.swing.JTextField();
        btnOkay = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblMaxArmor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblInfo.setText("Enter desired armor tonnage:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 0, 4);
        getContentPane().add(lblInfo, gridBagConstraints);

        txtArmorTons.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtArmorTons.setMaximumSize(new java.awt.Dimension(90, 20));
        txtArmorTons.setMinimumSize(new java.awt.Dimension(90, 20));
        txtArmorTons.setPreferredSize(new java.awt.Dimension(90, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        getContentPane().add(txtArmorTons, gridBagConstraints);
        txtArmorTons.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnOkayActionPerformed( e );
                }
            });

            btnOkay.setText("Okay");
            btnOkay.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnOkayActionPerformed(evt);
                }
            });
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
            gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
            getContentPane().add(btnOkay, gridBagConstraints);

            btnCancel.setText("Cancel");
            btnCancel.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnCancelActionPerformed(evt);
                }
            });
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
            gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 0);
            getContentPane().add(btnCancel, gridBagConstraints);

            lblMaxArmor.setText("Max Armor Tonnage: 100.00");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.insets = new java.awt.Insets(4, 4, 0, 4);
            getContentPane().add(lblMaxArmor, gridBagConstraints);

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkayActionPerformed
        // validate the text.
        try{//GEN-LAST:event_btnOkayActionPerformed
            result = Double.parseDouble( txtArmorTons.getText() );
        } catch( NumberFormatException n ) {
            Media.Messager( this, "Please enter a valid number" );
            txtArmorTons.setText( "" );
            NewTonnage = false;
            return;
        }

        // tell the program we have a new tonnage
        NewTonnage = true;
        setVisible( false );
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        NewTonnage = false;
        this.setVisible( false );
    }//GEN-LAST:event_btnCancelActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOkay;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblMaxArmor;
    private javax.swing.JTextField txtArmorTons;
    // End of variables declaration//GEN-END:variables
}
