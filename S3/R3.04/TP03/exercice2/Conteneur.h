#ifndef CONTENEUR_H
#define CONTENEUR_H

#include <vector>
#include <iostream>
#include <stdexcept>

template <class T>
class Conteneur {
public:
    Conteneur();                                                        // Construit le Conteneur (vide au départ)
    Conteneur(const Conteneur<T> & unAutreConteneur);                   // Construit le Conteneur (*this) par recopie d'un autre Conteneur
    Conteneur<T> & operator=(const Conteneur<T> & unAutreConteneur);    // Affecte le contenu d'un autre Conteneur au Conteneur (*this)
    virtual ~Conteneur();       // Vide le contenu du Conteneur
    void ajouter(T * element);  // Ajoute un élément au Conteneur
    void afficher() const;      // Affiche sur std::cout le contenu du Conteneur (éléments numérotés de 1 à n)
    T & choisir();  // 1. Affiche sur std::cout le contenu du Conteneur (éléments numérotés de 1 à n)
                    // 2. Demande à l'utilisateur de saisir sur std::cin un numéro d'élément i (1<=i<=n)
                    // 3. Retourne le ième élément du Conteneur
private:
    std::vector<T*> m_contenu;                          // Le contenu du Conteneur : un vecteur de T*
    void clear();                                       // Vide le Conteneur
    void clone(const Conteneur<T> & unAutreConteneur);  // Clone un autre Conteneur sur le Conteneur (*this)
};

// Implémentez ici les méthodes du template Conteneur<T> (pas de fichier .cpp pour un template)

template <class T>
Conteneur<T>::Conteneur()
: m_contenu() {
}

template <class T>
void Conteneur<T>::clone(const Conteneur<T> & unAutreConteneur) {
    // on clone le contenu de unConteneur dans this
    for (T* element : unAutreConteneur.m_contenu) {
        this->m_contenu.push_back(new T(*element)); // On alloue dynamiquement un nouvel élément construit par recopie
    }
}

template <class T>
void Conteneur<T>::clear() {
    for (T* element : this->m_contenu) {
        delete element; // On supprimer chaque élément du Conteneur
    }
    m_contenu.clear(); // Et on n'oublie pas de "vider" le vecteur de pointeurs
}

template <class T>
Conteneur<T>::Conteneur(const Conteneur<T> & unAutreConteneur) {
    this->clone(unAutreConteneur);
}

template <class T>
Conteneur<T> & Conteneur<T>::operator=(const Conteneur<T> & unAutreConteneur) {
    this->clear(); // On vide le conteneur *this (qui peut contenir des éléments)
    this->clone(unAutreConteneur); // On clone le contenu de l'autre Conteneur dans *this
    return *this; // On retourne *this pour pouvoir chaîner l'opérateur =, par exemple : c1=c2=c3;
}

template <class T>
Conteneur<T>::~Conteneur() {
    this->clear(); // On vide le conteneur *this
}

template <class T>
void Conteneur<T>::ajouter(T * element) {
    this->m_contenu.push_back(element);
}

template <class T>
void Conteneur<T>::afficher() const {
    unsigned int num = 1;
    for (T* element : this->m_contenu) {
        std::cout << num++ << " - " << *element << std::endl; // Possible seulement s'il existe operator<<(iostream, T)
    }
}

template <class T>
T & Conteneur<T>::choisir() {
    unsigned int i;
    std::cin >> i;
    std::cin.ignore(256, '\n'); // pour "consommer" le retour chariot (\n) tapé après l'entier saisi
    if (i < 1 || i > this->m_contenu.size()) {
        throw std::range_error("Element Inexistant"); // l'exception range_error est pertinente pour ce type de situation
    }
    return *(this->m_contenu[i - 1]); // Attention : il faut bien penser à déréférencer m_contenu[i - 1]
}

#endif /* CONTENEUR_H */

