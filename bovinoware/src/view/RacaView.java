/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.BovinoController;
import controller.RacaController;

import static java.lang.Integer.parseInt;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Raca;

/**
 *
 * @author Giuliano
 */
public class RacaView extends javax.swing.JInternalFrame {
    Raca r;
    RacaController rc = new RacaController();
    BovinoController bc = new BovinoController();
    
    private int idSelecionado;
    List<Raca> recLista = null;


    public RacaView() {
        initComponents();
        carregaLista();
    
       preencherTabela();
        
    }
    
    public void carregaLista(){
         recLista = rc.listar();
    }

    public int getIdSelecionado() {
        return idSelecionado;
    }

    public void setIdSelecionado(int idSelecionado) {
        this.idSelecionado = idSelecionado;
    }
    
    public void preencherTabela(){
        DefaultTableModel modelo = (DefaultTableModel)tbDados.getModel();
        modelo.setNumRows(0);
        
        tbDados.getColumnModel().getColumn(0).setPreferredWidth(10);//largura das colunas
        tbDados.getColumnModel().getColumn(1).setPreferredWidth(90);
        
        
        for(int i=0; i<recLista.size(); i++){
         
            modelo.addRow(new Object[]{
             recLista.get(i).getId(),
             recLista.get(i).getNome()
             });
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

        lblTituloNot = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDados = new javax.swing.JTable();
        lblMarca1 = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        lblTituloNot.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTituloNot.setText("Gerenciamento de Raças");

        lblModelo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblModelo.setText("Nome:");

        lblMarca.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblMarca.setText("Raças cadastradas:");

        btnSalvar.setBackground(new java.awt.Color(51, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        btnSalvar.setText("Salvar Nova Raça");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        btnEditar.setText("Editar Selecionada");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        btnExcluir.setText("Excluir Selecionada");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tbDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ));
        tbDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDados);

        lblMarca1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblMarca1.setText("Raça selecionada ID:");

        lbID.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbID.setText("00");

        jLabel2.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel2.setText("BW");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("BovinoWare");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("GERENCIADOR DE COMPRA E VENDA DE GADO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(lblMarca))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblModelo)
                                .addGap(18, 18, 18)
                                .addComponent(txtNome))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(lblMarca1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbID)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTituloNot)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel2))
                                    .addComponent(jLabel1))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExcluir)
                                .addGap(36, 36, 36)
                                .addComponent(btnEditar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(456, 456, 456)
                                .addComponent(btnSalvar)))
                        .addGap(38, 38, 38))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTituloNot))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addComponent(lblMarca)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca1)
                    .addComponent(lbID))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        if(txtNome.getText().isEmpty()){
         JOptionPane.showMessageDialog(null, "Insira um nome!");
        }
        else{
            r = new Raca();
            r.setNome(txtNome.getText());
            rc.salvar(r);
        }
        txtNome.setText("");
        carregaLista();
        preencherTabela();
               
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
         if(!txtNome.getText().isEmpty()){
        int resp = JOptionPane.showConfirmDialog(null, "Está certo disso?","Confirmação",JOptionPane.YES_NO_OPTION);
        if(resp==0){
            try {
                r = new Raca();
                r.setId(idSelecionado);
                 r.setNome(txtNome.getText());
                 rc.editar(r);
                 txtNome.setText("");
                 carregaLista();
                 preencherTabela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
            }  
        
        }
        }else{
              JOptionPane.showMessageDialog(null, "Insira um nome!");
         }
        
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       boolean restricao = bc.verificaUsoRaca(idSelecionado);
       if(restricao == false){
       
        int resp = JOptionPane.showConfirmDialog(null, "Está certo disso?","Confirmação",JOptionPane.YES_NO_OPTION);
        if(resp==0){
            try {
                 rc.excluir(idSelecionado);
        
                 txtNome.setText("");
                carregaLista();
                preencherTabela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
            }  
        
        }
       }
       else JOptionPane.showMessageDialog(null, "Esta raça esta sendo usada, por isso não poderá ser excluida!");
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tbDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDadosMouseClicked
         if(evt.getClickCount() == 1){ 
            //capitura dados
            Object objID = (tbDados.getValueAt(tbDados.getSelectedRow(), 0));
                String id = objID.toString(); 
            Object objNome = (tbDados.getValueAt(tbDados.getSelectedRow(), 1));
                  String nome = objNome.toString(); 
            
            int id2 = parseInt(id);  
            setIdSelecionado(id2);
            txtNome.setText(nome);
            lbID.setText(id);
         }   
    }//GEN-LAST:event_tbDadosMouseClicked
   
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMarca1;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblTituloNot;
    private javax.swing.JTable tbDados;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
   
  
}
