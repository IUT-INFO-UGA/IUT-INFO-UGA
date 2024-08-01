/* Sae S2.04, Exploitation d'une base de donnees -
Phase 1 : Exploration et Nettoyage des donnees */

   select count(code) from openfoodfacts where (countries='united-states' 
    or countries='United States' 
    or countries='%us%')
    and food_groups='en:one-dish-meals'
    and data_quality_errors_tags is null;

/* Creation d'une premiere table afin de recuperer uniquement les valeur pour le pays United-states*/

drop table if exists table1;
create temp table table1 as 
select code, url, product_name, brands_tags, stores, owner, food_groups, labels_tags, countries, countries_tags, quantity, fat_100g, saturated_fat_100g, sugars_100g, proteins_100g, carbohydrates_100g, energy_100g, salt_100g, sodium_100g, nutriscore_score, nutriscore_grade from openfoodfacts where (countries='united-states' 
    or countries='United States' 
    or countries='%us%')
    and food_groups='en:one-dish-meals';


/* On enleve toute les lignes qui sont comprise dans data_quality_errors_tags car elles ont des erreurs que l'on ne veut pas */
    drop table if exists table1;
create temp table table1 as 
select code, url, product_name, brands_tags, stores, owner, food_groups, labels_tags, countries, countries_tags, quantity, fat_100g, saturated_fat_100g, sugars_100g, proteins_100g, carbohydrates_100g, energy_100g, salt_100g, sodium_100g, nutriscore_score, nutriscore_grade from openfoodfacts where (countries='united-states' 
    or countries='United States' 
    or countries='%us%')
    and food_groups='en:one-dish-meals'
    and data_quality_errors_tags is null;



/* On enleve les lignes sans informations pour le nutriscore et celles qui n'ont pas le bon format de code */ 
drop table if exists table1;
create temp table table1 as 
select code, url, product_name, brands_tags, stores, owner, food_groups, labels_tags, countries, countries_tags, quantity, fat_100g, saturated_fat_100g, sugars_100g, proteins_100g, carbohydrates_100g, energy_100g, salt_100g, sodium_100g, nutriscore_score, nutriscore_grade from openfoodfacts 
where (countries='united-states' 
    or countries='United States' 
    or countries='%us%')
    and food_groups='en:one-dish-meals'
    and data_quality_errors_tags is null
    and (nutriscore_grade != 'unknown'
    or nutriscore_grade != ''
    or length(code) = 13);


/* on supprime aussi les lignes avec des valeurs nutritionelles aberantes */
drop table if exists table1;
create temp table table1 as 
select code, url, product_name, brands_tags, stores, owner, food_groups, labels_tags, countries, countries_tags, quantity, fat_100g, saturated_fat_100g, sugars_100g, proteins_100g, carbohydrates_100g, energy_100g, salt_100g, sodium_100g, nutriscore_score, nutriscore_grade from openfoodfacts where (countries='united-states' 
    or countries='United States' 
    or countries='%us%')
    and food_groups='en:one-dish-meals'
    and data_quality_errors_tags is null
    
    and fat_100g < 100
    and saturated_fat_100g < 100
    and sugars_100g < 100
    and proteins_100g < 100
    and carbohydrates_100g < 100
    and salt_100g < 100
    and sodium_100g < 100

    and fat_100g > 0
    and saturated_fat_100g > 0
    and sugars_100g > 0
    and proteins_100g > 0
    and carbohydrates_100g > 0
    and salt_100g > 0
    and sodium_100g > 0;
;



/* 
    1 gr de proteine apporte 4 kcal
    1 gr de glucide (carbohydrate) apporte 4 kcal
    1 gr de lipide apporte 9 kcal
    1 gr d'alcool apporte 7 kcal

    on ajoute une colonne pour le calcul des calories en Kcal sous le nom de computed_energy_100g
*/

