# Bowling Score app

Basic Bowling application that can read and write bowling scores.

## Features

  - Read bowling scores from text file.
  - Program verifies if the information is consistent.
  - White bowling scores as table to text file.
  
## Tree
```
com.juanchavezcornejo.bowling
│   Main.java
└───core
│   │   BowlingException.java
│   │   BowlingGame.java
│   │   BowlingPlayer.java
│   │   BowlingUtils.java
│   └───frames
│   │   │   BowlingFrame.java
│   │   │   EndFrame.java
│   │   │   MiddleFrame.java
│   │   │   StartFrame.java
│   └───score
│   │   │   Score.java
│   │   │   ScoreFactory.java
└───io
│   │   BowlingFileReader.java
│   │   BowlingFileWriter.java
```

### Unit tests
There are JUnit unit tests are on `src/test/java`. Those cover **~96% of the lines of code**.

### Integration tests

There are JUnit integration tests are on `src/test/java`. Integration tests cover valid, perfect, zero and foul cases.

### Bonus

Program uses Java 8 streams and lambdas on some specific cases.

### Considerations

  - **Single Responsibility Principle**: Classes are self contained.
  - **Liskov’s Substitution Principle**: There only necessary interface that its necessary is Bowling Frame.
  - **Dependency Inversion Principle**: Program depends on Bowling Frame interface, not implementations.
  - **Not using Singleton**, static classes only on utility methods and most-used constants.
  - **Encapsulated** code.
  - Using **Maven** for build process.
  - Using **git**.

### Clean task

```sh
mvn clean
```

### Install task

```sh
mvn install
```

### Compile task

```sh
mvn compile
```

### Run tests task

```sh
mvn test
```

### Package task

```sh
mvn package
```

### Execute

```sh
java -jar "input.txt" "output.txt"
```

License
----

MIT