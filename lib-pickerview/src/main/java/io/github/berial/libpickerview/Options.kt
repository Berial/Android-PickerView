package io.github.berial.libpickerview

import android.content.Context
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.bigkoo.pickerview.listener.*
import com.contrarywind.view.WheelView.DividerType
import java.util.*

/**
 *
 * @author Berial
 * @date 2020/8/13
 */
class Options<T> {

    companion object {
        //constant
        private const val PICKER_VIEW_BTN_COLOR_NORMAL = -0xfa8201
        private const val PICKER_VIEW_BG_COLOR_TITLE = -0xa0a0b
        private const val PICKER_VIEW_COLOR_TITLE = -0x1000000
        private const val PICKER_VIEW_BG_COLOR_DEFAULT = -0x1
    }

    var cancelListener: View.OnClickListener? = null

    var callback: ((Int, T) -> Unit)? = null

    var data: List<T>? = null

    //options picker
    var label: String? = null  //options picker

    var option = 0 //默认选中项
    var xOffset = 0 //x轴偏移量

    var cyclic = false //是否循环，默认否

    //******* general field ******//
    var layoutRes = 0
    var decorView: ViewGroup? = null
    var textGravity = Gravity.CENTER
    var context: Context? = null

    var textContentConfirm: String? = null //确定按钮文字

    var textContentCancel: String? = null //取消按钮文字

    var textContentTitle: String? = null //标题文字

    var textColorConfirm = PICKER_VIEW_BTN_COLOR_NORMAL //确定按钮颜色

    var textColorCancel = PICKER_VIEW_BTN_COLOR_NORMAL //取消按钮颜色

    var textColorTitle = PICKER_VIEW_COLOR_TITLE //标题颜色

    var bgColorWheel = PICKER_VIEW_BG_COLOR_DEFAULT //滚轮背景颜色

    var bgColorTitle = PICKER_VIEW_BG_COLOR_TITLE //标题背景颜色

    var textSizeSubmitCancel = 17 //确定取消按钮大小

    var textSizeTitle = 18 //标题文字大小

    var textSizeContent = 18 //内容文字大小

    var textColorOut = -0x575758 //分割线以外的文字颜色

    var textColorCenter = -0xd5d5d6 //分割线之间的文字颜色

    var dividerColor = -0x2a2a2b //分割线的颜色

    var outSideColor = -1 //显示时的外部背景色颜色,默认是灰色

    var lineSpacingMultiplier = 1.6f // 条目间距倍数 默认1.6

    var isDialog = false//是否是对话框模式

    var cancelable = true //是否能取消

    var isCenterLabel = false //是否只显示中间的label,默认每个item都显示

    var font = Typeface.MONOSPACE //字体样式

    var dividerType = DividerType.FILL //分隔线类型

    var itemsVisibleCount = 9 //最大可见条目数

    var isAlphaGradient = false //透明度渐变
}