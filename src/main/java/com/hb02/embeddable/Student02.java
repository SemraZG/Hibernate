package com.hb02.embeddable;

import javax.persistence.*;


@Entity
@Table(name = "t_student02")
public class Student02 {

  @Id//@Id ->zorunlu
    private int id;

  @Column(name= "student_name", length = 100, nullable = false, unique = false)//normalde column adi name olcakto @Column ile column adi student_name olsun dedim
    private String name;

  private int grade;


  //buraya kadar Hibernate databasede t_student02 adinda bir table olusturdu ve id,name,grade columnlarini olusturdu
    //Address data typeinda bu degiskeni gordugunde ise Address classina gider ve ordaki degiskenleri de (city,country,zipcode) t_student02 tablosunua coluimn olarak ekelr
    @Embedded//yazmamiz opsiyonel yazmasak da embedded oldugu anlasilir
    private Address address;

    //getter setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //tostring

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", address=" + address +  //burda adresi yazdirirken adres objesini yazdirir, digerlerinde direk degeri yazdirir
                '}';
    }
}
