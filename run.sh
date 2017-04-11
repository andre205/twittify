echo Twittify
javac -cp "json.jar" *.java

#Detect OS and run accordingly
if [ "$(uname)" == "Darwin" ]; then
    java -cp ".:json.jar" twittify
elif [ "$(expr substr $(uname -s) 1 5)" == "Linux" ]; then
    java -cp ".:json.jar" twittify
elif [ "$(expr substr $(uname -s) 1 10)" == "MINGW32_NT" ]; then
    java -cp ".;json.jar" twittify
elif [ "$(expr substr $(uname -s) 1 10)" == "MINGW64_NT" ]; then
    java -cp ".;json.jar" twittify 
fi


#I found Found the OS detection code here
#http://stackoverflow.com/questions/3466166/how-to-check-if-running-in-cygwin-mac-or-linux
