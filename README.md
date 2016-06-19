![](https://github.com/ruzhan123/ScrollerDemo/raw/master/gif/123.gif)


###Scroller的使用，让View随心所欲的移动吧

###Scroller能控制View自由的移动，相对于其他让View移动的api，例如ViewDragHelper，我个人倾向于使用Scroller，因为他使用起来简单，感觉更灵活一些。


###值得注意的是，在一个View使用Scroller是不能让这个View移动的，需要在ViewGroup或者他的子类里使用Scroller，才能让ViewGroup里的所有子View一起移动起来。


###1，首先，在ViewGroup中创建Scroller对象。

    public class ScrollViewGroup extends FrameLayout {
    private static final String TAG = ScrollViewGroup.class.getSimpleName();
    private Scroller mScroller;
    private int mHeight;
    private int mWidth;
    
    public ScrollViewGroup(Context context) {
        super(context);
        init();
    }
    
    public ScrollViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    
    public ScrollViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    
    private void init() {
        mScroller = new Scroller(getContext());
    }


###2，其次，复写View的 computeScroll() 方法

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

###3，然后，使用Scroller，让ViewGroup的子View移动起来


    public void smoothScrollTo(int startX, int startY, int dx, int dy, int duration) {
        mScroller.startScroll(startX, startY, dx, dy, duration);
        invalidate();
    }


