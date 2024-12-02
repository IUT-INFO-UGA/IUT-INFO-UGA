cmake_minimum_required(VERSION 3.19)
project(TP302-TP3)

set(CMAKE_CXX_STANDARD 14)

add_executable(exercice1 exercice1.cpp ArbreBinaireInterface.h ArbreNoeudsBinairesRecherche.h ExceptionNonTrouve.cpp ExceptionPrecontionViolee.cpp)

add_executable(exercice2 exercice2.cpp ArbreBinaireInterface.h ArbreNoeudsBinairesRecherche.h ExceptionNonTrouve.cpp ExceptionPrecontionViolee.cpp)