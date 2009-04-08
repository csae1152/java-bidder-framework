package com.appnexus.bidderframework.common.dataobjects;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 4:03:42 PM
 *
 * Like INet ADdr, this is a really small class because there's gonna be lots and lots of them
 * And, we want to be respectful of our heaps.
 *
 * We use a compressed form of byte, we return an int that is the byte - Byte.MIN_VALUE
 *
 * @see INetAddr
 */
public class IXIData {

    private INetAddr internetAddress;
    private int zipPlus4;
    private byte espectrumFull;
    private byte dsiDecile;
    private byte income360Decile;
    private byte provider;

    public INetAddr getInternetAddress() {
        return internetAddress;
    }

    public void setInternetAddress(INetAddr internetAddress) {
        this.internetAddress = internetAddress;
    }

    public int getZipPlus4() {
        return zipPlus4;
    }

    public void setZipPlus4(int zipPlus4) {
        this.zipPlus4 = zipPlus4;
    }

    public int getEspectrumFull() {
        return espectrumFull - Byte.MIN_VALUE;
    }

    public void setEspectrumFull(int espectrumFull) {
        this.espectrumFull = (byte) (espectrumFull + Byte.MIN_VALUE);
    }

    public int getDsiDecile() {
        return dsiDecile - Byte.MIN_VALUE;
    }

    public void setDsiDecile(int dsiDecile) {
        this.dsiDecile = (byte) (dsiDecile + Byte.MIN_VALUE);
    }

    public int getIncome360Decile() {
        return income360Decile - Byte.MIN_VALUE;
    }

    public void setIncome360Decile(int income360Decile) {
        this.income360Decile = (byte) (income360Decile + Byte.MIN_VALUE);
    }

    public int getProvider() {
        return provider - Byte.MIN_VALUE;
    }

    public void setProvider(int provider) {
        this.provider = (byte) (provider + Byte.MIN_VALUE);
    }
}
