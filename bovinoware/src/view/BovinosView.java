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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Bovino;
import model.Raca;

/**
 *
 * @author Eduardo
 */
public class BovinosView extends javax.swing.JInternalFrame {
    
    private int idUser;
    private int idBovino;
    
    
    BovinoController bc = new BovinoController();
    RacaController rc = new RacaController() ;
    List<Bovino> recLista = null;
    /**
     * Creates new form CadastroCompraView
     */
    public BovinosView(int idUser) {
        initComponents();
        carregaLista(idUser);
       setIdUser(idUser);
       preencherTabela();
       btnVender.setEnabled(false);
       int qtd  = bc.somaBovinos(idUser);
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
    
    
    public void carregaLista(int idUser){
         recLista = bc.getBovinos(idUser);
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
        
        for(int i=0; i<recLista.size(); i++){
         String racaEmTexto = rc.retornaRaca(recLista.get(i).getIdRaca());
            modelo.addRow(new Object[]{
             recLista.get(i).getId(),
             racaEmTexto,
             recLista.get(i).getBrinco(),
             recLista.get(i).getDataNascimento(),
             recLista.get(i).getValorCompra(),
             recLista.get(i).getPesoCompra(),
             recLista.get(i).getDataCompra()
             
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

        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnVender = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSelecionado = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbRebanho = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lbQtd = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Rebanho atual");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Bovinos selecionados:");

        btnVender.setBackground(new java.awt.Color(51, 204, 0));
        btnVender.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        tbSelecionado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Raça", "Brinco", "Data Nascimento", "Valor Compra", "Peso Compra", "Data Compra"
            }
        ));
        jScrollPane1.setViewportView(tbSelecionado);

        tbRebanho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Raça", "Brinco", "Data Nascimento", "Valor Compra", "Peso Compra", "Data Compra"
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
        jLabel4.setText("Total de bovinos:  ");

        lbQtd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbQtd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQtd.setText("000");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(319, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148)
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
            .addGroup(layout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(317, 317, 317))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbQtd)
                .addGap(295, 295, 295))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbRebanhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRebanhoMouseClicked
                                         
        if(evt.getClickCount() == 1){ 
            //capitura dados
            Object objID = (tbRebanho.getValueAt(tbRebanho.getSelectedRow(), 0));
                String id = objID.toString(); 
            Object objRaca = (tbRebanho.getValueAt(tbRebanho.getSelectedRow(), 1));
                String raca = objRaca.toString(); 
            Object objBrinco = (tbRebanho.getValueAt(tbRebanho.getSelectedRow(), 2));
                String brinco = objBrinco.toString();
            Object objDataNascimento = (tbRebanho.getValueAt(tbRebanho.getSelectedRow(), 3));
                String  dataNascimento =  objDataNascimento.toString();  
            Object objValorCompra = (tbRebanho.getValueAt(tbRebanho.getSelectedRow(), 4));
                String valorCompra = objValorCompra.toString();  
            Object objPesoCompra = (tbRebanho.getValueAt(tbRebanho.getSelectedRow(), 5));
                String pesoCompra = objPesoCompra.toString();  
            Object objDataCompra = (tbRebanho.getValueAt(tbRebanho.getSelectedRow(), 6));
                String dataCompra = objDataCompra.toString();  
            
             
        String colunas[] = {id, raca, brinco, dataNascimento, valorCompra, pesoCompra, dataCompra};
                
        DefaultTableModel modelo = (DefaultTableModel)tbSelecionado.getModel();
        modelo.setNumRows(0);
        
        tbSelecionado.getColumnModel().getColumn(0).setPreferredWidth(5);
        tbSelecionado.getColumnModel().getColumn(1).setPreferredWidth(70);
        tbSelecionado.getColumnModel().getColumn(2).setPreferredWidth(5);
        tbSelecionado.getColumnModel().getColumn(3).setPreferredWidth(70);
        tbSelecionado.getColumnModel().getColumn(4).setPreferredWidth(70);
        tbSelecionado.getColumnModel().getColumn(5).setPreferredWidth(70);
        tbSelecionado.getColumnModel().getColumn(6).setPreferredWidth(70);
        
                 
        tbSelecionado.setModel(modelo);   //preenche a tabela
        modelo.addRow(colunas);
            
          int idBovino = parseInt(id);
         setIdBovino(idBovino);
         btnVender.setEnabled(true);
        }   
    }//GEN-LAST:event_tbRebanhoMouseClicked

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        
         
        CadastroVendaView venda = new CadastroVendaView(getIdUser(),getIdBovino());
        
        
        venda.setVisible(true);
        
        this.dispose();
         
       
        
    }//GEN-LAST:event_btnVenderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbQtd;
    private javax.swing.JTable tbRebanho;
    private javax.swing.JTable tbSelecionado;
    // End of variables declaration//GEN-END:variables
}
