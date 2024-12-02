//  Created by Frank M. Carrano and Tim Henry.
//  Copyright (c) 2013 __Pearson Education__. All rights reserved.

/** Listing 15-1.
 @file BinaryTreeInterface.h */

#ifndef _BINARY_TREE_INTERFACE
#define _BINARY_TREE_INTERFACE

#include "ExceptionNonTrouve.h"

template<class TypeInfo>
class ArbreBinaireInterface
{
public:
   /** Teste si cet arbre binaire (this) est vide ou non.
    @return  vrai si cet arbre binaire est vide, faux sinon. */
   virtual bool estVide() const = 0;
   
   /** Retourne la hauteur de cet arbre binaire (this).
    @return  La hauteur de cet arbre binaire. */
   virtual int getHauteur() const = 0;
   
   /** Retourne le nombre de noeuds de cet arbre binaire (this).
    @return Le nombre de noeuds de cet arbre binaire. */
   virtual int getNombreDeNoeuds() const = 0;
   
   /** Retourne l'information disponble à la racine de cet arbre binaire (this).
    @pre  L'arbre binaire n'est pas vide.
    @post  L'information portée par la racine a été retournée, cet arbre binaire est inchangé.
    @return  L'information portée la racine de cet arbre. */
   virtual TypeInfo getInfoRacine() const = 0;
   
   /** Insère un nouveau noeud contenant la nouvelle information à cet arbre binaire.
    @param nouvelleInfo  l'information porté par le nouveau noeud.
    @post  L'arbre binaire contient un nouveau noeud contenant nouvelleInfo.
    @return  vrai si l'ajout est résussit, faux sinon. */
   virtual void insere(const TypeInfo& nouvelleInfo) = 0;
   
   /** Supprime le premier noeud contenant uneInfo de cet arbre binaire.
    @param  uneInfo  La valeur de d'information à suppirmer dans cet arbre binaire.
    @return  vrai si la suppression est réussie, faux sinon. */
   virtual bool supprime(const TypeInfo& uneInfo) = 0;
   
   /** Supprime tous les noeuds de cet arbre binaire. */
   virtual void vide() = 0;
      
   /** Teste si uneInfo est présente dans cet arbre binaire.
    @post  Cet arbre binaire est inchangé.
    @param uneInfo  L'information cherchée.
    @return  True si uneInfo est présente dans cet arbre ; false sinon. */
    virtual bool estInfoPresente(const TypeInfo& uneInfo) const = 0;
   
  
}; // end BinaryTreeInterface

#endif
