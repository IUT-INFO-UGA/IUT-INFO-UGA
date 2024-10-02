#ifndef USAGER_H
#define USAGER_H
#include <string>

class Usager {

private:
    const std::string name;
    const std::string emploi;
public:
    Usager(const std::string name, const std::string emploi) : name(name), emploi(emploi) {};
};

#endif /* USAGER_H */

