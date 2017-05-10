# Project Twittify - Running Instructions
### PC
#### In GIT Bash, compile and run using: ```./run.sh```
If permission is denied, type the following command: ```chmod +x run.sh``` and try again.

---

### Mac/Linux
#### Compile and run in Terminal using: ```./mac.sh```
If permission is denied, type the following command: ```chmod +x mac.sh``` and try again.

---

### Manually from within src folder
#### Change to source directory:  ```cd src```
#### Compile using: ```javac -cp ".;json/json.jar;csv/commons-csv-1.4.jar;twitter4j/twitter4j-core-4.0.4.jar;" \*.java```
#### PC run using: ```java -cp ".;json/json.jar;csv/commons-csv-1.4.jar;twitter4j/twitter4j-core-4.0.4.jar;" twittify```
#### Mac/Linux run using: ```java -cp ".:json/json.jar:csv/commons-csv-1.4.jar:twitter4j/twitter4j-core-4.0.4.jar" twittify```

---

# Project Description

This application implements Spotify and Twitter APIs to view tweets about songs, browse Spotify charts, and discover new artists.
# Application Features
### Twitter
Query Twitter's web API for any search term and return up to 9 relevant tweets.

### Spotify
Search Spotify for a track, artist, or album, as well as view the top 20 songs as seen on spotifycharts.com. Seemlessly view tweets pertaining to each song in the top 20 with a single click.

---

## Application Instructions
#### 1. Choose to discover tweets or music.

![](https://github.com/andre205/twittify/blob/master/src/images/README/welcome_spotify.png "Welcome Screen Spotify")

![](https://github.com/andre205/twittify/blob/master/src/images/README/welcome_twitter.png "Welcome Screen Twitter")

#### 2. Use the on screen buttons to search for tracks, artists, albums, tweets, or the spotify top 20

![](https://github.com/andre205/twittify/blob/master/src/images/README/twitter_search.png "Welcome Screen Twitter")

![](https://github.com/andre205/twittify/blob/master/src/images/README/spotify_top20.png "Welcome Screen Twitter")

#### 3. Return to the home screen at any time by clicking 'BACK'


---

### Resources:<br>
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
