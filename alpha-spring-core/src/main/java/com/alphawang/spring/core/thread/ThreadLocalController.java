package com.alphawang.spring.core.thread;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  -Xms500m -Xmx500m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/gc/heapdump.hprof  -XX:+PrintGCTimeStamps -XX:+PrintGCDetails -Xloggc:/tmp/gc/heaplog.log
 *
 *  jstat -gc pid --> 查看 GC 情况
 */
@RestController
public class ThreadLocalController {

    /**
     *  非 static ThreadLocal:
     *  gc() 时，老key会被回收；同时set()会清除key==null的Entry
     */
    @GetMapping(value = "/memory/threadlocal")
    public String threadlocal() {
        ThreadLocal<Byte[]> localVariable = new ThreadLocal<Byte[]>();
        localVariable.set(new Byte[4096 * 1024]);// 为线程添加变量
        
//        System.gc();
        Thread thread = Thread.currentThread();
        System.out.println("=========== 模拟内存泄漏: " + thread.getName() + " : " + localVariable);
//        System.out.println(localVariable.get());
        ThreadLocalPrinter.printThreadLocals(thread);
        return "ok";
    }

    /**
     * 对于 static ThreadLocal:
     * 每个请求都会重用这个key，只是修改value，不会OOM 
     */
    @GetMapping(value = "/memory/threadlocal/static")
    public String threadlocalStatic() {

        THREAD_LOCAL.set(new Byte[4096 * 1024]);// 为线程添加变量

        Thread thread = Thread.currentThread();
        System.out.println("模拟内存泄漏 -static: " + thread.getName() + " : " + THREAD_LOCAL);
//        System.out.println(THREAD_LOCAL.get());
        ThreadLocalPrinter.printThreadLocals(thread);
        return "ok";
    }

    private static ThreadLocal<Byte[]> THREAD_LOCAL = new ThreadLocal<Byte[]>();

}
