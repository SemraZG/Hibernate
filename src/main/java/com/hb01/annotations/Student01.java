package com.hb01.annotations;


import javax.persistence.*;

@Entity//@Entity koydugumuz class databasede bir tabloya karsilik gelir, @Entity yazmadigimiz classi Hibernate asla kaydetmez
@Table(name= "t_student01")//@Table(name= -->tabloya isim verir
public class Student01 {//Hibernate, ad yermeseydik default olrak databasede tablonun adini student01 olarak olusturur class ismi boyle oldugu icin

    @Id//  @Id-->primary key olusmasini sagliyor id ile belirttiklerimiz pk olmus oluyor--//@Id ->her tabloda yani Entity classlarinda bir tane olmak zorunlu
    //@Column(name = "std_id") // @Column(name = -->column name i set ederiz
    private int id;//

    @Column(name = "student_name", length = 100, nullable = false, unique = false )//nullable = false-->null olmasin birsey girilmek zorunda demek
    private String name;
    //@Column(name = , length,...bunlar veya Column annotatioj i zorunlu degil opsiyonel

    //!!! @Transient --> veritabanı tablosunda "grade" adında bir kolon oluşturulmaz. kod içinde
    // kullanılmak için bir değişken oluştururuz ama bu sınıf DB ye kaydedileceği
    // zaman ilgili tabloya kolon olarak eklenmez
    //@Transient
    private int grade;

    // @Lob ---> large object ile büyük boyutlu datalar tutulabilir.
//    @Lob
//    private byte[] image;

    //!!! Getter- Setter  *********************************************

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

    // !!! toString() ***********************************
    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}





