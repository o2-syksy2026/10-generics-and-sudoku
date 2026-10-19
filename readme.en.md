# Generic types and Sudoku game

With this exercise package, you will learn to define generic methods and classes. The topic is initially covered by creating general-purpose methods that can handle different types of data without having to repeat the program logic for different types. The tasks progress to implementing your own two-dimensional collection ([Grid](./src/main/java/grid/Grid.java)). Your own two-dimensional collection will eventually be used as the data structure for a Sudoku game.

To get acquainted with the topic, we recommend reading, for example, the [dev.java tutorial on Generics](https://dev.java/learn/generics/). Additionally, the video[ Generics In Java - Full Simple Tutorial (Coding with John, YouTube)](https://youtu.be/K1iu1kXkVoA) is a good resource to get started.

The task consists of several parts, which are evaluated separately using pre-written tests.

## Starting the exercise

Start by cloning the Git repository to your local machine. The exercise must be done in your own copy, so make sure the repository URL includes your GitHub username! Create your own copy by forking or copying this repository to your own GitHub account.

```sh
git clone https://github.com/make-sure-that-the-repository-address-contains-your-account.git
```

After cloning the project to your local machine, open it in your code editor.

## Submitting solutions

Solutions to this exercise are not graded by any GitHub Actions workflow (YAML), and `git push` does not start any grading. Grading is done by the course system: submit your solution on the exercise page in the course system, where your code is compiled and the exercise's JUnit tests are run.

Finally, push everything to your public GitHub repository and press the **Lähetä tarkistettavaksi** (submit for checking) button on the exercise page. The course system's bot then fetches your code from your repository and checks it with the same tests.

💡 *You can submit your solution as many times as needed until the chapter deadline. Your best result is kept.*


## Exercise 1: Randomizer.java *(basics, 25%)*

In the first phase of the task, the goal is to implement your own methods that allow you to fetch a random value from a list, shuffle the list into a random order, or take a certain number of random values from the list. Similar randomness could be utilized, for example, in a web application where a few random sales listings are picked for the front page. Various games, such as card games, also often involve similar randomness.

The [Randomizer](./src/main/java/randomizer/Randomizer.java) class to be coded in the task consists of predefined methods whose javadoc comments explain how the method should work. Your task is to read the comments and implement the method content to match the method name and description.

You can test your code using your own `main` method, or you can use the provided JUnit unit tests for the task, which can be found in the RandomizerTest class. You can run the tests using your code editor's testing tool ([VS Code](https://code.visualstudio.com/docs/java/java-testing), [Eclipse](https://www.vogella.com/tutorials/JUnitEclipse/article.html)) or the [Gradle automation tool](https://docs.gradle.org/current/userguide/java_testing.html):

```
./gradlew test --tests RandomizerTest        # unix
.\gradlew.bat test --tests RandomizerTest    # windows
```

💡 Tip: Pay attention to the similarity of the methods: could you perhaps call other methods of the same class from these methods?

## Exercise 2: "Generic randomizer" *(applying, 25%)*

In the second part of the task, you will continue developing the [Randomizer](./src/main/java/randomizer/Randomizer.java) class so that all the class methods become **generic**. With generic methods, you can use, for example, the method that fetches a random value with strings, numbers, and your own classes.

In this part of the task, you may not need to change much of the content of the methods you have implemented. Instead, the changes mainly focus on the method headers, where a `Type` type variable is used instead of a concrete `String` type. If you haven't yet familiarized yourself with generic types through the [dev.java tutorial](https://dev.java/learn/generics/) or the [Coding with John-videon](https://youtu.be/K1iu1kXkVoA), you should start with those.

### Testing the changes

In this task, the changes made to the [Randomizer](./src/main/java/randomizer/Randomizer.java) class must not break existing functionality. The tests performed in the previous part with the [Ran(./src/test/java/randomizer/RandomizerTest.java)domizerTest] class should still pass.

Testing the changes made to the method headers will cause compilation errors at the start of the task because the necessary changes have not yet been made to the methods called in the test class. Therefore, the test class is placed outside the source code files in the project. You need to move the `GenericRandomizerTest` test class used for task inspection to the correct directory when starting the task. This can be done with the `git mv` command, which also updates the information about the file move in version control:

```
# execute the following command in the root folder of the project:
git mv GenericRandomizerTest.txt src/test/java/randomizer/GenericRandomizerTest.java
```

Once you have copied the test class to the [src/test/java/randomizer/](./src/test/java/randomizer/) directory using the above command, you can run the tests as follows:

```
./gradlew test --tests GenericRandomizerTest        # unix
.\gradlew.bat test --tests GenericRandomizerTest    # windows
```

## Exercise 3: Grid.java *(applying, 25%)*

The [Grid](./src/main/java/grid/Grid.java) class to be implemented in this task represents a **two-dimensional** grid. The grid can be used to model a game board such as a chessboard, tic-tac-toe, or sudoku grid. The Grid is intended to be implemented as a **generic** (`Grid<Type>`), so the contents of the grid can be, for example, numbers (`Grid<Integer>`), strings (`Grid<String>`), or other objects (`Grid<ChessPiece>`) depending on its use. However, all values in a single Grid object are always of the same type.

Familiarize yourself with the [Grid](./src/main/java/grid/Grid.java) class javadoc comments and implement the logic for storing and retrieving data in the class. The data is intended to be stored and retrieved in much the same way as with arrays, lists, and map data structures. This time, the "key" consists of two values: the row and column numbers. Additionally, the size of the grid must grow dynamically, and new values must be able to be added in any order.

The JUnit tests for the class can be found in the [GridTest](./src/test/java/grid/GridTest.java) class, which you can run as follows:

```
./gradlew test --tests GridTest        # unix
.\gradlew.bat test --tests GridTest    # windows
```

### 💡 Tips

You will need to choose the data structure used for storing information within the Grid class yourself. You can solve the problem by using a one-dimensional data structure and storing objects in a list that consist of row and column numbers as well as the actual value to be stored.

Another, more efficient option could be to use a Map data structure, combining the row and column into a string key (`map.put("5:8", 7)`, `map.get("5:8")`).

A third, more advanced approach would be to create a new `Position` class to store the row and column (`map.put(new Position(5, 8), 7)`). If `Position` objects are used as keys in a hash table, the class must also implement the [hashCode](https://www.baeldung.com/java-hashcode) method, which Java uses for hashing data. On the other hand, it might be beneficial to implement `Position` as a [`record` class, since Java automatically generates the `hashCode` method for them](https://docs.oracle.com/en/java/javase/17/language/records.html).

```java
/**
 * "The appropriate accessors, constructor, equals, hashCode, and toString
 * methods are created automatically."
 *
 * See https://docs.oracle.com/en/java/javase/17/language/records.html
 */
record Position(int row, int col) {
}
```

## Exercise 4: Sudoku.java *(applying, 25 %)*

> *"Sudoku is a logic-based, combinatorial number-placement puzzle. In classic Sudoku, the objective is to fill a 9 × 9 grid with digits so that each column, each row, and each of the nine 3 × 3 subgrids that compose the grid (also called "boxes", "blocks", or "regions") contains all of the digits from 1 to 9"*
>
> Wikipedia. https://en.wikipedia.org/wiki/Sudoku

This Sudoku exercise serves as an example of how you can separate game logic, data storage, and the user interface into distinct classes.

The game logic itself is implemented in the [Sudoku](./src/main/java/sudoku/Sudoku.java) class, where it checks that the moves follow the game rules. The [Grid](./src/main/java/grid/Grid.java) class is used to store numbers on the two-dimensional game board. The actual game interface with outputs and inputs is implemented in a separate [SudokuGame](./src/main/java/sudoku/SudokuGame.java) class.

By dividing the application logic into different classes and making them generic if necessary, the code becomes more modular and easier to maintain and test. Code reuse is also facilitated, and we could use the Grid class as-is for other games that utilize a two-dimensional grid. The Sudoku class could, in turn, be used as-is with different interfaces, for example, as part of a desktop or web application.

The game is initially incomplete, but you can still run it by executing the main method of the [SudokuGame](./src/main/java/sudoku/SudokuGame.java) class. As you progress in the task and implement the methods of the Sudoku class, the end result will look something like this:

```
███████╗██╗   ██╗██████╗  ██████╗ ██╗  ██╗██╗   ██╗
██╔════╝██║   ██║██╔══██╗██╔═══██╗██║ ██╔╝██║   ██║
███████╗██║   ██║██║  ██║██║   ██║█████╔╝ ██║   ██║
╚════██║██║   ██║██║  ██║██║   ██║██╔═██╗ ██║   ██║
███████║╚██████╔╝██████╔╝╚██████╔╝██║  ██╗╚██████╔╝
╚══════╝ ╚═════╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝ ╚═════╝

Welcome to the Sudoku game! Press Ctrl + C to exit.

2 6 7 | 8 3 9 | 5 . 4
9 . 3 | 5 1 . | 6 . .
. 5 1 | 6 . . | 8 3 9
------ ------- ------
5 1 9 | . 4 6 | 3 2 8
8 . 2 | 1 . 5 | 7 . 6
6 7 4 | 3 2 . | . . 5
------ ------- ------
. . . | 4 5 7 | 2 6 3
3 2 . | . 8 . | . 5 7
7 4 5 | . . 3 | 9 . 1

Enter the row (0-8): 1
Enter the column (0-8): 1
Enter the number (1-9): 8
```

In this task, you only need to make changes to the `setNumber`, `getNumber`, `isSolved`, and `toString` methods in the [Sudoku](./src/main/java/sudoku/Sudoku.java) class. Note that the checks required by the `setNumber` method for rows, columns, and subgrids can be quite complex, and it might be a good idea to implement them in separate helper methods that you design yourself.

The JUnit tests for the Sudoku class can be found in the [SudokuTest](./src/test/java/sudoku/SudokuTest.java) class, and you can run them as follows:

```
./gradlew test --tests SudokuTest        # unix
.\gradlew.bat test --tests SudokuTest    # windows
```

There are no separate unit tests for the [SudokuGame](./src/main/java/sudoku/SudokuGame.java) class, but you can test its functionality by running the code and trying to place different values in different cells.

### Sudoku ❤ Programming MOOC

The Sudoku task is heavily influenced by the Python exercises from the University of Helsinki's [Introduction to Programming MOOC course](
https://programming-24.mooc.fi/) at https://programming-24.mooc.fi/part-5. The partially filled Sudoku grid in the Sudoku task is also borrowed from the exercises of the same MOOC course. The Programming MOOC is licensed under the [CC BY-NC-SA 4.0 license](https://programming-24.mooc.fi/credits).

## Tehtävä 5: ohjelman paketoiminen suoritettavaksi [JAR-tiedostoksi](https://en.wikipedia.org/wiki/JAR_(file_format)) *(extra, 0 %)*

Mikäli haluat luoda sudoku-sovelluksesta paketin, joka ei edellytä lähdekoodien ja IDE-työkalun käyttöä, voit tehdä sen projektissa mukana olevalla Gradle-työkalulla. `build`-komento paketoi sovelluksen .jar-tiedostoksi:

## Task 5: Packaging the program into an executable [JAR file](https://en.wikipedia.org/wiki/JAR_(file_format)) *(extra, 0%)*

If you want to create a package of the Sudoku application that does not require the use of source code and an IDE tool, you can do so with the Gradle tool included in the project. The `build` command packages the application into a .jar file:

```
./gradlew build         # unix
.\gradlew.bat build     # windows
```

The packaged file will appear in the [build/libs/](./build/libs/) subdirectory, from where it can be executed with the `java -jar` command:

```
java -jar build/libs/generics-and-sudoku.jar    # unix
java -jar build\libs\generics-and-sudoku.jar    # windows
```

For more detailed instructions on using Gradle, you can refer to [Building Java Projects with Gradle (spring.io)](https://spring.io/guides/gs/gradle).

💡 *There are no separate tests for this packaging task, and it does not affect the evaluation.*

## This exercise's license

This task was developed by Teemu Havulinna and translated to English by Kalle Ilves and is licensed under the [Creative Commons BY-NC-SA](https://creativecommons.org/licenses/by-nc-sa/4.0/). The task description, task templates, and automatic tests were created using the ChatGPT 3.5 language model and the GitHub Copilot AI tool.
