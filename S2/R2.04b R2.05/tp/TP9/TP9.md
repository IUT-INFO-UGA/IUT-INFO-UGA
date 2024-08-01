# TP09 : Analyse des trames d'un échange TCP

---

L'objectif du TP est de comprendre les principes TCP à l'aide de captures de trames faites depuis votre machine virtuelle. 

---

 

## 1\. Introduction

Comme cela a été étudié en cours, l'architecture TCP/IP regroupe un ensemble de protocoles organisé en 4 niveaux. Quelques protocoles "classiques" sont présentés dans la figure de ce transparent, mais il en existe bien d'autres. 

Nous avons en particulier observé, lors des TP précédents, le fonctionnement des protocoles ARP et ICMP (niveau réseau) ainsi que ceux des protocoles DHCP et HTTP (niveau application). Dans ce TP, nous allons analyser les échanges de niveau transport (TCP) qui sont nécessaires pour transmettre les requêtes et réponses du protocole HTTP entre un client Web (navigateur firefox) et un serveur web.  

## 2\. Capture des trames

1. Lancer votre **machine virtuelle** et sur cette machine lancer firefox (cliquer sur l'icône).
2. Lancer wireshark depuis un ***shell* root**.
3. Lancer une capture sur l'interface Ethernet (sélectionner l'interface `eth0`).
4. Vider le cache du navigateur et charger cette page Web : `http://transit.iut2.univ-grenoble-alpes.fr/index-old.html`
5. Fermer le navigateur.
6. Arrêter la capture.
7. Observer l'affichage dans wireshark et en particulier les colonnes d'adresse IP : repérer les trames émises et reçues par le serveur `transit` (retrouver si besoin dans le TP07 son adresse IP) et donc celles qui ont transporté la connexion TCP et la requête HTTP.
8. Isoler dans wireshark les trames de cette connexion TCP : sélectionner une trame de ce flux TCP et cliquer sur *Follow TCP stream* dans le menu *Analyze*).

## 3\. Analyse de la capture

1. Remplir le tableau suivant pour la 2ème trame, c'est-à-dire celle qui contient le 2ème paquet IP qui lui-même contient la réponse TCP envoyée par le serveur lors de l'ouverture de cette connexion TCP (segment TCP avec les flags \[SYN, ACK\]) :

|             | Adresse Ethernet  | Adresse IP    |
|-------------|-------------------|---------------|
| Source      | 52:54:00:12:34:56 | 10\.0.2.15     |
| Destination | 52:54:00:12:34:56 | 193\.55.51.227 |

1. À quelle machine appartient l'adresse IP source ? (se reporter au schéma fait dans un TP précédent avec les adresses IP et MAC de toutes les machines)
   1. l'ip appartient au serveur de vm.
2. À quelle machine appartient l'adresse Ethernet source ?
   1. l'adresse mac appartient a la machine virtuel.
3. Expliquer pourquoi ce n'est pas la même machine.
   1. l'adresse mac change pour chaque machine même virtuelle, alors que l'ip peut être la même pour toute les machine virtuelle
4. Dans la capture, repérer les 10 ou 11 trames "utiles" de l'échange HTTP. Wireshark peut avoir capturé des trames superflues (trames doubles ou dupliquées). Ignorer ces trames. Garder les trames suivantes:
   - les 7 premières trames de la connexion : ouverture et 2 premiers 	échanges, acquittements compris.  Ignorer les trames en rapport avec 	favicon.ico.       
   - les 3 ou 4 trames à partir du premier *flag* FIN     
5. Remplir **ligne par ligne** le tableau suivant grâce au décodage des champs TCP fait par `wireshark`.

Attention, `wireshark` n'utilise pas les mêmes notations que       le cours pour désigner les champs de l'en-tête TCP.  Quelques explications       sont données ci-dessous :

- Etape de la connexion : Ouverture (O), Échange (E) ou Fermeture (F).     
- N° de trame ou de paquet : ce sont les numéros de wireshark.  Vérifier       que les numéros sont dans l'ordre croissant.     
- Sens de parcours du paquet : Client → Serveur (C→S) ou Serveur → Client (C←S)     
- Port source et port destination : **ne remplir que les 3 premières lignes de ces colonnes**.
- Flags TCP : ils sont contenus dans le champ contrôle de TCP, noter ceux qui sont activiés (à 1)     
- Taille des données contenues dans le segment TCP : notée "Len"     
- Numéro de séquence : noté "Seq" (correspond à Sn dans le cours)     
- Numéro d'acquittement : noté "Ack" (correspond à An dans le cours)


- 

  | N° de trame | Sens de parcours  
  (C→S ou C←S)      | Port  
  src.      | Port  
  dest.      | Flags TCP | Étape (O/E/F) | Taille des données contenues dans le segment TCP | N° de séquence | N° d'acquittement |
  |-------------|------------------------------------|----------------|-----------------|-----------|---------------|--------------------------------------------------|----------------|-------------------|
  | 6           | c→s                                | 46894          | 80              | SYN       | o             | 0                                                | 0              | 0                 |
  | 8           | s→c                                | 80             | 46894           | syn ack   | o             | 0                                                | 0              | 1                 |
  | 9           | c→s                                | 46894          | 80              | ack       | o             | 0                                                | 1              | 1                 |
  | 10          | c→s                                | 46894          | 80              |           | e             | 463                                              | 1              | 1                 |
  | 11          | s→c                                | 80             | 46894           | ack       | e             | 0                                                | 1              | 464               |
  | 12          | s→c                                | 80             | 46894           |           | e             | 497                                              | 1              | 464               |
  | 13          | c→s                                |                |                 | ack       | e             | 0                                                | 464            | 498               |
  | 14          | c→s                                |                |                 | fin ack   | f             | 0                                                | 464            | 498               |
  | 15          | s→c                                |                |                 | ack       | f             | 0                                                | 498            | 465               |
  | 16          | s→c                                |                |                 | fin ack   | f             | 0                                                | 498            | 465               |
  | 17          | s→c                                |                |                 | ack       | f             | 0                                                | 465            | 499               |

1. Quel est le numéro de la trame qui contient la requête GET ?
   1. 10
2. Quel est le numéro de la trame qui contient le segment TCP qui acquitte le segment TCP contenant la requête GET ?  
   11
3. Écrire la relation qui relie un numéro de séquence, une longueur de segment TCP et un numéro d'acquittement (dans les segments TCP examinés dans les 2 questions précédentes) qui montre que la requête HTTP du client a bien été acquittée par le serveur.
   1. 463
4. Même question pour la réponse HTTP.
   1. 497
5. Représenter sur le schéma ci-dessous les échanges **au niveau TCP** (diagramme d'échanges tels que ceux vus en cours et TD, en notant pour chaque segment TCP : les flags, les indices Sn et An ainsi que le volume de données).
6. Représenter à côté le diagramme d'échange des messages entre client et serveur **au niveau application (HTTP)**. Placer les requêtes/réponses HTTP en face des segments TCP qui les contiennent.

![TCP+appli.svg](.attachments.203414/TCP%2Bappli.svg)