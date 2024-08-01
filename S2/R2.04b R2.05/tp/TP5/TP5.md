# TP05 : Réseaux IP et sous-réseaux

Consulter sur l'intranet le [schéma simplifié des réseaux IP de l'IUT2](https://www-info.iut2.univ-grenoble-alpes.fr/intranet/informations/cellule-info/materiel.php).

## 1\. Réseaux IP

Il est possible de connaître la liste de l'ensemble des machines de son   domaine grâce au DNS.  Pour cela, on utilise la commande

```
host -l NOM_DE_DOMAINE_DNS 193.55.51.34
```

Rappeler ici les 2 noms de domaine DNS de l'IUT2 (l'ancien et le nouveau)

1. Rappeler ici les 2 noms de domaine DNS de l'IUT2 (l'ancien et le nouveau)
   1. `iut2.upmf-grenoble.fr`
   2. `iut2.univ-grenoble-alpes.fr`
2. Consulter la liste des machines du domaine de l'IUT2 (cela fonctionne uniquement avec l'ancien domaine). Combien de machines environ sont répertoriées ? (s'aider de la commande wc)
   1. 1885 machines
3. Trier cette liste grâce au script trie-DNS (utilisation : trie-DNS FICHIER_CONTENANT_LA_LISTE). Ce script, écrit pour ce TP, est stocké dans le répertoire `/users/info/pub/bin/`. Vous pouvez en consulter le code si vous le souhaitez.
4. On considère que tous les réseaux de ce domaine sont en /24 (de classe C). Combien de réseaux IP l'IUT2 utilise-t-il ? Indication : parcourir manuellement le fichier d'adresses trié pour compter directement le nombre de réseaux en /24, c'est-à-dire dont le préfixe réseau est sur 24 bits.
   1. /users/info/pub/bin/trie-DNS Downloads/test | cut -d "." -f 1-3 |sort | uniq | wc  
      25     26    282
5. Parmi ces réseaux, combien sont [privés](https://fr.wikipedia.org/wiki/R%C3%A9seau_priv%C3%A9) et combien sont publics ? Indication : utiliser grep avec le préfixe des adresses privées 192.168.
   1. /users/info/pub/bin/trie-DNS Downloads/test | cut -d "." -f 1-3 | sort |uniq | grep "192.168." | wc

      18     18    203

   ## 2 Sous-réseaux
   1. Certains de ces réseaux sont découpés en sous-réseaux, en particulier le réseau 193.55.51.0. En combien de sous-réseaux le réseau 193.55.51.0 est-il découpé ? (Pour cela, se reporter à l'[annexe](https://www-info.iut2.univ-grenoble-alpes.fr/intranet/enseignements/reseaux1A/tp/tableau-sous-reseaux-IP-IUT2.html)).
      1. 10 sous réseau dont 6 utiliser
   2. À l'aide de l'annexe, compléter le tableau ci-dessous:

      | Adresse de réseau  
      en notation CIDR      | Masque de réseau | Intervalle d'adresses  
      utilisables par des machines      |
      |-----------------------------------------|------------------|---------------------------------------------------------|
      | 193\.55.51.64/26                         | 255\.255.255.192  |  193\.55.51.64->126                                      |
      | 193\.55.51.32/27                         | 255\.255.255.224  | 193\.55.51.192->63                                       |
      | 193\.55.51.16/28                         | 255\.255.255.240  | 193\.55.51.16->31                                        |
   3. Dessiner ci-après l'arbre de découpage du réseau 193.55.51.0 pour traduire l'emboîtement des intervalles d'adresses.

![shema reseau.svg](.attachments.192902/shema%20reseau.svg)

1. À quoi peut servir ce découpage en plusieurs sous-réseaux IP ?
   1. ce découpage sert a organiser et a décharger les routeur. il sert aussi a cloisonner les sous réseau. 

## 3\. Synthèse des commandes réseaux

1. Quelles sont les nouvelles commandes "réseaux" que vous avez utilisées dans ce TP ?
   1. host
   2. trie-DNS 