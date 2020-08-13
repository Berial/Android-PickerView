package io.github.berial.libpickerview

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.CustomListener
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener
import com.contrarywind.view.WheelView
import java.util.*

/**
 *
 * @author Berial
 * @date 2020/8/13
 */
class TimePickerBuilder(context: Context) : PickerBuilder {

    private val builder = TimePickerBuilder(context) { date, _ ->
        c?.invoke(date)
    }

    private var c: ((Date) -> Unit)? = null

    init {
        builder.isDialog(true)
    }

    var callback: (Date) -> Unit
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            c = value
        }

    var type: BooleanArray
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setType(value)
        }

    var gravity: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setGravity(value)
        }

    var isCyclic: Boolean
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.isCyclic(value)
        }

    var isLunarCalendar: Boolean
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setLunarCalendar(value)
        }

    var timeSelectChangeListener: OnTimeSelectChangeListener
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setTimeSelectChangeListener(value)
        }

    override var titleText: String
        get() = TODO("not implemented")
        set(value) {
            builder.setTitleText(value)
        }

    override var cancelText: String
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setCancelText(value)
        }

    override var submitText: String
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setSubmitText(value)
        }

    override var cancelColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setCancelColor(value)
        }

    override var submitColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setSubmitColor(value)
        }

    override var titleColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setTitleColor(value)
        }

    override var bgColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setBgColor(value)
        }

    override var titleBgColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setTitleBgColor(value)
        }

    override var contentTextSize: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setContentTextSize(value)
        }

    override var subCalSize: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setSubCalSize(value)
        }

    override var outSideCancelable: Boolean
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setOutSideCancelable(value)
        }

    override var itemVisibleCount: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setItemVisibleCount(value)
        }

    override var isAlphaGradient: Boolean
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.isAlphaGradient(value)
        }

    override var lineSpacingMultiplier: Float
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setLineSpacingMultiplier(value)
        }

    override var dividerColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setDividerColor(value)
        }

    override var dividerType: WheelView.DividerType
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setDividerType(value)
        }

    override var outSideColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setOutSideColor(value)
        }

    override var textColorCenter: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setTextColorCenter(value)
        }

    override var textColorOut: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setTextColorOut(value)
        }

    override var isCenterLabel: Boolean
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.isCenterLabel(value)
        }

    override var cancelListener: View.OnClickListener
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.addOnCancelClickListener(value)
        }

    fun show() {
        val view = build()

        view.dialog?.let {
            val lp = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT,
                Gravity.BOTTOM
            ).apply {
                leftMargin = 0
                rightMargin = 0
            }

            view.dialogContainerLayout.layoutParams = lp

            it.window?.let { w ->
                w.setWindowAnimations(R.style.Animation_Design_BottomSheetDialog)
                w.setGravity(Gravity.BOTTOM)
            }
        }

        view.show()
    }

    override fun setLayoutRes(res: Int, listener: CustomListener) {
        builder.setLayoutRes(res, listener)
    }

    fun setDate(date: Calendar) {
        builder.setDate(date)
    }

    fun setRangeDate(start: Calendar, end: Calendar) {
        builder.setRangDate(start, end)
    }

    fun setLabels(year: String, month: String, day: String, hour: String, minute: String, second: String) {
        builder.setLabel(year, month, day, hour, minute, second)
    }

    fun setTextXOffset(year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int) {
        builder.setTextXOffset(year, month, day, hour, minute, second)
    }

    fun build() = builder.build()
}