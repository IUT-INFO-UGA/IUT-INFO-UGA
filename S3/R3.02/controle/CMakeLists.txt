cmake_minimum_required(VERSION 3.19)
project(R302-Exam2022)

set(CMAKE_CXX_STANDARD 14)

add_executable(1_liste partie1/testListe.cpp partie1/ListeInt.cpp partie1/CellInt.cpp)

add_executable(2_arbrebinaire partie2/testArbreBinaire.cpp partie2/ArbreBinaireInt.cpp partie2/NoeudBinaireInt.cpp partie2/prettyPrint.cpp)

add_executable(3_mondial partie3/testMondial.cpp partie3/Mondial.cpp partie3/tinyxml2.cpp partie3/PrecondVioleeExcep.cpp)