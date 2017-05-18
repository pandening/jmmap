package com.hujian.mmap;

import java.io.Serializable;

/**
 * Created by hujian on 2017/5/18.
 */
public interface Operator extends Serializable {

    /**
     * write a byte to mmap buffer
     * @param b
     */
    void writeByte(byte b) throws Exception;

    /**
     * read byte from the buffer
     * @return
     */
    byte readByte();

    /**
     * write bytes to mmap buffer
     * @param bytes
     */
    void writeBytes(byte[] bytes) throws Exception;

    /**
     * read bytes from buffer {@code byteCount}
     * @param byteCount
     * @return
     */
    byte[] readBytes(int byteCount);

    /**
     * write int
     * @param i
     */
    void writeInt(int i) throws Exception;

    /**
     * read int from buffer start at current position
     * @return
     */
    int readInt();

    /**
     * write double
     * @param d
     */
    void writeDouble(double d) throws Exception;

    /**
     * read double
     * @return
     */
    double readDouble();

    /**
     * write long
     * @param l
     */
    void writeLong(long l) throws Exception;

    /**
     * read long from current position
     * @return
     */
    long readLong();
}
