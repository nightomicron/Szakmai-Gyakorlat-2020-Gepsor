package Generator;


import Tube.Product;
import Tube.SetUp;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

//class for saving and loading the pcb information into / from txt file(s)
public class Genpcb {
    //Method for saving the configuration values into a txt file
    //Parameters: a SetUp instance, String file name
    public static void savepcb(Product pcb, SetUp conf, String fname) throws FileNotFoundException{
        
        int a = conf.getA();
        int b = pcb.getB();
        Object[] p = pcb.getP();
        Object[][] r = pcb.getR();
        
        //sets the console to write its content into the text file through a printstream      
        PrintStream out = new PrintStream(new FileOutputStream(fname));
        System.setOut(out);
        
        System.out.println("# number of PCB types");
        System.out.println("numPCB=" + b);
        System.out.println("# number of pieces of each PCB type to produce");
        System.out.print("numPiecesPCB=");
        
        for(int i=0;i<p.length;i++){
            if(i==p.length-1){
                System.out.print(p[i]);
            }else{
                System.out.print(p[i] + " ");
            }
        }
        
        System.out.println();
        System.out.println("# number of component placements of each PCB by component types");
        System.out.print("numPiecesCompPCB=");
        
        for(int i=0;i<b;i++){
            for(int j=0;j<a;j++){
                if(j==a-1){
                    System.out.print(r[i][j] + ";");
                }else{
                    System.out.print(r[i][j] + " ");
                }
            }
        }
        //closes the file and also the printstream, gives the console back to the program (it will not write its contents into files anymore)
        out.close();
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
    
    //Method for loading configuration files and placing its values into a SetUp instance
    //parameters: String filename
    public static Product loadpcb(String fname, SetUp conf) throws FileNotFoundException{
        Product pcb = new Product(0,null,null);
        
        int a = conf.getA();
        int b = 0;
        //char temp = 0;
        
        //opens the file and creates a scanner than can search for character chains inside the lines of the file
        //once found the desired character chains, it will grab the content of the line and will place them into the instance
        File file = new File(fname);
        final Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            final String lineFromFile = scanner.nextLine();

            //B number of pcbs
            if(lineFromFile.contains("numPCB=")) { 
                String temp = "";
                for(int i=7; i<lineFromFile.length(); i++){
                    temp=temp+lineFromFile.charAt(i);
                }
                b = Integer.parseInt(temp);
                pcb.setB(b);
            }
            
            //P number of the pieces of pcbs
            Object[] p = new Object[b];
            if(lineFromFile.contains("numPiecesPCB=")) {
                String temp="";
                int counter=0;
                for(int i=0; i<lineFromFile.length()-13; i++){
                    if(lineFromFile.charAt(13+i)!=' '){
                        temp = temp+lineFromFile.charAt(13+i);
                        p[counter] = Integer.parseInt(temp);
                    }else{
                        counter++;
                        temp="";
                    }
                }
                pcb.setP(p);
            }
            
            //R comptabibility between the pieces and the pcbs
            Object[][] r = new Object[b][a];
            if(lineFromFile.contains("numPiecesCompPCB=")) {
                String temp="";
                int counterB=0;
                int counterA=0;
                for(int i=0; i<lineFromFile.length()-17; i++){
                    if(lineFromFile.charAt(17+i)==';'){
                        counterB++;
                        counterA=0;
                        temp="";
                    }else if(lineFromFile.charAt(17+i)!=' '){
                        temp = temp+lineFromFile.charAt(17+i);
                        r[counterB][counterA] = Integer.parseInt(temp);
                    }else{
                        counterA++;
                        temp="";
                    }
                }
                pcb.setR(r);
            }
        }
        
        return pcb;
    }
}
