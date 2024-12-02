#include "gtest/gtest.h"
#include <map>
#include "Salarie.h"
#include "SalarieException.h"
using namespace std;

TEST(SalarieTest, Constructeur) {
    // A COMPLETER : tester Salarie::Salarie
    Salarie s1("test", "1234567891234", 5000);
    EXPECT_EQ(s1.getNom(), "TEST") << "nom incorect";
    EXPECT_EQ(s1.getSalaireMensuel(), 5000) << "salaire mensuel incorrect";
    EXPECT_EQ(s1.getNumeroSS(), "1234567891234") << "numero ss incorect";

    Salarie S2{};
    S2.setNom("test");
    EXPECT_EQ(S2.getNom(), "TEST") << "erreur dans setNom";
    EXPECT_THROW(S2.setNom(""), NomIncorrectException);
    EXPECT_THROW(S2.setNom("-e"), NomIncorrectException);
    EXPECT_THROW(S2.setNom("e-"), NomIncorrectException);
    EXPECT_THROW(S2.setNom("test1"), NomIncorrectException);
    EXPECT_EQ(S2.getNom(), "TEST-test") << "erreur dans setNom";

    Salarie S3{};
    S3.setNumeroSS("1234567891234");
    EXPECT_EQ(S3.getNumeroSS(), "1234567891234");
    EXPECT_THROW(S3.setNumeroSS("1234567"), NumeroIncorrectException);
    EXPECT_THROW(S3.setNumeroSS("12345678912345"), NumeroIncorrectException);
    EXPECT_THROW(S3.setNumeroSS("123456789123A"), NumeroIncorrectException);

    Salarie S4{};
    EXPECT_THROW(S4.setSalaireMensuel(500), NumeroIncorrectException);
    EXPECT_THROW(S4.setSalaireMensuel(-6000), NumeroIncorrectException);
    S4.setSalaireMensuel(6000);
    EXPECT_EQ(S4.getSalaireMensuel(), 6000);
    S4.setSalaireMensuel(6000.50);
    EXPECT_EQ(S4.getSalaireMensuel(), 6000.50);
}

TEST(SalarieTest, GetNom) {
    // A COMPLETER : test Salarie::getNom
    Salarie s1{};
    EXPECT_EQ(s1.getNom(), "MARTIN") << "nom incorect";
}

TEST(SalarieTest, SetNom) {
    // A COMPLETER : test Salarie::setNom
    Salarie s1{};
    s1.setNom("test");
    EXPECT_EQ(s1.getNom(), "TEST") << "erreur dans setNom";
    EXPECT_THROW(s1.setNom(""), NomIncorrectException);
    EXPECT_THROW(s1.setNom("-e"), NomIncorrectException);
    EXPECT_THROW(s1.setNom("e-"), NomIncorrectException);
    EXPECT_THROW(s1.setNom("test1"), NomIncorrectException);
    EXPECT_EQ(s1.getNom(), "TEST-test") << "erreur dans setNom";


}

TEST(SalarieTest, SetNumeroSS) {
    // A COMPLETER : test Salarie::setNumeroSS
    Salarie s1{};
    s1.setNumeroSS("1234567891234");
    EXPECT_EQ(s1.getNumeroSS(), "1234567891234");
    EXPECT_THROW(s1.setNumeroSS("1234567"), NumeroIncorrectException);
    EXPECT_THROW(s1.setNumeroSS("12345678912345"), NumeroIncorrectException);
    EXPECT_THROW(s1.setNumeroSS("123456789123A"), NumeroIncorrectException);
}

TEST(SalarieTest, SetSalaire) {
    // A COMPLETER : test Salarie::setSalaire
    Salarie s1{};
    EXPECT_THROW(s1.setSalaireMensuel(500), NumeroIncorrectException);
    EXPECT_THROW(s1.setSalaireMensuel(-6000), NumeroIncorrectException);
    s1.setSalaireMensuel(6000);
    EXPECT_EQ(s1.getSalaireMensuel(), 6000);
    s1.setSalaireMensuel(6000.50);
    EXPECT_EQ(s1.getSalaireMensuel(), 6000.50);
}

TEST(SalarieTest, GetImpot)
{
    // A COMPLETER : tester Salarie::getImpot
    Salarie s1{};
    s1.setSalaireMensuel(6000.0f);
    EXPECT_EQ(true,true);
    for (auto tranche_impot : Salarie::TRANCHES_IMPOT)
    {
        if(Salarie::TRANCHES_IMPOT[0].first==)
        s1.setSalaireMensuel((tranche_impot.first*12.0f)-1.0f);
        EXPECT_FLOAT_EQ(s1.getImpot(), tranche_impot.second);
    }
}

