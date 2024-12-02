#include <cstdlib>
#include <iostream>
#include <iomanip>

using namespace std;

double puissance(float x, int n) {
// {n >= 0} => {résultat = x élevé à la puissance n}
    if(n==0)
    {
        return 1.0;
    }else if (n==1)
    {
        return x;
    }else {
        return x * puissance(x,n-1);
    }
}

double puissanceNbMult(float x, int n, int &nbmult) {
    // {n >= 0} => {résultat = x élevé à la puissance n ;
    //             nbmult est le nombre de multiplications nécessaires à la production du résultat}
    if(n==0)
    {
        return 1.0;
    }else if (n==1)
    {
        return x;
    } else {
        nbmult++;
        return x * puissanceNbMult(x,n-1, nbmult);
    }

}

double puissanceDrNbMult(float x, int n, int &nbmult) {
    // {n > 0} => {résultat = x élevé à la puissance n ;
    //             nbmults est le nombre de multiplications nécessaires à la production du résultat}

    if(n==0)
    {
        return 1.0;
    }else if (n==1)
    {
        return x;
    }else
    {
        const int n2 = n/2;
        if (n%2==0)
        {
            const double nb = puissanceDrNbMult(x,n2, nbmult);
            nbmult++;
            return nb*nb;
        } else
        {
            nbmult+=2;
            const double nb = puissanceDrNbMult(x,n2, nbmult);
            return x*nb*nb;
        }
    }

}

int main(int argc, char **argv) {
    cout << "***************************" << endl;
    cout << "*        puissance        *" << endl;
    cout << "***************************" << endl;
    int x, n;
    x = 2;
    n = 0;
    cout << " – " << x << " puissance " << n << " = " << puissance(x, n) << endl;
    x = 2;
    n = 1;
    cout << " – " << x << " puissance " << n << " = " << puissance(x, n) << endl;
    x = 2;
    n = 16;
    cout << " – " << x << " puissance " << n << " = " << puissance(x, n) << endl;
    x = 2;
    n = 128;
    cout << " – " << x << " puissance " << n << " = " << puissance(x, n) << endl;

    cout << "***************************" << endl;
    cout << "*    puissance nbmult     *" << endl;
    cout << "***************************" << endl;
    int compteur;
    double val;
    compteur = 0;
    x = 2;
    n = 0;
    val = puissanceNbMult(x, n, compteur);
    cout << " – " << x << " puissance " << n << " = " << val << " -> nb multiplications : " << compteur << endl;
    compteur = 0;
    x = 2;
    n = 1;
    val = puissanceNbMult(x, n, compteur);
    cout << " – " << x << " puissance " << n << " = " << val << " -> nb multiplications : " << compteur << endl;
    compteur = 0;
    x = 2;
    n = 16;
    val = puissanceNbMult(x, n, compteur);
    cout << " – " << x << " puissance " << n << " = " << val << " -> nb multiplications : " << compteur << endl;
    compteur = 0;
    x = 2;
    n = 128;
    val = puissanceNbMult(x, n, compteur);
    cout << " – " << x << " puissance " << n << " = " << val << " -> nb multiplications : " << compteur << endl;


    cout << "***************************" << endl;
    cout << "*   puissance DR nbmult   *" << endl;
    cout << "***************************" << endl;
    compteur = 0;
    x = 2;
    n = 0;
    val = puissanceDrNbMult(x, n, compteur);
    cout << " – " << x << " puissance " << n << " = " << val << " -> nb multiplications : " << compteur << endl;
    compteur = 0;
    x = 2;
    n = 1;
    val = puissanceDrNbMult(x, n, compteur);
    cout << " – " << x << " puissance " << n << " = " << val << " -> nb multiplications : " << compteur << endl;
    compteur = 0;
    x = 2;
    n = 16;
    val = puissanceDrNbMult(x, n, compteur);
    cout << " – " << x << " puissance " << n << " = " << val << " -> nb multiplications : " << compteur << endl;
    compteur = 0;
    x = 2;
    n = 128;
    val = puissanceDrNbMult(x, n, compteur);
    cout << " – " << x << " puissance " << n << " = " << val << " -> nb multiplications : " << compteur << endl;


    return 0;
}