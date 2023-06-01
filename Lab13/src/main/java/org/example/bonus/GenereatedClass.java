package org.example.bonus;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;

public class GenereatedClass {
    private final String className;
    private final String[] cloneableInterface;
    ClassReader reader;
    ClassWriter writer;
    AddFieldAdapter addFieldAdapter;
    PublicizeMethodAdapter pubMethAdapter;

    public GenereatedClass(String classToBeModified, String[] arraysOfInterfacesToBeAdded) throws IOException {
        this.className=classToBeModified;
        this.cloneableInterface=arraysOfInterfacesToBeAdded;
        this.reader=new ClassReader(this.className);
        this.writer=new ClassWriter(this.reader, 0);
    }
    public byte[] addFields()
    {
        addFieldAdapter=new AddFieldAdapter("aNewBooleanField", org.objectweb.asm.Opcodes.ACC_PUBLIC, writer);
        reader.accept(addFieldAdapter, 0);
        return writer.toByteArray();
    }
    public byte[] publicizeMethod() {
        pubMethAdapter = new PublicizeMethodAdapter(writer);
        reader.accept(pubMethAdapter, 0);
        return writer.toByteArray();
    }
}
