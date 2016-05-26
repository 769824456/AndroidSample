package win.yulongsun.uikit;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * ┏┓　　　┏┓
 *┏┛┻━━━┛┻┓
 *┃　　　　　　　┃ 　
 *┃　　　━　　　┃
 *┃　┳┛　┗┳　┃
 *┃　　　　　　　┃
 *┃　　　┻　　　┃
 *┃　　　　　　　┃
 *┗━┓　　　┏━┛
 *  ┃　　　┃   神兽保佑　　　　　　　　
 *  ┃　　　┃   代码无BUG！
 *  ┃　　　┗━━━┓
 *  ┃　　　　　　　┣┓
 *  ┃　　　　　　　┏┛
 *  ┗┓┓┏━┳┓┏┛
 *    ┃┫┫　┃┫┫
 *    ┗┻┛　┗┻┛
 * @Project AndroidSample
 * @Packate win.yulongsun.uikit
 * @Author yulongsun
 * @Email yulongsun@gmail.com
 * @Date 2016/5/26
 * @Version 1.0.0
 * @Description
 */
public class TextViewMust extends TextView {
    public TextViewMust(Context context) {
        super(context);
    }

    public TextViewMust(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextViewMust(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP) public TextViewMust(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }



}