drop table if exists table1;
create temp table table1 as 
select code, url, product_name, brands_tags, stores, owner, food_groups, labels_tags, countries, countries_tags, quantity, fat_100g, saturated_fat_100g, sugars_100g, proteins_100g, carbohydrates_100g, energy_100g, salt_100g, sodium_100g, nutriscore_score, nutriscore_grade,
((proteins_100g*4) + (sugars_100g*4) + (fat_100g)*9) as computed_energy_100g,
from openfoodfacts 
where (countries='united-states' 
    or countries='United States' 
    or countries='%us%')
    and food_groups='en:one-dish-meals'
    and data_quality_errors_tags is null
    
    and fat_100g < 100
    and saturated_fat_100g < 100
    and sugars_100g < 100
    and proteins_100g < 100
    and carbohydrates_100g < 100
    and salt_100g < 100
    and sodium_100g < 100

    and fat_100g > 0
    and saturated_fat_100g > 0
    and sugars_100g > 0
    and proteins_100g > 0
    and carbohydrates_100g > 0
    and salt_100g > 0
    and sodium_100g > 0;
;


/* Requete finale */

/* On supprime la table au cas ou elle existe */
DROP TABLE IF EXISTS table1;

/* On creer une table temporaire pour les informations du type de produits : "en:one-dish-meals" aux etats-unis. */
CREATE TEMP TABLE table1 AS 
/* On selectionne les champs utilent en gardant les doublons de code et url */
SELECT DISTINCT ON (product_name, brands_tags, owner, food_groups, labels_tags, countries, fat_100g, saturated_fat_100g, sugars_100g, proteins_100g, energy_100g, salt_100g, sodium_100g, nutriscore_score, nutriscore_grade) 
    product_name, 
    brands_tags,  
    owner, 
    food_groups, 
    labels_tags, 
    countries,  
    fat_100g, 
    saturated_fat_100g, 
    sugars_100g, 
    proteins_100g,  
    energy_100g, 
    salt_100g, 
    sodium_100g, 
    nutriscore_score, 
    nutriscore_grade, 
    code, 
    url,
    /* On calcul les calories en Kcal */
    ((proteins_100g*4) + (sugars_100g*4) + (fat_100g)*9) as computed_energy_100g,
    case 
        when labels_tags like '%en:organic,%' then TRUE
        when labels_tags like null then null
        else false
    end as bio,
    /* On creer un champ vegan pour savoir si le produit est vegan ou non */
    case 
        when ingredients_analysis_tags like '%en:vegan,%' then TRUE
        when ingredients_analysis_tags like '%en:non-vegan,%' then FALSE
        else null
    end as vegan,
     /* On creer un champ vegetarian pour savoir si le produit est vegetarien ou non */
    case 
        when ingredients_analysis_tags like '%en:vegetarian%' then TRUE
        when ingredients_analysis_tags like '%en:non-vegetarian%' then FALSE
        else null
    end as vegetarian,
     /* On creer un champ palm_oil pour savoir si le produit contient de l'huile de palme ou non */
    case 
        when ingredients_analysis_tags like '%en:palm-oil,%' then TRUE
        when ingredients_analysis_tags like '%en:palm-oil-free,%' then FALSE
        else null
    end as palm_oil,
     /* On creer un champ level_fat pour connaitre le niveau de gras contenu dans le produit */
    case 
        when nutrient_levels_tags like '%en:fat-in-low-quantity,%' then 'l'
        when nutrient_levels_tags like '%en:fat-in-moderate-quantity,%' then 'm'
        when nutrient_levels_tags like '%en:fat-in-high-quantity,%' then 'h'
        else null
    end as level_fat,
    /* On creer un champ level_satured_fat pour connaitre le niveau de gras sature contenu dans le produit */
    case 
        when nutrient_levels_tags like '%en:saturated-fat-in-low-quantity,%' then 'l'
        when nutrient_levels_tags like '%en:saturated-fat-in-moderate-quantity,%' then 'm'
        when nutrient_levels_tags like '%en:saturated-fat-in-high-quantity,%' then 'h'
        else null
    end as level_saturated_fat,
    /* On creer un champ level_sugars pour connaitre le taux de sucre contenu dans le produit */
    case 
        when nutrient_levels_tags like '%en:sugars-in-low-quantity,%' then 'l'
        when nutrient_levels_tags like '%en:sugars-in-moderate-quantity,%' then 'm'
        when nutrient_levels_tags like '%en:sugars-in-high-quantity,%' then 'h'
        else null
    end as level_sugars,
    /* On creer un champ level_salt pour connaitre le taux de sel contenu dans le produit */
    case 
        when nutrient_levels_tags like '%en:salt-in-low-quantity%' then 'l'
        when nutrient_levels_tags like '%en:salt-in-moderate-quantity%' then 'm'
        when nutrient_levels_tags like '%en:salt-in-high-quantity%' then 'h'
        else null
    end as level_salt
