package com.store.billingsystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        //Kullanacağımız değişkenlerin tanımlandığı kod bloğu
        Scanner myObj = new Scanner(System.in);
        double discount = 0;
        double netPayableAmount = 0;
        double billAmount = 0;
        double billAmountAfterDiscount = 0;
        int percentDiscount=0;
        String itemType;
        String userType;
        boolean typeLoop = true;

        //Kullanıcıdan ilgili kullanıcı tipini seçmesini istediğimiz kod bloğu
        System.out.println("Enter User Type:\nWrite 'Gold' for gold card\nWrite 'Silver' for silver card");
        System.out.println("Write 'A' for an affiliate of the store\nWrite 'C' for a customer for over 2 years");
        System.out.println("----------------------------------");
        userType = myObj.nextLine();

        //Seçilen kullanıcı tipine göre indirim yüzdesini atayan kod bloğu
        while(typeLoop) {
            typeLoop = false;

            if (userType.equals("Gold") || userType.equals("gold")) {
                percentDiscount = 30;
            } else if (userType.equals("Silver") || userType.equals("silver")) {
                percentDiscount = 20;
            } else if (userType.equals("A") || userType.equals("a")) {
                percentDiscount = 10;
            } else if (userType.equals("C") || userType.equals("c")) {
                percentDiscount = 5;
            } else {
                System.out.println("Invalid customer type!!! Please enter valid customer type");
                userType = myObj.nextLine();
                typeLoop = true;
            }
        }

        //Alınan indirim yüzdesi
        System.out.println("User Type:" + userType + " | " + "Percent Discount:" + percentDiscount);

        //Mobil kullanıcısı olup olmadığına göre indirim yüzdesini güncelleyen kod bloğu
        System.out.println("Enter Item Type:");
        System.out.println("Write 'P' for phones | Write 'O' for other");
        System.out.println("----------------------------------");
        itemType = myObj.nextLine();

        if (itemType.equals("P") || itemType.equals("p")) {
            percentDiscount= 0;
        }

        //Güncellenen indirim yüzdesi
        System.out.println("Percent Discount:" + percentDiscount);

        //Kullanıcının faturasını hesaplayan ve ekranda gösteren kod bloğu
        System.out.println("Enter Bill Amount:");
        billAmount = myObj.nextInt();
        discount = ((billAmount * percentDiscount)/100);
        billAmountAfterDiscount = (billAmount  - discount);
        netPayableAmount  = (billAmountAfterDiscount - (Math.floor(billAmountAfterDiscount/200)*5));
        System.out.println("Net_Payable_Amount:\n" + netPayableAmount + "TL" );
    }
}
