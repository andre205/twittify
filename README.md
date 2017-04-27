# Project Twittify - Running Instructions
### PC
#### In GIT Bash, compile and run using: ```./run.sh```
If permission is denied, type the following command: ```chmod +x run.sh```

---

### Mac/Linux
#### Compile and run in terminal using: ```./mac.sh```
If permission is denied, type the following command: ```chmod +x mac.sh```

---

### Manually from within src folder
#### Change to source directory:  ```cd src```
#### Compile using: ```javac -cp ".;json/json.jar;csv/commons-csv-1.4.jar;twitter4j/twitter4j-core-4.0.4.jar;" \*.java```
#### PC run using: ```java -cp ".;json/json.jar;csv/commons-csv-1.4.jar;twitter4j/twitter4j-core-4.0.4.jar;" twittify```
#### Mac/Linux run using: ```java -cp ".:json/json.jar:csv/commons-csv-1.4.jar:twitter4j/twitter4j-core-4.0.4.jar" twittify```

---

# Project Description

This application Implements Spotify and Twitter APIs to view tweets about songs, browse spotify charts, and discover new artists.

---

Resources:<br>
Spotify<br>
https://developer.spotify.com/web-api/user-guide/<br>
https://developer.spotify.com/web-api/search-item/<br>
https://developer.spotify.com/web-api/authorization-guide/<br>
CSV Parser<br>
https://commons.apache.org/proper/commons-csv/user-guide.html<br>
Twitter<br>
https://dev.twitter.com/rest/reference/get/search/tweets<br>
JavaFX<br>
https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html<br>
http://docs.oracle.com/javase/8/javafx/layout-tutorial/builtin_layouts.htm#JFXLY102<br>

JSON Package Source:<br>
https://github.com/stleary/JSON-java<br>
http://mvnrepository.com/artifact/org.json/json  Third version (20160810)<br>

CSV Package Source (Version 1.4):<br>
http://commons.apache.org/proper/commons-csv/download_csv.cgi<br>
