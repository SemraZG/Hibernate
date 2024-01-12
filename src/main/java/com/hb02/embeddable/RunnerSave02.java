package com.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {

        //once persist edecegimiz objeleri olusturuyoruz

        Student02 student1=new Student02();
        student1.setId(1001);
        student1.setName("Semra Hanim");
        student1.setGrade(99);

        //student1.setAddress();//parametre olrak Address data typenda bir obje istiyor bu yuzden Address classindan bir obje olusturuyrm
        Address address1=new Address();
        address1.setStreet("Apple Street");
        address1.setCity("London");
        address1.setCountry("Endland");
        address1.setZipCode("06533");

        student1.setAddress(address1);

        Address address2 = new Address();
        address2.setStreet("Elma Caddesi");
        address2.setCity("Elazig");
        address2.setCountry("Turkiye");
        address2.setZipCode("536343");

        Student02 student2 = new Student02();
        student2.setId(1002);
        student2.setName("James Bond");
        student2.setGrade(75);
        student2.setAddress(address2);

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student02.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);


        tx.commit();
        session.close();
        sf.close();
    }
}
