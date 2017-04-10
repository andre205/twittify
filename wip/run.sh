#Doesn't work -- looking into it
echo "Running main.java"
echo
javac -cp "twitter4j-core-4.0.4.jar" *.java
java -cp ".;twitter4j-core-4.0.4.jar;" Main
