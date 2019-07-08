/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BovinoController;
import controller.RacaController;
import controller.VendaController;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Bovino;
import model.Raca;
import model.Venda;

/**
 *
 * @author Eduardo
 */
public class BovinosVendidosView extends javax.swing.JInternalFrame {
    
    private int idUser;
    private int idBovino;
    private int idVenda;
    
    VendaController vc = new VendaController();
    BovinoController bc = new BovinoController();
    RacaController rc = new RacaController() ;
    List<Bovino> recLista = null;
    
    /**
     * Creates new form CadastroCompraView
     */
    public BovinosVendidosView(int idUser) {
        initComponents();
         carregaLista(idUser);
       setIdUser(idUser);
       preencherTabela();
      jTable1.setVisible(false);
       btnEditar.setVisible(false);
       btnCancelar.setVisible(false);
       int qtd  = bc.somaBovinosVendidos(idUser);
       lbQtd.setText(String.format(qtd+""));//duas casas
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdBovino() {
        return idBovino;
    }

    public void setIdBovino(int idBovino) {
        this.idBovino = idBovino;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    
    
    public void carregaLista(int idUser){
         recLista = bc.getBovinosVendidos(idUser);
         
    }

    
     public void preencherTabela(){
        DefaultTableModel modelo = (DefaultTableModel)tbRebanho.getModel();
        modelo.setNumRows(0);
        
        tbRebanho.getColumnModel().getColumn(0).setPreferredWidth(5);
        tbRebanho.getColumnModel().getColumn(1).setPreferredWidth(70);
        tbRebanho.getColumnModel().getColumn(2).setPreferredWidth(5);
        tbRebanho.getColumnModel().getColumn(3).setPreferredWidth(70);
        tbRebanho.getColumnModel().getColumn(4).setPreferredWidth(70);
        tbRebanho.getColumnModel().getColumn(5).setPreferredWidth(70);
        tbRebanho.getColumnModel().getColumn(6).setPreferredWidth(70);
        tbRebanho.getColumnModel().getColumn(7).setPreferredWidth(70);
        tbRebanho.getColumnModel().getColumn(8).setPreferredWidth(70);
        tbRebanho.getColumnModel().getColumn(9).setPreferredWidth(70);
    
        
        for(int i=0; i<recLista.size(); i++){
            
         String racaEmTexto = rc.retornaRaca(recLista.get(i).getIdRaca());
         
            modelo.addRow(new Object[]{
             recLista.get(i).getId(),
             racaEmTexto,
             recLista.get(i).getBrinco(),
             recLista.get(i).getDataNascimento(),
             recLista.get(i).getValorCompra(),
             recLista.get(i).getPesoCompra(),
             recLista.get(i).getDataCompra(),
             recLista.get(i).getValorVenda(),
             recLista.get(i).getPesoVenda(),
             recLista.get(i).getDataVenda(),
            
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

        jLabel0 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbRebanho = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lbQtd = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JToggleButton();
        btnCancelar = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel0.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel0.setText("Bovinos vendidos");

        tbRebanho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Raça", "Brinco", "Data Nascimento", "Valor Compra", "Peso Compra", "Data Compra", "Valor venda ", "Peso Venda", "Data Venda"
            }
        ));
        tbRebanho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRebanhoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbRebanho);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total de bovinos vendidos:  ");

        lbQtd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbQtd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQtd.setText("0000000");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome ", "Telefone", "Endereço"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Informações do comprador:");

        btnEditar.setBackground(new java.awt.Color(204, 204, 0));
        btnEditar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnEditar.setText("Editar Venda");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 0, 51));
        btnCancelar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar Venda");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("GERENCIADOR DE COMPRA E VENDA DE GADO");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("BovinoWare");

        jLabel12.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel12.setText("BW");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(414, 414, 414)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 994, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(btnCancelar)
                                .addGap(163, 163, 163)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 994, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel0, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(255, 255, 255)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel12))
                                    .addComponent(jLabel8))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbQtd)
                        .addGap(359, 359, 359))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel0))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbRebanhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRebanhoMouseClicked
          jTable1.setVisible(true);     
           btnEditar.setVisible(true);
            btnCancelar.setVisible(true);
        if(evt.getClickCount() == 1){ 
            //capitura dados
            Object objID = (tbRebanho.getValueAt(tbRebanho.getSelectedRow(), 0));
                String id = objID.toString(); 
           
         int idBovino = parseInt(id);   
         int idVenda = vc.buscaVenda2(idBovino, getIdUser()).getIdVenda();
         String nomeComprador = vc.buscaVenda2(idBovino, getIdUser()).getNome();
         String telefoneComprador =  vc.buscaVenda2(idBovino, getIdUser()).getTelefone();   
         String enderecoComprador =  vc.buscaVenda2(idBovino, getIdUser()).getEndereco(); 
         
        String colunas[] = {nomeComprador, telefoneComprador, enderecoComprador};
                
        DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        modelo.setNumRows(0);
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(5);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);
      
        
                
        jTable1.setModel(modelo);   //preenche a tabela
        modelo.addRow(colunas);
            
        
        setIdBovino(idBovino);
        setIdVenda(idVenda);
         //btnVender.setEnabled(true);
        }   
        
    }//GEN-LAST:event_tbRebanhoMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
     int resp = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar esta venda? O bovino voltará a ser disponivel no rebanho!","Confirmação",JOptionPane.YES_NO_OPTION);
        if(resp==0){
            try {
                 bc.cancelarRegistroVenda(getIdBovino());
                
                 vc.excluir(getIdVenda());
        
                carregaLista(getIdUser());
                preencherTabela();
                int qtd  = bc.somaBovinosVendidos(getIdUser());
                 lbQtd.setText(String.format(qtd+""));//duas casas
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
            }  
            jTable1.setVisible(false);
            btnEditar.setVisible(false);
            btnCancelar.setVisible(false);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        EditarVendaView ev = new EditarVendaView(getIdVenda(), getIdBovino(), getIdUser());
        ev.setVisible(true);
        jTable1.setVisible(false);
        btnEditar.setVisible(false);
        btnCancelar.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JLabel jLabel0;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbQtd;
    private javax.swing.JTable tbRebanho;
    // End of variables declaration//GEN-END:variables
}
