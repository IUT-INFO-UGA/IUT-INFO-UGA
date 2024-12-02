cmake_minimum_required(VERSION 3.19)
project(TP302-TP3)

set(CMAKE_CXX_STANDARD 14)

add_executable(mondial TestMondial.cpp Mondial.cpp tinyxml2.cpp PrecondVioleeExcep.cpp)