/****************************************/
/** Created by TheKhaeng on 7/20/2016. **/
/****************************************/

public class FriendListAdapter extends BaseAdapter{
    ...

    private class ViewHolder {
        TextView name;
        TextView species;
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent ) {
        final ViewHolder holder;
        if( convertView == null ) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from( getContext() ).inflate( R.layout.view_exhibit_list_item, parent, false );

            holder.name = (TextView) convertView.findViewById( R.id.name );
            holder.species = (TextView) convertView.findViewById( R.id.species );
            convertView.setTag( holder );
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText( getItem( position ).getName() );
        holder.species.setText( getItem( position ).getSpecies() );
        return convertView;
    }
}
