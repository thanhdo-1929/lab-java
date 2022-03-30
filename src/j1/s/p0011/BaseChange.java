/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011;

/**
 *
 * @author 84964
 */
public class BaseChange {
    
    //Change from demical to base
    public String decToBase(String n, int base) {
        StringBuilder sb = new StringBuilder();
        long remainder = Long.parseLong(n);
        long m;
        if (Long.parseLong(n) == 0) {
            return "0";
        }
        while (remainder > 0) {
            m = remainder % base;
            remainder = remainder / base;
            if (m > 9) {
                sb.append((char) (55 + m));
            } else {
                sb.append(m);
            }
        }
        return sb.reverse().toString();
    }
    
    //Change from base to demical
    public long baseToDec(String n, int base) {
        n = new StringBuilder(n).reverse().toString();
        long num = 0;
        char c;
        long hashCode;
        for (int i = 0; i < n.length(); i++) {
            c = n.charAt(i);
            if (Character.isDigit(c)) {
                num += Long.parseLong(c + "") * Math.pow(base, i);
            } else {
                hashCode = Character.hashCode(c) - 55;
                num += hashCode * Math.pow(base, i);
            }
        }
        return num;
    }
}
