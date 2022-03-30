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
public class Main {
    
    public static void main(String[] args) {
        BaseView view = new BaseView();
        DataInput in = new DataInput();
        while(true){
            System.out.println("---------Change base sysem------------");
            System.out.println("1. Base 2");
            System.out.println("2. Base 10");
            System.out.println("3. Base 16");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int option = in.inputInt(1, 4, "Your choice must from 1-4!");
            switch(option){
                case 1:
                    view.Base2();
                    break;
                case 2:
                    view.Base10();
                    break;
                case 3:
                    view.Base16();
                    break;
                case 4:
                    return;
            }
        }
    }
    
}
