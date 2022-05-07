package InventorySystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class TableModel implements Inventory {

    static Color headercolor = new Color(9, 15, 50);
    static Color kolonat = new Color(46, 32, 56);
    static JFrame f = Inventory.f;
    static JLabel String1,String2,String3,String4,String5;

    public static void generateJTable(){
// create JFrame and JTable

        final JTable tabela = new JTable();
        f = new JFrame();
        f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Admin\\IdeaProjects\\Inventory\\src\\InventorySystem/Image-frame.jpg")));
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
// krijimi i një modeli të tabelës dhe shtimi i Column Identifiers në kë model
        Object[] kolona = {"Emri i artikullit", "Nr. identifikimit", "Çmimi me shumicë", "Çmimi me pakicë", "Sasia në stok"};
        
        final DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(kolona);

// shtimi modelit në tabelë
        tabela.setModel(model);
        // create an array of objects to set the rreshti data
        tabela.setBackground(kolonat);
        tabela.setForeground(new Color(255, 255, 255));
        Font font = new Font("Serif", Font.BOLD, 18);
        tabela.setFont(font);
        tabela.setRowHeight(30);
        tabela.setVisible(true);
// krijiimi i header te tabelës
        JTableHeader header = tabela.getTableHeader();
        header.setBackground(headercolor);
        header.setFont(font);
        header.setForeground(Color.white);
        header.setPreferredSize(new Dimension(100, 38));
// krijimi JTextFields për t'i marrur vlerat
        final JTextField emri_artikullit = new JTextField();
        emri_artikullit.setOpaque(false);
        emri_artikullit.setForeground(Color.WHITE);
        emri_artikullit.setFont(font);
        final JTextField nr_identifikimit = new JTextField();
        nr_identifikimit.setOpaque(false);
        nr_identifikimit.setForeground(Color.WHITE);
        nr_identifikimit.setFont(font);
        final JTextField me_shumice = new JTextField();
        me_shumice.setOpaque(false);
        me_shumice.setForeground(Color.WHITE);
        me_shumice.setFont(font);
        final JTextField me_pakice = new JTextField();
        me_pakice.setOpaque(false);
        me_pakice.setForeground(Color.WHITE);
        me_pakice.setFont(font);
        final JTextField sasia = new JTextField();
        sasia.setOpaque(false);
        sasia.setForeground(Color.WHITE);
        sasia.setFont(font);

        // krijimi i border
        header.setBorder(new LineBorder(Color.WHITE, 1, true));
        tabela.setBorder(new LineBorder(Color.WHITE, 2, true));

// krijimi i JButtons
        JButton btnAdd = new JButton("Add");
        //btnAdd.setFont(font);
        JButton btnDelete = new JButton("Delete");
        //btnDelete.setBackground(framecolor);
        JButton btnUpdate = new JButton("Update");
        //btnUpdate.setBackground(framecolor);
        btnAdd.setVisible(true);
        btnDelete.setVisible(true);
        btnUpdate.setVisible(true);
// përcaktimi i dimensionit të JTextFields
        emri_artikullit.setBounds(193, 70, 100, 30);
        emri_artikullit.setCaretColor(Color.WHITE);
        nr_identifikimit.setBounds(240, 110, 100, 30);
        nr_identifikimit.setCaretColor(Color.WHITE);
        me_shumice.setBounds(230, 150, 100, 30);
        me_shumice.setCaretColor(Color.WHITE);
        me_pakice.setBounds(216, 190, 100, 30);
        me_pakice.setCaretColor(Color.WHITE);
        sasia.setBounds(180,230,100,30);
        sasia.setCaretColor(Color.WHITE);
// përcaktimi i dimensionit të JButtons
        btnAdd.setBounds(195, 340, 100, 45);
        btnAdd.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, 13));
         /*   btnAdd.setOpaque(false);
            btnAdd.setForeground(headercolor);
            btnAdd.setContentAreaFilled(false);
            btnAdd.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, 15));
            btnAdd.setBorder(new LineBorder(Color.WHITE, 1, true));
         */

        btnUpdate.setBounds(345, 340, 100, 45);
        btnUpdate.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, 13));

          /*  btnUpdate.setOpaque(false);
            btnUpdate.setForeground(headercolor);
            btnUpdate.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, 15));
            btnUpdate.setContentAreaFilled(false);
            btnUpdate.setBorder(new LineBorder(Color.WHITE, 1, true));
          */

        btnDelete.setBounds(495, 340, 100, 45);
        btnDelete.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, 13));

         /*   btnDelete.setOpaque(false);
            btnDelete.setForeground(headercolor);
            btnDelete.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, 15));
            btnDelete.setContentAreaFilled(false);
            btnDelete.setBorder(new LineBorder(Color.WHITE, 1, true));
         */
