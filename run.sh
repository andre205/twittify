echo "Running twittify.java"
echo
javac -cp "json.jar" *.java
java -cp ".;json.jar" twittify
