package com.alphawang.spring.core.thread;

import java.lang.reflect.Field;

public class ThreadLocalPrinter {
    
    public static void printThreadLocals(Thread t) {
        System.out.println("=========== Thread: " + t.getName());
        try {
//            Class<? extends Thread> clz = t.getClass();
            Class clz = Thread.class;
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object threadLocalMap = field.get(t);
            Class<?> tlmClass = threadLocalMap.getClass();
            Field entryArray = tlmClass.getDeclaredField("table");
            entryArray.setAccessible(true);
            Object[] arr = (Object[]) entryArray.get(threadLocalMap);
            System.out.println("threadLocalMap size = " + arr.length);
            
            for (Object entry : arr) {
                if (entry != null) {
                    Class<?> entryClass = entry.getClass();
                    Field entryValue = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    entryValue.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.println(
                      String.format("弱引用key = %s, value = %s", referenceField.get(entry), entryValue.get(entry)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
