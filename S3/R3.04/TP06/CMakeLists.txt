cmake_minimum_required(VERSION 3.23)
project(TP06-correction)
set(CMAKE_CXX_STANDARD 14)
# Avoid warning about DOWNLOAD_EXTRACT_TIMESTAMP in CMake 2.24:
if(CMAKE_VERSION VERSION_GREATER_EQUAL "3.24.0")
    cmake_policy(SET CMP0135 NEW)
endif()

# 1. Compilation du petit programme de tests "à la main" (exercice 1)

add_executable(exercice1 exercice1.cpp Salarie.h Salarie.cpp SalarieException.h)

# 2. Compilation des tests unitaires (salarieTest)

# Pour inclure la bibliothèque GoogleTest au projet (en allant la chercher sur GitHub
include(FetchContent)
FetchContent_Declare(
        googletest
        # Specify the commit you depend on and update it regularly.
        URL https://github.com/google/googletest/archive/03597a01ee50ed33e9dfd640b249b4be3799d395.zip
)

# Pour Windows: empêche la redéfinition des réglages de compilation/édition de lien du projet "parent"
set(gtest_force_shared_crt ON CACHE BOOL "" FORCE)
FetchContent_MakeAvailable(googletest)

add_executable(salarieTest salarieTest.cpp Salarie.h Salarie.cpp SalarieException.h)
# Il faut lier l'exécutable à la bibliothèque gtest_main
target_link_libraries(salarieTest gtest_main)