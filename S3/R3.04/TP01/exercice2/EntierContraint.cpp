#include "EntierContraint.h"

// A COMPLETER
EntierContraint::EntierContraint(int valleur, int min, int max)
{
    if (min > max)
    {
        throw std::invalid_argument("EntierContraint::EntierContraint()");
    }
    else if (valleur > max || valleur < min)
    {
        throw std::invalid_argument("EntierContraint::EntierContraint()");
    }
    else
    {
        this->min = min;
        this->max = max;
        this->val = valleur;
    }
}

int EntierContraint::getMin() const
{
    return this->min;
}

int EntierContraint::getMax() const
{
    return this->max;
}

int EntierContraint::getVal() const
{
    return this->val;
}

void EntierContraint::setVal(int val)
{
    if (val > this->max || val < this->min)
    {
        throw std::invalid_argument("EntierContraint::EntierContraint()");
    }
    else
    {
        this->val = val;
    }
}