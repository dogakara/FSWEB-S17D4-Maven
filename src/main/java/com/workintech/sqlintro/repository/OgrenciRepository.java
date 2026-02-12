package com.workintech.sqlintro.repository;

import com.workintech.sqlintro.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

    String QUESTION_1 = "SELECT * FROM ogrenci";
    @Query(value = QUESTION_1, nativeQuery = true)
    List<Ogrenci> findAll();

    String QUESTION_2 = "SELECT * FROM ogrenci WHERE cinsiyet = 'K'";
    @Query(value = QUESTION_2, nativeQuery = true)
    List<Ogrenci> findGirls();

    String QUESTION_3 = "SELECT DISTINCT sinif FROM ogrenci WHERE sinif IS NOT NULL ORDER BY sinif";
    @Query(value = QUESTION_3, nativeQuery = true)
    List<String> findAllClasses();

    String QUESTION_4 = "SELECT * FROM ogrenci WHERE sinif = '10A' AND cinsiyet = 'K'";
    @Query(value = QUESTION_4, nativeQuery = true)
    List<Ogrenci> find10AGirls();

    String QUESTION_5 = "SELECT * FROM ogrenci WHERE cinsiyet = 'K' AND ogrno BETWEEN 5 AND 10";
    @Query(value = QUESTION_5, nativeQuery = true)
    List<Ogrenci> findGirlsWithOgrno();

    String QUESTION_6 = "SELECT * FROM ogrenci ORDER BY ad ASC";
    @Query(value = QUESTION_6, nativeQuery = true)
    List<Ogrenci> findStudentsAlphabetically();

    String QUESTION_7 = "SELECT * FROM ogrenci WHERE sinif = '10A' ORDER BY ogrno DESC";
    @Query(value = QUESTION_7, nativeQuery = true)
    List<Ogrenci> find10AStudentsByOgrNo();

    String QUESTION_8 = "SELECT * FROM ogrenci ORDER BY dtarih DESC LIMIT 1";
    @Query(value = QUESTION_8, nativeQuery = true)
    Ogrenci findYoungestStudent();

    String QUESTION_9 = "SELECT * FROM ogrenci ORDER BY dtarih ASC LIMIT 1";
    @Query(value = QUESTION_9, nativeQuery = true)
    Ogrenci findElderStudent();

    String QUESTION_10 = "SELECT * FROM ogrenci WHERE SUBSTRING(ad, 2, 1) = 'e' OR SUBSTRING(ad, 2, 1) = 'E'";
    @Query(value = QUESTION_10, nativeQuery = true)
    List<Ogrenci> findStudentsSecondLetterOfN();
}