/****************************************/
/** Created by TheKhaeng on 7/20/2016. **/
/****************************************/

public class FriendListAdapter extends BaseAdapter{
    ...

    // AnimalView is CustomViewGroup.
    @Override
    public View getView( int position, View convertView, ViewGroup parent ) {
        AnimalView item;
        if( convertView == null ) {
            item = new AnimalView();
        } else {
            item = (AnimalView) convertView;
        }
        return item;
    }

}
