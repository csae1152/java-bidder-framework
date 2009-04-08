package com.appnexus.bidderframework.common.dataobjects;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 4:06:36 PM
 *
 * We wanna make this as small as possible
 *
 * So we have 4 bytes, but we need to go from 0..255
 * and byte is -127..128 (-2^7 .. 2^7 - 1)
 *
 * We do this by storing this as the difference between the byte representation and Byte.MIN_VALUE
 *
 * So that 100 is represented by 100 + Byte.MIN_VALUE or 100 - 127 or -27
 *
 * When we decode -27 we should get back 100 we do this by returning Byte code representation - Byte.MIN_VALUE
 *
 * -27(byte) ==> -27 - Byte.MIN_VALUE (int) ==> -27 - -127 (int) ==> -27 + 127 (int) ==> 100 (int)
 *
 */
public class INetAddr {

    private byte a1;
    private byte a2;
    private byte a3;
    private byte a4;

    /**
     * The idea here is that we store the ints as bytes
     *
     * Byte.MIN_VALUE = -2^7 (-128)
     * Byte.MAX_VALUE =  2^7 - 1 (127)
     * so that if S is a int, lets say 256, it is represented as Byte.MAX_VALUE
     *
     * if I is a int it is translated as: B = I + Byte.MIN_VALUE
     * if B is a byte it is translated as: I = B - Byte.MIN_VALUE
     *
     * @param a1
     * @param a2
     * @param a3
     * @param a4
     */
    public INetAddr(int a1, int a2, int a3, int a4) {
        this.a1 = (byte) (a1 + Byte.MIN_VALUE);
        this.a2 = (byte) (a2 + Byte.MIN_VALUE);
        this.a3 = (byte) (a3 + Byte.MIN_VALUE);
        this.a4 = (byte) (a4 + Byte.MIN_VALUE);
    }

    public int getA1() {
        return a1 - Byte.MIN_VALUE;
    }

    public void setA1(int a1) {
        this.a1 = (byte) (a1 + Byte.MIN_VALUE);
    }

    public int getA2() {
        return a2 - Byte.MIN_VALUE;
    }

    public void setA2(int a2) {
        this.a2 = (byte) (a2 + Byte.MIN_VALUE);
    }

    public int getA3() {
        return a3 - Byte.MIN_VALUE;
    }

    public void setA3(int a3) {
        this.a3 = (byte) (a3 + Byte.MIN_VALUE);
    }

    public int getA4() {
        return a4 - Byte.MIN_VALUE;
    }

    public void setA4(int a4) {
        this.a4 = (byte) (a4 + Byte.MIN_VALUE);
    }

    @Override
    public String toString() {
        return getA1() + "." + getA2() + "." +  getA3() + "." + getA4() + ".";
    }
}
