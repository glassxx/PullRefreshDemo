package cn.glassxx.pullrefresh.principle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.Scroller;

/**
 * the principle of pull refresh
 * 下拉刷新的原理解析
 * Created by glassx on 3/3/18.
 */

/***
 * Scroller是一个帮助View滚动的辅助类,在使用之前,用户需要通过startScroll来设置滚动的参数,
 * 即起始点坐标和(x,y)轴上要滚动的距离.Scroller封装了滚动时间、要滚动的目标x轴和y轴，以及在每个时间内View应该滚动
 * 到的（x，y）轴的坐标点，这样用户可以在有效的滚动周期内通过Scroller的getCurX（）和getCueY（）
 * 来获取当前时刻View应该滚动的位置，然后通过调用View的scrollTo或者scrollBy方法进行滚动。如何判断滚动结束呢？
 * 我们只需要覆写View的computeScroll方法，该方法会在View绘制的时候被调用，在里面调用Scroller的computeScrollOffset
 * 来判断滚动是否完成，如果返回true表明滚动完成，否则完成。上述说的scrollTo或者scrollBy的调用就
 * 是在computeScrollOffset位true的情况下调用，并且最后还要调用目标View的postInvalidate（）或者invalidate（）以
 * 实现View的重绘，View的重绘又会导致computeScroll方法被调用，从而继续整个滚动过程，直至computeScroll返回false，即滚动结束。
 */

public class ScrollLayout extends FrameLayout{
    private Scroller mScroller;

    public ScrollLayout(@NonNull Context context) {
        super(context);
        init(context);
    }

    public ScrollLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(@NonNull Context context){
        mScroller = new Scroller(context);
//        setBackgroundColor(Color.RED);
    }

    @Override
    public void computeScroll() {
        if(mScroller.computeScrollOffset()){
            this.scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            //request invalidate this view,android then will call computeScroll(),and still scroll,
            //until mScroller.computeScrollOffset() = false
            this.postInvalidate();

        }
        super.computeScroll();
    }

    public void scrollTo(int y){
        //it only show the principle of scroll,so we only scroll y,
        //and x is so on
        mScroller.startScroll(getScrollX(),getScrollY(),0,y);
        this.invalidate();
    }
}
