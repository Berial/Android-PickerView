package io.github.berial.libpickerview.common

import android.graphics.Typeface
import android.view.View
import com.bigkoo.pickerview.adapter.ArrayWheelAdapter
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener
import com.contrarywind.listener.OnItemSelectedListener
import com.contrarywind.view.WheelView
import com.contrarywind.view.WheelView.DividerType
import io.github.berial.libpickerview.R
import kotlinx.android.synthetic.main.pickerview_common.view.*
import org.jetbrains.anko.find

/**
 *
 * @author Berial
 * @date 2020/8/13
 */
class WheelOptions<T>(val view: View) {

    private var wheelView: WheelView = view.find(R.id.wheel)

    private var mItems = arrayListOf<T>()

    private var wheelListener: OnItemSelectedListener? = null

    var currentItemIndex: Int
        get() = wheelView.currentItem
        set(value) {
            wheelView.currentItem = value
        }

    val currentItem: T
        get() = mItems[wheelView.currentItem]


    fun setData(items: List<T>) {
        mItems.addAll(items)

        wheelView.adapter = ArrayWheelAdapter(mItems) // 设置显示数据
        wheelView.currentItem = 0 // 初始化时显示的数据
        wheelView.setIsOptions(true)

        wheelListener?.onItemSelected(wheelView.currentItem)
    }

    fun setTextContentSize(textSize: Int) {
        wheelView.setTextSize(textSize.toFloat())
    }

    /**
     * 设置选项的单位
     *
     * @param unit 单位
     */
    fun setUnit(unit: String?) {
        wheelView.setLabel(unit)
    }

    /**
     * 设置x轴偏移量
     */
    fun setTextXOffset(xOffset: Int) {
        wheelView.setTextXOffset(xOffset)
    }

    /**
     * 设置是否循环滚动
     *
     * @param cyclic 是否循环
     */
    fun setCyclic(cyclic: Boolean) {
        wheelView.setCyclic(cyclic)
    }

    /**
     * 设置字体样式
     *
     * @param font 系统提供的几种样式
     */
    fun setTypeface(font: Typeface?) {
        wheelView.setTypeface(font)
    }

    /**
     * 设置间距倍数,但是只能在1.2-4.0f之间
     *
     * @param lineSpacingMultiplier
     */
    fun setLineSpacingMultiplier(lineSpacingMultiplier: Float) {
        wheelView.setLineSpacingMultiplier(lineSpacingMultiplier)
    }

    /**
     * 设置分割线的颜色
     *
     * @param dividerColor
     */
    fun setDividerColor(dividerColor: Int) {
        wheelView.setDividerColor(dividerColor)
    }

    /**
     * 设置分割线的类型
     *
     * @param dividerType
     */
    fun setDividerType(dividerType: DividerType?) {
        wheelView.setDividerType(dividerType)
    }

    /**
     * 设置分割线之间的文字的颜色
     *
     * @param textColorCenter
     */
    fun setTextColorCenter(textColorCenter: Int) {
        wheelView.setTextColorCenter(textColorCenter)
    }

    /**
     * 设置分割线以外文字的颜色
     *
     * @param textColorOut
     */
    fun setTextColorOut(textColorOut: Int) {
        wheelView.setTextColorOut(textColorOut)
    }

    /**
     * Label 是否只显示中间选中项的
     *
     * @param isCenterLabel
     */
    fun isCenterLabel(isCenterLabel: Boolean) {
        wheelView.isCenterLabel(isCenterLabel)
    }

    /**
     * 设置最大可见数目
     *
     * @param itemsVisible 建议设置为 3 ~ 9之间。
     */
    fun setItemsVisible(itemsVisible: Int) {
        wheelView.setItemsVisibleCount(itemsVisible)
    }

    fun setAlphaGradient(isAlphaGradient: Boolean) {
        wheelView.setAlphaGradient(isAlphaGradient)
    }
}