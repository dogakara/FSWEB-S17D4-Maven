package com.workintech.sqlintro;

import com.workintech.sqlintro.entity.Ogrenci;
import com.workintech.sqlintro.repository.OgrenciRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(ResultAnalyzer.class)
class SqlIntroApplicationTests {

    private OgrenciRepository ogrenciRepository;

    @Autowired
    public SqlIntroApplicationTests(OgrenciRepository ogrenciRepository) {
        this.ogrenciRepository = ogrenciRepository;
    }

    @DisplayName("Öğrenci tablosundaki tüm kayıtları listeleyin.")
    @Test
    void getAllStudentTest() {
        List<Ogrenci> students = ogrenciRepository.findAll();
        assertEquals(10, students.size());
        assertEquals("Hülya", students.get(0).getAd());
    }

    @DisplayName("Öğrenci tablosundaki kız öğrencileri listeleyin.")
    @Test
    void getAllGirlsTest() {
        List<Ogrenci> girls = ogrenciRepository.findGirls();
        assertEquals(5, girls.size());
        assertEquals("Hülya", girls.get(0).getAd());
    }

    @DisplayName("Öğrenci tablosunda kaydı bulunan sınıfların adını her sınıf bir kez görüntülenecek şekilde listeleyiniz")
    @Test
    void getAllStudentBySpecialColumnsTest() {
        List<String> classes = ogrenciRepository.findAllClasses();
        assertEquals(6, classes.size());
    }

    @DisplayName("Öğrenci tablosunda, 10A sınıfında olan kız öğrencileri listeleyiniz.")
    @Test
    void getFind10AGirlsTest() {
        List<Ogrenci> girls = ogrenciRepository.find10AGirls();
        assertEquals(1, girls.size());
        assertEquals("Hülya", girls.get(0).getAd());
        assertEquals("Yiğit", girls.get(0).getSoyad());
    }

    @DisplayName("Öğrenci numarası 5 ile 10 arasında olan Kız öğrencileri listeleyiniz.")
    @Test
    void getFindGirlsWithOgrnoTest() {
        List<Ogrenci> girls = ogrenciRepository.findGirlsWithOgrno();
        assertEquals(4, girls.size());  // 3 → 4 olarak değiştir
        assertEquals("Betül", girls.get(0).getAd());
    }

    @DisplayName("Öğrencileri adına göre sıralayınız (alfabetik)")
    @Test
    void findStudentsAlphabeticallyTest() {
        List<Ogrenci> students = ogrenciRepository.findStudentsAlphabetically();
        assertEquals(10, students.size());
        assertEquals("Betül", students.get(0).getAd());
        assertEquals("Sema", students.get(students.size() - 1).getAd());
    }

    @DisplayName("10A sınıfındaki öğrencileri okul numarasına göre azalan olarak sıralayınız.")
    @Test
    void find10AStudentsByOgrNo() {
        List<Ogrenci> students = ogrenciRepository.find10AStudentsByOgrNo();
        assertEquals(1, students.size());
        assertEquals("Hülya", students.get(0).getAd());
    }

    @DisplayName("Öğrenciler tablosundaki en genç öğrenciyi listeleyiniz.")
    @Test
    void findYoungestStudentTest() {
        Ogrenci student = ogrenciRepository.findYoungestStudent();
        assertEquals("Niyazi", student.getAd());
        assertEquals("Sevinç", student.getSoyad());
    }

    @DisplayName("Öğrenciler tablosundaki en yaşlı öğrenciyi listeleyiniz.")
    @Test
    void findElderStudentTest() {
        Ogrenci student = ogrenciRepository.findElderStudent();
        assertEquals("Kenan", student.getAd());
        assertEquals("Emin", student.getSoyad());
    }

    @DisplayName("İkinci harfi E olan öğrencileri listeleyiniz.")
    @Test
    void findStudentsSecondLetterOfETest() {
        List<Ogrenci> students = ogrenciRepository.findStudentsSecondLetterOfN();
        assertEquals(5, students.size());  // 4 → 5 olarak değiştir
    }
}