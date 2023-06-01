package org.example.Compulsory;


import org.example.annotation.Test;

import java.lang.reflect.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Compulsory {

    static public Class loadClass(String classToLoad) throws ClassNotFoundException {
        Class cls = Class.forName(classToLoad);
        return cls;
    }
    static public String identifyPackage(Class aclass)
    {
        return aclass.getPackageName();
    }
    static public Method[] identifyMethods(Class aclass)
    {

       return aclass.getMethods();
    }
    static public Field[] identifyMemeberVaraibles(Class aClass)
    {
        return aClass.getDeclaredFields();
    }
    static public Field[] callMethodsWithAnnotation(Class classToCheck, Class annotation) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        Method[] methods =  Compulsory.identifyMethods(classToCheck);
        Object obj =  classToCheck.getConstructor().newInstance();
        for(Method meth:methods)
        {
            if(meth.isAnnotationPresent(annotation))
            {
                if(Modifier.isStatic(meth.getModifiers()))
                {
                    meth.invoke(null);
                }
                else
                {
                    meth.invoke(obj);
                }
            }
        }
        return null;
    }


}
