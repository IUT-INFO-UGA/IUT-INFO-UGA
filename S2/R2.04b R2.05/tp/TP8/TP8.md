# TP08 : Configuration IPv4 manuelle, IPv6

---

 Ce TP a pour objectif d'utiliser les commandes de base qui permettent de configurer les paramètres IP d'un système Linux.   
Pour réaliser ces configurations, utiliser un ***shell* root** de votre machine virtuelle comme indiqué dans le **TP06**. Consulter également le schéma du **TP07** pour comprendre les manipulations de ce TP et identifier les adresses utiles.

---

## 1\. Préparatifs : désactivation du client DHCP

Habituellement, votre machine virtuelle utilise un client DHCP pour obtenir ses paramètres IPv4. Comme nous voulons réaliser ces opérations à la main, nous allons temporairement désactiver le client DHCP dans la machine virtuelle.

1. D'après l'adresse IPv4 actuelle de votre machine virtuelle et son masque, écrire l'intervalle d'adresses de son réseau IP (utiliser ip addr) :

   192\.168.141.144/24: min 192.168.141.0 max 192.168.141.255
2. Noter l'adresse IP du routeur par défaut de votre machine virtuelle (cf. TP06 et TP07) :

   10\.0.2.15
3. Désactiver l'interface Ethernet de votre machine virtuelle :

   ```
   ifdown eth0
   ```
4. Vérifier que l'interface `eth0` est dans l'état DOWN et qu'il n'y a plus d'adresse IPv4 affectée à cette interface (utiliser ip addr).  
   vrais
5. Utiliser `ping` pour vérifier que le routeur par défaut de votre machine virtuelle n'est plus joignable.

   temporary failure in name resolution

## Adresse IP

Le logiciel ip, déjà utilisé précédemment pour consulter certaines informations, permet aussi de configurer les paramètres IP d'une machine. 

1. Choisir une adresse IP quelconque dans l'intervalle d'adresses du réseau IP de votre machine virtuelle (différente de l'adresse IP initiale et différente de celle du routeur par défaut) :
2. Configurer l'interface `eth0` pour utiliser cette adresse IP :

   ```
   ip addr add ADRESSE_IP/24 dev eth0
   ```
3. Activer l'interface `eth0` :

   ```
   ip link set eth0 up
   ```
4. Avec ip addr, vérifier que la nouvelle adresse IP est bien en place et que l'interface est bien active (UP).
5. Utiliser `ping` pour vérifier que le routeur par défaut de votre machine virtuelle est bien joignable.

## 3\. Routage IP

1. Utiliser `ssh` pour tester si d'autres réseaux sont joignables, par exemple : ssh 193.55.51.227.
2. Quel message d'erreur est affiché ?

   network is unrechable
3. Que contient la table de routage ?

   10\.0.2.0
4. Ajouter une route par défaut :

   ```
   ip route add default via ADRESSE_IP_DU_ROUTEUR
   ```
5. Que contient alors la table de routage ?

   la nouvelle ip
6. Tester de nouveau une connexion ssh pour vérifier que les autres réseaux sont accessibles, mais ne pas essayer de se loger sur la machine distante et faire Ctrl-c quand un mot de passe est demandé..

## 4\. DNS : Domain Name System (système de noms de domaine)

 Analyser le principe du service DNS, par exemple à partir de la page [Wikipédia](https://fr.wikipedia.org/wiki/Domain_Name_System). 

La configuration DNS d'une machine se trouve dans le fichier : 

```
/etc/resolv.conf
```

 1. Quelle est l'adresse IP du serveur DNS actuel de votre machine virtuelle ?

    10\.0.2.3
 2. Interroger le DNS :

    ```
    nslookup www-info.iut2.univ-grenoble-alpes.fr
    ```
 3. Vérifier que c'est bien le serveur DNS trouvé ci-dessus qui répond.

    oui
 4. Interroger le DNS avec le logiciel `host` que vous avez déjà utilisé :

    ```
    host www-info.iut2.univ-grenoble-alpes.fr
    ```
 5. Comparer les informations obtenues avec les 2 logiciels `nslookup` et `host` :

    elle sont ressemblante 
 6. Quelle est l'adresse IP du serveur DNS de votre poste Linux ?

    127\.0.0.53 et 193.55.51.34
 7. Modifier la configuration DNS de votre machine virtuelle (utiliser l'éditeur de texte mousepad depuis un ***shell* root**) pour utiliser le même serveur DNS que les stations Linux.
 8. Refaire la même requête DNS que précédemment. Quelle est l'adresse IP du serveur DNS qui répond ?

    193\.55.51.34
 9. S'inspirer de la configuration DNS d'une station Linux pour faire en sorte que votre machine virtuelle puisse utiliser des noms de machines abrégés pour le domaine `iut2.univ-grenoble-alpes.fr`. Ne pas recopier telle quelle la configuration de votre staion Linux car elle utilise encore le nom de domaine `iut2.upmf-grenoble.fr`.
10. Tester en exécutant la requête DNS avec nom abrégé :

    ```
    nslookup www-info
    ```
11. Quelle réponse obtient-on :  
    Non-authoritative answer:   
    Name:   www-info.iut2.upmf-grenoble.fr   
    Address: 195.221.57.37

## 5\. IPv6

### 5\.1 ICMPv6 sur stations physiques

Chaque station Linux dispose de 2 adresses IPv6 : 

- une adresse commençant par `fe80`, qui est générée     automatiquement par Linux à partir de l'adresse MAC de la station, et qui     ne peut servir qu'à joindre des machines du même réseau local (`scope     local`)    
- une adresse commençant par `fd00`, qui pourrait permettre de     joindre des machines sur d'autres réseaux (`scope global`), si     les routeurs de l'IUT2 étaient configurés pour cela.  Comme ce n'est pas le     cas, dans ce TP, on se contentera du réseau des stations Linux. 

 

1. Avec la commande ip addr, visualiser et noter les 2 adresses IPv6 de votre poste Linux :

   fe80::e654:e8ff:fe59:6114/64  
   fd00::2889/64
2. Pinger une machine voisine grâce à son adresse `fe80:...`
3. Pinger une machine voisine grâce à son adresse `fd00:...`
4. Visualiser le cache ARP de votre station. Quelles adresses IPv6 y sont apparues ?

   aucune
5. Quel protocole a été utilisé pour les découvrir ?

### 5\.2 SSH sur IPv6

1. Utiliser ssh pour se connecter à une station Linux voisine grâce à son adresse `fd00:...`
2. Utiliser le logiciel who pour visualiser votre connexion et son origine.

   :0 
3. Quelle adresse IP est affichée par who ? Est-ce une adresse IPv4 ou IPv6 ?

   sans doute une ipv6

    

### 5\.3 Capture de ICMPv6 sur machines virtuelles

- Dans votre machine virtuelle, lancer un `ping` vers sa propre adresse IPv6 qui commence par `fec0`.
- Capturer les paquets ICMPv6 avec `wireshark`, en utilisant l'interface réseau "any".
- Noter les noms des protocoles utilisés, tels que `wireshark` les a identifiés par le décodage des données encapsulées dans les trames :

  | Niveau interface        | Linux cooked capture |
  |-------------------------|----------------------|
  | Niveau réseau (premier) |                      |
  | Niveau réseau (second)  |                      |
