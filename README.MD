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


## Licence

```
The MIT License (MIT)
Copyright (c) 2018 tonnoz
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
documentation files (the "Software"), to deal in the Software without restriction, including without limitation
the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial 
portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```