package com.tonnoz.wct.main.domain;

import com.tonnoz.wct.main.utils.StringUtils;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.tonnoz.wct.main.utils.StringUtils.COLUMN;
import static com.tonnoz.wct.main.utils.StringUtils.DASH;
import static com.tonnoz.wct.main.utils.StringUtils.DASH_CHAR;
import static com.tonnoz.wct.main.utils.StringUtils.DATE_PATTERN;
import static com.tonnoz.wct.main.utils.StringUtils.isRegularLookingLogLine;


/**
 * Example skipped line: "10/27/15, 10:23 - Save: Ahahahah"
 * Example matched line: "11/21/15, 12:38 - Enrico: Wow super cool! https://m.facebook.com/story.php?story_fbid=1111111
 * Example non-regular line: "https://www.youtube.com/watch?v=xxxxx&feature=youtu.be"
 * Another Example of a non-regular line: "Some text"
 */
@Data
public class LogLine {

    private String date;
    private String from;
    private String url;
    private String wholeMessage;

    public LogLine(String aLogLine){
        wholeMessage = aLogLine;
        final String maybeDate = aLogLine.split(DASH)[0];
        if(!isRegularLookingLogLine(maybeDate)){
            url = maybeDate;
            return;
        }
        date = LocalDateTime.parse(maybeDate, DateTimeFormatter.ofPattern(DATE_PATTERN)).toString();
        final String allTheRest = aLogLine.substring(aLogLine.indexOf(DASH_CHAR) + 2);
        from = allTheRest.split(COLUMN)[0];
        url = StringUtils.extractUrls(allTheRest);
    }


}
