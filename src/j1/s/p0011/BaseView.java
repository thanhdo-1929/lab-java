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
public class BaseView {

    private BaseChange changer = new BaseChange();
    private DataInput in = new DataInput();

    //Change base binary
    public void Base2() {
        while (true) {
            System.out.println("1-Base 2 to Base 10");
            System.out.println("2-Base 2 to Base 16");
            System.out.print("Please choice one option: ");
            int option = in.inputInt(1, 2, "PLease choose 1 or 2!");
            switch (option) {
                case 1: //change base binaru to demical
                    String convertNum = in.inputBinary();
                    System.out.println("Number after change is: "
                            + changer.baseToDec(convertNum, 2));
                    return;
                case 2: //change base binary to hexademical
                    long temp = changer.baseToDec(in.inputBinary(), 2);
                    System.out.print("Number after change is: "
                            + changer.decToBase(temp + "", 16) + "\n");
                    return;
            }
        }
    }

    //Change base demical
    public void Base10() {
        while (true) {
            System.out.println("1-Base 10 to Base 2");
            System.out.println("2-Base 10 to Base 16");
            System.out.print("Please choice one option: ");
            int option = in.inputInt(1, 2, "PLease choose 1 or 2!");
            switch (option) {
                case 1: //change base demical to binary
                    String convertNum = in.inputDecimal();
                    System.out.println("Number after change is: "
                            + changer.decToBase(convertNum, 2));
                    return;
                case 2: //change base demical to hexademical
                    System.out.println("Number after change is: "
                            + changer.decToBase(in.inputDecimal(), 16));
                    return;
            }
        }
    }

    //Change base dexademical
    public void Base16() {
        while (true) {
            System.out.println("1-Base 16 to Base 2");
            System.out.println("2-Base 16 to Base 10");
            System.out.print("Please choice one option: ");
            int option = in.inputInt(1, 2, "PLease choose 1 or 2!");
            switch (option) {
                case 1: //change base hexademical to binary
                    String convertNum = in.inputHexaDecimal();
                    long temp = changer.baseToDec(convertNum, 16);
                    System.out.print("Number after change is: " + 
                            changer.decToBase(temp + "", 2) + "\n");
                    return;
                case 2: //change base hexademical to demical
                    System.out.println("Number after change is: " 
                            + changer.baseToDec(in.inputHexaDecimal(), 16));
                    return;
            }
        }
    }
}
