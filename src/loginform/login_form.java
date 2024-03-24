
package loginform;
import admin.adminDashboard;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class login_form extends javax.swing.JFrame {


    public login_form() {
        initComponents();
    }

    public static boolean loginAcc(String j_user, String j_pass){
        dbConnector connect = new dbConnector();
        try{
            
            String query = "SELECT * FROM `law_users`  WHERE`u_username`= '"+j_user+"' AND `u_password`= '"+j_pass+"'";
            ResultSet resultSet = connect.getData(query);
            return resultSet.next();
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Database Connection error");
            
            return false;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        j_user = new javax.swing.JTextField();
        j_pass = new javax.swing.JPasswordField();
        j_login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanel1.setLayout(null);

        jLabel1.setText("Username:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(80, 110, 52, 14);

        jLabel2.setText("Password:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 170, 50, 14);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setText("LawFirm");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(160, 50, 95, 30);
        jPanel1.add(j_user);
        j_user.setBounds(120, 130, 190, 30);
        jPanel1.add(j_pass);
        j_pass.setBounds(120, 190, 190, 30);

        j_login.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        j_login.setText("Login");
        j_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_loginActionPerformed(evt);
            }
        });
        jPanel1.add(j_login);
        j_login.setBounds(250, 240, 67, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void j_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_loginActionPerformed
         if(loginAcc(j_user.getText(),j_pass.getText())){
                JOptionPane.showMessageDialog(null, "Login Success!");
                adminDashboard ads = new adminDashboard();
                ads.setLocationRelativeTo(null);
                ads.setVisible(true);
                this.dispose();
                
                }else{
                JOptionPane.showMessageDialog(null, "Login Failed!");
                
                }
    }//GEN-LAST:event_j_loginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton j_login;
    private javax.swing.JPasswordField j_pass;
    private javax.swing.JTextField j_user;
    // End of variables declaration//GEN-END:variables
}
