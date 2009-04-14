package com.appnexus.bidderframework.common.dataobjects;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 13, 2009
 * Time: 11:43:02 AM
 * @deprecated
 */
public class Datran {

    private int age;
    private int zip;
    private int personicxCluster;
    private Gender gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getPersonicxCluster() {
        return personicxCluster;
    }

    public void setPersonicxCluster(int personicxCluster) {
        this.personicxCluster = personicxCluster;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
