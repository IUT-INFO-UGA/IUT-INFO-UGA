cmake_minimum_required(VERSION 3.23)
project(TP07_ExemplePatternVisitor)

set(CMAKE_CXX_STANDARD 14)

add_executable(exercice1 exercice1.cpp Composite.h Composite.cpp Visiteur.h Visiteur.cpp)
