
import Tube.SetUp;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

//class for saving and loading the configurations into / from txt file(s)
public class Genconf {
    //Method for saving the configuration values into a txt file
    //Parameters: a SetUp instance, String file name
    public static void saveconf(SetUp tube, String fname) throws FileNotFoundException{
        
        Object[] c = tube.getC();
        Object[] w = tube.getW();
        Object[] ttr = tube.getTtr();
        Object[] tpp = tube.getTpp();
        Object[][] an = tube.getAn();
        Object[][] nh = tube.getNh();
        
        //sets the console to write its content into the text file through a printstream        
        PrintStream out = new PrintStream(new FileOutputStream(fname));
        System.setOut(out);
        System.out.println("#### parameters for machine configuration ####");
        System.out.println("# number of machine modules");
        System.out.println("numM=" + tube.getM());
        System.out.println("# number of head types");
        System.out.println("numH=" + tube.getH());
        System.out.println("# number of nozzle types");
        System.out.println("numN=" + tube.getN());
        System.out.println("# number of component types");
        System.out.println("numA=" + tube.getA());
        System.out.println("# capacity of feeder");
        System.out.println("capF=" + tube.getF());
        System.out.println("# capacity of head types");
        System.out.print("capH=");
        
        for(int i=0;i<c.length;i++){
            if(i==c.length-1){
                System.out.print(c[i]);
            }else{
                System.out.print(c[i] + " ");
            }
        }
        
        System.out.println();
        System.out.println("# width of the component types (in tapes)");
        System.out.print("widthA=");
        
        for(int i=0;i<w.length;i++){
            if(i==w.length-1){
                System.out.print(w[i]);
            }else{
                System.out.print(w[i] + " ");
            }
        }
        
        System.out.println();
        System.out.println("# traveling time of head types");
        System.out.print("travTimeH=");
        
        for(int i=0;i<ttr.length;i++){
            if(i==ttr.length-1){
                System.out.print(ttr[i]);
            }else{
                System.out.print(ttr[i] + " ");
            }
        }
        
        System.out.println();
        System.out.println("# pick-and-place time of head types");
        System.out.print("ppTimeH=");
        
        for(int i=0;i<tpp.length;i++){
            if(i==tpp.length-1){
                System.out.print(tpp[i]);
            }else{
                System.out.print(tpp[i] + " ");
            }
        }
        
        System.out.println();
        System.out.println("# component-nozzle compatibility matrix");
        System.out.print("compatAN=");
        
        for(int i=0;i<tube.getA();i++){
            for(int j=0;j<tube.getN();j++){
                if(j==tube.getN()-1){
                    System.out.print(an[i][j] + ";");
                }else{
                    System.out.print(an[i][j] + " ");
                }
            }
        }
        
        System.out.println();
        System.out.println("# nozzle-head compatibility matrix");
        System.out.print("compatNH=");
        
        for(int i=0;i<tube.getN();i++){
            for(int j=0;j<tube.getH();j++){
                if(j==tube.getH()-1){
                    System.out.print(nh[i][j] + ";");
                }else{
                    System.out.print(nh[i][j] + " ");
                }
            }
        }
        //closes the file and also the printstream, gives the console back to the program (it will not write its contents into files anymore)
        out.close();
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
    
    //Method for loading configuration files and placing its values into a SetUp instance
    //parameters: String filename
    public static SetUp loadconf(String fname) throws FileNotFoundException{
        SetUp conf = new SetUp(0,0,0,0,0,null,null,null,null,null,null);
        
        char temp = 0;
        int m = 0;
        int h = 0;
        int n = 0;
        int a = 0;
        int f = 0;
        
        //opens the file and creates a scanner than can search for character chains inside the lines of the file
        //once found the desired character chains, it will grab the content of the line and will place them into the instance
        File file = new File(fname);
        final Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            final String lineFromFile = scanner.nextLine();
            
            //M number of the machines
            if(lineFromFile.contains("numM=")) { 
                temp = lineFromFile.charAt(lineFromFile.length()-1);
                m = temp-'0';
                conf.setM(m);
            }
            
            //H number of the heads
            if(lineFromFile.contains("numH=")) { 
                temp = lineFromFile.charAt(lineFromFile.length()-1);
                h = temp-'0';
                conf.setH(h);
            }
            
            //N number of the nozzles
            if(lineFromFile.contains("numN=")) { 
                temp = lineFromFile.charAt(lineFromFile.length()-1);
                n = temp-'0';
                conf.setN(n);
            }
            
            //A number of the components
            if(lineFromFile.contains("numA=")) { 
                temp = lineFromFile.charAt(lineFromFile.length()-1);
                a = temp-'0';
                conf.setA(a);
            }
            
            //F number of the feeders
            if(lineFromFile.contains("capF=")) { 
                temp = lineFromFile.charAt(lineFromFile.length()-1);
                f = temp-'0';
                conf.setF(f);
            }
            
            //C number of the capacity of the heads
            Object[] c = new Object[h];
            if(lineFromFile.contains("capH=")) {
                int counter=0;
                for(int i=0; i<lineFromFile.length()-5; i++){
                    if(lineFromFile.charAt(5+i)!=' '){
                        temp = lineFromFile.charAt(5+i);
                        c[counter] = temp-'0';
                        counter++;
                    }
                }
                conf.setC(c);
            }
            
            //W number of the width of the components
            Object[] w = new Object[a];
            if(lineFromFile.contains("widthA=")) {
                int counter=0;
                for(int i=0; i<lineFromFile.length()-7; i++){
                    if(lineFromFile.charAt(7+i)!=' '){
                        temp = lineFromFile.charAt(7+i);
                        w[counter] = temp-'0';
                        counter++;
                    }
                }
                conf.setW(w);
            }
            
            //TTR travel time of the heads
            Object[] ttr = new Object[h];
            if(lineFromFile.contains("travTimeH=")) {
                int counter=0;
                for(int i=0; i<lineFromFile.length()-10; i++){
                    if(lineFromFile.charAt(10+i)!=' '){
                        temp = lineFromFile.charAt(10+i);
                        ttr[counter] = temp-'0';
                        counter++;
                    }
                }
                conf.setTtr(ttr);
            }
            
            //TPP pick and place time of the heads
            Object[] tpp = new Object[h];
            if(lineFromFile.contains("ppTimeH=")) {
                int counter=0;
                for(int i=0; i<lineFromFile.length()-8; i++){
                    if(lineFromFile.charAt(8+i)!=' '){
                        temp = lineFromFile.charAt(8+i);
                        tpp[counter] = temp-'0';
                        counter++;
                    }
                }
                conf.setTpp(tpp);
            }
            
            //AN compatibility between the nozzles and components
            Object[][] an = new Object[a][n];
            if(lineFromFile.contains("compatAN=")) {
                int counterA=0;
                int counterN=0;
                for(int i=0; i<lineFromFile.length()-9; i++){
                    if(lineFromFile.charAt(9+i)==';'){
                        counterA++;
                        counterN=0;
                    }else if(lineFromFile.charAt(9+i)!=' '){
                        temp = lineFromFile.charAt(9+i);
                        an[counterA][counterN] = temp-'0';
                        counterN++;
                    }
                }
                conf.setAn(an);
            }
            
            //NH compatibility of the nozzles and the heads
            Object[][] nh = new Object[n][h];
            if(lineFromFile.contains("compatNH=")) {
                int counterN=0;
                int counterH=0;
                for(int i=0; i<lineFromFile.length()-9; i++){
                    if(lineFromFile.charAt(9+i)==';'){
                        counterN++;
                        counterH=0;
                    }else if(lineFromFile.charAt(9+i)!=' '){
                        temp = lineFromFile.charAt(9+i);
                        nh[counterN][counterH] = temp-'0';
                        counterH++;
                    }
                }
                conf.setNh(nh);
            }
        }
        
        return conf;
    }
}
