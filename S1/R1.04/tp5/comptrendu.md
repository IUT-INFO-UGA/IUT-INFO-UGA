#  TP5 : Permissions Unix, Scripts shell, Liens symboliques

## Droits d'accès aux fichiers

2. ```shell
   xxxxxxx@pc-dg-025-01 ~/Public> nano test
   ```

3. ```shell
   xxxxxxx@pc-dg-025-01 ~> chmod g+rx ~ Public/
   xxxxxxx@pc-dg-025-01 ~> ll | grep Pu
   d-wxr-x--x 2 xxxxxxx infobut1 4,0K 11 oct.  10:16 Publi
   ```

4. ```shell
   xxxxxxx@pc-dg-025-01 ~/Public> chmod g+r test
   xxxxxxx@pc-dg-025-01 ~/Public> ll | grep test
   -rw-r--r-- 1 xxxxxxx infobut1  15 11 oct.  10:16 test
   ```

6. ```shell
   xxxxxxx@pc-dg-025-01 ~/Public> cp /users/info/pub/1a/R1.04/tp-permissions/exemple-script .
   ```

7. ```shell
   xxxxxxx@pc-dg-025-01 ~/Public> chmod 750 exemple-script
   xxxxxxx@pc-dg-025-01 ~/Public> ll | grep exemple-script 
   -rwxr-x--- 1 xxxxxxx infobut1 199 11 oct.  10:49 exemple-script
   xxxxxxx@pc-dg-025-01 ~/Public> ./exemple-script toto
   Bonjour,
   Je suis le script ./exemple-script
   Mon propriétaire est : xxxxxxx
   Je suis exécuté par : xxxxxxx
   Le paramètre qui m'a été transmis est : toto
   
   ```

8. ```shell
   xxxxxxx@pc-dg-025-01 /u/i/e/m/P/tp-permissions> ./exemple-script toto
   Bonjour,
   Je suis le script ./exemple-script
   Mon propriétaire est : michoull
   Je suis exécuté par : xxxxxxx
   Le paramètre qui m'a été transmis est : toto
   ```

## Scripts *shell*

### Variable d'environnement `PATH`

1. ```shell
   xxxxxxx@pc-dg-025-01 ~/Public> echo "$PATH" 
   /users/info/etu-1a/xxxxxxx/.local/bin:/usr/local/bin:/usr/bin:/bin:/usr/local/games:/usr/games:/users/info/pub/bin
   ```

2. dans cette variable il y a 7 répertoire, (7 double point)

3. ```shell
   pc-dg-025-01% PATH=toto
   ```

4. ```shell
   pc-dg-025-01% ls
   zsh: command not found: ls
   ```

   le message command not fond s’affiche car le terminal ne sait plus ou chercher

5. ```shell
   pc-dg-025-01% /bin/ls
   exemple-script  test
   ```

   on a exécuter le logiciel avec son chemin donc on a pu l'executé.

6. ```shell
   xxxxxxx@pc-dg-025-01 ~/Public> echo "$PATH"
   /users/info/etu-1a/xxxxxxx/.local/bin:/usr/local/bin:/usr/bin:/bin:/usr/local/games:/usr/games:/users/info/pub/bin
   
   ```

   PATH est revenu a son état original

7. ```shell
   xxxxxxx@pc-dg-025-01 ~/Public> ~/.local/bin/
   xxxxxxx@pc-dg-025-01 ~/.l/bin> ls
   f2py*  f2py3*  f2py3.11*
   ```

   ce répertoire existe déjà.

8. ```shell
   xxxxxxx@pc-dg-025-01 ~/.l/bin [2]> echo "$PATH"
   /users/info/etu-1a/xxxxxxx/.local/bin:/usr/local/bin:/usr/bin:/bin:/usr/local/games:/usr/games:/users/info/pub/bin
   ```

   le répertoir local/bin est encore la .

### Premier script

1. ```shell
   xxxxxxx@pc-dg-025-01 ~/.l/bin> nano essai-script
   ```

2. ```shell
   xxxxxxx@pc-dg-025-01 ~/.l/bin> chmod +x essai-script
   ```

3. ```shell
   xxxxxxx@pc-dg-025-01 ~/.l/bin> ./essai-script
   Ça marche !
   ```

### Script avec paramètre

1. ```shell
   xxxxxxx@pc-dg-025-01 ~/.l/bin> nano script-param
   ```

2. ```shell
   xxxxxxx@pc-dg-025-01 ~/.l/bin> chmod +x script-param
   xxxxxxx@pc-dg-025-01 ~/.l/bin> ./script-param toto
   La valeur du paramètre est : toto
   ```

### Script d'archivage simple

1. ```sh
   #!/bin/sh
   placment="/tmp"
   tar --xz -cvf "$placment"/test.tar.gz /users/info/etu-1a/xxxxxxx/Documents/IUT-INFO-UGA/R1.01/
   ```

### Script d'archivage avec paramètre

