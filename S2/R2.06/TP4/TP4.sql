/*=======================================*/
/* NOM Prénom - TP04 : Triggers sur vues */
/*=======================================*/

/*==========================*/
/* Ex. 1 : Vues modifiables */
/*==========================*/
/***********************************************************/
/* 1  Considérons tout d'abord la vue mes_favoris. Tenter d'utiliser cette vue pour ajouter un nouveau personnage à vos favoris. Pourquoi l'insertion échoue-t-elle? */
/***********************************************************/

insert into mes_favoris values ('Thor');
-- c'est une vue et pas une table, donc pas de modification possible

/***********************************************************/
-- 2 Ajouter ce nouveau personnage favori directement dans la table favoris. Est-il visible par la vue mes_favoris?
/***********************************************************/

insert into favoris values (user,'Thor');
-- oui

/***********************************************************/
-- 3 Utiliser cette vue pour modifier ce personnage. Pourquoi cette mise-à-jour est-elle possible? Cela a-t-il changé un tuple dans la table d'origine favoris?
/***********************************************************/

update mes_favoris set perso='Thor';
-- pas posible car vue pas modifiable

/***********************************************************/
-- 4 Considérons à présent la vue meurt_dans. Cette vue a été créée pour remplacer la table de même nom initialement construite, afin de permettre à des applications tiers de continuer à s'exécuter. Il convient de terminer ce travail en traduisant, dans la nouvelle configuration de la base, l'effet d'opérations sur meurt_dans. Commençons par identifier quelles opérations nécessitent un trigger. Supprimer, par un DELETE sur cette vue, les deux enregistrements correspondant aux morts du Soldat de l'hiver dans le film 5 et de Nick Fury dans le film 9. En quoi cela ne convient-il pas?
/***********************************************************/
