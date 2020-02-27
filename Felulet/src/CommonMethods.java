

//Class for methods that can appear in other classes
public class CommonMethods {
    //method for setting the conf, pcb instances and the booleans to default
    public static void changed(){
        SplashScreen.conf.setM(0);
        SplashScreen.conf.setH(0);
        SplashScreen.conf.setN(0);
        SplashScreen.conf.setA(0);
        SplashScreen.conf.setF(0);
        SplashScreen.conf.setC(null);
        SplashScreen.conf.setAn(null);
        SplashScreen.conf.setNh(null);
        SplashScreen.conf.setTpp(null);
        SplashScreen.conf.setTtr(null);
        SplashScreen.conf.setW(null);
        SplashScreen.pcb.setB(0);
        SplashScreen.pcb.setP(null);
        SplashScreen.pcb.setR(null);
        SplashScreen.pcbloaded = false;
        SplashScreen.confloaded = false;
        SplashScreen.pcbsaved = false;
        SplashScreen.confsaved = false;
    }
}
