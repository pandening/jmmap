package com.hujian.mmap;

import java.io.Serializable;

/**
 * Created by hujian on 2017/5/18.
 */
public class test implements Serializable {

    /**
     * test the mmap
     * @param args
     * @throws Exception
     */
    public static void main(String... args) throws Exception {

        String file = "test";
        /**
         * 10 Mb
         */
        Mmap mmap = new Mmap(file, (long) 1024 * 10);

        mmap.writeInt(12);
        mmap.writeInt(23);
        mmap.writeByte((byte) 2);
        mmap.writeBytes("i am hujian".getBytes());
        mmap.writeDouble(2.34);
        mmap.writeLong(12222L);

        int a = mmap.readInt();
        int b = mmap.readInt();
        byte c = mmap.readByte();
        byte[] bytes = mmap.readBytes(11);
        double d = mmap.readDouble();
        long l = mmap.readLong();

        System.out.println(a + "," + b + "," + c + " ," + d + "," + l + " ," +
                new String(bytes) + " ," + c);

    }

}
