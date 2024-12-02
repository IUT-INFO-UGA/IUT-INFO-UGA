/* 
 * File:   prettyPrint.h
 * Author: hb adapted from https://articles.leetcode.com/how-to-pretty-print-binary-tree/
 *
 * Created on 3 janvier 2018, 14:10
 */

#ifndef PRETTYPRINT_H
#define PRETTYPRINT_H

#include "NoeudBinaire.h"
#include "ArbreNoeudsBinairesRecherche.h"

#include <fstream>
#include <iostream>
#include <deque>
#include <iomanip>
#include <sstream>
#include <string>
#include <math.h>

using namespace std;

namespace prettyPrint {
    
    template<typename TypeInfo>
    int maxHeight(NoeudBinaire<TypeInfo>* p);
    
    template<typename TypeInfo>
    string toString(TypeInfo val);
    
    template<typename TypeInfo>
    void printBranches(int branchLen, int nodeSpaceLen, int startLen, int nodesInThisLevel, const deque<NoeudBinaire<TypeInfo>*>& nodesQueue, ostream& out);
    
    template<typename TypeInfo>
    void printNodes(int branchLen, int nodeSpaceLen, int startLen, int nodesInThisLevel, const deque<NoeudBinaire<TypeInfo>*>& nodesQueue, ostream& out);
    
    template<typename TypeInfo>
    void printLeaves(int indentSpace, int level, int nodesInThisLevel, const deque<NoeudBinaire<TypeInfo>*>& nodesQueue, ostream& out);
    
    template<typename TypeInfo>
    void printPretty(ArbreNoeudBinaireRecherche<TypeInfo>* tree, int level, int indentSpace, ostream& out);
}


#endif /* PRETTYPRINT_H */

