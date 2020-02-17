
import Tube.Product;
import Tube.SetUp;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class Genpcb {
    public static void savepcb(Product pcb, SetUp conf, String fname) throws FileNotFoundException{
        
        int a = conf.getA();
        int b = pcb.getB();
        Object[] p = pcb.getP();
        Object[][] r = pcb.getR();
        
        PrintStream out = new PrintStream(new FileOutputStream(fname));
        System.setOut(out);
        
        System.out.println("# number of PCB types");
        System.out.println("numPCB=" + b);
        System.out.println("# number of pieces of each PBC type to produce");
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
        
        out.close();
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
    
    public static Product loadB(String fname, SetUp conf) throws FileNotFoundException{
        Product pcb = new Product(0,null,null);
        
        int a = conf.getA();
        int b = 0;
        Object[] p = new Object[b];
        Object[][] r = new Object[b][a];
        char temp = 0;
        
        File file = new File(fname);
        final Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            final String lineFromFile = scanner.nextLine();

            //B
            if(lineFromFile.contains("numPCB=")) { 
                temp = lineFromFile.charAt(lineFromFile.length()-1);
                b = temp-'0';
                pcb.setB(b);
            }
            
            //P
            if(lineFromFile.contains("numPiecesPCB=")) {
                int counter=0;
                for(int i=0; i<lineFromFile.length()-13; i++){
                    if(lineFromFile.charAt(13+i)!=' '){
                        temp = lineFromFile.charAt(13+i);
                        p[counter] = temp-'0';
                        counter++;
                    }
                }
                pcb.setP(p);
            }
            
            //R
            if(lineFromFile.contains("numPiecesCompPCB=")) {
                int counterB=0;
                int counterA=0;
                for(int i=0; i<lineFromFile.length()-17; i++){
                    if(lineFromFile.charAt(17+i)==';'){
                        counterB++;
                        counterA=0;
                    }else if(lineFromFile.charAt(17+i)!=' '){
                        temp = lineFromFile.charAt(17+i);
                        r[counterB][counterA] = temp-'0';
                    }
                }
                pcb.setR(r);
            }
        }
        
        return pcb;
    }
}
