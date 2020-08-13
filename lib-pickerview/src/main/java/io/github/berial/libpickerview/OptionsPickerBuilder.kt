package io.github.berial.libpickerview

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import com.bigkoo.pickerview.builder.OptionsPickerBuilder
import com.bigkoo.pickerview.listener.CustomListener
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener
import com.bigkoo.pickerview.view.OptionsPickerView
import com.contrarywind.view.WheelView

/**
 *
 * @author Berial
 * @date 2020/8/13
 */
class OptionsPickerBuilder<T>(context: Context) : PickerBuilder {

    private val builder = OptionsPickerBuilder(context) { item1, item2, item3, _ ->
        c?.invoke(item1, item2, item3)
    }

    private var c: ((Int, Int, Int) -> Unit)? = null

    private val items1 = arrayListOf<T>()
    private val items2 = arrayListOf<T>()
    private val items3 = arrayListOf<T>()

    init {
        builder.isDialog(true)
    }

    var callback: (Int, Int, Int) -> Unit
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            c = value
        }

    var optionsSelectChangeListener: OnOptionsSelectChangeListener
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.setOptionsSelectChangeListener(value)
        }

    var isRestoreItem: Boolean
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            builder.isRestoreItem(value)
        }

    override var titleText: String
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
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

    fun setLabels(label1: String, label2: String, label3: String) {
        builder.setLabels(label1, label2, label3)
    }

    fun setTextXOffset(offset1: Int, offset2: Int, offset3: Int) {
        builder.setTextXOffset(offset1, offset2, offset3)
    }

    fun setCyclic(cyclic1: Boolean, cyclic2: Boolean, cyclic3: Boolean) {
        builder.setCyclic(cyclic1, cyclic2, cyclic3)
    }

    fun setSelectOptions(option1: Int, option2: Int = 0, option3: Int = 0) {
        builder.setSelectOptions(option1, option2, option3)
    }

    fun setData(items1: List<T>, items2: List<T>, items3: List<T>) {
        this.items1.addAll(items1)
        this.items2.addAll(items2)
        this.items3.addAll(items3)
    }

    fun build(): OptionsPickerView<T> {
        val picker = builder.build<T>()
        picker.setNPicker(items1, items2, items3)
        return picker
    }
}
