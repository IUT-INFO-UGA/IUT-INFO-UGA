# Introduction aux réseaux de l'IUT2

## 1\. Découverte des réseaux de l'IUT2 (site Doyen Gosse)

Le schéma du TP01 donne une vue partielle des réseaux (utilisés par le département informatique) du site Doyen Gosse (les locaux où nous sommes) et de la connexion vers l'extérieur (Internet).

On distingue sur ce schéma les 3 réseaux principaux :

- Le réseau **DG-TX** (DG : Doyen Gosse TX : postes de travail   Linux, en rouge) comprend les stations Linux des salles de TP, les machines   (on dit aussi serveurs) `epperly4` et `erebus4`, des   commutateurs.  
      **Remarque:** votre répertoire personnel est physiquement sur un   disque de la machine `erebus4` et le serveur   `epperly4` sert au clonage des stations Linux.    
- Le réseau **INFOMM** (INFO : Informatique MM : MultiMédia,   en vert) comprend entre  autres les postes de travail (Linux, Windows, Mac)   des personnels enseignants et administratifs du département   informatique.    
- Le réseau **CI** (CI : Centre Informatique, en bleu) comprend   en particulier la machine  `meije`, qui sert de **serveur   DNS** primaire (Domain Name Service), ainsi que d'autres  équipements   (serveurs Windows, imprimantes,...) non représentés sur la figure. 

Un autre réseau, le réseau **DMZ** est "isolé" du reste des réseaux. On y trouve des machines qui peuvent potentiellement poser des problèmes de sécurité pour les machines des réseaux internes.

On notera que les autres réseaux du site Doyen Gosse ne sont pas représentés (en particulier les réseaux pédagogiques des machines sous Windows). Il en est de même pour les réseaux des autres sites de l'IUT2 (autres départements situés Place de Verdun, à Vienne et sur le campus). Toutes les machines de ces réseaux font partie du même **domaine DNS** : le domaine `iut2.univ-grenoble-alpes.fr`. Ce domaine est lui-même un sous-domaine du domaine `univ-grenoble-alpes.fr` (organisation hiérarchique des noms de domaines DNS). Notons qu'en interne à l'IUT2, l'ancien nom de domaine `iut2.upmf-grenoble.fr` est encore utilisé.

Enfin, on remarquera la présence d'une machine spécifique (routeur dédié à la sécurité) entre Internet et les réseaux de l'IUT2. Cette machine est un routeur/pare-feu (*firewall*) d'entrée de site dont le rôle est d'assurer la sécurité des machines internes en filtrant les entrées et en contrôlant les sorties.

Récapitulatif à remplir :

- Nom actuel du domaine DNS de l'IUT2 : `iut2.univ-grenoble-alpes.fr`
- Ancien nom du domaine DNS de l'IUT2 : `iut2.upmf-grenoble.fr`
- Nombre et types des nœuds (commutateurs ou routeurs) du réseau `DG-TX` : un routeur central plus un routeur par salle.
- Nombre et types des nœuds (commutateurs ou routeurs) du réseau `INFOMM` : 4
- Rôle de la machine `meije` : serveur dns
- Rôle de la machine `epperly4` : le serveur `epperly4` sert au clonage des stations Linux
- Rôle de la machine `erebus4` : sert a conserver les fichier.

## 2\. Cartes de réseaux

Nous allons maintenant voir comment l'IUT2 est relié à Internet, ce qui vous a déjà été introduit dans la ressource R1.04. Pour cela, consulter le [site de Renater](https://www.renater.fr/). 

À partir du menu, consulter la page "Réseau - Le réseau Renater".

1. Que désigne-t-on par NR (Nœud Renater), aussi appelé "point de présence" ?
   1. c'est un routeur Renater
2. Combien y a-t-il de NRs en France ?
   1. \+- 36
3. Quel est le débit de base entre les NRs ?
   1. 10gb
4. Par quelles villes Renater est-il relié au reste d'Internet ?
   1. les est relier a internet par Marseille (170gb) et paris 60gb

À partir du menu, consulter la page "Réseau - Le réseau Renater - Disponibilité du Réseau - Métropole"

1. Préciser les liaisons internationales (régions du monde, débits) :
   1. quatre lien avec Reneater Géant
   2. deux liaison internet
   3. une liaison restena
2. Y a-t-il des liaisons indisponibles ?
   1. non
3. Quelles sont les liaisons avec le plus grand débit ?
   1. celle qui part vers Geant
4. Quelles sont les liaisons les plus chargées ?
   1. aucune
5. Combien de pays européens participent au réseau Géant ?
   1. 34
6. Lister les pays auxquels la France est rattachée par le réseau Géant.
   1. 4

   ## 3\. Observation du routage

Le logiciel `traceroute` permet de découvrir le chemin entre deux machines sur Internet, en affichant la liste des routeurs traversés. Il envoie des paquets avec une durée de vie limitée pour forcer les routeurs à révéler leur présence. Pour chaque routeur, 3 paquets de tests sont envoyés et les temps d'aller retour sont affichés. Lorsqu’il ne parvient pas à déterminer l’adresse IP d’un routeur, traceroute affiche à la place une étoile (\*). 

Utiliser la commande traceroute NOM_MACHINE ou traceroute -I NOM_MACHINE (selon les cas, c'est l'une ou l'autre qui donne les meilleurs résultats) pour les serveurs suivants.  Parfois il est nécessaire d'exécuter la commande 2 fois pour obtenir un résultat satisfaisant.  

| Emplacement supposé du serveur | Nom du serveur       |
|--------------------------------|----------------------|
| Serveur situé en France        | `www.univ-lorraine.fr` |
| Serveur situé en Europe        | `www.uni-ulm.de`       |

1. Vérifier qu'un paquet sort du réseau des stations Linux toujours par le même routeur. Quel est le nom de ce routeur et quelle est son adresse IP ?
   1. nous sorton toujour par le gatway: 192.168.141.19
2. Vérifier qu'un paquet à destination de l'extérieur de l'IUT2 passe ensuite toujours par le même routeur. Quel est son nom ?
   1. rt-wan.iut2.upmf-grenoble.fr (193.55.51.1)
3. Puis, quel est le nom du routeur suivant ?
   1. r-viallet1.grenet.fr (193.54.184.185)
4. Repérer ces 3 routeurs sur le plan du réseau IUT2-DG du TP01.
5. Parmi les chemins affichés par traceroute, donner le nom d'un routeur du réseau Renater.
   1. hu0-2-0-2-ren-nr-grenoble-rtr-091.noc.renater.fr (193.51.181.94)
6. Pour aller de Grenoble à Nancy (Université de Lorraine), lister les villes traversées par les paquets IP.
   1. lyon
   2. paris
   3. remis
   4. nancy
7. Parmi les chemins affichés par traceroute, donner le nom d'un routeur du réseau Géant.
   1. renater.mx1.gen.ch.geant.net (62.40.124.61)
8. Pour aller de Grenoble à Ulm (Allemagne), par quel pays intermédiaire passent les paquets IP ?
   1. allemagne 

## 4\. Synthèse des commandes réseaux

1. Quelles sont les nouvelles commandes "réseaux" que vous avez utilisées dans ce TP ?
   1. traceroute