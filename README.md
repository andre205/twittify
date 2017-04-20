# Project Twittify -- Running Instructions
### PC
#### In GIT Bash, compile and run using: ./run.sh
If permission is denied, type the following command: chmod +x run.sh

---

### Mac/Linux
#### Compile and run in terminal using: ./mac.sh
If permission is denied, type the following command: chmod +x mac.sh

---

### Manually from within src folder
#### Compile using: javac -cp ".;json/json.jar;csv/commons-csv-1.4.jar;" \*.java
#### PC run using: java -cp ".;json/json.jar;csv/commons-csv-1.4.jar" twittify
#### Mac/Linux run using: java -cp ".:json/json.jar:csv/commons-csv-1.4.jar" twittify

---

This application Implements Spotify and Twitter APIs to view tweets about songs, <br>
and generates playlists from popular songs on twitter.

Resources:<br>
https://facebook.github.io/react-native/docs/getting-started.html<br>
https://developer.spotify.com/web-api/user-guide/<br>
https://developer.spotify.com/web-api/search-item/<br>
https://developer.spotify.com/web-api/authorization-guide/<br>
https://commons.apache.org/proper/commons-csv/user-guide.html<br>

JSON Package Source<br>
https://github.com/stleary/JSON-java<br>
http://mvnrepository.com/artifact/org.json/json  Third version (20160810)<br>

CSV Package Source (Version 1.4)<br>
http://commons.apache.org/proper/commons-csv/download_csv.cgi<br>
