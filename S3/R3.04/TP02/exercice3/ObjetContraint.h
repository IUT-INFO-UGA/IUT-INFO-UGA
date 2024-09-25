#ifndef OBJETCONTRAINT_H
#define OBJETCONTRAINT_H
#include <stdexcept>

template <class T>
class ObjetContraint {

    // A COMPLETER : Spécifiez ici le template de classe ObjetContraint<T>
private:
    T m_val, m_min, m_max;

public:
    ObjetContraint(T val, T min, T max);
    const T& getMin() const;
    const T& getMax() const;
    const T& getVal() const;
    void setVal(T min);
    operator T() const;
};

// A COMPLETER : Implémentez ici les méthodes du template ObjetContraint<T> (pas de fichier .cpp pour un template)
template <class T>
void ObjetContraint(T val, T min, T max)
{
    m_val(min);
    m_min(min);
    m_max(max);
}

template <class T>
const t& getMin() const
{

}


#endif /* OBJETCONTRAINT_H */

