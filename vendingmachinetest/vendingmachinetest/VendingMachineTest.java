import javax.swing.JOptionPane;

public class VendingMachineTest { 

   
    
    final static String minuman_0 = "Sprite";
    final static int harga_0 = 6000;
    final static int jumlah_0 = 10;
    
    final static String minuman_1 = "Fanta";
    final static int harga_1 = 6000;
    final static int jumlah_1 = 10;
    
    final static String minuman_2 = "Coca-cola";
    final static int harga_2 = 6000;
    final static int jumlah_2 = 10;
    
    final static String minuman_3 = "Mizone";
    final static int harga_3 = 5000;
    final static int jumlah_3 = 10;
    
    final static String minuman_4 = "Minute paid pulpy";
    final static int harga_4 = 7500;
    final static int jumlah_4 = 10;
    
    final static String minuman_5 = "Aqua";
    final static int harga_5 = 4000;
    final static int jumlah_5 = 10;
    
    final static String minuman_6 = "Bear brand";
    final static int harga_6 = 11500;
    final static int jumlah_6 = 10;
    
    final static String minuman_7 = "Teh pucuk";
    final static int harga_7 = 8000;
    final static int jumlah_7 = 10;
    
    final static String minuman_8 = "Pocari Sweat";
    final static int harga_8 = 10000;
    final static int jumlah_8 = 10;
    
    final static String minuman_9 = "Indomilk";
    final static int harga_9 = 8000;
    final static int jumlah_9 = 10;
    
    
    private static int balance;
    private static boolean CA = false;
   
    private static int harga[] = new int[12];
           
    private static String minuman[] = new String[12];
            
    private static int jumlah[] = new int[12];
            
    private static int Pilihan;
    private static int MaxLen = 0; 
    public static void setharga(int ItemNumber, int harga) {
      
        harga[ItemNumber] = harga; 
    } 

    public static int getharga(int ItemNumber) {
      
        return harga[ItemNumber]; 
    } 
    
    public static void setjumlah(int ItemNumber, int jumlah) {
       
        jumlah[ItemNumber] = jumlah;
    } 
    
    public static void setInitjumlah() {
        int i;
        for ( i=0 ; i<12 ;i++){
            setjumlah(i,10);
        }
    } 
    
    public static void setPilihan(int ItemNumber){
        Pilihan = ItemNumber;
    }
    
    public static int getPilihan(){
        return Pilihan;
    }
    
    public static int getjumlah(int ItemNumber) {
       
        return jumlah[ItemNumber]; 
    } 
    
    
    public static void setminuman(int ItemNumber, String minuman) {
      
        minuman[ItemNumber] = minuman; 
    } 

    public static String getminuman(int ItemNumber) {
      
        return minuman[ItemNumber]; 
    } 

    public VendingMachineTest(int myBalance, boolean CloseAfter) { 
        balance = myBalance; 
        CA = CloseAfter;
        setInitjumlah();
       
    } 

    public static boolean getCA() {
        return CA;
    }

    public static void setBalance(int Balance) {
        
        balance = Balance; 
    } 
    public static boolean BuyItem(int ItemNumber) {
        int jumlah;
        boolean returnMe; 
       
        if (balance < getharga(ItemNumber)) {
            
            Output("Mohon Isi Saldo", 1);
           
            returnMe = false;
        } 
        
        else if(getjumlah(ItemNumber)==0){
            Output("Stok Habis\n", 1);
            returnMe = false;
        }

        else { 
            balance -= getharga(ItemNumber); 
            jumlah = getjumlah(ItemNumber) - 1;
            setjumlah(ItemNumber, jumlah);
            Output("Transaksi : " + getminuman(ItemNumber) + " \nSeharga : " + PrettyMoney(getharga(ItemNumber)), 1);
            
            returnMe = true; 
        } 

        return returnMe; 
    } 

    public static void PrintMenu() {
       
        String myMenu =
              "1  " + getminuman(0) + "   " + PrettyMoney(getharga(0)) + "    T  Rp. 1.0000 (Sepuluh Ribu)\n" +
              "2  " + getminuman(1) + "   " + PrettyMoney(getharga(1)) + "    F  Rp. 5.000 (Lima Ribu)\n" +
              "3  " + getminuman(2) + "   " + PrettyMoney(getharga(2)) + "    D  Rp. 2.000 (Dua Ribu)\n" +
              "4  " + getminuman(3) + "   " + PrettyMoney(getharga(3)) + "    S  Rp. 1.000 (Seribu)\n" +
              "5  " + getminuman(4) + "   " + PrettyMoney(getharga(4)) + "    L  Rp. 5.00 (500)\n" +
              "6  " + getminuman(5) + "   " + PrettyMoney(getharga(5)) + "    C  Coin Return";
        
        Output(myMenu, 1); 
    } 

    public static void Output(String Message, int Type) {
       
        if (Type == 1) {  
            JOptionPane.showMessageDialog(null, Message, "Vending Machine", JOptionPane.PLAIN_MESSAGE);
        } 
        else { 
        } 
    }

    public static void ReturnChange() {
      
        int myTotal = getBalance(); 
        int Rupiah = 0; 
         

        Rupiah = myTotal; 

        Output("Transaksi Berhasil \nSisa Saldo Anda : " + PrettyMoney(getBalance()) + " \nSilahkan Ambil Minuman Anda\nTerima Kasih",1); 
                
       
        
    } 

    public static String getPrettyBalance() {
       
        return PrettyMoney(balance); 
    } 
    public static int getBalance() {
      
        return balance; 
    } 

    public static void AddMoney(int Amount) {
       
        balance = balance + Amount; 
    } 
    public static void Initialize() {
      
        int i = 0; 
        String minuman = null; 
        setminuman(0, minuman_0);
        setminuman(1, minuman_1);
        setminuman(2, minuman_2);
        setminuman(3, minuman_3);
        setminuman(4, minuman_4);
        setminuman(5, minuman_5);
        setminuman(6, minuman_6);
        setminuman(7, minuman_7);
        setminuman(8, minuman_8);
        setminuman(9, minuman_9);
       
        
        setharga(0, harga_0);
        setharga(1, harga_1);
        setharga(2, harga_2);
        setharga(3, harga_3);
        setharga(4, harga_4);
        setharga(5, harga_5);
        setharga(6, harga_6);
        setharga(7, harga_7);
        setharga(8, harga_8);
        setharga(9, harga_9);
        
        
        for(i = 0 ; i < 10; i++) { 
            minuman = getminuman(i); 
            if (minuman.length() > MaxLen) { 
                MaxLen = getminuman(i).length(); 
            } 
        } 
        Formatminuman(MaxLen);
    } 

    public static void Formatminuman(int ML) {
        // format semua deskriipsi berdasar length terpanjang
        /* contoh:
            Formatminumanription(20);
            mengambil semua string dan spasi sampai 20 karakter
        */
    } // END Formatminumanription(int ML)

    public static String PrettyMoney (int Money) {
        int Rupiah = 0;
   
        String Pretty = null;
        Rupiah = Money; 
        Pretty = "Rp. " + Rupiah; 
        return Pretty;
    } 
    
    public static void ScanCard(){
        setBalance(50000);
        Output("Silahkan mulai transaksi",1);
    
    }
    
    
    
} 