// krijimi i JScrollPane
        JScrollPane pane = new JScrollPane(tabela);
        pane.setBounds(6,462, 809, 325);
        pane.setBorder(new LineBorder(Color.WHITE, 2, true));
        pane.setBackground(headercolor);
        f.add(pane);

// shtimi i JTextFields në JFrame
         f.add(emri_artikullit);
         f.add(nr_identifikimit);
         f.add(me_shumice);
         f.add(me_pakice);
         f.add(sasia);

// shtimi i JButtons në JFrame
         f.add(btnAdd);
         f.add(btnDelete);
         f.add(btnUpdate);

// button shton rresht pas klikimit në Add Button

         Object[] rreshti = new Object[5];
         btnAdd.addActionListener(e -> {

             rreshti[0] = emri_artikullit.getText();
             rreshti[1] = nr_identifikimit.getText();
             rreshti[2] = me_shumice.getText();
             rreshti[3] = me_pakice.getText();
             rreshti[4] = sasia.getText();

             // add rreshti to the model
             model.addRow(rreshti);
         });

// button remove rreshti - Clicked on Delete Button
         btnDelete.addActionListener(e -> {

// i = the index of the selected rreshti
             int i = tabela.getSelectedRow();
             if (i >= 0) {
// remove a rreshti from jtable
                 model.removeRow(i);
             } else {
                JOptionPane.showMessageDialog(f,"Nuk keni selektuar asnjë nga rreshtat, për të fshirë të dhënat(Delete)!\nJu lutem, selektoni një nga rreshtat, për të fshirë të dhënat në databazë !","Vërejtje",JOptionPane.WARNING_MESSAGE);
             }
         });

// get selected rreshti data From tabela to textfields
         tabela.addMouseListener(new MouseAdapter() {

             @Override
             public void mouseClicked(MouseEvent e) {

// i = the index of the selected rreshti
                 int i = tabela.getSelectedRow();

             if (i >= 0) {
                 emri_artikullit.setText(model.getValueAt(i, 0).toString());
                 nr_identifikimit.setText(model.getValueAt(i, 1).toString());
                 me_shumice.setText(model.getValueAt(i, 2).toString());
                 me_pakice.setText(model.getValueAt(i, 3).toString());
                 sasia.setText(model.getValueAt(i, 4).toString());}
             }
         });

// button update rreshti - Clicked on Update Button
         btnUpdate.addActionListener(e -> {

// i = the index of the selected rreshti
             int i = tabela.getSelectedRow();

             if (i >= 0) {
                 model.setValueAt(emri_artikullit.getText(), i, 0);
                 model.setValueAt(nr_identifikimit.getText(), i, 1);
                 model.setValueAt(me_shumice.getText(), i, 2);
                 model.setValueAt(me_pakice.getText(), i, 3);
                 model.setValueAt(sasia.getText(), i, 4);
           }else {
              JOptionPane.showMessageDialog(f,"Nuk keni selektuar asnjë nga rreshtat, për të bërë përditësim(Update)!\nJu lutem, selektoni një nga rreshtat që të mund t'i ndryshoni të dhënat në databazë !","Vërejtje",JOptionPane.WARNING_MESSAGE);
         }
     });
        String1 = new JLabel("Emri i artikullit:");
           String1.setBounds(60,60, 200 , 50);
           String1.setFont(font);
        String2 = new JLabel("Numri i identifikimit :");
           String2.setBounds(60,100,200,50);
           String2.setFont(font);
        String3 = new JLabel("Çmimi me shumicë :");
           String3.setBounds(60,140, 200 , 50);
           String3.setFont(font);
        String4 = new JLabel("Çmimi me pakicë :");
           String4.setBounds(60,180,200,50);
           String4.setFont(font);
        String5 = new JLabel("Sasia në stok :");
           String5.setBounds(60,220,200,50);
           String5.setFont(font);
        f.pack();
        f.add(String1).setForeground(Color.WHITE);
        f.add(String2).setForeground(Color.WHITE);
        f.add(String3).setForeground(Color.WHITE);
        f.add(String4).setForeground(Color.WHITE);
        f.add(String5).setForeground(Color.WHITE);
        f.setTitle("                                                                      Sales Inventory Maintaining System");
        f.setSize(835,830);
        f.setResizable(false);
     }

    @Override
    public boolean plotesohetKushti1() {
        return false;
    }

    @Override
    public boolean plotesohetKushti2() {
        return false;
    }
 /*  public static void main(String[] args){
        generateJTable();
    }
  */
}
