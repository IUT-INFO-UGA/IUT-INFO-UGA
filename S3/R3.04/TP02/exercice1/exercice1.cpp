#include <cstdlib>
#include <iostream>
#include "EntierContraint.h"
using namespace std;

int main(int argc, char** argv) {
    
    // A Compléter
    // Il faut tester operator int, operator << et operator >> sur la classe EntierContraint
    EntierContraint ec(5,0,100);
    int i=int(ec);
    cout << i ;
    return 0;
}

