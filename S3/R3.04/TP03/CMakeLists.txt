cmake_minimum_required(VERSION 3.23)
project(TP03)

set(CMAKE_CXX_STANDARD 14)

add_executable(exercice1 exercice1/AttributsVisage.h exercice1/Visage.cpp exercice1/Exercice1.cpp)
add_executable(exercice2 exercice2/ObjetContraint.h exercice2/Conteneur.h exercice2/Tarif.cpp
        exercice2/Trajet.cpp exercice2/Promotion.cpp exercice2/Billet.cpp exercice2/BilletReduit.cpp
        exercice2/exercice2.cpp)
