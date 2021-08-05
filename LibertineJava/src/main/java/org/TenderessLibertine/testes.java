package org.TenderessLibertine;

import org.TenderessLibertine.persistence.file2object.File2Object;

import java.util.Random;

public class testes {


    public static void main(String[] args) {

/*       ^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$*/

        String email = "joni_ygweug2134534@gmail.com";

        System.out.println(email.matches("/^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$/g"));

    }

}
