package com.alphawang.spring.core.feature.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PathResourceDemo {

    public static void main(String[] args) {
        String path = "/Users/Alpha/dev/git/alpha-spring/alpha-spring-core/src/main/resources/conf/resource.txt";

        WritableResource writableResource = new PathResource(path);
        Resource resource = new ClassPathResource("myProperties.properties");

        System.out.println("res1:" + writableResource.getFilename());
        System.out.println("res2:" + resource.getFilename());

        try {
            OutputStream os = writableResource.getOutputStream();
            os.write("测试输出文本".getBytes());
            os.close();

            InputStream is1 = writableResource.getInputStream();
            InputStream is2 = resource.getInputStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i;
            while ( (i = is1.read()) != -1) {
                baos.write(i);
            }
            
            System.out.println(baos.toString());
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        

    }
}
