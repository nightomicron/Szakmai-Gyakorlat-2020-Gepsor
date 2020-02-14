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
    private Object b;
    private Object [][] r;
    private Object [] p;

    public Product(Object b, Object[][] r, Object[] p) {
        this.b = b;
        this.r = r;
        this.p = p;
    }
    
    public Object getB() {
        return b;
    }

    public void setB(Object b) {
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

    public void setP(Object[] r) {
        this.p = p;
    }
    
    
}
