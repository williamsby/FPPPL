import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.JOptionPane; 

public class VendingMachineUI extends JFrame implements ActionListener {
   
    private int StartingBalance = 50000; 
    public boolean CloseAfter = false; 
    private int Width = 975; 
    private int Height = 435;
    private JButton Buttons[]; 
    private int i; 
    public VendingMachineTest Machine = new VendingMachineTest(StartingBalance, CloseAfter); 
    public JLabel About = new JLabel("   Selamat Datang");
    public JLabel Bal = new JLabel("   Saldo Anda : " + Machine.getPrettyBalance());
    public VendingMachineUI() { 
        setTitle("FINAL PROJECT");
        Toolkit myTK = Toolkit.getDefaultToolkit();
        Dimension myD = myTK.getScreenSize();
        setBounds((myD.width - Width)/3, (myD.height - Height)/3, Width, Height);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            } 
        }
        ); 

        Buttons = new JButton[11]; 
        Machine.Initialize(); 
        for (i = 0 ; i < 11 ; i++) {
            if (Machine.getStock(i) != 0 & i!=9){
                Buttons[i] = new JButton(Machine.getminuman(i) + " - " + Machine.PrettyMoney(Machine.getharga(i)) + " - " + Machine.getjumlah(i));
            }
            else{
                Buttons[i] = new JButton(Machine.getminuman(9) + " - " + Machine.PrettyMoney(Machine.getharga(9)));
            }
        } 

        Buttons[10] = new JButton("Bayar");
         
        Container pane = getContentPane(); 
        pane.setLayout(new GridLayout(5,3));
        for(i = 0 ; i < 4; i++) { 
            pane.add(Buttons[i]); 
            pane.add(Buttons[i+4]);
            pane.add(Buttons[i+8]);
            Buttons[i].addActionListener(this); 
            Buttons[i+4].addActionListener(this); 
            Buttons[i+8].addActionListener(this); 
        } 

        pane.add(Bal); 
        pane.add(About); 
    } 
    public void actionPerformed(ActionEvent e) { 
        boolean Success;
        Machine.Initialize();
        Object theButton = e.getSource();
        int pilih = Machine.getPilihan();
            if(theButton == Buttons[i]) { 
                switch(i) { 
                 
                    case 11: 
                        Success = Machine.BuyItem(pilih);
                    if ((Machine.getCA() == true) || (Success == true)) {
                        Machine.ReturnChange();
                        if (Machine.getjumlah(pilih) !=0){
                            Buttons[pilih].setText(Machine.getminuman(pilih) + " - " + Machine.PrettyMoney(Machine.getPrice(pilih)) + " - " + Machine.getjumlah(pilih));
                        }
                        else{
                            Buttons[pilih].setText(Machine.getminuman(9) + " - " + Machine.PrettyMoney(Machine.getharga(9)));
                        }
                    }
                        break;
                    
                        
                } 
            } 
        for(i = 0; i < 11; i++) { 
            if(theButton == Buttons[i]) { 
                Machine.setPilihan(i); 
                
            } 
        } 
        Bal.setText("   Saldo Anda : " + VendingMachineTest.getPrettyBalance());
      
    } 
} 
