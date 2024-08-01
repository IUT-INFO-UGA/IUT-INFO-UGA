# TP6 Bilan et rattrapage, Compléments, Applications réseau

## 3 - Compléments sur le logiciel `grep`

1. ```shell
   xxxxxxx@pc-dg-035-03 ~/D/R/TP6> grep père Avare.txt 
   HARPAGON, père de Cléante et d'Elise, et amoureux de Mariane.
   ANSELME, père de Valère et de Mariane.
   ELISE.-- Hélas! cent choses à la fois : l'emportement d'un père, les
   pour me voir, à vous revêtir de l'emploi de domestique de mon père.
   scrupules que vous avez, votre père lui-même ne prend que trop de soin
   dire de bien. Mais enfin, si je puis, comme je l'espère, retrouver mes
   à vous bien mettre dans l'esprit de mon père.
   VALERE.-- On ne peut pas ménager l'un et l'autre ; et l'esprit du père
   je dépends d'un père, et que le nom de fils me soumet à ses volontés ;
   quel déplaisir ce m'est de voir que par l'avarice d'un père je sois
   Enfin j'ai voulu vous parler pour m'aider à sonder mon père sur les
   sont semblables aux miennes, et qu'il faille que notre père s'oppose à
   
   ```

2. ```shell
   xxxxxxx@pc-dg-035-03 ~/D/R/TP6> grep père Avare.txt | wc -l
   12
   ```

3. ```shell
   xxxxxxx@pc-dg-035-03 ~/D/R/TP6> grep -r  "public class" ../../IUT-INFO-UGA/R1.01/
   ../../IUT-INFO-UGA/R1.01/TP5/src/ReleveMensuel.java:public class ReleveMensuel {
   ../../IUT-INFO-UGA/R1.01/TP5/src/Pollution.java:public class Pollution {
   ../../IUT-INFO-UGA/R1.01/TP5/src/VecteursDeInteger.java:public class VecteursDeInteger {
   ../../IUT-INFO-UGA/R1.01/TP5/src/Utilitaire.java:public class Utilitaire {
   [...]
   ```

4. j'ai ecrit 61 classe java:

   ```shell
   xxxxxxx@pc-dg-035-03 ~/D/R/TP6 [SIGPIPE|1]> grep -r  "public class" ../../IUT-INFO-UGA/R1.01/ | wc -l
   61
   ```

5. les fichier qui contienne  `ArrayList` sont:
   ```shell
   xxxxxxx@pc-dg-035-03 ~/D/R/TP6> grep -r  "ArrayList" ../../IUT-INFO-UGA/R1.01/
   grep: ../../IUT-INFO-UGA/R1.01/TP5/out/production/TP5/VecteursDeString.class: binary file matches
   grep: ../../IUT-INFO-UGA/R1.01/TP5/out/production/TP5/VecteursDeInteger.class: binary file matches
   grep: ../../IUT-INFO-UGA/R1.01/TP5/out/production/TP5/Utilitaire.class: binary file matches
   grep: ../../IUT-INFO-UGA/R1.01/TP5/out/production/TP5/Pollution.class: binary file matches
   ../../IUT-INFO-UGA/R1.01/TP5/src/Pollution.java:import java.util.ArrayList;
   ../../IUT-INFO-UGA/R1.01/TP5/src/Pollution.java:                final ArrayList<String> semestre1 = new ArrayList<String >(Arrays.asList("janvier", "fevrié"," mars"," avril"," mai"," juin"));
   [...]
   ```

   

## 4 - Compléments sur les *wildcards*

1. ficher alias s’appel: [.bash_aliases](../../../.bash_aliases) 

## 5 - Impressions

### 5.3 - Logiciels de KDE

2. le logicielle se trouve a cette emplacement:

```shell
xxxxxxx@pc-dg-035-03 ~/D/R/TP6> ulocate unixtd3.pdf
/users/info/pub/1a/R1.04/tp-impression/unixtd3.pdf
```

## 6 - Utilisation de machines en réseau

1. la commande rwho donne:
   ```shell
   xxxxxxx@pc-dg-035-03:~$ rwho
   adame    pc-dg-035-08:pts/0  Oct 18 10:01 :49
   adame    pc-dg-035-08:pts/1  Oct 18 10:01 :49
   adame    pc-dg-035-08:pts/2  Oct 18 10:01 :49
   adame    pc-dg-035-08:pts/3  Oct 18 10:01 :49
   adame    pc-dg-035-08:pts/4  Oct 18 10:46 :03
   [...]
   ```

