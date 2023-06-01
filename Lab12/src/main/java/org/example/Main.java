package org.example;

import org.example.Compulsory.Compulsory;
import org.example.annotation.Test;
import org.example.bonus.GenereatedClass;

import java.awt.geom.GeneralPath;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, IOException {

        // Class aclass= Compulsory.loadClass("org.example.MyProgram");
        // System.out.println(Compulsory.identifyPackage(aclass));
        /*
        for(var a:Compulsory.identifyMethods(aclass))
        {
            System.out.println(a);
        }
        System.out.println("\n\n");
        for(var a:Compulsory.identifyMemeberVaraibles(aclass))
        {
            System.out.println(a);
        }
        */
        //Compulsory.callMethodsWithAnnotation(aclass, Test.class);


        GenereatedClass genereatedClass = new GenereatedClass("org.example.bonus.CreatedClass",null);
        genereatedClass.publicizeMethod();
    }

}