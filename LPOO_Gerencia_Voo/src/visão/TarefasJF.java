/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visão;

/*
Configurar a exibição das tarefas e atualizar a cor do background 

 */
import controle.TarefaController;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.Tarefa;

/**
 *
 * @author vito
 */
/// Classe que contem todas as tarefas cadastradas e pode ser excluidas ou marcadas como concluida
public class TarefasJF extends javax.swing.JFrame {

    ArrayList<Tarefa> listaTarefa = new ArrayList<>(); // array criado para armazenar a lista de tarefas

    public void carregarTarefa() {
        DefaultListModel modelo = new DefaultListModel();
        modelo.removeAllElements();

        for (Tarefa f : listaTarefa) {
            modelo.addElement(f);
        }

        LTTarefa.setModel(modelo);

    }

    public TarefasJF() {
        initComponents();
        carregarTarefa();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBTarefa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LTTarefa = new javax.swing.JList<>();
        BtnTarefaCadastrar = new javax.swing.JButton();
        BtnTarefaConcluido = new javax.swing.JButton();
        BtnTarefaExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LBTarefa.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        LBTarefa.setText("Lista geral de atividades");

        jScrollPane1.setViewportView(LTTarefa);

        BtnTarefaCadastrar.setText("Cadastrar");
        BtnTarefaCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTarefaCadastrarActionPerformed(evt);
            }
        });

        BtnTarefaConcluido.setText("Marcar como Concluido");
        BtnTarefaConcluido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTarefaConcluidoActionPerformed(evt);
            }
        });

        BtnTarefaExcluir.setText("Excluir");
        BtnTarefaExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTarefaExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(LBTarefa))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnTarefaCadastrar)
                                .addGap(36, 36, 36)
                                .addComponent(BtnTarefaExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnTarefaConcluido)))))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(LBTarefa)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnTarefaCadastrar)
                    .addComponent(BtnTarefaConcluido)
                    .addComponent(BtnTarefaExcluir))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /// Cria uma tarefa e adiciona a lista de tarefas junto ao curso respectivo
    private void BtnTarefaCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTarefaCadastrarActionPerformed

        CadastraTarefaJD TelaTarefa = new CadastraTarefaJD(this, true);
        TelaTarefa.setVisible(true);

        Tarefa tarefaNova = TelaTarefa.getTarefa();

        TarefaController control = new TarefaController();
        listaTarefa = (ArrayList<Tarefa>) control.addTarefa(tarefaNova, listaTarefa);

        carregarTarefa();
    }//GEN-LAST:event_BtnTarefaCadastrarActionPerformed

    /// Exclui uma tarefa selecionada da lista de exibição
    private void BtnTarefaExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTarefaExcluirActionPerformed
        Tarefa tarefaSelecionada = LTTarefa.getSelectedValue();
        if (tarefaSelecionada != null) {
            int opRemover = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja remover esta tarefa" + tarefaSelecionada.getNome() + "?");
            if (opRemover == JOptionPane.YES_OPTION) {
                listaTarefa.remove(tarefaSelecionada);
                carregarTarefa();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione uma tarefa para ser removida");
            }
        }


    }//GEN-LAST:event_BtnTarefaExcluirActionPerformed

    /// Adiciona o texto de tarefa concluida a tarefa para a identificação
    private void BtnTarefaConcluidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTarefaConcluidoActionPerformed

        Tarefa tarefaSelecionada = LTTarefa.getSelectedValue();
        if (tarefaSelecionada != null) {
            int opConcluido = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja marcar a  tarefa com o concluida" + tarefaSelecionada.getNome() + "?");
            if (opConcluido == JOptionPane.YES_OPTION) {
                tarefaSelecionada.setNome(tarefaSelecionada.getNome() + " - Conluida");
                carregarTarefa();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione uma tarefa para ser marcada como concluida");
            }
        }

    }//GEN-LAST:event_BtnTarefaConcluidoActionPerformed

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
            java.util.logging.Logger.getLogger(TarefasJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TarefasJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TarefasJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TarefasJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TarefasJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnTarefaCadastrar;
    private javax.swing.JButton BtnTarefaConcluido;
    private javax.swing.JButton BtnTarefaExcluir;
    private javax.swing.JLabel LBTarefa;
    private javax.swing.JList<Tarefa> LTTarefa;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