2. la commande ruptime donne:
   ```shell
   xxxxxxx@pc-dg-035-03 ~/D/R/TP6> ruptime
   epperly4      up   14+13:07,     0 users,  load 0.00, 0.00, 0.00
   erebus4       up    4+12:37,     0 users,  load 0.14, 0.09, 0.06
   pc-dg-025-01  up       2:19,     5 users,  load 0.83, 0.75, 0.76
   pc-dg-025-02  up       2:58,     2 users,  load 0.94, 0.66, 0.64
   pc-dg-025-03  up       2:58,     5 users,  load 0.62, 0.51, 0.59
   [...]
   ```

3. il y a 87 station linux:
   ```shell
   xxxxxxx@pc-dg-035-03 ~/D/R/TP6> ruptime | grep "pc-dg-" | wc -l
   87
   ```

### 6.2 Utilisation de machines à distance

2. ```shell
   xxxxxxx@pc-dg-035-03 ~/D/R/TP6 [SIGINT]> ssh -X pc-dg-035-04
   The authenticity of host 'pc-dg-035-04 (192.168.141.164)' can't be established.
   ED25519 key fingerprint is SHA256:mszYzrQYKBMRSwOtRP+1Casg2a27jof66ygdio1p7qw.
   This key is not known by any other names.
   Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
   Warning: Permanently added 'pc-dg-035-04' (ED25519) to the list of known hosts.
   xxxxxxx@pc-dg-035-04's password: 
   Linux pc-dg-035-04 6.1.0-13-amd64 #1 SMP PREEMPT_DYNAMIC Debian 6.1.55-1 (2023-09-29) x86_64
   
   The programs included with the Debian GNU/Linux system are free software;
   the exact distribution terms for each program are described in the
   individual files in /usr/share/doc/*/copyright.
   
   Debian GNU/Linux comes with ABSOLUTELY NO WARRANTY, to the extent
   permitted by applicable law.
   xxxxxxx@pc-dg-035-04:~$ 
   
   ```

3. il y a bien moi et mon voisin:

```shell
xxxxxxx@pc-dg-035-04:~$ who
thuillim tty7         2023-10-18 09:59 (:0)
thuillim pts/0        2023-10-18 09:59 (:0)
thuillim pts/1        2023-10-18 10:01 (:0)
xxxxxxx pts/2        2023-10-18 10:59 (192.168.141.163)
```

5. le logicielle ce lance chez moi depuis chez mon voisin (titre de la fenêtre).

6. le logicielle est plutôt rapide.

7. le ogiciel Kcalc ne tourne pas chez moi:
   ```shell
   xxxxxxx@pc-dg-035-03:~/Documents/R1.04/TP6$ ps aux | grep calc
   xxxxxxx   71602  0.0  0.0   6412  2152 pts/2    S+   11:03   0:00 grep --color=auto calc
   ```

### 6.2 - Protocole VNC

2. 

```shell
xxxxxxx@pc-dg-035-04:~$ vncviewer pc-dg-035-04

TigerVNC Viewer 64-bit v1.12.0
Built on: 2023-01-06 16:01
Copyright (C) 1999-2021 TigerVNC Team and many others (see README.rst)
See https://www.tigervnc.org for information on TigerVNC.

Wed Oct 18 11:07:15 2023
 DecodeManager: Detected 6 CPU core(s)
 DecodeManager: Creating 4 decoder thread(s)
 CConn:       Connected to host pc-dg-035-04 port 5900
 CConnection: Server supports RFB protocol version 3.8
 CConnection: Using RFB protocol version 3.8
 CConnection: Choosing security type None(1)

Wed Oct 18 11:07:16 2023
 CConn:       Using pixel format depth 24 (32bpp) little-endian rgb888
 CConnection: Enabling continuous updates

```

3. nous arrivons sur un écran de connexion 
4. le logicielle est plutôt rapide.

### 6.3 - Transferts de fichiers Linux ↔ Windows depuis les stations Linux

1. copie dans tmp:
   ```shell
   xxxxxxx@pc-dg-035-03 ~/D/R/TP6> scp -p  /users/info/etu-1a/xxxxxxx/Documents/IUT-INFO-UGA/R1.01/tp6/src/Utilitaire.java /tmp/truc
   ```

3. copie dans l'ordinateur voisin:
   ```shell
   xxxxxxx@pc-dg-035-03 ~/D/R/TP6> scp -p  /users/info/etu-1a/xxxxxxx/Documents/IUT-INFO-UGA/R1.01/tp6/src/Utilitaire.java xxxxxxx@pc-dg-035-04:/tmp/truc
   xxxxxxx@pc-dg-035-04's password: 
   Utilitaire.java  
   ```