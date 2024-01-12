package com.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Embeddable;

public class RunnerFetch02 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student02.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student02 student=session.get(Student02.class,1001);//get()methodu ile 1001 id'li studentin tum bilgilerini getir dedik,Student02 data typenda bir obje dondurdu
        System.out.println(student);//Student02{id=1001, name='Semra Hanim', grade=99, address=Address{street='Apple Street', city='London', country='Endland', zipCode='06533'}}
        System.out.println("student.getAddress() = " + student.getAddress());//Address{street='Apple Street', city='London', country='Endland', zipCode='06533'}
        //@Embeddable-->bizi tek tek getter methodlarini cagirmaktan kurtarir, getAddress dedigimjizde street,city,county..bilgilerininjn hepsini getirdi

        tx.commit();
        session.close();
        sf.close();
    }
}
