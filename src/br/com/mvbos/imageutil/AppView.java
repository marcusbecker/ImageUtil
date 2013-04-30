/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvbos.imageutil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author mbecker
 */
public class AppView extends javax.swing.JFrame {
    
    private final JFileChooser fc = new JFileChooser();
    private File selectedFile;
    private final String DEFAULT = "imageutil.jpg";
    private ImageIcon orgImage = new ImageIcon(DEFAULT);
    private PanelWork panelWork;
    private DefaultListModel listModel = new DefaultListModel();
    private List<File> openFiles = new ArrayList(5);
    private List<ImageIcon> selectedImgs;

    /**
     * Creates new form AppView
     */
    public AppView() {
        initComponents();
        
        panelWork = (PanelWork) drawPanel;
        panelWork.setImage(orgImage);
    }
    
    private void loadImage(File f) {
        try {
            BufferedImage bi = ImageIO.read(f);
            orgImage = new ImageIcon(bi);
            selectedImgs = null;
            
            selectedFile = f;
            panelWork.setImage(orgImage);
        } catch (Exception ex) {
            selectedFile = null;
            panelWork.setImage(null);
            Logger.getLogger(AppView.class.getName()).log(Level.SEVERE, "Error do load image {0}", f.getName());
        }
    }
    
    private void loadImages(List<ImageIcon> imgs) {
        panelWork.setPixelImage(imgs);
        orgImage = null;
        selectedImgs = imgs;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        btnResize = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        tfResizeWidth = new javax.swing.JTextField();
        tfResizeHeight = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstImages = new javax.swing.JList();
        btnRemove = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnOpen = new javax.swing.JMenuItem();
        btnSaveAll = new javax.swing.JMenuItem();
        btnExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Útil");
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        javax.swing.GroupLayout drawPanelLayout = new javax.swing.GroupLayout(drawPanel);
        drawPanel.setLayout(drawPanelLayout);
        drawPanelLayout.setHorizontalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );
        drawPanelLayout.setVerticalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        btnResize.setText("Resize");
        btnResize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResizeActionPerformed(evt);
            }
        });

        btnUndo.setText("Undo");
        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });

        tfResizeWidth.setText("134");

        tfResizeHeight.setText("94");
        tfResizeHeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfResizeHeightActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Width x Height");

        lstImages.setToolTipText("");
        lstImages.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstImagesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstImages);

        btnRemove.setText("-");
        btnRemove.setToolTipText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnResize, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfResizeWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfResizeHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnUndo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemove))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfResizeHeight, tfResizeWidth});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfResizeWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfResizeHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnResize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUndo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(btnRemove)
                .addContainerGap())
        );

        jMenu1.setText("Image Útil");

        btnOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        btnOpen.setText("Abrir");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });
        jMenu1.add(btnOpen);

        btnSaveAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        btnSaveAll.setText("Criar miniatura");
        btnSaveAll.setToolTipText("Criar miniatura das imagens selecionadas na pasta 'out' no diretório das imagens.");
        btnSaveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAllActionPerformed(evt);
            }
        });
        jMenu1.add(btnSaveAll);

        btnExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        btnExit.setText("Sair");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jMenu1.add(btnExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sobre");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        fc.setMultiSelectionEnabled(true);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] files = fc.getSelectedFiles();
            for (File f : files) {
                if (!openFiles.contains(f)) {
                    openFiles.add(f);
                    selectedFile = f;
                    listModel.addElement(f.getName());
                }
            }
            
            lstImages.setModel(listModel);
            if (selectedFile != null) {
                loadImage(selectedFile);
                lstImages.setSelectedValue(selectedFile.getName(), true);
            }
        }
        
    }//GEN-LAST:event_btnOpenActionPerformed
        
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed
    
    private void btnResizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResizeActionPerformed
        int w = Global.parseInt(tfResizeWidth.getText());
        int h = Global.parseInt(tfResizeHeight.getText());
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        bi.createGraphics().drawImage(orgImage.getImage(), 0, 0, w, h, null, null);
        ImageIcon i = new ImageIcon(bi);
        panelWork.setImage(i);
        
    }//GEN-LAST:event_btnResizeActionPerformed
    
    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed
        panelWork.setImage(orgImage);
    }//GEN-LAST:event_btnUndoActionPerformed
    
    private void lstImagesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstImagesValueChanged
        //int sel = lstImages.getSelectedIndex();
        //if (sel > 0) {
        //   loadImage(openFiles.get(sel));
        //}

        int[] arrSel = lstImages.getSelectedIndices();
        if (arrSel.length == 1) {
            loadImage(openFiles.get(arrSel[0]));
        } else if (arrSel.length > 1) {
            List<ImageIcon> imgs = new ArrayList<>(arrSel.length);
            for (int i = 0; i < arrSel.length; i++) {
                try {
                    imgs.add(new ImageIcon(ImageIO.read(openFiles.get(arrSel[i]))));
                } catch (IOException ex) {
                }
            }
            
            loadImages(imgs);
        }
        
        
    }//GEN-LAST:event_lstImagesValueChanged
    
    private void tfResizeHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfResizeHeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfResizeHeightActionPerformed
    
    private void btnSaveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAllActionPerformed
        
        for (File f : openFiles) {
            saveFile(f);
        }
        
    }//GEN-LAST:event_btnSaveAllActionPerformed
    
private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
    int[] arrSel = lstImages.getSelectedIndices();
    loadImage(new File(DEFAULT));
    int count = 0;
    for (int i : arrSel) {
        listModel.remove(i - count);
        openFiles.remove(i - count);
        count++;
    }
    
    lstImages.setModel(listModel);
    
}//GEN-LAST:event_btnRemoveActionPerformed
    
private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
    if (selectedImgs != null) {
        panelWork.updateScreen(selectedImgs);
    } else {
        panelWork.updateScreen(orgImage);
    }
}//GEN-LAST:event_formWindowStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnExit;
    private javax.swing.JMenuItem btnOpen;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnResize;
    private javax.swing.JMenuItem btnSaveAll;
    private javax.swing.JButton btnUndo;
    private final javax.swing.JPanel drawPanel = new PanelWork();
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstImages;
    private javax.swing.JTextField tfResizeHeight;
    private javax.swing.JTextField tfResizeWidth;
    // End of variables declaration//GEN-END:variables

    private void saveFile(File selectedFile) {
        int w = Global.parseInt(tfResizeWidth.getText());
        int h = Global.parseInt(tfResizeHeight.getText());
        File dir = new File(Global.getDir(selectedFile) + File.separator + "out");
        App.criarMiniatura(selectedFile, dir, w, h);
    }
}
