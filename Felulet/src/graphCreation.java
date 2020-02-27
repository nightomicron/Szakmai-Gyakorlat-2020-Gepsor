
import Tube.Product;
import Tube.SetUp;


public class graphCreation {
    public static String[][] create(SetUp conf, Product pcb){
        int a = SplashScreen.conf.getA();
        int x = 0;
        int m = SplashScreen.conf.getM();
        int h = SplashScreen.conf.getM()*SplashScreen.conf.getH();
        int s = 0;
        
        s=0; 
        Object c[] = SplashScreen.conf.getC();
        
        for(int i=0; i<c.length;i++){
            s+=Integer.parseInt(c[i].toString());
        }
        s=s*m;
        
        /*Object nh[][] = SplashScreen.conf.getNh();
        int hn = 0;
        for(int i=0; i<SplashScreen.conf.getH();i++){
            int temp=0;
            for(int j=0; j<SplashScreen.conf.getN();j++){
                if(Integer.parseInt(nh[i][j].toString())==1){
                    temp++;
                }
            }
            hn+=temp*Integer.parseInt(c[i].toString());
        }
        hn=hn*m;*/
        
        
        x=a+m+h+s;
        String[][] graph = new String[x][x];
        System.out.println(a);
        System.out.println(m);
        System.out.println(h);
        System.out.println(s);
        //System.out.println(hn);
        System.out.println(x);
        return graph;
    }
}
