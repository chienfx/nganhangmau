/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShowEditMenu;

/**
 *
 * @author PC
 */
import java.util.Scanner;
//employee
import EditEmployee.hienthi;
import EditEmployee.themDB;
import EditEmployee.suaDB;
import EditEmployee.xoaDB;
import MainMenu.GetLine;


/**
 *
 * @author PC
 */
public class mainmenu {
    private int number;
    private int a;

    public mainmenu() {
    }

    public mainmenu(int number, int a) {
        this.number = number;
        this.a = a;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void run() {
        for (; ; ) {

            int nhap;
			System.out.println("***********************************************************************************************");
			System.out.println("*                                    ------------ EDIT -----------                            *");
			System.out.println("*                                    |  1  |     Edit Employee   |                            *");
			System.out.println("*                                    |  2  |     Edit Customer   |                            *");
			System.out.println("*                                    |  3  |     Edit Product    |                            *");
			System.out.println("*                                    |  4  |     Back            |                            *");
			System.out.println("*                                    -----------------------------                            *");
			System.out.println("***********************************************************************************************");

            System.out.print("select: ");
            nhap = GetLine.gInt();
            System.out.println("");

//employee
            if (nhap == 1) {
                int a;
                int b;
                hienthi ht = new hienthi();
                ht.Display();
                System.out.println("");
                System.out.println("***********************************************************************************************");
                System.out.println("*                               -------------------------------                               *");
                System.out.println("*                               |  1  |     insert emplyee    |                               *");
                System.out.println("*                               |  2  |     update employee   |                               *");
                System.out.println("*                               |  3  |     delete employee   |                               *");
                System.out.println("*                               |  4  |     back              |                               *");
                System.out.println("*                               -------------------------------                               *");
                System.out.println("***********************************************************************************************");
                System.out.print("select: ");
                a = GetLine.gInt();
                System.out.println("");

                if (a == 1) {
                    themDB ad = new themDB();
                    for (;;) {
                        
                    	System.out.println("");
                    	System.out.println("***********************************************************************************************");
                        System.out.println("*                              ------------continue ?---------                                *");
                        System.out.println("*                              |  1  |         yes           |                                *");
                        System.out.println("*                              |  2  |         no            |                                *");
                        System.out.println("*                              -------------------------------                                *");
                        System.out.println("***********************************************************************************************");
                        System.out.println("");
                        System.out.print("select: ");
                        b = GetLine.gInt();
                        System.out.println("");
                        
                        if (b == 1) {
                            ad.InsertEm();
                        } 
                        else if (b == 2) {
                            break;

                        } else {
                            continue;
                        }
                    }

                } else if (a == 2) {
                    suaDB ud = new suaDB();
                    for (; ; ) {
                    	System.out.println("");
                    	System.out.println("***********************************************************************************************");
                        System.out.println("*                              ------------continue ?---------                                *");
                        System.out.println("*                              |  1  |         yes           |                                *");
                        System.out.println("*                              |  2  |         no            |                                *");
                        System.out.println("*                              -------------------------------                                *");
                        System.out.println("***********************************************************************************************");
                        System.out.println("");
                        System.out.print("select: ");
                        b = GetLine.gInt();
                        System.out.println("");
                        
                        if (b == 1) {
                            ud.UpdateEm();
                        } else if (b == 2) {
                            break;

                        } else {
                            continue;
                        }
                    }

                } else if (a == 3) {
                    for (; ; ) {
                    	System.out.println("");
                    	System.out.println("***********************************************************************************************");
                        System.out.println("*                              ------------continue ?---------                                *");
                        System.out.println("*                              |  1  |         yes           |                                *");
                        System.out.println("*                              |  2  |         no            |                                *");
                        System.out.println("*                              -------------------------------                                *");
                        System.out.println("***********************************************************************************************");
                        System.out.println("");
                        System.out.print("select: ");
                        b = GetLine.gInt();
                        System.out.println("");
                        
                        if (b == 1) {
                            xoaDB.xoaEm();
                        } else if (b == 2) {
                            break;

                        } else {
                            continue;
                        }
                    }

                } else if (a == 4) {
                	break;
                }else {
                	continue;
                }
            }

//EditCustomer
            else if (nhap == 2) {
                int a;
                int b = 0;
                
                    EditCustomer.hienthi ht = new EditCustomer.hienthi();
                    ht.Display();

                System.out.println("");
                System.out.println("***********************************************************************************************");
                System.out.println("*                               -------------------------------                               *");
                System.out.println("*                               |  1  |     insert customer   |                               *");
                System.out.println("*                               |  2  |     update customer   |                               *");
                System.out.println("*                               |  3  |     delete customer   |                               *");
                System.out.println("*                               |  4  |     back              |                               *");
                System.out.println("*                               -------------------------------                               *");
                System.out.println("***********************************************************************************************");
                System.out.println("");
                System.out.print("select: ");
                a = GetLine.gInt();
                System.out.println("");

                if (a == 1) {
                    EditCustomer.themDB ad = new EditCustomer.themDB();
                    for (; ; ) {
                    	System.out.println("");
                    	System.out.println("***********************************************************************************************");
                        System.out.println("*                              ------------continue ?---------                                *");
                        System.out.println("*                              |  1  |         yes           |                                *");
                        System.out.println("*                              |  2  |         no            |                                *");
                        System.out.println("*                              -------------------------------                                *");
                        System.out.println("***********************************************************************************************");
                        System.out.println("");
                        System.out.print("select: ");
                        b = GetLine.gInt();
                        System.out.println("");
                        if (b == 1) {
                            ad.InsertCm();
                        } else if (b == 2) {
                            break;

                        } else {
                            continue;
                        }
                    }

                } else if (a == 2) {
                    EditCustomer.suaDB ud = new EditCustomer.suaDB();
                    for (; ; ) {
                    	System.out.println("");
                    	System.out.println("***********************************************************************************************");
                        System.out.println("*                              ------------continue ?---------                                *");
                        System.out.println("*                              |  1  |         yes           |                                *");
                        System.out.println("*                              |  2  |         no            |                                *");
                        System.out.println("*                              -------------------------------                                *");
                        System.out.println("***********************************************************************************************");
                        System.out.println("");
                        System.out.print("select: ");
                        b = GetLine.gInt();
                        System.out.println("");
                        if (b == 1) {
                            ud.UpdateCm();
                        } else if (b == 2) {
                            break;

                        } else {
                            continue;
                        }
                    }
                } else if (a == 3) {
                    for (; ; ) {
                    	System.out.println("");
                    	System.out.println("***********************************************************************************************");
                        System.out.println("*                              ------------continue ?---------                                *");
                        System.out.println("*                              |  1  |         yes           |                                *");
                        System.out.println("*                              |  2  |         no            |                                *");
                        System.out.println("*                              -------------------------------                                *");
                        System.out.println("***********************************************************************************************");
                        System.out.println("");
                        System.out.print("select: ");
                        b = GetLine.gInt();
                        System.out.println("");
                        if (b == 1) {
                            EditCustomer.xoaDB.xoaCm();
                        } else if (b == 2) {
                            break;

                        } else {
                            continue;
                        }
                    }

                } else if (a == 4) {
                	break;
                }else {
                	continue;
                }
            }
            //EditProduct
            else if (nhap == 3) {
                int a;
                int b = 0;
                
                    EditProduct.hienthi ht = new EditProduct.hienthi();
                    ht.Display();

                System.out.println("");
                System.out.println("***********************************************************************************************");
                System.out.println("*                               -------------------------------                               *");
                System.out.println("*                               |  1  |     insert product    |                               *");
                System.out.println("*                               |  2  |     update product    |                               *");
                System.out.println("*                               |  3  |     delete product    |                               *");
                System.out.println("*                               |  4  |     back              |                               *");
                System.out.println("*                               -------------------------------                               *");
                System.out.println("***********************************************************************************************");
                System.out.println("");
                System.out.print("select: ");
                a = GetLine.gInt();
                System.out.println("");

                if (a == 1) {
                    EditProduct.themDB ad = new EditProduct.themDB();
                    for (;;) {
                    	System.out.println("");
                    	System.out.println("***********************************************************************************************");
                        System.out.println("*                              ------------continue ?---------                                *");
                        System.out.println("*                              |  1  |         yes           |                                *");
                        System.out.println("*                              |  2  |         no            |                                *");
                        System.out.println("*                              -------------------------------                                *");
                        System.out.println("***********************************************************************************************");
                        System.out.println("");
                        System.out.print("select: ");
                        b = GetLine.gInt();
                        if (b == 1) {
                        	
                            ad.InsertPd();
                            
                        } else if (b == 2) {
                            break;

                        } else {
                            continue;
                        }
                    }
                } else if (a == 2) {
                    EditProduct.suaDB ud = new EditProduct.suaDB();
                    for (; ; ) {
                    	System.out.println("");
                    	System.out.println("***********************************************************************************************");
                        System.out.println("*                              ------------continue ?---------                                *");
                        System.out.println("*                              |  1  |         yes           |                                *");
                        System.out.println("*                              |  2  |         no            |                                *");
                        System.out.println("*                              -------------------------------                                *");
                        System.out.println("***********************************************************************************************");
                        System.out.println("");
                        System.out.print("select: ");
                        b = GetLine.gInt();
                        System.out.println("");
                        
                        if (b == 1) {
                            ud.UpdatePd();
                        } else if (b == 2) {
                            break;

                        } else {
                            continue;
                        }
                    }
                } else if (a == 3) {
                    for (; ; ) {
                    	System.out.println("");
                    	System.out.println("***********************************************************************************************");
                        System.out.println("*                              ------------continue ?---------                                *");
                        System.out.println("*                              |  1  |         yes           |                                *");
                        System.out.println("*                              |  2  |         no            |                                *");
                        System.out.println("*                              -------------------------------                                *");
                        System.out.println("***********************************************************************************************");
                        System.out.println("");
                        System.out.print("select: ");
                        b = GetLine.gInt();
                        System.out.println("");
                        
                        if (b == 1) {
                            EditProduct.xoaDB.xoapd();
                        } else if (b == 2) {
                            break;

                        } else {
                            continue;
                        }
                    }
                } else if (a == 4) {
                	break;
                }else {
                	continue;
                }
            }
            //back
            else if (nhap == 4) {
               break;
            }else {
            	continue;
            }
            

        }
    }
    
}
