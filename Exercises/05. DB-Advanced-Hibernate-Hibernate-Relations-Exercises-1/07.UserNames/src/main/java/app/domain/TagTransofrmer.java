package app.domain;


public class TagTransofrmer {

    private static final Integer MAX_TAG_LENGTH  = 20;

    public static String transform(String tag){
        String resultTag = tag;
        if(resultTag.length() == 0){
            resultTag = "#";
        }

        if(! resultTag.substring(0, 1).equals("#")){
            resultTag = "#" + resultTag;
        }

        resultTag = resultTag.replaceAll("\\s+", "");

        if(resultTag.length() > MAX_TAG_LENGTH){
            resultTag = resultTag.substring(0, MAX_TAG_LENGTH);
        }

        return resultTag;
    }
}
