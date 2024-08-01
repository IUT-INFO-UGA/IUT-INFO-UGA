# TP06 : Machine virtuelle et analyse de trames

---

## 1\. Les machines virtuelles

### 1\.1 Introduction

Les TPs des prochaines séances nécessitent que vous disposiez de **droits d'administrateur** pour : 

- Installer des logiciels serveur.   
- Capturer et examiner des trames circulant sur le réseau. 

 Comme vous ne disposez pas de ces droits sur les postes Linux, on va installer des **machines virtuelles Linux** sur lesquelles vous posséderez ces droits d'administrateur. Chaque machine virtuelle s'exécutera donc comme un processus sur une machine physique (votre poste Linux). Les machines virtuelles auront accès au réseau réel de façon transparente à travers le poste Linux. 

De nombreux hyperviseurs permettent d'exécuter des machines virtuelles sur un système réel.  Nous utiliserons Qemu/KVM.  

Les machines virtuelles que vous allez installer ont besoin d'un disque virtuel qui se présente sous la forme d'un fichier de grande taille (plusieurs Go).  Il est donc trop gros par rapport au quota disque qui vous est alloué. Ce fichier est donc placé sur un autre système de stockage et n'est **pas sauvegardé**.  Attention, donc, car toute fausse manipulation sera irréversible ! 

### 1\.2 Prise en main de votre machine virtuelle

On fournit le script R2.04-lance-machine-virtuelle qui lance la machine virtuelle. Une fois la VM lancée, il est conseillé de ne pas essayer de redimensionner sa fenêtre. Elle prendra toute seule une taille plus confortable quand vous aurez lancé un environnement graphique à l'intérieur.  
Les comptes créés dans la machine virtuelle sont :

|                          | Login | Mot de passe              |
|--------------------------|-------|---------------------------|
| Compte utilisateur       | `etu`   | `etu`                       |
| Compte super-utilisateur | `root`  | —<br />(utiliser sudo -i) |

Travail à réaliser :

- Lancer votre machine virtuelle (et ne pas redimensionner la fenêtre).
- Se logger avec le compte "`etu`".
- Ouvrir un terminal.
- Pour obtenir un *shell* root, y taper la commande suivante :\*

  ```
  sudo -i
  ```

   puis le mot de passe de "`etu`".
- Pour s'entraîner à le faire systématiquement, éteindre votre machine virtuelle en cliquant sur "`etu`" en haut à droite, puis sur "*Shut Down*".

### 1\.3 Paramètres réseau de votre machine virtuelle

Cette partie est à réaliser dans votre machine virtuelle. 

1. Utiliser la commande ip addr pour afficher les paramètres réseau de votre VM et remplir les 4 premières lignes du tableau suivant.
2. Utiliser la commande ip route, qui affiche la table de routage d'une machine, pour remplir la dernière ligne du tableau.

   | Nom de l'interface réseau        |                   |
   |----------------------------------|-------------------|
   | Adresse MAC                      | 25:54:00:12:34:56 |
   | Adresse IP                       | 10\.0.2.15         |
   | Masque de réseau                 | 255\.255.255.0     |
   | Adresse IP du routeur par défaut | 10\.0.2.2          |

## 2\. Capture et analyse de trames

outes les opérations suivantes sont à faire dans votre machine virtuelle. 

1. Dans un *shell* **root**, lancer le logiciel wireshark (ne pas tenir compte de l'avertissement de Wireshark).
2. Dans Wireshark, visualiser la liste des interfaces réseau de la VM.
3. Trouver l'interface réseau qui permettra de faire une capture sur le réseau Ethernet virtuel de la VM.
4. Lancer une capture de trames sur l'interface réseau choisie.
5. Pendant que la capture tourne, faire un "ping" vers le routeur par défaut de la machine virtuelle, puis arrêter la capture. NB: les "ping" vers des machines externes ne fonctionnent pas car l'émission de paquets ICMP est interdite par l'OS de la station Linux pour le processus non privilégié Qemu dans lequel tourne votre VM.
6. Parmi des trames capturées, repérer celles qui correspondent au ping (protocole ICMP). On doit trouver une requête ICMP et une réponse ICMP.
7. Noter les noms des protocoles utilisés, tels que `wireshark` les a identifiés par le décodage des données encapsulées dans les trames (cf. cours) :

   | Niveau interface (liaison/physique) | Ethernet |
   |-------------------------------------|----------|
   | Niveau réseau                       | IP       |
   | Niveau réseau                       | ICMP     |
8. Pour les 2 trames repérées, relever les informations suivantes dans les en-têtes Ethernet et IP :

   |                                                                     | Trame 1             | Trame 2           |
   |---------------------------------------------------------------------|---------------------|-------------------|
   | Longueur de la trame                                                | 98                  | 98                |
   | Adresse Ethernet source                                             | 52:55:0a:00:02:02   | 52:54:00:12:34:56 |
   | Adresse Ethernet destination                                        | 52:54:00:12:34:56   | 52:55:0a:00:02:02 |
   | Protocole encapsulé dans la trame ("Type")                          | IPV4                | IPV4              |
   | Version de IP                                                       | 4                   | 4                 |
   | Longueur de l'en-tête IP                                            | 20                  | 20                |
   | Taille totale du paquet IP                                          | 84                  | 84                |
   | Protocole encapsulé dans le paquet IP ("Protocol")                  | ICMP                | ICMP              |
   | Adresse IP source                                                   | 10\.0.2.15           | 10\.0.2.2          |
   | Adresse IP destination                                              | 10\.0.2.2            | 10\.0.2.15         |
   | Longueur du paquet ICMP                                             | 64                  | 64                |
   | Interprétation du paquet donnée par wireshark<br />(colonne "Info") | echo (ping) request | echo (ping) reply |
