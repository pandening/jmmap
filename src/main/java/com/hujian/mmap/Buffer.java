package com.hujian.mmap;

import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by hujian on 2017/5/18.
 */
public class Buffer implements Serializable {

    /**
     * the bucket's file
     */
    private RandomAccessFile randomAccessFile = null;

    /**
     * the buffer of this file in the memory
     */
    private MappedByteBuffer mappedByteBuffer = null;

    /**
     * the buffer's size
     */
    private Long MmapBufferSize = null;

    /**
     * the current position
     */
    private Long position = null;

    /**
     * the constructor
     * @param file
     * @param mmapBufferSize
     * @param
     */
    public Buffer(String file,Long mmapBufferSize) throws Exception {
        this.MmapBufferSize = mmapBufferSize;
        this.randomAccessFile = new RandomAccessFile(file,"rw");
        this.mappedByteBuffer = this.randomAccessFile.getChannel().
                map(FileChannel.MapMode.READ_WRITE,0,this.MmapBufferSize);
    }

    public RandomAccessFile getRandomAccessFile() {
        return randomAccessFile;
    }

    public void setRandomAccessFile(RandomAccessFile randomAccessFile) {
        this.randomAccessFile = randomAccessFile;
    }

    public MappedByteBuffer getMappedByteBuffer() {
        return mappedByteBuffer;
    }

    public void setMappedByteBuffer(MappedByteBuffer mappedByteBuffer) {
        this.mappedByteBuffer = mappedByteBuffer;
    }

    public Long getMmapBufferSize() {
        return MmapBufferSize;
    }

    public void setMmapBufferSize(Long mmapBufferSize) {
        MmapBufferSize = mmapBufferSize;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }
}
