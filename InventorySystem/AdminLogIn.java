package InventorySystem;

import javax.swing.*;

public class AdminLogIn extends AdminData implements Inventory{

    public AdminLogIn() {
        if(plotesohetKushti1() == true || plotesohetKushti2() == true){ TableModel.generateJTable(); }
        else { JOptionPane.showMessageDialog(null, "WARNING!\nTë dhënat e shtypura nuk përputhen me të dhënat konfidenciale !", "WARNING MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
    }
    public boolean plotesohetKushti1() {

        boolean flag = false;

        String adminperdoruesi = JOptionPane.showInputDialog("Admin Përdoruesi : ");
        String adminemail = JOptionPane.showInputDialog("Email-i i Admin Përdoruesit: ");
        String adminfjalekalimi = JOptionPane.showInputDialog("Fjalëkalimi i Admin Përdoruesit: ");

        if ((!adminperdoruesi.equals(getAdmin_1_username()) || !adminperdoruesi.equals(getAdmin_2_username())) && !adminemail.equals(getAdminemail()) && !adminfjalekalimi.equals(getAdminpassword())){
            JOptionPane.showMessageDialog(null, "Me të dhënat e shtypura nuk mund të hyni në databazë !\nTë dhënat e shtypura nuk ekzitojnë !", "WARNING MESSAGE", JOptionPane.WARNING_MESSAGE);
         return flag;
        }else { return !flag;
        }

    }
    public boolean plotesohetKushti2() {

         String secret_key = "M2!m/b&7-21";

        String admin1 = JOptionPane.showInputDialog("Admin1: ");
        String admin2 = JOptionPane.showInputDialog("Admin2: ");
        String celesi = JOptionPane.showInputDialog("Për të vazhduar shtypin çelësin: ");


        if (admin1.equals("Blerina Demaj") && admin2.equals("Flamur Sheholli") && (celesi.equals(secret_key))) {
            return true;
        }
        else return false;
    }
 //   }
    public static void main(String[] args){
        new AdminLogIn();
        }
    }



