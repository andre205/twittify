cd src
echo Compiling...
javac -cp ".;json/json.jar;csv/commons-csv-1.4.jar;twitter4j/twitter4j-core-4.0.4.jar;" *.java
echo Running Twittify
java -cp ".;json/json.jar;csv/commons-csv-1.4.jar;twitter4j/twitter4j-core-4.0.4.jar;" twittify
echo Twittify now running
