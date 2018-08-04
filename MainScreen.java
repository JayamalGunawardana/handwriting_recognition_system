package handwriting_recognition_system;

import handwriting_recognition_system.RecogChar.SymListSelection;
import java.util.Vector;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class MainScreen extends javax.swing.JFrame {

    SymAction lSymAction = new SymAction();
    java.awt.List letters = new java.awt.List();
    String messag;
    static final int DOWNSAMPLE_WIDTH = 6;
    static final int DOWNSAMPLE_HEIGHT = 8;
    Vector sampleList = new Vector();
    DrawLetters entry;
    Sample sample;
    Kalgo net;

    public MainScreen() {
        initComponents();
        this.setSize(1366, 768);
        preload();
        updateList();

        toppanel_draw.setLayout(new BorderLayout());
        toppanel_draw.add(message = new JLabel("Draw a letter, click Recognize"), BorderLayout.NORTH);
        toppanel_draw.add(entry, BorderLayout.CENTER);

        letterspanel.add(letters);
        letterspanel.setLayout(new BorderLayout());
        letterspanel.add(letters, BorderLayout.CENTER);        
        
        JPanel downSamplePanel = new JPanel();
        downSamplePanel.setLayout(new BorderLayout());
        sample = new Sample(DOWNSAMPLE_WIDTH, DOWNSAMPLE_HEIGHT);
        entry.setSample(sample);
        sample.repaint();
        downSamplePanel.add(sample, BorderLayout.CENTER);
        bottomContent.add(downSamplePanel);
        entry.requestFocus();
    }

    public void preload() {
        //System.out.println("in preload");
        int index = 0;
        //System.out.println("RecogChar.HANDWRITING.length="+RecogChar.HANDWRITING.length);
        for (int i = 0; i < RecogChar.HANDWRITING.length; i++) {
            String line = HANDWRITING[i].trim();
            //System.out.println("line="+line);
            SampleData ds = new SampleData(line.charAt(0), RecogChar.DOWNSAMPLE_WIDTH, RecogChar.DOWNSAMPLE_HEIGHT);
            sampleList.insertElementAt(ds, index++);
            int idx = 2;
            for (int y = 0; y < ds.getHeight(); y++) {
                for (int x = 0; x < ds.getWidth(); x++) {
                    ds.setData(x, y, line.charAt(idx++) == '1');
                }
            }
        }
        train_actionPerformed(null);
    }
    public static final String HANDWRITING[] = {
        "1:001100011100110100100100000100000100000100111111",
        "2:111100100100100100000100000100001100011000111111",
        "3:011110000100000100111000011100000100000101111110",
        "4:001000011000010000110100100100100101111111000100",
        "5:111111100000100000111111100001000001000001111111",
        "6:011111110000100000111110110011100001110001011111",
        "7:111111000001000011000010000110000100001100001000",
        "8:111111100001110011011110011110110011100001111111",
        "9:111111100001100001111111000001000001100001111111",
        "A:001100001100011110011110010010010011100001100001",
        "B:111110100011100011101110111111100001100011111110",
        "C:001111011000110000100000100000100000100000111111",
        // "D:111110110011010001010001010001010001110011111110",
        "D:111111100001100001100001100001100001100010111100",
        "E:111111100000100000111111100000100000100000111111",
        "F:111111100000100000100000111110100000100000100000",
        "G:011110110000100000111111100101100101100101111101",
        "H:100001100001100001111111100001100001100001100001",
        "I:111111000100000100000100000100000100000100111111",
        "J:111111000100000100000100000100000100101100111000",
        "K:100011100110111100111100100010100011100001100001",
        "L:100000100000100000100000100000100000100000111111",
        "M:110011111111101101100101100001100001100001100001",
        "N:100001110001111001101101100101100111100011100001",
        "O:011110110011100001100001100011100011110010011110",
        "P:111111100001100001100111111100100000100000100000",
        "Q:011110110011100001100001100001100001111111111111",
        "R:111111100001100011100110111111100001100001100001",
        "S:011111110000100000110000011111000001000001111111",
        "T:111111000100000100000100000100000100000100000100",
        "U:100001100001100001100001100001100001100001111111",
        "V:100001110001010011010010011010001110001100000100",
        "W:100001100001110001110001010101011111011011011011",
        "X:100001110011010110001100001100010110110011100001",
        // "Y:100001110010011110001000001000001000001000001000",//FOR KEYBOARD Y
        "Y:100001110010011110001100001100001000010000100000",
        "Z:111111000011000110001100001000011000110000111111"
    };

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        toppanel_draw = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        recognize = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        letterToAdd = new javax.swing.JTextField();
        clear = new javax.swing.JButton();
        bottomContent1 = new javax.swing.JPanel();
        del = new javax.swing.JButton();
        delAll = new javax.swing.JButton();
        train = new javax.swing.JButton();
        message = new javax.swing.JLabel();
        letterspanel = new javax.swing.JPanel();
        bottomContent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareacustdet = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Handwritten Character Recognition");
        getContentPane().setLayout(null);

        topPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Add and Recognize characters"));
        entry = new DrawLetters();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(message = new JLabel("Draw a letter, click Recognize"), BorderLayout.NORTH);
        topPanel.add(entry, BorderLayout.CENTER);
        //        topPanel.add(topButtonPanel, BorderLayout.EAST);
        //        message.setForeground(Color.BLUE);

        sample = new Sample(DOWNSAMPLE_WIDTH, DOWNSAMPLE_HEIGHT);
        entry.setSample(sample);
        topPanel.add(sample, BorderLayout.CENTER);

        toppanel_draw.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout toppanel_drawLayout = new javax.swing.GroupLayout(toppanel_draw);
        toppanel_draw.setLayout(toppanel_drawLayout);
        toppanel_drawLayout.setHorizontalGroup(
            toppanel_drawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        toppanel_drawLayout.setVerticalGroup(
            toppanel_drawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Click this to recognize"));

        recognize.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        recognize.setText("Recognize");
        //addActionListener(lSymAction)
        recognize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recognizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(recognize)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(recognize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Add characters"));

        add.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        letterToAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        letterToAdd.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        clear.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letterToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(letterToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addComponent(toppanel_draw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(254, 254, 254)))
                .addContainerGap())
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toppanel_draw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(topPanelLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        getContentPane().add(topPanel);
        topPanel.setBounds(10, 100, 386, 516);

        bottomContent1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        del.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        del.setText("Delete");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });

        delAll.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        delAll.setText("Delete All");
        delAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delAllActionPerformed(evt);
            }
        });

        train.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        train.setText("Train");
        train.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainActionPerformed(evt);
            }
        });

        letterspanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                letterspanelComponentMoved(evt);
            }
        });

        javax.swing.GroupLayout letterspanelLayout = new javax.swing.GroupLayout(letterspanel);
        letterspanel.setLayout(letterspanelLayout);
        letterspanelLayout.setHorizontalGroup(
            letterspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );
        letterspanelLayout.setVerticalGroup(
            letterspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bottomContent1Layout = new javax.swing.GroupLayout(bottomContent1);
        bottomContent1.setLayout(bottomContent1Layout);
        bottomContent1Layout.setHorizontalGroup(
            bottomContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomContent1Layout.createSequentialGroup()
                .addGroup(bottomContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bottomContent1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bottomContent1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(bottomContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(delAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(del, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(train, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(letterspanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bottomContent1Layout.setVerticalGroup(
            bottomContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomContent1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bottomContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(train, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bottomContent1Layout.createSequentialGroup()
                        .addGroup(bottomContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bottomContent1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(del, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(delAll, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(letterspanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(bottomContent1);
        bottomContent1.setBounds(400, 100, 450, 240);

        bottomContent.setBackground(new java.awt.Color(204, 204, 255));
        bottomContent.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bottomContent.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(bottomContent);
        bottomContent.setBounds(400, 350, 450, 260);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Handwritten Character Recognition");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 20, 880, 60);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Customer details");

        txtareacustdet.setColumns(20);
        txtareacustdet.setRows(5);
        jScrollPane1.setViewportView(txtareacustdet);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(870, 140, 340, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recognizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recognizeActionPerformed

        if (net == null) {
            messag = "I need to be trained first!";
            javax.swing.JOptionPane.showMessageDialog(null, messag, "output", javax.swing.JOptionPane.WARNING_MESSAGE);
            //message.setText("I need to be trained first!");
            return;
        }
        entry.downSample();

        double input[] = new double[8 * 6];
        int idx = 0;
        SampleData ds = sample.getData();
        for (int y = 0; y < ds.getHeight(); y++) {
            for (int x = 0; x < ds.getWidth(); x++) {
                input[idx++] = ds.getData(x, y) ? .5 : -.5;
            }
        }

        double normfac[] = new double[1];

        int best = net.winner(input, normfac);
        //map[best] = ds.getLetter(); //extra code in mapNeurons() starting from input declaration. map[sampleList.size]. 
        char map[] = mapNeurons();
        
        
        
//        String messag;
        
        
//        if (map[best] >= 97 && map[best] <= 122) {
//            messag = "English Small letter : " + map[best];
//            javax.swing.JOptionPane.showMessageDialog(null, messag, "output", javax.swing.JOptionPane.INFORMATION_MESSAGE);
//        } else if (map[best] >= 33 && map[best] <= 47) {
//            messag = "Operands : " + map[best];
//            javax.swing.JOptionPane.showMessageDialog(null, messag, "output", javax.swing.JOptionPane.INFORMATION_MESSAGE);
//        } else if (map[best] >= 65 && map[best] <= 90) {
//            messag = "English Capital letter : " + map[best];
//            javax.swing.JOptionPane.showMessageDialog(null, messag, "output", javax.swing.JOptionPane.INFORMATION_MESSAGE);
//        } else if (map[best] >= 48 && map[best] <= 57) {
//            messag = "English Numerical : " + map[best];
//            javax.swing.JOptionPane.showMessageDialog(null, messag, "output", javax.swing.JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            messag = "Special Character : " + map[best];
//            javax.swing.JOptionPane.showMessageDialog(null, messag, "output", javax.swing.JOptionPane.INFORMATION_MESSAGE);
//        }

        ShowCustDetails(String.valueOf(map[best]));
        clear_actionPerformed(null);
        
        
        
        
        
    }//GEN-LAST:event_recognizeActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        int i = letters.getSelectedIndex();

        if (i == -1) {
            messag = "Please select a letter to delete.";
            javax.swing.JOptionPane.showMessageDialog(null, messag, "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
            //message.setText("Please select a letter to delete.");

            return;
        }

        sampleList.removeElementAt(i);
        updateList();
    }//GEN-LAST:event_delActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        entry.clear();
        sample.getData().clear();
        sample.repaint();
    }//GEN-LAST:event_clearActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        int i;
        String letter = letterToAdd.getText().trim();
        if (letter.length() > 1 || letter.length() == 0) {
            messag = "You should enter a single character";
            javax.swing.JOptionPane.showMessageDialog(null, messag, "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
            //message.setText("Enter within 1 letter");
            return;
        }

        if (letter.length() < 1) {
            messag = "Enter a single character";
            javax.swing.JOptionPane.showMessageDialog(null, messag, "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
            //message.setText("Enter a letter to add.");
            return;
        }

        entry.downSample();
        SampleData sampleData = (SampleData) sample.getData().clone();
        sampleData.setLetter(letter.charAt(0));
        //sampleData.setLetter(letter.substring(0,1));

        for (i = 0; i < sampleList.size(); i++) {
            SampleData str = (SampleData) sampleList.elementAt(i);
            if (str.equals(sampleData)) {
                messag = "Letter already defined, delete it first!";
                javax.swing.JOptionPane.showMessageDialog(null, messag, "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
                //message.setText("Letter already defined, delete it first!");
                return;
            }

            if (str.compareTo(sampleData) > 0) {
                //System.out.println(i);
                sampleList.insertElementAt(sampleData, i);
                updateList();
                return;
            }
        }
        sampleList.insertElementAt(sampleData, sampleList.size());
        updateList();
        letters.select(i);
        entry.clear();
        sample.repaint();
    }//GEN-LAST:event_addActionPerformed

    private void trainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainActionPerformed
        try {
            int in = RecogChar.DOWNSAMPLE_HEIGHT * RecogChar.DOWNSAMPLE_WIDTH;
            int out = sampleList.size();

            TrainingSet set = new TrainingSet(in, out);
            set.setTrainingSetCount(sampleList.size());

            for (int t = 0; t < sampleList.size(); t++) {
                int idx = 0;
                SampleData ds = (SampleData) sampleList.elementAt(t);
                for (int y = 0; y < ds.getHeight(); y++) {
                    for (int x = 0; x < ds.getWidth(); x++) {
                        set.setInput(t, idx++, ds.getData(x, y) ? .5 : -.5);
                    }
                }
            }

            net = new Kalgo(in, out, this);
            net.setTrainingSet(set);
            net.learn();
            this.clear_actionPerformed(null);
            messag = "Trained...\n Ready to recognize.";
            javax.swing.JOptionPane.showMessageDialog(null, messag, "output", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            //message.setText("Trained. Ready to recognize.");
        } catch (Exception e) {
            //messag="Exception:";
            //javax.swing.JOptionPane.showMessageDialog(null,messag,"output",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            message.setText("Exception:" + e.getMessage());
        }
        
        letterToAdd.setText("");
    }//GEN-LAST:event_trainActionPerformed

    private void letterspanelComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_letterspanelComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_letterspanelComponentMoved

    private void delAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delAllActionPerformed
        sampleList.removeAllElements();
        net = null;
        updateList();
        entry.clear();
        sample.getData().clear();
        sample.repaint();
    }//GEN-LAST:event_delAllActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
                
            }
        });
    }

    class SymAction implements java.awt.event.ActionListener {

        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == clear) {
                clear_actionPerformed(event);
            } else if (object == add) {
                add_actionPerformed(event);
            } else if (object == del) {
                del_actionPerformed(event);
            } else if (object == delAll) {
                deleteAll_actionPerformed(event);
            } else if (object == train) {
                train_actionPerformed(event);
            } else if (object == recognize) {
                recognize_actionPerformed(event);
            }
        }
    }

    
    private void ShowCustDetails(String custid){
    
        try {
             DbCon con = new DbCon();
            Statement stmt = con.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `custname`,`custid`,`dob`,`relationstat`,`nic`,`address` FROM `customerdetails` WHERE `custid` = '"+ custid.trim() +"' ");
            
            if (rs.next()) {
                txtareacustdet.setText("Customer Name: "+ rs.getString("custname") + "\n" + "Customer ID: " +  rs.getString("custid") + "\n" + "DOB: " + rs.getString("dob") + "\n" + "Relationship start date: " +  rs.getString("relationstat") + "\n" + "NIC: " +  rs.getString("nic") + "\n" + "Address: " +  rs.getString("address") );
                
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /* Called when the train button is pressed.
     event=The event.
     */
    void train_actionPerformed(java.awt.event.ActionEvent event) {
        try {
            int in = RecogChar.DOWNSAMPLE_HEIGHT * RecogChar.DOWNSAMPLE_WIDTH;
            int out = sampleList.size();

            TrainingSet set = new TrainingSet(in, out);
            set.setTrainingSetCount(sampleList.size());

            for (int t = 0; t < sampleList.size(); t++) {
                int idx = 0;
                SampleData ds = (SampleData) sampleList.elementAt(t);
                for (int y = 0; y < ds.getHeight(); y++) {
                    for (int x = 0; x < ds.getWidth(); x++) {
                        set.setInput(t, idx++, ds.getData(x, y) ? .5 : -.5);
                    }
                }
            }

            net = new Kalgo(in, out, this);
            net.setTrainingSet(set);
            net.learn();
            this.clear_actionPerformed(null);
            messag = "Trained...\n Ready to recognize.";
            javax.swing.JOptionPane.showMessageDialog(null, messag, "output", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            //message.setText("Trained. Ready to recognize.");
        } catch (Exception e) {
            //messag="Exception:";
            //javax.swing.JOptionPane.showMessageDialog(null,messag,"output",javax.swing.JOptionPane.INFORMATION_MESSAGE);
//            message.setText("Exception:" + e.getMessage());
        }

    }

    /* Called when the recognize button is pressed.
     event=The event.
     */
    void recognize_actionPerformed(java.awt.event.ActionEvent event) {
        if (net == null) {
            messag = "I need to be trained first!";
            javax.swing.JOptionPane.showMessageDialog(null, messag, "output", javax.swing.JOptionPane.WARNING_MESSAGE);
            //message.setText("I need to be trained first!");
            return;
        }
        entry.downSample();

        double input[] = new double[8 * 6];
        int idx = 0;
        SampleData ds = sample.getData();
        for (int y = 0; y < ds.getHeight(); y++) {
            for (int x = 0; x < ds.getWidth(); x++) {
                input[idx++] = ds.getData(x, y) ? .5 : -.5;
            }
        }

        double normfac[] = new double[1];

        int best = net.winner(input, normfac);
        //map[best] = ds.getLetter(); //extra code in mapNeurons() starting from input declaration. map[sampleList.size]. 
        char map[] = mapNeurons();
        String messag;
        if (map[best] >= 97 && map[best] <= 122) {
            messag = "English Small letter : " + map[best];
            javax.swing.JOptionPane.showMessageDialog(null, messag, "output", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else if (map[best] >= 33 && map[best] <= 47) {
            messag = "Operands : " + map[best];
            javax.swing.JOptionPane.showMessageDialog(null, messag, "output", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else if (map[best] >= 65 && map[best] <= 90) {
            messag = "English Capital letter : " + map[best];
            javax.swing.JOptionPane.showMessageDialog(null, messag, "output", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else if (map[best] >= 48 && map[best] <= 57) {
            messag = "English Numerical : " + map[best];
            javax.swing.JOptionPane.showMessageDialog(null, messag, "output", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            messag = "Special Character : " + map[best];
            javax.swing.JOptionPane.showMessageDialog(null, messag, "output", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }

        clear_actionPerformed(null);

    }

    char[] mapNeurons() {
        char map[] = new char[sampleList.size()];
        double normfac[] = new double[1];

        for (int i = 0; i < map.length; i++) {
            map[i] = '?';
        }
        for (int i = 0; i < sampleList.size(); i++) {
            double input[] = new double[8 * 6];
            int idx = 0;
            SampleData ds = (SampleData) sampleList.elementAt(i);
            for (int y = 0; y < ds.getHeight(); y++) {
                for (int x = 0; x < ds.getWidth(); x++) {
                    input[idx++] = ds.getData(x, y) ? .5 : -.5;
                }
            }

            int best = net.winner(input, normfac);
            map[best] = ds.getLetter();
        }
        return map;
    }

    /*this updateList fn gets d char from sampleList (from preload) and displays it in the list onto d screen. also stores chars in 
     * letters (java.awt.List)*/
    public void updateList() {//System.out.println("in updatelist");
        letters.removeAll();
        for (int i = 0; i < sampleList.size(); i++) {
            SampleData sample = (SampleData) sampleList.elementAt(i);
            //System.out.println("sample="+sample);
            letters.add("" + sample.letter);
        }

    }

    /* Called to clear the image.*/
    void clear_actionPerformed(java.awt.event.ActionEvent event) {
        entry.clear();
        sample.getData().clear();
        sample.repaint();
    }

    /* Called to clear the image.*/
    void deleteAll_actionPerformed(java.awt.event.ActionEvent event) {
        sampleList.removeAllElements();
        net = null;
        updateList();
        entry.clear();
        sample.getData().clear();
        sample.repaint();
    }

    /* Called to add the current image to the training set.*/
    void add_actionPerformed(java.awt.event.ActionEvent event) {
        int i;
        String letter = letterToAdd.getText().trim();
        if (letter.length() > 1 || letter.length() == 0) {
            messag = "You should enter a single character";
            javax.swing.JOptionPane.showMessageDialog(null, messag, "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
            //message.setText("Enter within 1 letter");
            return;
        }

        if (letter.length() < 1) {
            messag = "Enter a single character";
            javax.swing.JOptionPane.showMessageDialog(null, messag, "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
            //message.setText("Enter a letter to add.");
            return;
        }

        entry.downSample();
        SampleData sampleData = (SampleData) sample.getData().clone();
        sampleData.setLetter(letter.charAt(0));
        //sampleData.setLetter(letter.substring(0,1));

        for (i = 0; i < sampleList.size(); i++) {
            SampleData str = (SampleData) sampleList.elementAt(i);
            if (str.equals(sampleData)) {
                messag = "Letter already defined, delete it first!";
                javax.swing.JOptionPane.showMessageDialog(null, messag, "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
                //message.setText("Letter already defined, delete it first!");
                return;
            }

            if (str.compareTo(sampleData) > 0) {
                //System.out.println(i);
                sampleList.insertElementAt(sampleData, i);
                updateList();
                return;
            }
        }
        sampleList.insertElementAt(sampleData, sampleList.size());
        updateList();
        letters.select(i);
        entry.clear();
        sample.repaint();

    }

    /* Called when the del button is pressed.
     event=The event.
     */
    void del_actionPerformed(java.awt.event.ActionEvent event) {
        int i = letters.getSelectedIndex();

        if (i == -1) {
            messag = "Please select a letter to delete.";
            javax.swing.JOptionPane.showMessageDialog(null, messag, "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
            //message.setText("Please select a letter to delete.");

            return;
        }

        sampleList.removeElementAt(i);
        updateList();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JPanel bottomContent;
    private javax.swing.JPanel bottomContent1;
    private javax.swing.JButton clear;
    private javax.swing.JButton del;
    private javax.swing.JButton delAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField letterToAdd;
    private javax.swing.JPanel letterspanel;
    private javax.swing.JLabel message;
    private javax.swing.JButton recognize;
    private javax.swing.JPanel topPanel;
    private javax.swing.JPanel toppanel_draw;
    private javax.swing.JButton train;
    private javax.swing.JTextArea txtareacustdet;
    // End of variables declaration//GEN-END:variables
}
