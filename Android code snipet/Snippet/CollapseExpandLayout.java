/****************************************/
/** Created by TheKhaeng on 9/22/2016. **/
/****************************************/

    public void expand(){
        //set Visible
        llCreditCard.setVisibility( View.VISIBLE );

        final int widthSpec = View.MeasureSpec.makeMeasureSpec( 0, View.MeasureSpec.UNSPECIFIED );
        final int heightSpec = View.MeasureSpec.makeMeasureSpec( 0, View.MeasureSpec.UNSPECIFIED );
        llCreditCard.measure( widthSpec, heightSpec );

        ValueAnimator mAnimator = slideAnimator( 0, llCreditCard.getMeasuredHeight(), llCreditCard );
        mAnimator.start();
    }

    public void collapse(){
        int finalHeight = llCreditCard.getHeight();
        ValueAnimator mAnimator = slideAnimator( finalHeight, 0, llCreditCard );

        mAnimator.addListener( collapseListener );
        mAnimator.start();
    }

    private ValueAnimator slideAnimator( int start, int end, final View v ){
        ValueAnimator animator = ValueAnimator.ofInt( start, end );

        ValueAnimator.AnimatorUpdateListener slideAnimationListener = new ValueAnimator.AnimatorUpdateListener(){
            @Override
            public void onAnimationUpdate( ValueAnimator valueAnimator ){
                //Update Height
                int value = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                layoutParams.height = value;
                v.setLayoutParams( layoutParams );
            }
        };
        animator.addUpdateListener( slideAnimationListener );
        return animator;
    }

    /**************/
    /** Listener **/
    /**************/
    //<editor-fold desc="Listener folding">
    private Animator.AnimatorListener collapseListener = new Animator.AnimatorListener(){
        @Override
        public void onAnimationStart( Animator animation ){

        }

        @Override
        public void onAnimationEnd( Animator animator ){
            //Height=0, but it set visibility to GONE
            llCreditCard.setVisibility( View.GONE );
        }

        @Override
        public void onAnimationCancel( Animator animation ){

        }

        @Override
        public void onAnimationRepeat( Animator animation ){

        }
    };

    //</editor-fold desc="Inner class folding">
