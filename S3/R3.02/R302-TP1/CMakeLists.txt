cmake_minimum_required(VERSION 3.19)
project(TP302-TP1)

set(CMAKE_CXX_STANDARD 14)

add_executable(exercice1 Exercice1/TesteListe.cpp Shared/Cellule.h Shared/PrecondVioleeExcep.cpp Shared/ListeInterface.h PileCellules.h ListeChainee.h)

add_executable(exercice2 Exercice2/TestPile.cpp Shared/Cellule.h Shared/PrecondVioleeExcep.cpp Shared/PileInterface.h PileCellules.h)

add_executable(exercice3 Exercice3/testeListeTrieeChainee.cpp Shared/Cellule.h Shared/PrecondVioleeExcep.cpp Shared/ListeTrieeInterface.h ListeTrieeChainee.h)

