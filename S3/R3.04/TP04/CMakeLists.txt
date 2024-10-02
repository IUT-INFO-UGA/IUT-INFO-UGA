cmake_minimum_required(VERSION 3.23)
project(TP04)

set(CMAKE_CXX_STANDARD 14)

add_executable(exercice1 exercice1/exercice1.cpp exercice1/Element.cpp
               exercice1/Fichier.cpp exercice1/Repertoire.cpp exercice1/Usager.cpp)
add_executable(exercice2 exercice2/exercice2.cpp exercice2/Parametres.cpp
               exercice2/Joueur.h exercice2/Theme.h)
