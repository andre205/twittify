echo Twittify
echo Compiling...
javac -cp "json.jar" *.java
#If semicolon style fails, try colon style for mac/linux
echo -n "Attempting to run (GIT Bash): "
java -cp ".;json.jar" twittify || {
echo -e "\rAttempting to run (Mac/Linux)"
java -cp ".:json.jar" twittify
}
