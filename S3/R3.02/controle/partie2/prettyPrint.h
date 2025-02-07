/* 
 * File:   prettyPrint.h
 * Author: hb adapted from https://articles.leetcode.com/how-to-pretty-print-binary-tree/
 *
 * Created on 3 janvier 2018, 14:10
 */

#ifndef PRETTYPRINT_H
#define PRETTYPRINT_H

#include "NoeudBinaireInt.h"
#include "ArbreBinaireInt.h"

#include <fstream>
#include <iostream>
#include <deque>
#include <iomanip>
#include <sstream>
#include <string>
#include <math.h>

using namespace std;

namespace prettyPrint {
    
    int maxHeight(NoeudBinaireInt* p);
    
    string intToString(int val);
    
    void printBranches(int branchLen, int nodeSpaceLen, int startLen, int nodesInThisLevel, const deque<NoeudBinaireInt*>& nodesQueue, ostream& out);
    
    void printNodes(int branchLen, int nodeSpaceLen, int startLen, int nodesInThisLevel, const deque<NoeudBinaireInt*>& nodesQueue, ostream& out);
    
    void printLeaves(int indentSpace, int level, int nodesInThisLevel, const deque<NoeudBinaireInt*>& nodesQueue, ostream& out);
    
    void printPretty(ArbreBinaireInt tree, int level, int indentSpace, ostream& out);
}


#endif /* PRETTYPRINT_H */

