# Compléments de programmation - TD 1

## Remarques préliminaires
* Avez vous lu sur persee, l'annonce "La notation et l'IA" ?
* Les commandes `git` sont à taper en ligne de commande dans un *shell bash*.
* Vous pouvez utiliser l'IDE de votre choix.
  Sur le cartable numérique, [Eclipse](www.eclipse.org), [IntelliJ IDEA](http://www.jetbrains.com/idea/) et [Visual Studio Code](https://code.visualstudio.com/) sont installés.
* Vous répondrez aux questions directement dans ce fichier en complétant les emplacements correspondants.
  Ajoutez ensuite ce fichier au dépôt `git`.

## Partie I (à faire durant le TD) : découverte de `git`
Dans cet exercice, vous créerez une classe `Fraction` représentant un nombre rationnel et une classe `Main` qui testera les méthodes de la classe `Fraction` **avec des assertions** (cf. [Utilisation d'assertions](https://koor.fr/Java/Tutorial/java_assert.wp)).
À chaque étape, consultez le statut des fichiers du projet (`git status`) ainsi que l'historique (`git log`).

1. Sur la forge, créez le dépôt (_repository_) `SimpleFraction`;
   En terme de *commits*, quelle différence constatez-vous entre cocher une (ou plusieurs) des cases *Initialize this repository with* et n'en cocher aucune ?
   > Lorsque l'on coche une ou plusieurs options d'initialisation, la forge crée automatiquement les fichiers sélectionnés et effectue un premier commit. Si aucune option n'est cochée, le dépôt est créé vide, sans commit initial.

   *Pour la suite, ne cochez aucune de ces cases*.
1. Localement, configurez `git` avec votre nom (`user.name`) et votre email (`user.email`) (cf. [Personnalisation de Git](https://git-scm.com/book/fr/v2/Personnalisation-de-Git-Configuration-de-Git));
    ```bash
     git config --global user.name "Hajar Drai"
     git config --global user.email "hajardraiz@gmail.com"
    ```
1. Initialisez le dépôt `git` local pour le projet (cf. [Démarrer un dépôt Git](https://git-scm.com/book/fr/v2/Les-bases-de-Git-D%C3%A9marrer-un-d%C3%A9p%C3%B4t-Git));
    ```bash
     cd SimpleFraction
     git init
    ```
1. Dans votre IDE, créez la classe `Fraction` (vide pour le moment) et la classe `Main` (avec un simple affichage) dans le projet (cf. [Méthode `main`](https://docs.oracle.com/javase/specs/jls/se19/html/jls-12.html#jls-12.1.4));
   Vérifiez que le projet compile et s'exécute dans l'IDE;
   Validez les changements (cf. [Enregistrer des modifications dans le dépôt](https://git-scm.com/book/fr/v2/Les-bases-de-Git-Enregistrer-des-modifications-dans-le-d%C3%A9p%C3%B4t));
    ```bash
      git status
      git add .
      git commit -m "Création des classes Fraction et Main"
      git log
    ```
1. Ajoutez la méthode `toString` à la classe `Fraction` (cf. [`Object.toString`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Object.html#toString())) qui retournera la chaîne `"Je suis une fraction."` et modifiez la classe `Main` en conséquence;
   Validez les changements;
    ```Java
        // Fraction.java
        public class Fraction {
            @Override
            public String toString() {
                return "Je suis une fraction.";
            }
        }

        // Main.java
        public class Main {
            public static void main(String[] args) {
                Fraction fraction = new Fraction();
                System.out.println(fraction.toString());
            }
        }
    ```
1. Publiez vos modifications sur le dépôt distant (cf. [Travailler avec des dépôts distants](https://git-scm.com/book/fr/v2/Les-bases-de-Git-Travailler-avec-des-d%C3%A9p%C3%B4ts-distants));
   Vous utiliserez le protocole `https` pour cela;
   Vérifiez avec le navigateur;
    ```bash
    git remote add origin https://github.com/hajard642/SimpleFraction.git
    git push -u origin master
    
    ```
1. Sur la forge, ajoutez un fichier de documentation `README.md`.
   Quelle syntaxe est utilisée pour ce fichier ?
   > La syntaxe Markdown
1. Récupérez localement les modifications effectuées sur la forge.
    ```bash
    git pull origin master
    ```
1. Ajoutez les répertoires et fichiers issus de la compilation aux fichiers ignorés par `git` (cf. [`.gitignore` pour Java](https://github.com/github/gitignore/blob/main/Java.gitignore));
    ```bash
    # target/
!.mvn/wrapper/maven-wrapper.jar
!**/src/main/**/target/
!**/src/test/**/target/

### IntelliJ IDEA ###
.idea/modules.xml
.idea/jarRepositories.xml
.idea/compiler.xml
.idea/libraries/
*.iws
*.iml
*.ipr

### Eclipse ###
.apt_generated
.classpath
.factorypath
.project
.settings
.springBeans
.sts4-cache

### NetBeans ###
/nbproject/private/
/nbbuild/
/dist/
/nbdist/
/.nb-gradle/
build/
!**/src/main/**/build/
!**/src/test/**/build/

### VS Code ###
.vscode/

### Mac OS ###
.DS_Store
```
1. Retirez les fichiers de configuration de l'IDE du projet;
    ```bash
     git rm -r --cached .idea
    ```
   Ajoutez-les aux fichiers ignorés par `git`.
    ```bash
     .idea/
    ```
1. Configurez l'accès par clé publique/clé privée à la forge (cf. [Connecting to GitHub with SSH](https://docs.github.com/en/authentication/connecting-to-github-with-ssh)).
   > Générer une paire de clés SSH (clé publique et clé privée) avec ssh-keygen.
   Ajouter la clé publique dans GitHub, dans Settings > SSH and GPG keys.
   Tester la connexion avec ssh -T git@github.com.
   Enfin, utiliser l'URL SSH du dépôt pour les opérations Git.

## Partie II (à faire durant le TD) : compléter la classe `Fraction`
Dans cet partie, vous compléterez les classes `Fraction` et `Main`.
Un exemple d'interface pour une telle classe est donné par la classe [`Fraction`](http://commons.apache.org/proper/commons-math/javadocs/api-3.6.1/org/apache/commons/math3/fraction/Fraction.html) de la bibliothèque [Apache Commons Math](http://commons.apache.org/math/).

Vous respecterez les consignes ci-dessous :
* chaque méthode de `Fraction` sera testée dans `Main` **avec des assertions** (cf. [Utilisation d'assertions](https://koor.fr/Java/Tutorial/java_assert.wp));
* à la fin de chaque question, consultez le statut des fichiers du projet (`git status`) ainsi que l'historique (`git log`) puis validez les changements.

1. Ajoutez les attributs représentants le numérateur et le dénominateur (nombres entiers).
    ```Java
    // Déclaration des attributs
    private int numerator;
    private int denominator;
    ```
1. Ajoutez les constructeurs (cf. [Constructor Declarations](https://docs.oracle.com/javase/specs/jls/se19/html/jls-8.html#jls-8.8)) suivants :
    * initialisation avec un numérateur et un dénominateur,
    * initialisation avec juste le numérateur (dénominateur égal à _1_),
    * initialisation sans argument (numérateur égal _0_ et dénominateur égal à _1_),
    ```Java
    // Assertions pour tester les constructeurs (avec toString)
public Fraction(int numerator, int denominator) {
this.numerator = numerator;
this.denominator = denominator;
}

public Fraction(int numerator) {
this.numerator = numerator;
this.denominator = 1;
}

public Fraction() {
this.numerator = 0;
this.denominator = 1;
}
```
1. Ajoutez les fractions constantes ZERO (0, 1) et UN (1, 1) (cf. [Constants in Java](https://www.baeldung.com/java-constants-good-practices)),
    ```Java
    // Déclaration des constantes
    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction UN = new Fraction(1, 1);
    ```
1. Ajoutez une méthode de consultation du numérateur et du dénominateur (par convention, en Java, une méthode retournant la valeur de l'attribut `anAttribute` est nommée `getAnAttribute`),
    ```Java
    // Définition des getters
public int getNumerator() {
return numerator;
}

public int getDenominator() {
return denominator;
}
```
1. Ajoutez une méthode de consultation de la valeur sous la forme d'un nombre en virgule flottante (méthode `doubleValue()`) (cf. [`java.lang.Number`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Number.html)),
   ```Java
    // Assertions pour tester la conversion
Fraction fraction = new Fraction(1, 2);
assert Math.abs(fraction.doubleValue() - 0.5) < 1E-8;
```
1. Ajoutez une méthode permettant l'addition de deux fractions (la méthode `add` prend en paramètre *une* fraction et *retourne* la somme de la fraction courante et du paramètre),
   ```Java
    // Assertions pour tester l'addition
Fraction f1 = new Fraction(1, 2);
Fraction f2 = new Fraction(1, 3);
Fraction result = f1.add(f2);
assert result.getNumerator() == 5;
assert result.getDenominator() == 6;
```
1. Ajoutez le test d'égalité entre fractions (deux fractions sont égales si elles représentent la même fraction réduite) (cf. [`java.lang.Object.equals`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object))),
   ```Java
    // Assertions pour tester l'égalité
Fraction f4 = new Fraction(1, 2);
Fraction f5 = new Fraction(2, 4);
Fraction f6 = new Fraction(2, 3);
assert f1.equals(f5);
assert !f1.equals(f6);
```
1. Ajoutez la comparaison de fractions selon l'ordre naturel (cf. [`java.lang.Comparable`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Comparable.html)).
   ```Java
    // Assertions pour tester la comparaison
Fraction f7 = new Fraction(1, 2);
Fraction f8 = new Fraction(2, 3);
Fraction f9 = new Fraction(1, 2);

assert f1.compareTo(f8) < 0;
assert f2.compareTo(f7) > 0;
assert f1.compareTo(f9) == 0;
```
1. Faites hériter votre classe `Fraction` de la classe [`java.lang.Number`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Number.html) et complétez les méthodes
   ```Java
    // Vérifiez avec le code ci-dessous
    Number aNumber = java.math.BigDecimal.ONE;
    Number anotherNumber = new Fraction(1, 2);
    assert java.lang.Math.abs(aNumber.doubleValue() + anotherNumber.doubleValue() - 1.5) < 1E-8;
    ```

## Partie III (à faire à la maison) : révisions et perfectionnement *shell* et *IDE*
### Maîtriser le *shell* de commandes
L'objectif de cet exercice est de vous faire réviser/découvrir les commandes de base du *shell* de votre machine.
Vous pouvez répondre en utilisant le shell de votre choix (*bash*, *Powershell*, …).
Pour répondre à ces questions, vous devez effectuer les recherches documentaires adéquates (livre, web, …).

1. Quel OS et quel shell de commande utilisez-vous ?
   >J'utilise Windows avec Git Bash comme shell de commande
1. Quelle commande permet d'obtenir de l'aide ?
   Donnez un exemple.
    ```bash
    ls --help
    ```
1. Donnez la ou les commandes shell permettant de
    1. afficher les fichiers d'un répertoire triés par taille (taille affichée lisiblement)
        ```bash
         ls -lhS
        ```
    1. compter le nombre de ligne d'un fichier
        ```bash
         wc -l nom_du_fichier
        ```
    1. afficher les lignes du fichier `Main.java` contenant la chaîne `uneVariable`
        ```bash
         grep "uneVariable" Main.java
        ```
    1. afficher récursivement les fichiers `.java` contenant la chaîne `uneVariable`
        ```bash
         grep -R --include="*.java" "uneVariable" .
        ```
    1. trouver les fichiers (pas les répertoires) nommés `README.md` dans une arborescence de répertoires
        ```bash
         find . -type f -name "README.md"
        ```
    1. afficher les différences entre deux fichiers textes
        ```bash
         diff fichier1.txt fichier2.txt
        ```
1. Expliquez en une ou deux phrases le rôle de ces commandes et dans quel contexte elles peuvent être utiles pour un développeur.
    * `ssh`
      > ssh permet d'établir une connexion sécurisée à une machine distante. Pour un développeur, il peut notamment être utilisé pour accéder à un serveur distant ou communiquer avec un dépôt Git utilisant SSH.
    * `screen`/`tmux`
      > screen et tmux permettent de conserver des sessions de terminal actives et de travailler avec plusieurs terminaux dans une même session. Ils sont utiles notamment lors du travail sur un serveur distant ou pour laisser tourner un programme longtemps.
    * `curl`/[HTTPie](https://httpie.org/)
      > curl et HTTPie permettent d'envoyer des requêtes HTTP depuis le terminal. Ils sont utiles pour tester une API, envoyer des données à un serveur et vérifier les réponses HTTP sans utiliser une interface graphique.
    * [jq](https://stedolan.github.io/jq/)
      > jq permet de lire, filtrer et transformer des données au format JSON depuis le terminal. Il est particulièrement utile pour analyser les réponses JSON d'une API ou traiter automatiquement des données dans des scripts.

### Découverte de votre *IDE*
Dans cet exercice, vous expliquerez en quelques phrases comment vous réalisez les actions ci-dessous dans votre IDE.
Vous pouvez choisir l'IDE/éditeur de texte de votre choix.
Pour réaliser cette exercice, vous devez bien évidemment vous reporter à la documentations de l'IDE ([IntelliJ IDEA](https://www.jetbrains.com/help/idea/discover-intellij-idea.html#developer-tools), [Visual Studio Code](https://code.visualstudio.com/docs), [Eclipse](https://help.eclipse.org/2020-09/index.jsp), …).

1. Quels IDE ou éditeurs de texte utilisez-vous pour le développement Java ?
   > Intellij

   Pour la suite, ne considérez que l'un de vos choix.
1. Comment vérifier/définir que l'encodage utilisé est *UTF-8* ?
   > Dans IntelliJ IDEA, je vais dans File → Settings → Editor → File Encodings. Je vérifie que l'encodage du projet et celui des fichiers sont configurés en UTF-8.
1. Comment choisir le JDK à utiliser dans un projet ?
   > Je vais dans File → Project Structure → Project, puis dans SDK je sélectionne le JDK souhaité. Pour mon projet, j'utilise le JDK 17.
1. Comment préciser la version Java des sources dans un projet ?
   > Dans File → Project Structure → Project, je peux définir le Language level correspondant à la version Java utilisée. Je peux également le définir dans la configuration Maven du projet si celui-ci utilise Maven.
1. Comment ajouter une bibliothèque externe dans un projet ?
   > Je vais dans File → Project Structure → Libraries, puis j'ajoute la bibliothèque souhaitée. Dans un projet Maven, je peux également ajouter la dépendance correspondante dans le fichier pom.xml.
1. Comment reformater un fichier source Java ?
   >Je sélectionne le fichier puis j'utilise le raccourci Ctrl + Alt + L pour reformater automatiquement le code selon les règles de formatage d'IntelliJ IDEA.
1. Comment trouver la déclaration d'une variable ou méthode ?
   > Je place le curseur sur la variable ou la méthode et j'utilise Ctrl + B pour accéder à sa déclaration.
1. Comment insérer un bloc de code prédéfini (*snippet*) ?
   > Je peux utiliser les Live Templates d'IntelliJ IDEA. Avec Ctrl + J, je peux afficher les templates disponibles et insérer le bloc de code souhaité.
1. Comment renommer une classe dans l'ensemble du projet ?
   > Je place le curseur sur le nom de la classe et j'utilise Shift + F6. IntelliJ IDEA effectue ensuite le renommage dans les endroits concernés du projet.
1. Comment exécuter le programme en lui passant un paramètre en ligne de commande ?
   > Je vais dans Run → Edit Configurations, je sélectionne la configuration de mon programme et je renseigne les paramètres dans le champ Program arguments. Je peux ensuite exécuter le programme avec cette configuration.
1. Comment déboguer le programme en visualisant le contenu d'une ou plusieurs variables ?
   > Je place un point d'arrêt (breakpoint) sur une ligne de code, puis je lance le programme en mode Debug. Lorsque l'exécution s'arrête sur le breakpoint, je peux consulter la valeur des variables dans la fenêtre du débogueur et avancer pas à pas dans le programme.
1. Quels paramètres ou fonctionnalités vous semblent particulièrement importants/utiles pour le développement Java ?
   > Les fonctionnalités qui me semblent particulièrement utiles sont l'autocomplétion, la détection des erreurs, le débogueur, le refactoring, la navigation rapide dans le code, le reformatage automatique, la gestion de Maven et Git, ainsi que les tests JUnit. Elles permettent de gagner du temps, de détecter plus facilement les erreurs et de maintenir un code propre et organisé.
