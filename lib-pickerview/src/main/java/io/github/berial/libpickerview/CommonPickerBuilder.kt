package io.github.berial.libpickerview

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import com.bigkoo.pickerview.listener.CustomListener
import com.contrarywind.view.WheelView

/**
 *
 * @author Berial
 * @date 2020/8/13
 */
class CommonPickerBuilder<T>(context: Context) : PickerBuilder {

    private val options = Options<T>()

    init {
        options.context = context
    }

    var data: List<T>
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.data = value
        }

    var callback: (Int, T) -> Unit
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.callback = value
        }

    override var cancelText: String
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.textContentCancel = value
        }

    override var submitText: String
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.textContentConfirm = value
        }

    override var titleText: String
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.textContentTitle = value
        }

    override var submitColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.textColorConfirm = value
        }

    override var cancelColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.textColorCancel = value
        }

    override var titleColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.textColorTitle = value
        }

    override var bgColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.bgColorWheel = value
        }

    override var titleBgColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.bgColorTitle = value
        }

    override var contentTextSize: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.textSizeContent = value
        }

    override var subCalSize: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.textSizeSubmitCancel = value
        }

    override var outSideCancelable: Boolean
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.cancelable = value
        }

    override var itemVisibleCount: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.itemsVisibleCount = value
        }

    override var isAlphaGradient: Boolean
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.isAlphaGradient = value
        }

    override var lineSpacingMultiplier: Float
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.lineSpacingMultiplier = value
        }

    override var dividerColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.dividerColor = value
        }

    override var dividerType: WheelView.DividerType
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.dividerType = value
        }

    override var outSideColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.outSideColor = value
        }

    override var textColorCenter: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.textColorCenter = value
        }

    override var textColorOut: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.textColorOut = value
        }

    override var isCenterLabel: Boolean
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.isCenterLabel = value
        }

    override var cancelListener: View.OnClickListener
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get() = Internals.noGetter()
        set(value) {
            options.cancelListener = value
        }

    @Deprecated("no used", ReplaceWith("Unit"))
    override fun setLayoutRes(res: Int, listener: CustomListener) = Unit

    fun build() = CommonPickerView<T>(options)

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
                val params = w.attributes
                params.width = it.context.resources.displayMetrics.widthPixels
                w.attributes = params
            }
        }

        view.show()
    }
}