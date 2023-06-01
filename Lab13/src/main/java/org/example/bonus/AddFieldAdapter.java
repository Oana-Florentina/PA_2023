package org.example.bonus;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

import java.lang.reflect.Field;

import static jdk.internal.org.objectweb.asm.Opcodes.ASM4;

public class AddFieldAdapter  extends ClassVisitor {

    //the name of the filed that will be added
    private String fieldName;
    //the type of the field that will be added
    private String fieldDefault;
    //the acces modified of the field
    private int access = org.objectweb.asm.Opcodes.ACC_PUBLIC;

    private boolean isFieldPresent;

    public AddFieldAdapter(String fieldName, int fieldAccess, ClassVisitor cv)
    {
        super(ASM4, cv);
        this.cv=cv;
        this.fieldName=fieldName;
        this.access=fieldAccess;
    }

    //A method to check if the field we plan toa dd already exists, we can also modify the visibility of the field with this method
    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        if (name.equals(fieldName)) {
            isFieldPresent = true;
        }
        return cv.visitField(access, name, desc, signature, value);
    }

    //we will use this method to insert the field into the class
    @Override
    public void visitEnd() {
        if(!isFieldPresent)
        {
            FieldVisitor fv = cv.visitField(access, fieldName, fieldDefault, null, null);
        }
        cv.visitEnd();
    }
}
