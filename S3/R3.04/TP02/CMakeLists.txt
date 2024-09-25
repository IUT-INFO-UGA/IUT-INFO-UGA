cmake_minimum_required(VERSION 3.23)
project(TP02)

set(CMAKE_CXX_STANDARD 14)

add_executable(exercice1 exercice1/exercice1.cpp exercice1/EntierContraint.cpp
        ../TP01/exercice2/EntierContraint.cpp)
add_executable(exercice2 exercice2/exercice2.cpp exercice2/Personne.cpp exercice2/Groupe.cpp
        ../TP01/exercice2/EntierContraint.cpp)
add_executable(exercice3 exercice3/exercice3.cpp exercice3/ObjetContraint.h exercice3/Point.cpp
        ../TP01/exercice2/EntierContraint.cpp)
add_executable(exercice4 exercice4/exercice4.cpp exercice4/Conteneur.h
        ../TP01/exercice2/EntierContraint.cpp)
