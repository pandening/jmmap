package com.hujian.mmap;

/**
 * Created by hujian on 2017/5/18.
 */
public class OutOfMapBufferSizeException extends Exception{

    /**
     * constructor
     * @param msg
     */
    public OutOfMapBufferSizeException(String msg){
        super(msg);
        System.out.println("[The error maybe]:" + msg );
    }

}
