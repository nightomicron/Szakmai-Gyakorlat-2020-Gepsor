/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tube;

/**
 *
 * @author nimrod
 */
public class SetUp {
    private int m;
    private int h;
    private int n;
    private int a;
    private int f;
    private Object[] c; 
    private Object[] tpp;
    private Object[] w;
    private Object[][] nh;
    private Object[] ttr;
    private Object[][] an;

    public SetUp(int m, int h, int n, int a, int f, Object[] c, Object[] tpp, Object[] w, Object[][] nh, Object[] ttr, Object[][] an) {
        this.m = m;
        this.h = h;
        this.n = n;
        this.a = a;
        this.f = f;
        this.c = c;
        this.tpp = tpp;
        this.w = w;
        this.nh = nh;
        this.ttr = ttr;
        this.an = an;
    }

    public Object[] getC() {
        return c;
    }

    public void setC(Object[] c) {
        this.c = c;
    }

    public Object[] getTpp() {
        return tpp;
    }

    public void setTpp(Object[] tpp) {
        this.tpp = tpp;
    }

    public Object[] getW() {
        return w;
    }

    public void setW(Object[] w) {
        this.w = w;
    }

    public Object[][] getNh() {
        return nh;
    }

    public void setNh(Object[][] nh) {
        this.nh = nh;
    }

    public Object[] getTtr() {
        return ttr;
    }

    public void setTtr(Object[] ttr) {
        this.ttr = ttr;
    }

    public Object[][] getAn() {
        return an;
    }

    public void setAn(Object[][] an) {
        this.an = an;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }
    
    //checks if nozzle and head are compatible at the given spot
    public boolean isCompatibleNozzleTHeadT(int y, int h){
        if(Integer.parseInt(nh[y][h].toString()) == 1){
            return true;
        }else{
            return false;
        }  
    }
    
    public boolean isCompatibleCompTNozzleT(int cV, int yV){
        if(Integer.parseInt(an[cV][yV].toString()) == 1){
            return true;
        }else{
            return false;
        } 
    }
    
    public int getCompWidth(int aV){
        int wV = Integer.parseInt(w[aV].toString());
        return wV;
    }
    
    public int getTravelingTimeHead(int num){
        int ttrV = Integer.parseInt(ttr[num].toString());
        return ttrV;
    }
    
    public int getPickPlaceTimeHead(int hV){
        int tppV = Integer.parseInt(tpp[hV].toString());
        return tppV;
    }
}