FROM 
    openfoodfacts 
WHERE 
/* On verifie que l'on prend bien les informations des etats-unis et du produit : 'one-dish-meals' */
    (countries LIKE '%united-states%' OR countries LIKE '%United States%' OR countries LIKE '%us%')
    AND food_groups = 'en:one-dish-meals'
    AND data_quality_errors_tags IS NULL
    AND fat_100g < 100
    AND saturated_fat_100g < 100
    AND sugars_100g < 100
    AND proteins_100g < 100
    AND carbohydrates_100g < 100
    AND salt_100g < 100
    AND sodium_100g < 100
    AND fat_100g > 0
    AND saturated_fat_100g > 0
    AND sugars_100g > 0
    AND proteins_100g > 0
    AND carbohydrates_100g > 0
    AND salt_100g > 0
    AND sodium_100g > 0
    /*On verifie qu'il n'y as pas de doublon ayant des composition differentes */
    AND code not in (select code
from (select DISTINCT ON (product_name, brands_tags, owner, food_groups, labels_tags, countries, fat_100g, saturated_fat_100g, sugars_100g, proteins_100g, energy_100g, salt_100g, nutriscore_score, nutriscore_grade) 
    product_name, 
    brands_tags,  
    owner, 
    food_groups, 
    labels_tags, 
    countries,   
    fat_100g, 
    saturated_fat_100g, 
    sugars_100g, 
    proteins_100g,  
    energy_100g, 
    salt_100g,  
    nutriscore_score, 
    nutriscore_grade, 
    code, 
    url
    from openfoodfacts) as a
group by code
having count(*) > 1);




/* Tests pour connaitre les differents taux en fonction des nouveaux champs cree */
select count(*) from table1 where bio = true;
select count(*) from table1 where bio = false;
select count(*) from table1 where bio is null;

select count(*) from table1 where vegan = true;
select count(*) from table1 where vegan = false;
select count(*) from table1 where vegan is null;

select count(*) from table1 where vegetarian = true;
select count(*) from table1 where vegetarian = false;
select count(*) from table1 where vegetarian is null;

select count(*) from table1 where palm_oil = true;
select count(*) from table1 where palm_oil = false;
select count(*) from table1 where palm_oil is null;

select count(*) from table1 where level_fat = 'l';
select count(*) from table1 where level_fat = 'm';
select count(*) from table1 where level_fat = 'h';
select count(*) from table1 where level_fat is null;

select count(*) from table1 where level_saturated_fat = 'l';
select count(*) from table1 where level_saturated_fat = 'm';
select count(*) from table1 where level_saturated_fat = 'h';
select count(*) from table1 where level_saturated_fat is null;

select count(*) from table1 where level_sugars = 'l';
select count(*) from table1 where level_sugars = 'm';
select count(*) from table1 where level_sugars = 'h';
select count(*) from table1 where level_sugars is null;


select count(*) from table1 where level_salt = 'l';
select count(*) from table1 where level_salt = 'm';
select count(*) from table1 where level_salt = 'h';
select count(*) from table1 where level_salt is null;


/* Copie dans un fichier.csv */
\copy table1 to './team_a04-marsandm-xxxxxxx.csv' with (DELIMITER E'\t', FORMAT CSV, NULL 'NA', ENCODING 'UTF-8');
