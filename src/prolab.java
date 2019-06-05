
// 150201181 - Emre Kiziltepe

import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.JSpinner;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;




/**
 *
 * @author ek-19
 */
public class prolab extends javax.swing.JFrame {
    
    /**
     *
     */
    public prolab() {
        initComponents();
    }
    
    Node kok;
    
    static int[] arrayNodeX1 =new int[100];
    static int[] arrayNodeY1 =new int[100];
    static int[] arrayNodeX2 =new int[100];
    static int[] arrayNodeY2 =new int[100];
    static int cmbrMerkezX,cmbrMerkezY,i,xm,ym,yaricap,dugumSay=0;
    static int xb,yb,xm2,ym2;
    static boolean mouseOn,findOn;
    static int randomX,randomY,sayac=0;
    static int[] arrayX =new int[100];
    static int[] arrayY =new int[100];
    static int[] arrayMerkezX =new int[100];
    static int[] arrayMerkezY =new int[100];
 
    /**
     * Bu fonksiyon rastgele veya mouse tıklanması ile oluşturulan koordinatın 
     * agaca eklenmesini belirli bolgeye yerleşmesini saglar.
     * @param x Eklenen düğümün x değerini tutar.
     * @param y Eklenen düğümün y değerini tutar.
     * @param index Düğümün dizideki yerini tutar.
     */
    public void NodeEkle(int x,int y, int index)
{
        Node newNode= new Node(x,y);

        if(kok==null)
        {
            kok= newNode;
            kok.oncekiNodeX1=0;
            kok.oncekiNodeY1=0;
            kok.oncekiNodeX2=520;
            kok.oncekiNodeY2=543;
            arrayNodeX1[0]=0;
            arrayNodeY1[0]=0;
            arrayNodeX2[0]=520;
            arrayNodeY2[0]=543;
            arrayMerkezX[0]=kok.x;
            arrayMerkezY[0]=kok.y;
        }   
        
        else
        {
            Node mainNode=kok;
            Node oncekiNode;
            Node aile;
            while(true)
            { 
                aile=mainNode;
                
                if(x>=mainNode.x && y>=mainNode.y)
                {
                    oncekiNode=mainNode;
                    mainNode=mainNode.GD;
                    if(mainNode==null)
                    {
                        aile.GD=newNode;
                        aile.GD.oncekiNodeX1=oncekiNode.x;
                        aile.GD.oncekiNodeY1=oncekiNode.y;
                        
                        aile.GD.oncekiNodeX2=oncekiNode.oncekiNodeX2;
                        aile.GD.oncekiNodeY2=oncekiNode.oncekiNodeY2;
                        
                        arrayNodeX1[index]=aile.GD.oncekiNodeX1;
                        arrayNodeY1[index]=aile.GD.oncekiNodeY1;
                        arrayNodeX2[index]=aile.GD.oncekiNodeX2;
                        arrayNodeY2[index]=aile.GD.oncekiNodeY2;
                        
                        arrayMerkezX[index]=oncekiNode.x;
                        arrayMerkezY[index]=oncekiNode.y;
                        return;
                    }
                }

                else if(x>=mainNode.x && y<=mainNode.y)
                {
                    oncekiNode=mainNode;
                    mainNode=mainNode.KD;
                    if(mainNode==null)
                    {
                        aile.KD=newNode;
                        aile.KD.oncekiNodeX1=oncekiNode.x;
                        aile.KD.oncekiNodeY1=oncekiNode.oncekiNodeY1;
                        aile.KD.oncekiNodeX2=oncekiNode.oncekiNodeX2;
                        aile.KD.oncekiNodeY2=oncekiNode.y;
                        arrayNodeX1[index]=aile.KD.oncekiNodeX1;
                        arrayNodeY1[index]=aile.KD.oncekiNodeY1;
                        arrayNodeX2[index]=aile.KD.oncekiNodeX2;
                        arrayNodeY2[index]=aile.KD.oncekiNodeY2;
                                  
                        arrayMerkezX[index]=oncekiNode.x;
                        arrayMerkezY[index]=oncekiNode.y;
                        return;
                    }
                }
                
                else if(x<=mainNode.x && y>=mainNode.y)
                {
                    oncekiNode=mainNode;
                    mainNode=mainNode.GB;
                    if(mainNode==null)
                    {
                        aile.GB=newNode;
                        aile.GB.oncekiNodeX1=oncekiNode.oncekiNodeX1;
                        aile.GB.oncekiNodeY1=oncekiNode.y;
                        aile.GB.oncekiNodeX2=oncekiNode.x;
                        aile.GB.oncekiNodeY2=oncekiNode.oncekiNodeY2;
                        arrayNodeX1[index]=aile.GB.oncekiNodeX1;
                        arrayNodeY1[index]=aile.GB.oncekiNodeY1;
                        arrayNodeX2[index]=aile.GB.oncekiNodeX2;
                        arrayNodeY2[index]=aile.GB.oncekiNodeY2;
                        arrayMerkezX[index]=oncekiNode.x;
                        arrayMerkezY[index]=oncekiNode.y;
                        return;
                    }
                }
                   
                else if(x<=mainNode.x && y<=mainNode.y)
                {
                    oncekiNode=mainNode;
                    mainNode=mainNode.KB;
                    if(mainNode==null)
                    {
                        aile.KB=newNode;
                        aile.KB.oncekiNodeX1=oncekiNode.oncekiNodeX1;
                        aile.KB.oncekiNodeY1=oncekiNode.oncekiNodeY1;
                        aile.KB.oncekiNodeX2=oncekiNode.x;
                        aile.KB.oncekiNodeY2=oncekiNode.y;
                        arrayNodeX1[index]=aile.KB.oncekiNodeX1;
                        arrayNodeY1[index]=aile.KB.oncekiNodeY1;
                        arrayNodeX2[index]=aile.KB.oncekiNodeX2;
                        arrayNodeY2[index]=aile.KB.oncekiNodeY2;
                        arrayMerkezX[index]=oncekiNode.x;
                        arrayMerkezY[index]=oncekiNode.y;
                        return;
                    }
                }
  
            }
    }
}
    
    
    @Override
        public void paint(Graphics g2) {
        super.paint(g2);
        
        
        for(int i=0;i<sayac;i++){
        
            if(i==0){
                xb=arrayX[i];
                yb=arrayY[i];
                g2.setColor(Color.RED);
                g2.fillOval(arrayX[i]-5,arrayY[i]-5,10,10);
                g2.setColor(Color.RED);
                g2.drawLine(xb,0,xb,543);
                g2.drawLine(0,yb,520,yb);
                
                
            }
            else{
                g2.setColor(Color.BLACK);
                g2.fillOval(arrayX[i]-5,arrayY[i]-5,10,10);
                g2.setColor(Color.BLACK);
                g2.drawLine(arrayX[i],arrayNodeY1[i],arrayX[i],arrayNodeY2[i]);
                g2.drawLine(arrayNodeX1[i],arrayY[i],arrayNodeX2[i],arrayY[i]);
                
            }
        }
        
       
        if(findOn==true){
            g2.setColor(Color.BLUE);
            yaricap=(int) jSpinner1.getValue();
            cmbrMerkezX=(xm2+yaricap/2);
            cmbrMerkezY=(ym2+yaricap/2);
            g2.drawOval(xm2-yaricap/2+8,ym2-yaricap/2+31, yaricap, yaricap);

            
            
            System.out.println("--------------------------------");
                for(int f=0;f<sayac;f++){
                    double sonuc = Math.sqrt(Math.pow(xm2-(arrayX[f]-8), 2)+Math.pow(ym2-(arrayY[f]-31),2));
                    if(sonuc<=yaricap/2){
                        g2.setColor(Color.BLUE);
                        g2.fillOval(arrayX[f]-5,arrayY[f]-5,10,10);
                        g2.setColor(new Color(50,200,50));
                        bulunan.add("("+(arrayX[f]-8)+","+(arrayY[f]-31)+")");
                        System.out.println((arrayX[f]-8)+","+(arrayY[f]-31)+" Koordinati bulundu");
                        dugumSay++;    
                        }
                }
            bulunan.add("Dugum sayisi: "+dugumSay);
            System.out.println("Bulunan dugum sayisi: "+dugumSay);
            dugumSay=0;
                
            System.out.println("--------------------------------");
            
        }
     
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        altpanel = new javax.swing.JPanel();
        random = new javax.swing.JButton();
        clean = new javax.swing.JButton();
        add = new javax.swing.JToggleButton();
        find = new javax.swing.JToggleButton();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        sagpanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        eklenen = new java.awt.List();
        bulunan = new java.awt.List();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QuadTree");
        setBackground(new java.awt.Color(102, 102, 102));

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setName(""); // NOI18N
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        altpanel.setBackground(new java.awt.Color(204, 204, 204));
        altpanel.setPreferredSize(new java.awt.Dimension(512, 45));

        random.setBackground(new java.awt.Color(255, 255, 255));
        random.setText("Random");
        random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomActionPerformed(evt);
            }
        });

        clean.setBackground(new java.awt.Color(255, 255, 255));
        clean.setText("Clean");
        clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        find.setBackground(new java.awt.Color(255, 255, 255));
        find.setText("Find");
        find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(50, 0, 500, 5));

        jLabel1.setText("Çember Yarıçapı");

        javax.swing.GroupLayout altpanelLayout = new javax.swing.GroupLayout(altpanel);
        altpanel.setLayout(altpanelLayout);
        altpanelLayout.setHorizontalGroup(
            altpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(random, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clean, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(find, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(altpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(altpanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        altpanelLayout.setVerticalGroup(
            altpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altpanelLayout.createSequentialGroup()
                .addGroup(altpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(altpanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(altpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(find, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clean, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(random, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(altpanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sagpanel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("Eklenen Düğümler");

        jLabel3.setText("Bulunan Düğümler");

        eklenen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eklenenActionPerformed(evt);
            }
        });

        bulunan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulunanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sagpanelLayout = new javax.swing.GroupLayout(sagpanel);
        sagpanel.setLayout(sagpanelLayout);
        sagpanelLayout.setHorizontalGroup(
            sagpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sagpanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(sagpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eklenen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(sagpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bulunan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        sagpanelLayout.setVerticalGroup(
            sagpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sagpanelLayout.createSequentialGroup()
                .addGroup(sagpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sagpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eklenen, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                    .addComponent(bulunan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(altpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(sagpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(altpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(sagpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void randomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomActionPerformed
                
                mouseOn = false;
                findOn = false;
                bulunan.removeAll();
                Random deger = new Random();
                randomX=deger.nextInt(512)+8;
                randomY=deger.nextInt(512)+31;
                System.out.println((randomX-8)+","+(randomY-31)+" Koordinati eklendi"); 
                eklenen.add("("+(randomX-8)+","+(randomY-31)+")");
                arrayX[sayac]=randomX;
                arrayY[sayac]=randomY;
                NodeEkle(arrayX[sayac], arrayY[sayac], sayac);
                sayac++;
                repaint( );
    }//GEN-LAST:event_randomActionPerformed

    private void cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanActionPerformed
        
        panel.updateUI();
        sagpanel.updateUI();
        eklenen.removeAll();
        bulunan.removeAll();
        sayac=0;
        kok=null;
        mouseOn = false;
        findOn = false;
    }//GEN-LAST:event_cleanActionPerformed

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseClicked
        
               
                if(mouseOn==true){
                    xm=evt.getX()+8;
                    ym=evt.getY()+31;
                    System.out.println((xm-8)+","+(ym-31)+" Koordinati eklendi");
                    eklenen.add("("+(xm-8)+","+(ym-31)+")");
                    arrayX[sayac]=xm;
                    arrayY[sayac]=ym;
                    NodeEkle(xm,ym,sayac);
                    sayac++;                
                    repaint();
                }         
                
                if(findOn==true){
                    xm2=evt.getX();
                    ym2=evt.getY();
                    repaint();
                }
    }//GEN-LAST:event_panelMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
            mouseOn = true;
            findOn = false;
    }//GEN-LAST:event_addActionPerformed

    private void findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findActionPerformed
        
            findOn = true;
            mouseOn = false;
            
            
    }//GEN-LAST:event_findActionPerformed

    private void panelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMousePressed
            bulunan.removeAll();      
    }//GEN-LAST:event_panelMousePressed

    private void eklenenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eklenenActionPerformed

    }//GEN-LAST:event_eklenenActionPerformed

    private void bulunanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulunanActionPerformed

    }//GEN-LAST:event_bulunanActionPerformed
    
    /**
     *
     * @param args
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
            java.util.logging.Logger.getLogger(prolab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(prolab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(prolab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(prolab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new prolab().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton add;
    private javax.swing.JPanel altpanel;
    private java.awt.List bulunan;
    private javax.swing.JButton clean;
    private java.awt.List eklenen;
    private javax.swing.JToggleButton find;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JPanel panel;
    private javax.swing.JButton random;
    private javax.swing.JPanel sagpanel;
    // End of variables declaration//GEN-END:variables
}
