import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Practice implements ActionListener{

 private JTextField lastNameContent;
 
 private JTextField firstNameContent;  
 
 private JTextField amountContent;
 
 private JButton contributeToObama;
 
 private JButton contributeToRomney;
 
 private JButton listObama;
 
 private JButton listRomney;
 
 private JTextArea contentShow;
 
 private List<Contributors> obamaContributor;
 
 private List<Contributors> romneyContributor;
 
 
    public Practice() {
        
        obamaContributor = new ArrayList<Contributors>();
        romneyContributor = new ArrayList<Contributors>();
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 15);
       
        
        
       // Font font = new Font(Font.MONOSPACED, Font.BOLD, 14);
        JFrame frame = new JFrame("Midterm Champaign Contribution Application");
        frame.setSize(750, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = frame.getContentPane();


        JPanel panel1 = new JPanel();


        container.add(panel1);
        
        JLabel lastName = new JLabel("Contributer Last Name:");
        panel1.add(lastName);
        
        lastNameContent = new JTextField(8);
        panel1.add(lastNameContent);
        
        JLabel firstName = new JLabel("First Name");
        panel1.add(firstName);
        
        firstNameContent = new JTextField(8);
        panel1.add(firstNameContent);
        
        JLabel amount = new JLabel("Amount");
        panel1.add(amount);
        
        amountContent = new JTextField(8);
        panel1.add(amountContent);
        
        contributeToObama = new JButton("Contribute to Obama");
        panel1.add(contributeToObama);
        contributeToObama.addActionListener(this);
        
        contributeToRomney = new JButton("Contribute to Romney");
        panel1.add(contributeToRomney);
        contributeToRomney.addActionListener(this);
        
        listObama = new JButton("List Obama Contributors");
        panel1.add(listObama);
        listObama.addActionListener(this);
        
        listRomney = new JButton("List Romney Contributors");
        panel1.add(listRomney);
        listRomney.addActionListener(this);
        
        contentShow = new JTextArea(20,40);
        contentShow.setFont(font);
        panel1.add(contentShow);
        contentShow.setEditable(false);
        JScrollPane scroller = new JScrollPane(contentShow);
        panel1.add(scroller);
        
        
        frame.setVisible(true);
        
        

    

                
        
    }
    
         public void actionPerformed(ActionEvent e) {
             int flag = 0;
             long sum = 0;
             String voteFor;
             Contributors currentContributor = null;
        if (e.getSource() == contributeToObama) {
            if (lastNameContent.getText().isEmpty()) {
                contentShow.append("LastName Missing!\n");
                lastNameContent.setText(null);
            } else 
                if (firstNameContent.getText().isEmpty()) {
                    contentShow.append("FirstName Missing!\n");
                    firstNameContent.setText(null);
                } else 
                    if (!amountContent.getText().matches("^-?\\d+$")) {
                        contentShow.append("Contribution amount must be integer!\n");
                    } else 
                        if (Integer.parseInt(amountContent.getText()) < 0) {
                            contentShow.append("Contribution amount must be positive!\n");
                        } else 
                        {
           voteFor = "Obama";
           for (Contributors contributor: obamaContributor) {
               flag = checkContributor(contributor);
           }
           if (flag == 0) {
             //  System.out.println("Enter point to new contributor");
               currentContributor = createContributor(voteFor);
           //    System.out.println("has a new contributor");
               obamaContributor.add(currentContributor);
               
           }
                }
        } else
         if (e.getSource() == contributeToRomney) {
             if (lastNameContent.getText().isEmpty()) {
                 contentShow.append("LastName Missing!\n");
                 lastNameContent.setText(null);
             } else 
                 if (firstNameContent.getText().isEmpty()) {
                     contentShow.append("FirstName Missing!\n");
                     firstNameContent.setText(null);
                 } else 
                     if (!amountContent.getText().matches("^-?\\d+$")) {
                         contentShow.append("Contribution amount must be integer!\n");
                     } else 
                         if (Integer.parseInt(amountContent.getText()) < 0) {
                             contentShow.append("Contribution amount must be positive!\n");
                         } else 
                         {
             for (Contributors contributor: romneyContributor) {
                 flag = checkContributor(contributor);
             }
             if (flag == 0) {
                 voteFor = "Romney";
                 currentContributor = createContributor(voteFor);
                 romneyContributor.add(currentContributor);
                 
             }
                         }
         } else
         if (e.getSource() == listObama) {
             sum = 0;
             listSort(obamaContributor);
             contentShow.setText("");
             for (Contributors contributor: obamaContributor) {
                 contentShow.append(contributor.toString()+"\n");
                 sum = sum + contributor.getMoney();
             }
             contentShow.append("Total Contributions for Obama: $ "+String.format("%,d", sum) + "\n");
         } else
         if (e.getSource() == listRomney) {
             sum = 0;
             listSort(romneyContributor);
             contentShow.setText("");
             for (Contributors contributor: romneyContributor) {
                 contentShow.append(contributor.toString()+"\n");
             }
             contentShow.append("Total Contributions for Romney: $ "+String.format("%,d", sum) + "\n");
         }
        }
        

    
         
         public  void listSort (List<Contributors> candidateList) {
             int length = candidateList.size();
             int i;
             int j;
             int judge;
             for ( i = 0; i < length; i++) {
                 for ( j = i; j < length; j++) {
                     if (candidateList.get(i).getMoney() < candidateList.get(j).getMoney()) {
                         switchList(i, j, candidateList);
                     } else 
                         if (candidateList.get(i).getMoney() == candidateList.get(j).getMoney()) {
                             judge = candidateList.get(i).getLastName().compareTo(candidateList.get(j).getLastName());
                             if (judge < 0) {
                                 switchList(i, j, candidateList);
                             } else if (judge == 0) {
                                 if (candidateList.get(i).getFirstName().compareTo(candidateList.get(j).getFirstName()) < 0) {
                                     switchList(i, j, candidateList);
                                 }
                             }
                         }
                     
                 }
                 
             }
         }
         
         public void switchList (int i, int j, List<Contributors> candidateList) {
         Contributors temp;
         temp = candidateList.get(i);
         candidateList.set(i, candidateList.get(j));
         candidateList.set(j, temp);
         
         }
         
         public int checkContributor(Contributors contributor) {
              long newmoney;
              int flag =0;
              int flagvalid = 0;
              System.out.println("check the contributor");
             if ((contributor.getFirstName().equals(firstNameContent.getText())) &&
                     (contributor.getLastName().equals(lastNameContent.getText()))) {
                     newmoney = Long.parseLong(amountContent.getText()) + 
                                 contributor.getMoney();
                     if (newmoney >= 10000000) {
                         //contentShow.append("Personal contribution should less than 10000000");
                         flagvalid = 1;
                     } else {
                     contributor.setMoney(newmoney);
                     }
                     flag = 1;
                     if (flagvalid == 1) {
                         contentShow.append(contributor.toString()+"\n");
                         contentShow.append("Personal contribution should less than $10,000,000!");
                     } else {
                         contentShow.append(contributor.toString() + "\n");
                         firstNameContent.setText("");
                         lastNameContent.setText("");
                         amountContent.setText("");
                     }
             }
             return flag;
         }
         
         public Contributors createContributor(String voteFor) {
             int flagvalid = 0;
             String validFirstName;
             String validLastName;
             if (firstNameContent.getText().length() > 15) {
                 validFirstName = firstNameContent.getText().substring(0, 15);
             } else {
                 validFirstName = firstNameContent.getText();
             }
             if (lastNameContent.getText().length() > 15) {
                 validLastName = lastNameContent.getText().substring(0, 15);
             } else {
                 validLastName = lastNameContent.getText();
             }
             Contributors newContributor = new Contributors(); 
             newContributor.setFirstName(validFirstName);
             newContributor.setLastName(validLastName);
             newContributor.setVoteFor(voteFor);
//             System.out.println(amountContent.getText());
             if (Integer.parseInt(amountContent.getText()) >= 10000000) {
                 flagvalid = 1;
                 //contentShow.append("Personal contribution should less than 10000000");
                 newContributor.setMoney(0);
             } else {
             newContributor.setMoney(Long.parseLong(amountContent.getText()));
             }
             if (flagvalid == 1) {
                 contentShow.append(newContributor.toString() + "\n");
                 contentShow.append("Personal contribution should less than $10,000,000!\n");

             } else {
                 contentShow.append(newContributor.toString()+ "\n");
                 firstNameContent.setText("");
                 lastNameContent.setText("");
                 amountContent.setText("");
                 
             }
             return newContributor;
         }
         
    private class Contributors {
        private String lastName;
        private String firstName;
        private long money;
        private String voteFor;
        
        private void setLastName(String newlastName) {
            lastName = newlastName;
        }
        public String getLastName() {
            return lastName;
        }
        private void setFirstName(String newfirstName) {
            firstName = newfirstName;
        }
        public String getFirstName() {
            return firstName;
        }
        private void setMoney(long newMoney) {
            money = newMoney;
        }
        public long getMoney() {
            return money;
        }
        private void setVoteFor(String people) {
            voteFor = people;
        }
        private String getVoteFor() {
            return voteFor;
        }
        
        @Override
        public String toString() {
             return String.format("%-15s", lastName + "," + firstName) + String.format("%,10d", money)+String.format("%10s", voteFor);
            //return firstName + ", " + lastName  + "\t" + "$" + String.format("%,d", money) + "\t" + voteFor; 
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         new Practice();
    }

}
