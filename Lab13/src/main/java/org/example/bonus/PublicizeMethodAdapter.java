package org.example.bonus;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.PrintWriter;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class PublicizeMethodAdapter extends ClassVisitor {
    PrintWriter pw = new PrintWriter(System.out);
    TraceClassVisitor tracer;

    public PublicizeMethodAdapter(ClassVisitor cv) {
        super(ASM4, cv);
        this.cv = cv;
         tracer = new TraceClassVisitor(cv, pw);
    }

    public MethodVisitor visitMethod(
            int access,
            String name,
            String desc,
            String signature,
            String[] exceptions) {
        if (name.equals("toUnsignedString0")) {
            System.out.println("Visiting unsigned method");
            return tracer.visitMethod(
                    ACC_PUBLIC + ACC_STATIC, name, desc, signature, exceptions);
        }
        return tracer.visitMethod(
                access, name, desc, signature, exceptions);
    }

    public void visitEnd(){
        tracer.visitEnd();
        System.out.println(tracer.p.getText());
    }

}
