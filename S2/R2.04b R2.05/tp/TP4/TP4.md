# TP04 : Paramètres IP et protocole ARP

---

## 1\. Paramètres IP d'une machine

Contrairement à l'adresse Ethernet qui est fixée par le fabricant de la carte réseau, l'adresse IP d'une machine est attribuée par l'administrateur du réseau. Cela est fait soit *manuellement* (adresse inscrite dans un fichier de configuration), soit *automatiquement* (grâce en général au protocole DHCP que nous verrons plus tard). 

La commande ip addr affiche les paramètres réseau d'une machine sous Linux.  

Utiliser cette commande pour remplir le tableau ci-dessous en suivant ces indications :  

- pour la ligne `erebus4` utiliser les données du TP01    
- pour la ligne `transit`, faire une connexion SSH vers cette machine    
- pour la colonne "Adresse du réseau", les valeurs ne sont pas affichées     par `ip addr`, c'est à vous de les calculer en vous aidant de ce que     vous avez vu en cours. 

  |                                               | Adresse IPv4 de l'interface | Masque de réseau | Adresse du réseau en notation CIDR | Adresse privée ou publique ? | Adresse de diffusion du réseau (*broadcast*) |
  |-----------------------------------------------|-----------------------------|------------------|------------------------------------|------------------------------|--------------------------------------------|
  | interface Ethernet de votre poste Linux       | 192\.168.141.132             | 255\.255.255.0    | 192\.168.141.132/24                 | privé                        | 192\.168.141.255                            |
  | interface Ethernet de erebus4                 | 
  192\.168.141.8              | 255\.255.255.0    |  192\.168.141.8/24                  | privé                        |                                            |
  | interface Ethernet de transit                 | 193\.55.51.227               | 255\.255.255.258  | 193\.55.51.227/29                   | public                       |                                            |
  | interface `lo`<br />(*loopback*) des postes Linux | 127\.0.0.1                   | 255\.0.0.0        | 1277\.0.0.1/8                       | privé                        |                                            |

## 2\. Lien entre Ethernet et IP : le protocole ARP

ARP *(Address Resolution Protocol)* permet à une machine de déterminer l'adresse physique d'une autre machine connaisant son adresse IP et ainsi mettre à jour son **cache ARP**, c'est-à-dire sa table de correspondance adresse physique/adresse IP. 

Ainsi, si une machine émettrice, connaissant l'adresse IP du destinataire, cherche à obtenir son adresse physique parce qu'elle n'en dispose pas dans son cache ARP, elle émet un *broadcast* Ethernet sur le réseau local qui va être reçu par toutes les machines **du même réseau Ethernet**.  

### 2\.1 Cache ARP

 Les questions ci-dessous permettent d'observer et de comprendre le contenu du cache ARP de votre poste Linux. Nous verrons dans la section suivante en détail le fonctionnement de ce protocole grâce à l'analyse d'une capture de trames. 

la commande ip neigh permet d'afficher le cache ARP d'un poste Linux. 

1. Quelles sont les machines répertoriées dans le cache ?
   1. 192\.168.141.19 dev eth0 lladdr a0:f8:49:92:d5:66 REACHABLE  
   2. 192\.168.141.8 dev eth0 lladdr b4:96:91:2a:18:06 REACHABLE  
   3. 192\.168.141.9 dev eth0 lladdr b4:96:91:2a:18:0a STALE
2. Choisir le nom d'une autre station que la vôtre dans la même salle. L'adresse Ethernet de cette machine est-elle dans le cache ARP de votre poste Linux ? Réaliser un échange avec cette machine en utilisant la commande ping NOM_DE_STATION, puis consulter de nouveau le cache ARP. Expliquer ce qui s'est passé.
   1. le pig a ajouter l'ip de la station dans le cache
3. L'adresse Ethernet de la machine `transit` est-elle dans le cache ARP de votre poste Linux ? Réaliser un échange avec cette machine en faisant ping transit, puis consulter de nouveau le cache ARP. L'adresse Ethernet de `transit` est-elle dans le cache ARP ? Expliquer.
   1. non car transit n'est pas dans le même lan que transit

### 2\.2 Échange ARP

On vous founit dans ce [fichier de capture de trames](https://www-info.iut2.univ-grenoble-alpes.fr/intranet/enseignements/reseaux1A/tp/capture-ARP.pcapng) la capture d'un échange de trames ARP entre 2 stations Linux. Cette capture a été obtenue lors d'un ping entre 2 machines qui n'ont jamais échangé de paquets IP entre elles. Grâce au logiciel wireshark, on vous demande d'analyser ces trames, et de remplir le tableau suivant :

|                                                                                             | Trame 1               | Trame 2           |
|---------------------------------------------------------------------------------------------|-----------------------|-------------------|
| Adresse Ethernet source                                                                     | B8:CA:3A:77:50:C2     | B8:CA:3A:77:54:01 |
| Adresse Ethernet destination                                                                | FF:FF:FF:FF:FF:FF     | B8:CA:3A:77:50:C2 |
| Adresse IP de la machine qui fait la requête (donnée dans les paramètres de la requête ARP) | 192\.168.141.201       | 192\.168.141.202   |
| Adresse IP cible (donnée dans les paramètres de la requête ARP)                             | 192\.168.141.202       | 192\.168.141.201   |
| Interprétation de cette trame donnée par `wireshark` (champ `info` de la capture)               | commande who          | commande is       |
| Interprétation que vous pouvez faire de cette trame                                         | demande de qui est IP | eth répond        |

## 3\. Synthèse des commandes réseaux

1. Quelles sont les nouvelles commandes "réseaux" que vous avez utilisées dans ce TP ?
   1. ip niegh
   2. ip addr