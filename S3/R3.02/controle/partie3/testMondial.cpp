
#include <cstdlib>
#include <iostream>

#include "Mondial.h"

using namespace std;


void testIslandCodeFromName(Mondial& theMondial) {
    cout << endl << "****************************************" << endl;
    cout << "*                                      *" << endl;
    cout << "*           Code d'une île             *" << endl;
    cout << "*                                      *" << endl;
    cout << "****************************************" << endl << endl;
    string islandName;
    string islandCode;
    try {
        islandName = "Guernsey";
        islandCode = theMondial.getIslandCodeFromName(islandName);
        cout << "L'île : " << islandName << " existe et son code est : " << islandCode << endl;
    } catch (PrecondVioleeExcep e) {
        cout << endl << "  !!! CA C'EST MAL PASSEE, VOICI POURQUOI ---> " << endl;
        cout << e.what() << endl;
        cout << "  !!! ENFIN ON A QUAND MEME RECUPERER LE COUP !" << endl;
    }
    try {
        islandName = "Test";
        islandCode = theMondial.getIslandCodeFromName(islandName);
        cout << "L'île : " << islandName << " existe et son code est :  " << islandCode << endl;
    } catch (PrecondVioleeExcep e) {
        cout << endl << "  !!! CA C'EST MAL PASSEE, VOICI POURQUOI ---> " << endl;
        cout << e.what() << endl;
        cout << "  !!! ENFIN ON A QUAND MEME RECUPERER LE COUP !" << endl;
    }
    cout << endl;
}

void testPrintInfoIslandFromName(Mondial& theMondial) {
    cout << endl << "******************************" << endl;
    cout << "*                            *" << endl;
    cout << "*  Informations sur une île  *" << endl;
    cout << "*                            *" << endl;
    cout << "******************************" << endl << endl;
    string islandName;
    islandName = "Guernsey";
    theMondial.printInfoIslandFromName(islandName);
    cout << endl;
    islandName = "Greenland";
    theMondial.printInfoIslandFromName(islandName);
    cout << endl;
    islandName = "Hokkaido";
    theMondial.printInfoIslandFromName(islandName);
    cout << endl;
    islandName = "Test";
    theMondial.printInfoIslandFromName(islandName);
    cout << endl;
}

void testPrintIslandsInSameArchipelago(Mondial& theMondial) {
    cout << endl << "**********************************" << endl;
    cout << "*                                *" << endl;
    cout << "*  Informations sur un archipel  *" << endl;
    cout << "*                                *" << endl;
    cout << "**********************************" << endl << endl;
    string islandName;
    islandName = "Guernsey";
    theMondial.printIslandsInSameArchipelago(islandName);
    cout << endl;
    islandName = "Hokkaido";
    theMondial.printIslandsInSameArchipelago(islandName);
    cout << endl;
    islandName = "Saint Pierre";
    theMondial.printIslandsInSameArchipelago(islandName);
    cout << endl;
 
}

void testPrintIslandBorderedExculivelyByOneSea(Mondial& theMondial) {
    cout << endl << "************************************************" << endl;
    cout << "*                                              *" << endl;
    cout << "*  Informations sur les îles d'une mer unique  *" << endl;
    cout << "*                                              *" << endl;
    cout << "************************************************" << endl << endl;
    string seaCode;
    seaCode = "sea-ArcticOcean";
    theMondial.printIslandBorderedExculivelyByOneSea(seaCode);
    cout << endl;
    seaCode = "sea-Caribbean";
    theMondial.printIslandBorderedExculivelyByOneSea(seaCode);
    cout << endl;
    seaCode = "sea-JapanSea";
    theMondial.printIslandBorderedExculivelyByOneSea(seaCode);
    cout << endl;
    seaCode = "sea-Schwarzes_Meer";
    theMondial.printIslandBorderedExculivelyByOneSea(seaCode);
    cout << endl;
    seaCode = "sea-Marmarameer";
    theMondial.printIslandBorderedExculivelyByOneSea(seaCode);
    cout << endl;
}

