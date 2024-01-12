package com.hb02.embeddable;

import javax.persistence.Embeddable;

@Embeddable//-->Entity deseydik address adinda table olusacakti, embeddable yazinca ise baska bir tablonun colunlari olcak bu clasda demek
public class Address {
 //@Embeddable-->Adress icin ayri bir tablo olusmasin, Ama Adress sinifindaki degiskenler ,
 // tudent tablosunda header olarak eklenmesini sagliyor
    private String street;
    private String city;
    private String country;
    private String zipCode;

    //getter and setter

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    //toString

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
