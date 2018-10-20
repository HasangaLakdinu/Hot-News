package c.thenewboston.hotnews;

public class ExampleItem {
    private String mImageUrl;
    private String mTitle;
    private String mDate;
    private String mDescription;
    private String mAuthor;
    private String mUrl1;

    public String getmDescription() {
        return mDescription;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmUrl1() {
        return mUrl1;
    }

    public ExampleItem(String imageUrl, String Title, String datee, String Description, String author, String Url1){
        if(author.trim().equals("null")){
            author="Unknown";
        }


        String capturedDate=datee.substring(0,10);
        mImageUrl=imageUrl;
        mTitle=Title;
        mDate=capturedDate;
        mDescription=Description;
        mAuthor=author;
        mUrl1=Url1;

    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDate() {
        return mDate;
    }
}