void testPrintIslandBorderedExclusivelyOrNotByOneSea(Mondial& theMondial) {
    cout << endl << "************************************************" << endl;
    cout << "*                                              *" << endl;
    cout << "*  Informations sur les îles d'une mer unique  *" << endl;
    cout << "*                                              *" << endl;
    cout << "************************************************" << endl << endl;
    string seaCode;
    seaCode = "sea-ArcticOcean";
    theMondial.printIslandBorderedExclusivelyOrNotByOneSea(seaCode);
    cout << endl;
    seaCode = "sea-Caribbean";
    theMondial.printIslandBorderedExclusivelyOrNotByOneSea(seaCode);
    cout << endl;
    seaCode = "sea-JapanSea";
    theMondial.printIslandBorderedExclusivelyOrNotByOneSea(seaCode);
    cout << endl;
    seaCode = "sea-Schwarzes_Meer";
    theMondial.printIslandBorderedExclusivelyOrNotByOneSea(seaCode);
    cout << endl;
    seaCode = "sea-Marmarameer";
    theMondial.printIslandBorderedExclusivelyOrNotByOneSea(seaCode);
    cout << endl;
}



int main() {

    /*
     * ATTENTION
     * METTRE VOTRE CHEMIN D'ACCÈS À JOUR SI NÉCESSAIRE !!
     */

    // version HB
    // Mondial theMondial("/Users/hb/Documents/ Enseignement/R3.02/TP_Sols/R302-TP3-Correction-compile/mondial_HB.xml");

    // pour l'examen machine
    Mondial theMondial("/users/info/pub/s3/R302/mondial_HB.xml");

    // autre, mettre votre chemin d'accès au fichier XML
    // Mondial theMondial("/MON_CHEMIN_D_ACCES/mondial_HB.xml");


    //theMondial.Print();

    testIslandCodeFromName(theMondial);
    testPrintInfoIslandFromName(theMondial);
    testPrintIslandsInSameArchipelago(theMondial);
    testPrintIslandBorderedExculivelyByOneSea(theMondial);     
    testPrintIslandBorderedExclusivelyOrNotByOneSea(theMondial);
            
            
    return 0;
}


