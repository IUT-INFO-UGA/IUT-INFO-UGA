#ifndef ATTRIBUTSVISAGE_H
#define ATTRIBUTSVISAGE_H
#include <string>
#include <iostream>
////////////////////////////////////////////////////////////////////////////////
class Ethnie {
private:
  std::string m_type;
public:
  inline Ethnie(std::string typeEthnie) : m_type(typeEthnie) {}
  inline const std::string & getType() const { return  m_type; }
};
inline std::ostream & operator << (std::ostream & sortie, const Ethnie & ethnie) {
   return sortie << "Ethnie de type " <<  ethnie.getType();
}
////////////////////////////////////////////////////////////////////////////////
class Nez {
private:
  int m_longueur;
public:
  inline Nez(int longueur) : m_longueur(longueur) {}
  inline int getLongueur() const { return  m_longueur; }
};
inline std::ostream & operator << (std::ostream & sortie, const Nez & nez) {
   return sortie << "Nez mesurant " <<  nez.getLongueur() << " cm";
}
////////////////////////////////////////////////////////////////////////////////
class Moustache {
private:
  int m_largeur;
public:
  inline Moustache(int largeur) : m_largeur(largeur) {}
  inline int getLargeur() const { return  m_largeur; }
};
inline std::ostream & operator << (std::ostream & sortie, const Moustache & moustache) {
   return sortie << "Moustache mesurant " <<  moustache.getLargeur() << " cm";
}
////////////////////////////////////////////////////////////////////////////////
class Chapeau {
private:
  int m_poids;
public:
  inline Chapeau(int poids) : m_poids(poids) {}
  inline int getPoids() const { return  m_poids; }
};
inline std::ostream & operator << (std::ostream & sortie, const Chapeau & chapeau) {
   return sortie << "Chapeau pesant " <<  chapeau.getPoids() << " gramme(s)";
}
////////////////////////////////////////////////////////////////////////////////
class Bouton {
private:
  int m_diametre;
public:
  inline Bouton(int diametre) : m_diametre(diametre) {}
  inline int getDiametre() const { return  m_diametre; }
};
inline std::ostream & operator << (std::ostream & sortie, const Bouton & bouton) {
   return sortie << "Un bouton mesurant " << bouton.getDiametre() << " cm";
}
////////////////////////////////////////////////////////////////////////////////
class Bijou {
private:
  int m_prix;
public:
  inline Bijou(int prix) : m_prix(prix) {}
  inline int getPrix() const { return  m_prix; }
};
inline std::ostream & operator << (std::ostream & sortie, const Bijou & bijou) {
   return sortie << "Un bijou coutant " << bijou.getPrix() << " €";
}
#endif /* ATTRIBUTSVISAGE_H */
