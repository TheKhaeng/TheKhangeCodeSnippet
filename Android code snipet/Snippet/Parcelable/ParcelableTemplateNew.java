/****************************************/
/** Created by TheKhaeng on 7/10/2016. **/
/****************************************/
______________________________________________________________________________
// [ Config ]
// Web: http://parceler.org/
// Gradle: compile 'org.parceler:parceler-api:1.1.5', apt 'org.parceler:parceler:1.1.5'
/** Progulard:
    # Parcel library
    -keep interface org.parceler.Parcel
    -keep @org.parceler.Parcel class * { *; }
    -keep class **$$Parcelable { *; }
**/
______________________________________________________________________________
@Parcel
public class Movie {
    // No private
    long id;
    String title;
    ...
    String urlReviews;
    String urlSimilar;

    @ParcelConstructor
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
}

// Wrap to Parrcelable
Parcelable wrapped = Parcels.wrap( new Movie( ... ) );
// Unwrap
Person movie = Parcels.unwrap(wrapped);


______________________________________________________________________________

// Example 1
@Override
protected void onSaveInstanceState(Bundle outState) {
    outState.putParcelable("person key", Parcels.wrap(person),);
    super.onSaveInstanceState(outState);
}
@Override
protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);

    person = Parcels.unwrap(savedInstanceState.getParcelable("person key"));
}
______________________________________________________________________________

// Example 2
Intent intent = new Intent();
intent.putExtra("person key", Parcels.wrap(person));

Intent intent = getIntent();
Person person = Parcels.unwrap(intent.getParcelableExtra("person key"));
______________________________________________________________________________