/* TRACE ATTENDUE */
/*
****************************************
*                                      *
*           Code d'une île             *
*                                      *
****************************************

L'île : Guernsey existe et son code est : island-Guernsey

  !!! CA C'EST MAL PASSEE, VOICI POURQUOI ---> 
Dans getIslandCodeFromName, l'île Test n'existe pas !
  !!! ENFIN ON A QUAND MEME RECUPERER LE COUP !


******************************
*                            *
*  Informations sur une île  *
*                            *
******************************

Informations sur l'île : Guernsey
  - archipel : Channel Islands
  - surface : 194
  - Latitude : 49.6
  - Longitude : -2.6
  - Élévation : 111

Informations sur l'île : Greenland
  - surface : 2175600
  - Latitude : 70
  - Longitude : -40
  - Élévation : 3694

Informations sur l'île : Hokkaido
  - archipel : Japan
  - surface : 83456
  - Latitude : 43.3
  - Longitude : 143
  - Élévation : 2290

L'île Test n'existe pas !


**********************************
*                                *
*  Informations sur un archipel  *
*                                *
**********************************

L'île Guernsey fait partie de l'archipel : Channel Islands
Les îles qui font partie de cet archipel sont : 
   - Guernsey
   - Jersey

L'île Hokkaido fait partie de l'archipel : Japan
Les îles qui font partie de cet archipel sont : 
   - Hokkaido
   - Honshu
   - Kyushu
   - Shikoku
   - Awajishima
   - Okinawa

L'île Saint Pierre ne fait pas partie d'un archipel !

L'île Test n'existe pas !


************************************************
*                                              *
*  Informations sur les îles d'une mer unique  *
*                                              *
************************************************

Îles bordées uniquement par la mer sea-ArcticOcean
  - Victoria Island
  - Banks Island
  - Prince of Wales Island

Îles bordées uniquement par la mer sea-Caribbean
  - Jamaica
  - Curacao
  - Aruba
  - Grand Cayman
  - Little Cayman
  - Cayman Brac
  - San Andres

Îles bordées uniquement par la mer sea-JapanSea
  - Cette mer ne borde de manière excusive aucune île !

Îles bordées uniquement par la mer sea-Schwarzes_Meer
  - Cette mer ne borde de manière excusive aucune île !

Îles bordées uniquement par la mer sea-Marmarameer
  - Cette mer ne borde de manière excusive aucune île !



************************************************
*                                              *
*  Informations sur les îles d'une mer unique  *
*                                              *
************************************************

Îles bordées par la mer sea-ArcticOcean et au moins une autre : 
  – L'île Svalbard est bordée par sea-ArcticOcean, sea-Greenlandsea, sea-NorwegianSea, sea-BarentsSea
  – L'île Greenland est bordée par sea-Atlantic, sea-ArcticOcean, sea-Greenlandsea, sea-LabradorSea
  – L'île Novaya Zemlya Severny Island est bordée par sea-ArcticOcean, sea-BarentsSea, sea-KaraSea
  – L'île Kotelny Island est bordée par sea-ArcticOcean, sea-SibirianSea
  – L'île Victoria Island est bordée uniquement par sea-ArcticOcean
  – L'île Banks Island est bordée uniquement par sea-ArcticOcean
  – L'île Prince of Wales Island est bordée uniquement par sea-ArcticOcean
  – L'île Baffin Island est bordée par sea-ArcticOcean, sea-LabradorSea, sea-HudsonBay
  – L'île Ellesmere Island est bordée par sea-ArcticOcean, sea-LabradorSea
  – L'île Devon Island est bordée par sea-ArcticOcean, sea-LabradorSea

Îles bordées par la mer sea-Caribbean et au moins une autre : 
  – L'île Cuba est bordée par sea-Caribbean, sea-Golf_von_Mexiko, sea-Atlantic
  – L'île Jamaica est bordée uniquement par sea-Caribbean
  – L'île Hispaniola est bordée par sea-Caribbean, sea-Atlantic
  – L'île Puerto Rico est bordée par sea-Caribbean, sea-Atlantic
  – L'île Tortola est bordée par sea-Atlantic, sea-Caribbean
  – L'île Saint Thomas est bordée par sea-Atlantic, sea-Caribbean
  – L'île Anguilla est bordée par sea-Atlantic, sea-Caribbean
  – L'île St. Martin est bordée par sea-Atlantic, sea-Caribbean
  – L'île St. Barthelemy est bordée par sea-Atlantic, sea-Caribbean
  – L'île Saint Kitts est bordée par sea-Atlantic, sea-Caribbean
  – L'île Nevis est bordée par sea-Atlantic, sea-Caribbean
  – L'île Barbuda est bordée par sea-Atlantic, sea-Caribbean
  – L'île Antigua est bordée par sea-Atlantic, sea-Caribbean
  – L'île Montserrat est bordée par sea-Atlantic, sea-Caribbean
  – L'île Basse-Terre est bordée par sea-Atlantic, sea-Caribbean
  – L'île Grande-Terre est bordée par sea-Atlantic, sea-Caribbean
  – L'île Dominica est bordée par sea-Atlantic, sea-Caribbean
  – L'île Martinique est bordée par sea-Atlantic, sea-Caribbean
  – L'île Saint Lucia est bordée par sea-Atlantic, sea-Caribbean
  – L'île Saint Vincent est bordée par sea-Atlantic, sea-Caribbean
  – L'île Grenada est bordée par sea-Atlantic, sea-Caribbean
  – L'île Trinidad est bordée par sea-Atlantic, sea-Caribbean
  – L'île Tobago est bordée par sea-Atlantic, sea-Caribbean
  – L'île Curacao est bordée uniquement par sea-Caribbean
  – L'île Aruba est bordée uniquement par sea-Caribbean
  – L'île Grand Cayman est bordée uniquement par sea-Caribbean
  – L'île Little Cayman est bordée uniquement par sea-Caribbean
  – L'île Cayman Brac est bordée uniquement par sea-Caribbean
  – L'île San Andres est bordée uniquement par sea-Caribbean

Îles bordées par la mer sea-JapanSea et au moins une autre : 
  – L'île Sachalin est bordée par sea-JapanSea, sea-OchotskSea
  – L'île Hokkaido est bordée par sea-JapanSea, sea-Pacific, sea-OchotskSea
  – L'île Honshu est bordée par sea-JapanSea, sea-Pacific
  – L'île Kyushu est bordée par sea-JapanSea, sea-EastChinaSea, sea-Pacific

Îles bordées par la mer sea-Schwarzes_Meer et au moins une autre : 
  - Cette mer ne borde aucune île !

Îles bordées par la mer sea-Marmarameer et au moins une autre : 
  - Cette mer ne borde aucune île !

 */

