# wct
Whatsapp Chat tool

## What is this?
A command line tool to convert Whatsapp conversation files to different output formats, with different filter and mapping features
##### Features:

- Filter chat messages that present a link and convert them to Json message:

INPUT:
```
 * Example skipped line: "10/27/15, 10:23 - Save: Ahahahah"
 * Example matched line: "11/21/15, 12:38 - Enrico: Wow super cool! https://m.facebook.com/story.php?story_fbid=1111111
 * Example non-regular line: "https://www.youtube.com/watch?v=xxxxx&feature=youtu.be"
 * Another Example of a non-regular line: "Some text"
```

OUTPUT:
```
{
    output: [{
                "date": "DDMMYYY HH:MM string",
                "from": "string",
                "url": "string",
                "wholeMessage": "string"
              },{..}
             ]
}

``` 

## How to install
```
mvn clean install
```

## How to run
from the root of the project:

```
./wct.sh --input yourchat.txt --output chatlinks.json
```


## More

