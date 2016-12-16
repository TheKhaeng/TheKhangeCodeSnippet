/****************************************/
/** Created by TheKhaeng on 7/10/2016. **/
/****************************************/

______________________________________________________________________________
// [ Overview ]
// SwitchView --> PagerAdapter(){...}
// SwitchFragment --> FragmentPagerAdapter(){...}
//                --> FragmentStatePagerAdapter(){...} save state
______________________________________________________________________________

ViewPager viewPager = (ViewPager) getActivity().findViewById( R.id.viewPager );

private void switchViewOnly(){
    viewPager.setAdapter( new PagerAdapter(){
        @Override
        public int getCount(){
            // How many page?
            return 3;
        }

        @Override
        public boolean isViewFromObject( View view, Object object ){
            return view == object;
        }

        @Override
        public Object instantiateItem( ViewGroup container, int position ){
            // Example view
            Button btn = new Button( container.getContext() );
            btn.setText( "Position: "+ position );
            container.addView( btn );
            return btn;
        }

        @Override
        public void destroyItem( ViewGroup container, int position, Object object ){
            // object is "btn object" that we return in instantiateItem(...) method.
            // (View) object removed cannot restore state, "must manual restore by self"
            container.removeView( (View) object );
        }
    } );
}

______________________________________________________________________________
// [ Switch Fragment ]

// if you use ViewPager in Fragment you must use getChildFragmentManager()
// for use FragmentManager itself because every Fragment has own FragmentManager.

mPagerAdapter = new ScreenSlidePagerAdapter( getChildFragmentManager() );
viewPager.setAdapter( mPagerAdapter );
private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{

    public static final int NUM_PAGES = 2;

    public ScreenSlidePagerAdapter( FragmentManager fm ){
        super( fm );
    }

    @Override
    public Fragment getItem( int position ){
        switch( position ){
            case 0:
                return Fragment1.newInstance();
            case 1:
                return Fragment2.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount(){
        return NUM_PAGES;
    }
}
