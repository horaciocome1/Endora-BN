/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conversoes.Binario;
import conversoes.Decimal;
import conversoes.Hexadecimal;
import conversoes.Octal;

/**
 *
 * @author horaciocome1
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        noEditable();
        Converter();
        jM_actual.setEnabled(false);
    }
    
    // variaveis que vou precisar
    int vet1[] = new int[30];
    int vet2[] = new int[30];
    int keychar, i1=0, i2=0, escolha;
    String acumula1="", acumula2="", item;
    
    //metodos por mim definidos
    void Converter() {
        jP_pai.removeAll();
        jP_pai.add(jP_converter);
        jP_pai.repaint();
        jP_pai.revalidate();
        resetAll();
        noEditable();
        jMI_converter.setVisible(false);
        jMI_calcular.setVisible(false);
        jMI_ajuda.setVisible(true);
        jMI_sobre.setVisible(true);
        jM_actual.setText("Converter");
    }
//    void Calcular() {
//        jP_pai.removeAll();
//        jP_pai.add(jP_calcular);
//        jP_pai.repaint();
//        jP_pai.revalidate();
//        resetAll();
//        noEditable();
//        jMI_converter.setVisible(true);
//        jMI_calcular.setVisible(false);
//        jMI_ajuda.setVisible(true);
//        jMI_sobre.setVisible(true);
//        jM_actual.setText("Calcular");
//    }
    void Ajuda() {
        jP_pai.removeAll();
        jP_pai.add(jP_ajuda);
        jP_pai.repaint();
        jP_pai.revalidate();
        jMI_converter.setVisible(true);
//        jMI_calcular.setVisible(true);
        jMI_ajuda.setVisible(false);
        jMI_sobre.setVisible(true);
        jM_actual.setText("Ajuda");
    }
    void Sobre() {
        jP_pai.removeAll();
        jP_pai.add(jP_sobre);
        jP_pai.repaint();
        jP_pai.revalidate();
        jMI_converter.setVisible(true);
//        jMI_calcular.setVisible(true);
        jMI_ajuda.setVisible(true);
        jMI_sobre.setVisible(false);
        jM_actual.setText("Sobre");
    }
    void Tbinario(int keychar) {
        switch (keychar) {
            case 49: // 1
                keychar = 1;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 48: //0
                keychar = 0;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
        }
    }
    void fromBinario() {
        jTF_decimal.setText(String.valueOf(Binario.Decimal(vet1, i1)));
        jTF_octal.setText(Binario.Octal(vet1, i1));
        jTF_hexadecimal.setText(Binario.Hexadecimal(vet1, i1));
    }
    void Tdecimal(int keychar) {
        if (jTF_decimal.getText().trim().equalsIgnoreCase("")) {
            System.out.println("vazio!");
            jTF_binario.setText("");
            jTF_octal.setText("");
            jTF_hexadecimal.setText("");
        } else {
            if (keychar >= 48 && keychar <= 57 || keychar == 8){
                if (Float.parseFloat(jTF_decimal.getText()) < 201326591){
                    acumula1 = jTF_decimal.getText();
                    fromDecimal();
                } else {
                    jTF_decimal.setText("");
                    jTF_decimal.setText(acumula1);
                }
            } else {
                jTF_decimal.setText("");
                jTF_decimal.setText(acumula1);
            }
        }
    }
    void fromDecimal() {
        jTF_binario.setText(Decimal.Binario(Integer.parseInt(jTF_decimal.getText())));
        jTF_octal.setText(Decimal.Octal(Integer.parseInt(jTF_decimal.getText())));
        jTF_hexadecimal.setText(Decimal.Hexadecimal(Integer.parseInt(jTF_decimal.getText())));
    }
    void resetAll(){
        jTF1.setText("");
        jTF2.setText("");
        jTF_resultado.setText("");
        jTF_binario.setText("");
        jTF_octal.setText("");
        jTF_decimal.setText("");
        jTF_hexadecimal.setText("");
        acumula1 = "";
        acumula2 = "";
        for (int j=0; j<i1; j++)
            vet1[j] = 0;
        for (int j=0; j<i2; j++)
            vet2[j] = 0;
    }
    void editable(String item) {
        if (item.equalsIgnoreCase("binario")) {
            jTF_binario.setEditable(true);
            jTF_octal.setEditable(false);
            jTF_decimal.setEditable(false);
            jTF_hexadecimal.setEditable(false);
        } else if (item.equalsIgnoreCase("octal")) {
            jTF_binario.setEditable(false);
            jTF_octal.setEditable(true);
            jTF_decimal.setEditable(false);
            jTF_hexadecimal.setEditable(false);
        } else if (item.equalsIgnoreCase("decimal")) {
            jTF_binario.setEditable(false);
            jTF_octal.setEditable(false);
            jTF_decimal.setEditable(true);
            jTF_hexadecimal.setEditable(false);
        } else if (item.equalsIgnoreCase("hexadecimal")){
            jTF_binario.setEditable(false);
            jTF_octal.setEditable(false);
            jTF_decimal.setEditable(false);
            jTF_hexadecimal.setEditable(true);            
        } else {
            noEditable();
        }
        resetAll();
    }
    void noEditable() {
        jTF_binario.setEditable(false);
        jTF_octal.setEditable(false);
        jTF_decimal.setEditable(false);
        jTF_hexadecimal.setEditable(false);      
        jTF1.setEditable(false);      
        jTF2.setEditable(false);     
    }
    boolean checkBinario() {
        boolean certo = false;
        if (keychar<=49 && keychar>=48 && i1<28)
            certo = true;
        return certo;
    }
    boolean checkDecimal() {
        boolean certo = false;
        if (keychar>=48 && keychar<=57 && Integer.parseInt(jTF_decimal.getText()) < 201326591)
            certo = true;
        return certo;
    }
    boolean checkOctal() {
        boolean certo = false;
        if (keychar>=48 && keychar<=55 && i1<10)
            certo = true;
        return certo;
    }
    boolean checkBspace() {
        boolean certo = false;
        if (keychar==8 && i1>0)
            certo = true;
        return certo;
    }
    void Bspace() {
        i1--;
        vet1[i1] = 0;
        acumula1 = "";
        for (int j=0; j<i1; j++)           
            acumula1 = acumula1 + vet1[j];
    }
    void Toctal(int keychar) {
        switch (keychar) {
            case 48: //0
                keychar = 0;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 49: // 1
                keychar = 1;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 50: //2
                keychar = 2;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 51: //3
                keychar = 3;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 52: //4
                keychar = 4;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 53: //5
                keychar = 5;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 54: //6
                keychar = 6;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 55: //7
                keychar = 7;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
                
        }
    }
    void fromOctal() {
        jTF_binario.setText(Octal.Binario(vet1, i1));
        jTF_decimal.setText(String.valueOf(Octal.Decimal(vet1, i1)));
        jTF_hexadecimal.setText(Octal.Hexadecimal(vet1, i1));
    }
    void fromHexadecimal(){
        jTF_binario.setText(Hexadecimal.Binario(vet1, i1));
        jTF_decimal.setText(String.valueOf(Hexadecimal.Decimal(vet1, i1)));
        jTF_octal.setText(Hexadecimal.Octal(vet1, i1));
    }
    void Thexadecimal(int keychar) {
        switch (keychar) {
            case 48: //0
                keychar = 0;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 49: // 1
                keychar = 1;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 50: //2
                keychar = 2;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 51: //3
                keychar = 3;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 52: //4
                keychar = 4;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 53: //5
                keychar = 5;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 54: //6
                keychar = 6;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 55: //7
                keychar = 7;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 56: //8
                keychar = 8;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 57: //9
                keychar = 9;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + String.valueOf(keychar);
                break;
            case 65: //a
                keychar = 10;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + "A";
                break;
            case 66: //b
                keychar = 11;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + "B";
                break;
            case 67: //c
                keychar = 12;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + "C";
                break;
            case 68: //d
                keychar = 13;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + "D";
                break;
            case 69: //e
                keychar = 14;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + "E";
                break;
            case 70: //f
                keychar = 15;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + "F";
                break;
            case 97: //A
                keychar = 10;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + "A";
                break;
            case 98: //B
                keychar = 11;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + "B";
                break;
            case 99: //C
                keychar = 12;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + "C";
                break;
            case 100: //D
                keychar = 13;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + "D";
                break;
            case 101: //E
                keychar = 14;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + "E";
                break;
            case 102: //F
                keychar = 15;
                vet1[i1] = keychar;
                i1++;
                acumula1 = acumula1 + "F";
                break;
        }
    }
    boolean checkHexadecimal(){
        boolean certo = false;
        if (keychar>=48 && keychar<=57 && i1<7 || keychar>=97 && keychar<=102 && i1<7 || keychar>=65 && keychar<=70 && i1<7)
            certo = true;
        return certo;
    }
    void BspaceH() {
        i1--;
        vet1[i1] = 0;
        acumula1 = "";
        for (int j=0; j<i1; j++) {
            switch (vet1[j]) {
                case 10:
                    acumula1 = acumula1 + "A";
                    break;
                case 11:
                    acumula1 = acumula1 + "B";
                    break;
                case 12:
                    acumula1 = acumula1 + "C";
                    break;
                case 13:
                    acumula1 = acumula1 + "D";
                    break;
                case 14:
                    acumula1 = acumula1 + "E";
                    break;
                case 15:
                    acumula1 = acumula1 + "F";
                    break;
                default:
                    acumula1 = acumula1 + vet1[j];
                    break;
            }
        }
    }
//    void Selecione(String item) {
//        if (item.equalsIgnoreCase("binario")) {
//            escolha = 2;
//        } else if (item.equalsIgnoreCase("octal")) {
//            escolha = 8;
//        } else if (item.equalsIgnoreCase("decimal")) {
//            escolha = 10;
//        } else if (item.equalsIgnoreCase("hexadecimal")){
//            escolha = 16;            
//        } else {
//            noEditable();
//        }
//        resetAll();
//    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP_pai = new javax.swing.JPanel();
        jP_converter = new javax.swing.JPanel();
        jB_conajuda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTF_octal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTF_decimal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTF_hexadecimal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTF_binario = new javax.swing.JTextField();
        jCB_converter = new javax.swing.JComboBox<>();
        jP_calcular = new javax.swing.JPanel();
        jB_calajuda = new javax.swing.JButton();
        jTF1 = new javax.swing.JTextField();
        jTF2 = new javax.swing.JTextField();
        jB_add = new javax.swing.JButton();
        jB_sub = new javax.swing.JButton();
        jB_multi = new javax.swing.JButton();
        jB_div = new javax.swing.JButton();
        jTF_resultado = new javax.swing.JTextField();
        jB_binario = new javax.swing.JButton();
        jB_octal = new javax.swing.JButton();
        jB_decimal = new javax.swing.JButton();
        jB_hexadecimal = new javax.swing.JButton();
        jCB_calcular = new javax.swing.JComboBox<>();
        jP_ajuda = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jP_sobre = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jMB = new javax.swing.JMenuBar();
        jM_opcoes = new javax.swing.JMenu();
        jMI_calcular = new javax.swing.JMenuItem();
        jMI_converter = new javax.swing.JMenuItem();
        jMI_sobre = new javax.swing.JMenuItem();
        jMI_ajuda = new javax.swing.JMenuItem();
        jMI_fechar = new javax.swing.JMenuItem();
        jM_actual = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Endora BN");
        setResizable(false);

        jP_pai.setLayout(new java.awt.CardLayout());

        jB_conajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/help.png"))); // NOI18N
        jB_conajuda.setToolTipText("Para ajuda.");
        jB_conajuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_conajudaActionPerformed(evt);
            }
        });

        jLabel1.setText("02");

        jLabel2.setText("bi");

        jLabel3.setText("08");

        jTF_octal.setToolTipText("Campo para numero octal.");
        jTF_octal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_octalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTF_octalKeyReleased(evt);
            }
        });

        jLabel4.setText("oct");

        jLabel5.setText("10");

        jTF_decimal.setToolTipText("Campo para numero decimal.");
        jTF_decimal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_decimalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTF_decimalKeyReleased(evt);
            }
        });

        jLabel6.setText("dec");

        jLabel7.setText("16");

        jTF_hexadecimal.setToolTipText("Campo para numero hexadecimal.");
        jTF_hexadecimal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_hexadecimalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTF_hexadecimalKeyReleased(evt);
            }
        });

        jLabel8.setText("hexa");

        jTF_binario.setToolTipText("Campo para numero binario.");
        jTF_binario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_binarioActionPerformed(evt);
            }
        });
        jTF_binario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_binarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTF_binarioKeyReleased(evt);
            }
        });

        jCB_converter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Binario", "Octal", "Decimal", "Hexadecimal" }));
        jCB_converter.setToolTipText("Selecione uma base numerica.");
        jCB_converter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_converterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_converterLayout = new javax.swing.GroupLayout(jP_converter);
        jP_converter.setLayout(jP_converterLayout);
        jP_converterLayout.setHorizontalGroup(
            jP_converterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_converterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_converterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_converterLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_hexadecimal, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_converterLayout.createSequentialGroup()
                        .addGroup(jP_converterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jP_converterLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTF_binario, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jP_converterLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jCB_converter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jB_conajuda))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jP_converterLayout.createSequentialGroup()
                                .addGroup(jP_converterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jP_converterLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTF_octal, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jP_converterLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTF_decimal, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jP_converterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jP_converterLayout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(23, 23, 23))))
        );
        jP_converterLayout.setVerticalGroup(
            jP_converterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_converterLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jP_converterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jB_conajuda)
                    .addComponent(jCB_converter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jP_converterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTF_binario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jP_converterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTF_octal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(jP_converterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTF_decimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(38, 38, 38)
                .addGroup(jP_converterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTF_hexadecimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(21, 21, 21))
        );

        jP_pai.add(jP_converter, "card4");

        jB_calajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/help.png"))); // NOI18N
        jB_calajuda.setToolTipText("Clique para ajuda.");

        jTF1.setToolTipText("Campo para o primeiro numero.");
        jTF1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTF1KeyReleased(evt);
            }
        });

        jTF2.setToolTipText("Campo para o segundo numero.");

        jB_add.setText("+");
        jB_add.setToolTipText("Adicionar.");

        jB_sub.setText("-");
        jB_sub.setToolTipText("Subtrair.");

        jB_multi.setText("*");
        jB_multi.setToolTipText("Multiplicar.");

        jB_div.setText("/");
        jB_div.setToolTipText("Dividir.");

        jTF_resultado.setEditable(false);
        jTF_resultado.setToolTipText("O resultado aparecera aqui.");

        jB_binario.setText("bi");
        jB_binario.setToolTipText("Mostrar o resultado em binario.");

        jB_octal.setText("oct");
        jB_octal.setToolTipText("Mostrar o resultado em octal");

        jB_decimal.setText("dec");
        jB_decimal.setToolTipText("Mostrar o resultado em decimal.");

        jB_hexadecimal.setText("hexa");
        jB_hexadecimal.setToolTipText("Mostrar o resultado em hexadecimal.");

        jCB_calcular.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Binario", "Octal", "Decimal", "Hexadecimal" }));
        jCB_calcular.setToolTipText("Clique e selecione a base.");
        jCB_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_calcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_calcularLayout = new javax.swing.GroupLayout(jP_calcular);
        jP_calcular.setLayout(jP_calcularLayout);
        jP_calcularLayout.setHorizontalGroup(
            jP_calcularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_calcularLayout.createSequentialGroup()
                .addGroup(jP_calcularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_calcularLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jB_calajuda))
                    .addGroup(jP_calcularLayout.createSequentialGroup()
                        .addGroup(jP_calcularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jP_calcularLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jP_calcularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCB_calcular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTF1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addComponent(jTF2)
                                    .addComponent(jTF_resultado)))
                            .addGroup(jP_calcularLayout.createSequentialGroup()
                                .addGroup(jP_calcularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jP_calcularLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jB_binario, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jB_decimal, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_calcularLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jP_calcularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jB_multi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jB_add, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jP_calcularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jP_calcularLayout.createSequentialGroup()
                                        .addGroup(jP_calcularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jB_octal, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jB_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jB_hexadecimal, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jB_div, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jP_calcularLayout.setVerticalGroup(
            jP_calcularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_calcularLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_calcularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jB_calajuda)
                    .addComponent(jCB_calcular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jP_calcularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_sub)
                    .addComponent(jB_add))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jP_calcularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_multi)
                    .addComponent(jB_div))
                .addGap(12, 12, 12)
                .addComponent(jTF_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jP_calcularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_decimal)
                    .addComponent(jB_octal)
                    .addComponent(jB_hexadecimal)
                    .addComponent(jB_binario))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jP_pai.add(jP_calcular, "card6");

        jLabel9.setText("Primeiro selecione o sistema a partir do qual");

        jLabel10.setText("pretende começar a converter. ");

        jLabel11.setText("Depois vá ao campo de texto correspondente e");

        jLabel12.setText("digite o número.");

        jLabel13.setText("Por razões de espaço foram estabelecidos");

        jLabel14.setText("limites de cifras que variam de base para base.");

        jLabel15.setText("Para outras informções sobre o projecto e");

        jLabel16.setText("contactos, consulte o painel Sobre.");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page_white_text.png"))); // NOI18N
        jButton1.setToolTipText("Sobre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_ajudaLayout = new javax.swing.GroupLayout(jP_ajuda);
        jP_ajuda.setLayout(jP_ajudaLayout);
        jP_ajudaLayout.setHorizontalGroup(
            jP_ajudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_ajudaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jP_ajudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_ajudaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(49, 49, 49))
        );
        jP_ajudaLayout.setVerticalGroup(
            jP_ajudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_ajudaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jP_pai.add(jP_ajuda, "card5");

        jLabel17.setText("Endora Bases Númericas");

        jLabel18.setText("Desenvolvida a pensar nos jovens estudantes");

        jLabel19.setText("que a certa altura se vão deparar com o tema.");

        jLabel20.setText("A Endora não vem supremir a necessidade de");

        jLabel21.setText("fazer no papel. Mas sim servir como");

        jLabel22.setText("ferramenta simples e grátis de confirmação de");

        jLabel23.setText("resultados.");

        jLabel24.setText("Moz Binario");

        jLabel25.setText("b1moz.tumblr.com");

        javax.swing.GroupLayout jP_sobreLayout = new javax.swing.GroupLayout(jP_sobre);
        jP_sobre.setLayout(jP_sobreLayout);
        jP_sobreLayout.setHorizontalGroup(
            jP_sobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_sobreLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jP_sobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jP_sobreLayout.setVerticalGroup(
            jP_sobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_sobreLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addGap(28, 28, 28)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jP_pai.add(jP_sobre, "card3");

        jM_opcoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/arrow_down.png"))); // NOI18N
        jM_opcoes.setText("Opções");
        jM_opcoes.setToolTipText("Aceder a outros paineis.");

        jMI_calcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/calculator.png"))); // NOI18N
        jMI_calcular.setText("Calcular");
        jMI_calcular.setToolTipText("Painel para realizar operacoes.");
        jMI_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMI_calcularActionPerformed(evt);
            }
        });
        jM_opcoes.add(jMI_calcular);

        jMI_converter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/arrow_rotate_clockwise.png"))); // NOI18N
        jMI_converter.setText("Converter");
        jMI_converter.setToolTipText("Painel para realizar conversoes.");
        jMI_converter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMI_converterActionPerformed(evt);
            }
        });
        jM_opcoes.add(jMI_converter);

        jMI_sobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page_white_text.png"))); // NOI18N
        jMI_sobre.setText("Sobre");
        jMI_sobre.setToolTipText("Mais informacoes.");
        jMI_sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMI_sobreActionPerformed(evt);
            }
        });
        jM_opcoes.add(jMI_sobre);

        jMI_ajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/help.png"))); // NOI18N
        jMI_ajuda.setText("Ajuda");
        jMI_ajuda.setToolTipText("Saiba como tornar a sua experiencia proveitosa.");
        jMI_ajuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMI_ajudaActionPerformed(evt);
            }
        });
        jM_opcoes.add(jMI_ajuda);

        jMI_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/door_out.png"))); // NOI18N
        jMI_fechar.setText("Fechar");
        jMI_fechar.setToolTipText("Terminar o aplicativo.");
        jMI_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMI_fecharActionPerformed(evt);
            }
        });
        jM_opcoes.add(jMI_fechar);

        jMB.add(jM_opcoes);

        jM_actual.setText("Converter");
        jM_actual.setToolTipText("Painel actual.");
        jMB.add(jM_actual);

        setJMenuBar(jMB);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_pai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_pai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMI_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMI_calcularActionPerformed
        // TODO add your handling code here:
//        Calcular();
//        resetAll();
//        noEditable();
    }//GEN-LAST:event_jMI_calcularActionPerformed

    private void jMI_converterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMI_converterActionPerformed
        // TODO add your handling code here:
        Converter();
        resetAll();
        noEditable();
    }//GEN-LAST:event_jMI_converterActionPerformed

    private void jMI_sobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMI_sobreActionPerformed
        // TODO add your handling code here:
        Sobre();
    }//GEN-LAST:event_jMI_sobreActionPerformed

    private void jMI_ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMI_ajudaActionPerformed
        // TODO add your handling code here:
        Ajuda();
    }//GEN-LAST:event_jMI_ajudaActionPerformed

    private void jMI_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMI_fecharActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMI_fecharActionPerformed

    private void jTF_binarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_binarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_binarioActionPerformed

    private void jTF_binarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_binarioKeyPressed
        // TODO add your handling code here:
        keychar = evt.getKeyChar();
        if (checkBinario()) {
            Tbinario(keychar);
            fromBinario();
        } else if (checkBspace()) {
            Bspace();
            fromBinario();
            jTF_binario.setText(acumula1);
            jTF_binario.setText("");
        } else {
            jTF_binario.setText("");
            jTF_binario.setText(acumula1);
        }
    }//GEN-LAST:event_jTF_binarioKeyPressed

    private void jTF_binarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_binarioKeyReleased
        // TODO add your handling code here:
        jTF_binario.setText("");
        jTF_binario.setText(acumula1);
    }//GEN-LAST:event_jTF_binarioKeyReleased

    private void jTF_decimalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_decimalKeyReleased
        // TODO add your handling code here:
        keychar = evt.getKeyChar();
        if (keychar >= 48 && keychar <= 57 || keychar == 8)
            Tdecimal(keychar);
        else {
            jTF_decimal.setText(acumula1); 
        }
    }//GEN-LAST:event_jTF_decimalKeyReleased

    private void jTF_decimalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_decimalKeyPressed
        // TODO add your handling code here:
        keychar = evt.getKeyChar();
        Tdecimal(keychar);
    }//GEN-LAST:event_jTF_decimalKeyPressed

    private void jCB_converterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_converterActionPerformed
        // TODO add your handling code here:
        item = (String) jCB_converter.getSelectedItem();
        editable(item);
    }//GEN-LAST:event_jCB_converterActionPerformed

    private void jTF_octalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_octalKeyPressed
        // TODO add your handling code here:
        keychar = evt.getKeyChar();
        if (checkOctal()){ //se for um numero octal
            Toctal(keychar);
            fromOctal();
        } else if (checkBspace()) {
            Bspace();
            fromOctal();
            jTF_octal.setText("");
            jTF_octal.setText(acumula1);
        } else {
            jTF_octal.setText("");
            jTF_octal.setText(acumula1);
        }
    }//GEN-LAST:event_jTF_octalKeyPressed

    private void jTF_octalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_octalKeyReleased
        // TODO add your handling code here:
        jTF_octal.setText("");
        jTF_octal.setText(acumula1);
    }//GEN-LAST:event_jTF_octalKeyReleased

    private void jTF_hexadecimalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_hexadecimalKeyPressed
        // TODO add your handling code here:
        keychar = evt.getKeyChar();
        if (checkHexadecimal()) {
            Thexadecimal(keychar);
            fromHexadecimal();
        } else if (checkBspace()) {
            BspaceH();
            fromHexadecimal();
            jTF_hexadecimal.setText("");
            jTF_hexadecimal.setText(acumula1);
        } else {
            jTF_hexadecimal.setText("");
            jTF_hexadecimal.setText(acumula1);
        }
    }//GEN-LAST:event_jTF_hexadecimalKeyPressed

    private void jTF_hexadecimalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_hexadecimalKeyReleased
        // TODO add your handling code here:
        jTF_hexadecimal.setText("");
        jTF_hexadecimal.setText(acumula1);
    }//GEN-LAST:event_jTF_hexadecimalKeyReleased

    private void jCB_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_calcularActionPerformed
        // TODO add your handling code here:
//        item = String.valueOf(jCB_calcular.getSelectedItem());
//        if (item.equalsIgnoreCase("selecione")) {
//            noEditable();
//            resetAll();
//        }
//        else {
//            Selecione(item);
//            jTF1.setEditable(true);
//            jTF2.setEditable(true);
//        }
    }//GEN-LAST:event_jCB_calcularActionPerformed

    private void jTF1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF1KeyPressed
        // TODO add your handling code here:
//        keychar = evt.getKeyChar();
//        switch (escolha) {
//            case 2:
//                jTF_binarioKeyPressed(evt);
//                break;
//            case 8:
//                jTF_octalKeyPressed(evt);
//                break;
//            case 10:
//                if (checkDecimal())
//                    acumula1 = jTF1.getText();
//                break;
//            case 16:
//                jTF_hexadecimalKeyPressed(evt);
//                break;
//            
//        }
    }//GEN-LAST:event_jTF1KeyPressed

    private void jTF1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF1KeyReleased
        // TODO add your handling code here:
//        jTF1.setText("");
//        jTF1.setText(acumula1);
    }//GEN-LAST:event_jTF1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Sobre();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jB_conajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_conajudaActionPerformed
        // TODO add your handling code here:
        Ajuda();
    }//GEN-LAST:event_jB_conajudaActionPerformed

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
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_add;
    private javax.swing.JButton jB_binario;
    private javax.swing.JButton jB_calajuda;
    private javax.swing.JButton jB_conajuda;
    private javax.swing.JButton jB_decimal;
    private javax.swing.JButton jB_div;
    private javax.swing.JButton jB_hexadecimal;
    private javax.swing.JButton jB_multi;
    private javax.swing.JButton jB_octal;
    private javax.swing.JButton jB_sub;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCB_calcular;
    private javax.swing.JComboBox<String> jCB_converter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMB;
    private javax.swing.JMenuItem jMI_ajuda;
    private javax.swing.JMenuItem jMI_calcular;
    private javax.swing.JMenuItem jMI_converter;
    private javax.swing.JMenuItem jMI_fechar;
    private javax.swing.JMenuItem jMI_sobre;
    private javax.swing.JMenu jM_actual;
    private javax.swing.JMenu jM_opcoes;
    private javax.swing.JPanel jP_ajuda;
    private javax.swing.JPanel jP_calcular;
    private javax.swing.JPanel jP_converter;
    private javax.swing.JPanel jP_pai;
    private javax.swing.JPanel jP_sobre;
    private javax.swing.JTextField jTF1;
    private javax.swing.JTextField jTF2;
    private javax.swing.JTextField jTF_binario;
    private javax.swing.JTextField jTF_decimal;
    private javax.swing.JTextField jTF_hexadecimal;
    private javax.swing.JTextField jTF_octal;
    private javax.swing.JTextField jTF_resultado;
    // End of variables declaration//GEN-END:variables
}
