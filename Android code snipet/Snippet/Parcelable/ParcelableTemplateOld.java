/****************************************/
/** Created by TheKhaeng on 7/10/2016. **/
/****************************************/
______________________________________________________________________________
// NOTE: Parcelable not use Reflection
// 1: implements interface Parcelable.
// 2: convert any fields into Parcel ---> writeToParcel(...);
// 3: create CREATOR for convert back from Parcel to own object.
//    It's use Construtor(Parcel input){...}
______________________________________________________________________________

// 1: implements interface Parcelable
public class Movie implements Parcelable {
    private long id;
    private String title;
    ...
    private String urlReviews;
    private String urlSimilar;


    public Movie() {/* Required empty bean constructor */ }

    public Movie(Parcel input) {
        id = input.readLong();
        title = input.readString();
        ...
        urlReviews = input.readString();
        urlSimilar = input.readString();
    }

    public Movie(long id,
                 String title,
                 ...
                 String urlReviews,
                 String urlSimilar) {
        this.id = id;
        this.title = title;
        ...
        this.urlReviews = urlReviews;
        this.urlSimilar = urlSimilar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

// 2: convert any fields into Parcel in writeToParcel(...); method.
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        ...
        dest.writeString(urlReviews);
        dest.writeString(urlSimilar);

    }


// 3: create CREATOR for convert back from Parcel to own object.
    public static final Parcelable.Creator<Movie> CREATOR
            = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
