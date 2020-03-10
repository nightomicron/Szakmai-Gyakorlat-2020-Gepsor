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
public class Product {
    private int b;
    private Object [][] r;
    private Object [] p;

    public Product(int b, Object[][] r, Object[] p) {
        this.b = b;
        this.r = r;
        this.p = p;
    }
    
    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Object[][] getR() {
        return r;
    }

    public void setR(Object[][] r) {
        this.r = r;
    }

    public Object[]getP() {
        return p;
    }

    public void setP(Object[] p) {
        this.p = p;
    }
    
    
}
