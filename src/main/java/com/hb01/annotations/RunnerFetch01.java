package com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch01 {
    public static void main(String[] args) {

        Configuration con=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);//-->Config dosyasini ve entityy classimi belirtiyorum


        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //DB'den bilgi cekmek icin;
            //1-get methodu
            //2-SQL
            //3-HQL(Hibernate Query Language)

        //1.Get Methodu ile;
//        Student01 student1=session.get(Student01.class, 1001);
//        // 1.parametre -> hangi türde bir nesne çekmek istediğinizi belirtir
//        Student01 student2=session.get(Student01.class, 1002);
//
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student2.getName());

        // Not: SQL =========================================================================
//        String sqlQuery = "SELECT * FROM t_student01";
//        List<Object[]> resultList1 = session.createSQLQuery(sqlQuery).getResultList();
//
//        for (Object[] objects : resultList1){
//            System.out.println(Arrays.toString(objects));
//        }

        // Not: HQL ==========================================================================
//        String hqlQuery1 = "FROM Student01";//sql den farkli olrak tablo adi degil entity adini uyani class adini yaziyoruz
//        List<Student01> resultList3 = session.createQuery(hqlQuery1, Student01.class).getResultList();
//
//        for(Student01 student01 : resultList3){
//            System.out.println(student01);
//        }

        //Not; sorgu neticesinde tek bir data gelecekse uniqueResult()
        // SQL ile cozumu =================
//        String sqlQuery2="SELECT * FROM t_student01 WHERE student_name='Omer Faruk'";//sql'de tablename ve sutun adi yaziyoruz
//        Object[] uniqueResult1= (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();//uniqueResult() methodu tek bir obje dondurur
//        System.out.println(Arrays.toString(uniqueResult1));
//        System.out.println(uniqueResult1[0]);//id'yi getirir


        //Not; sorgu neticesinde tek bir data gelecekse uniqueResult()
        // HQL ile cozumu =================
        //String hqlQuery2 = "FROM Student01 WHERE name='Faruk Bey'";
//        Student01 uniqueResult2 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
//        System.out.println(uniqueResult2);


        //Not: Alias kullanimi-----------------Alias'lari uzun tablo isimlerinden kacinmak icin AS diyerek veya demeden yeniden isimlendiiryoruz
//        String hqlQuery3="FROM Student01 std WHERE std.name='Omer Faruk'";//Student01--> std olsun dedik
//        Student01 uniquRersult3=session.createQuery(hqlQuery3, Student01.class).uniqueResult();
//        System.out.println(uniquRersult3);
//
//        //grade degeri 75 olan ogrencilerin id ve namelerini getir
//        String hqlQuery4="SELECT s.id, s.name FROM Student01 s WHERE s.grade=75";//Student01 olan table name s olsun dedik
//        List<Object[]> resultList4=session.createQuery(hqlQuery4).getResultList();//birden fazla deger donecekse getResultList(), tek obje donecekse uniqueResult()
//        //burada 2.cozum olarak(onerilmeyen) Student01.class demeyip yani mapleme yapmadan List in turu Object dedim boyle de olur ama kullanisli degil
//        for (Object[] objects: resultList4){
//            System.out.println(Arrays.toString(objects));
//        }

        //id'ye gore azalan sirali listeyi getirleim==============
        String hqlQuery5="FROM Student01 s ORDER BY s.id DESC";
        List<Student01> resultList5=session.createQuery(hqlQuery5, Student01.class).getResultList();
        for (Student01 student01: resultList5){
            System.out.println(student01);
        }

        // !!! get - SQL - HQL --> Hangisini tercih etmemiz gerekiyor :  1-get / 2-HQL / 3-SQL
    /*  HQL daha yavas cunku HQL kodelari once SQL e cevrilip oyle okunuyor dtabesede

        *   Native SQL hizli olsada eksi yonleri :
        1) bazi DB'lerde sql syntax'in farkliliklar olabiliyor, Native SQL burada sorun olabilir
        2) String yapilarin hataya acik olmasi
*/


        tx.commit();
        session.close();
        sf.close();
    }
}
