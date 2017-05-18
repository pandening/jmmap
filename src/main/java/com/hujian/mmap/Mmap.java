package com.hujian.mmap;

import java.io.IOException;

/**
 * Created by hujian on 2017/5/18.
 */
public class Mmap implements Operator {

    /**
     * the buffer
     */
    private Buffer buffer = null;

    /**
     * the current position(just for reading)
     */
    private int position = 0;

    /**
     * the constructor
     * @param file
     * @param mapSize
     */
    public Mmap(String file,Long mapSize) throws Exception {
        this.buffer = new Buffer(file,mapSize);
        if( buffer == null ){
            throw new Exception("get a buffer error");
        }else{
            System.out.println("initializer with " + mapSize + " bytes map buffer");
        }
    }

    /**
     * require {@code byteCount bytes,if the map buffer's size is limit,just re-map}
     * @param byteCount
     */
    private void require(int byteCount) throws Exception {
        int response = (int) (this.buffer.getMmapBufferSize() -
                this.buffer.getMappedByteBuffer().position());
        if( response < byteCount ){
            throw new OutOfMapBufferSizeException("out of map buffer size limit");
        }else{
            System.out.println("require " + byteCount + " byte(s),response " + response + " bytes");
        }
    }

    /**
     * close the file
     * @throws IOException
     */
    public void close() throws IOException {
        this.buffer.getRandomAccessFile().close();
    }

    /**
     * get the position of now
     * @return
     */
    public int getReaderPosition(){
        return position;
    }

    /**
     * get write position
     * @return
     */
    public int getWriterPosition(){
        return this.buffer.getMappedByteBuffer().position();
    }

    public void writeByte(byte b) throws Exception {
        this.require(1);
        this.buffer.getMappedByteBuffer().put(b);
    }

    public byte readByte() {
        byte b = this.buffer.getMappedByteBuffer().get(position);
        position ++;
        return b;
    }

    public void writeBytes(byte[] bytes) throws Exception {
        this.require(bytes.length);
        this.buffer.getMappedByteBuffer().put(bytes);
    }

    public byte[] readBytes(int byteCount) {
        byte[] bytes = new byte[byteCount];
        for( int i = 0; i < byteCount; i ++ ){
            bytes[i] = readByte();
        }
        return bytes;
    }

    public void writeInt(int i) throws Exception {
        this.require(4);
        this.buffer.getMappedByteBuffer().putInt(i);
    }

    public int readInt() {
        int i = this.buffer.getMappedByteBuffer().getInt(position);
        position += 4;
        return i;
    }

    public void writeDouble(double d) throws Exception {
        this.require(8);
        this.buffer.getMappedByteBuffer().putDouble(d);
    }

    public double readDouble() {
        double d = this.buffer.getMappedByteBuffer().getDouble(position);
        position += 8;
        return d;
    }

    public void writeLong(long l) throws Exception {
        this.require(8);
        this.buffer.getMappedByteBuffer().putLong(l);
    }

    public long readLong() {
        long l = this.buffer.getMappedByteBuffer().getLong(position);
        position += 8;
        return l;
    }
}
