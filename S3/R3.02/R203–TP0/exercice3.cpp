#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <vector>

using namespace std;

template<class T>
void afficheVecteur(const vector<T> v) {
    // {v.size() > 0} => {pretty print de v}
    cout << "[" << v[0];
    int i = 1;
    while (i < v.size()) {
        cout << ", " << v[i];
        i++;
    }
    cout << "]" << endl;
}

template<class T>
void minMaxIter(const vector<T> v, T &min, T &max, int &nbComp) {
    // {v.size()≥ 1} => {min = plus petite valeur de v,
    //                   max = plus grande valeur de v,
    //                   nbcomp = nombre de comparaisons impliquant au moins un élément de v}

    for (int i = 1; i < v.size(); i++)
    {
        nbComp+=2;
        if(v[i] < min)
        {
            min = v[i];
            nbComp--;
        }else if(v[i] > max)
        {
            max = v[i];
        }
    }
}

template<class T>
void minMaxRec(const vector<T>& v, int inf, int sup, T &min, T &max, int &nbComp) {
    // {v.size()≥ 1} => {min = plus petite valeur de v sur l'intervalle [inf..sup],
    //                   max = plus grande valeur de v sur l'intervalle [inf..sup],
    //                   nbcomp = nombre de comparaisons impliquant au moins un élément de v}

    if(sup-inf<=0)
    {
        min = max = v[inf];
        return;
    }
    else if (inf+1 == sup)
    {
            nbComp++;
        if(v[inf]<v[sup])
        {
            min = v[inf];
            max = v[sup];
            return;
        }else
        {
            min = v[sup];
            max = v[inf];
            return;
        }
    }
    else if (inf+1 <= sup)
    {
        const int med = (inf+sup)/2;
        T minL, minR, maxL, maxR;
        minMaxRec(v, inf, med, minL, maxL, nbComp);
        minMaxRec(v, med+1, sup, minR, maxR, nbComp);
        min = minL < minR ? minL : minR;
        max = maxL > maxR ? maxL : maxR;
        nbComp+=2;

        return;
    }

}


void testMinMaxIter() {
    cout << "***************************" << endl;
    cout << "*        min max iter     *" << endl;
    cout << "***************************" << endl;

    int min;
    int max;
    int nbComp = 0;

    vector<int> v = {10};
    minMaxIter(v, min, max, nbComp);
    cout << "v : ";
    afficheVecteur(v);
    cout << "Taille du vecteur = " << v.size() << " -> " << " min = " << min << ", max = " << max << ", nbComp = " << nbComp << endl << endl;

    nbComp = 0;
    v = {10, 3, 6, 8, 67, 2, 9, 1};
    minMaxIter(v, min, max, nbComp);
    cout << "v : ";
    afficheVecteur(v);
    cout << "Taille du vecteur = " << v.size() << " -> " << " min = " << min << ", max = " << max << ", nbComp = " << nbComp << endl << endl;

    nbComp = 0;
    v.clear();
    srand((unsigned)time(NULL));
    for (int i =0; i < 128; i++){
        int b = rand() % 128 + 1;
        v.push_back(b);
    }
    minMaxIter(v, min, max, nbComp);
    cout << "v : ";
    afficheVecteur(v);
    cout << "Taille du vecteur = " << v.size() << " -> " << " min = " << min << ", max = " << max << ", nbComp = " << nbComp << endl << endl;
}

void testMinMaxDR() {
    cout << "***************************" << endl;
    cout << "*         min max DR      *" << endl;
    cout << "***************************" << endl;

    int min;
    int max;
    int inf;
    int sup;
    int nbComp = 0;

    vector<int> v = {10};
    inf = 0;
    sup = v.size()-1;
    minMaxRec(v, inf, sup, min, max, nbComp);
    cout << "v : ";
    afficheVecteur(v);
    cout << "Taille du vecteur = " << v.size() <<  " -> min = " << min << ", max = " << max << ", nbComp = " << nbComp << endl << endl;

    nbComp = 0;
    v = {10, 3, 6, 8, 67, 2, 9, 1};
    inf = 0;
    sup = v.size()-1;
    minMaxRec(v, inf, sup, min, max, nbComp);
    cout << "v : ";
    afficheVecteur(v);
    cout << "Taille du vecteur = " << v.size() <<  " -> min = " << min << ", max = " << max << ", nbComp = " << nbComp << endl << endl;

    nbComp = 0;
    v.clear();
    srand((unsigned)time(NULL));
    for (int i =0; i < 128; i++){
        int b = rand() % 128 + 1;
        v.push_back(b);
    }
    inf = 0;
    sup = v.size()-1;
    minMaxRec(v, inf, sup, min, max, nbComp);
    cout << "v : ";
    afficheVecteur(v);
    cout << "Taille du vecteur = " << v.size() << " -> min = " << min << ", max = " << max << ", nbComp = " << nbComp << endl << endl;
}

int main(int argc, char **argv) {

    testMinMaxIter();
    testMinMaxDR();

    return 0;
}
