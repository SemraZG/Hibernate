package com.hb01.annotations;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {

        Student01 student1=new Student01();
        student1.setId(1001);
        student1.setName("Berat Bey");
        student1.setGrade(75);

        Student01 student2=new Student01();
        student2.setId(1002);
        student2.setName("Omer Faruk");
        student2.setGrade(75);

        Student01 student3=new Student01();
        student3.setId(1003);
        student3.setName("Ahmet Faruk");
        student3.setGrade(75);

        Configuration con=new Configuration().configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Student01.class);//-->Config dosyasini ve entityy classimi belirtiyorum


        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
//burada sql query'ler olacak

        //db'ye kaydederken sql ile--> INSERT INTO t_student01 (id,name,grade) VALUES(?,?,?)
        session.save(student1);//-->hibernate ile bu bekilde
        session.save(student2);
        session.save(student3);

        tx.commit();//commit demezsek db'ye daydedilme garantisi yok, otocommit'in ne zaman baslayacaginin garantisi yok
        session.close();
        sf.close();


    }
}
