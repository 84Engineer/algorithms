/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

/**
 *
 * @author LocalUser
 */
public class Euclide {
   
    public static void main(String[] args) {
        System.out.println(euclid(16, 25));
    }
    
    public static int euclid(int a, int b) {
        System.out.println("a=" + a + ", b=" + b);
        if (b == 0) {
            return a;
        } else {
            return euclid(b, a % b);
        }
    }
    
}
