package io.github.berial.libpickerview

import android.view.View
import com.bigkoo.pickerview.listener.CustomListener
import com.contrarywind.view.WheelView

/**
 *
 * @author Berial
 * @date 2020/8/13
 */
interface PickerBuilder {

    var cancelText: String
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var submitText: String
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var titleText: String
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var submitColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var cancelColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var titleColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var bgColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var titleBgColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var contentTextSize: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var subCalSize: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var outSideCancelable: Boolean
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var itemVisibleCount: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var isAlphaGradient: Boolean
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var lineSpacingMultiplier: Float
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var dividerColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var dividerType: WheelView.DividerType
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var outSideColor: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var textColorCenter: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var textColorOut: Int
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var isCenterLabel: Boolean
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    var cancelListener: View.OnClickListener
        @Deprecated(Internals.NO_GETTER, level = DeprecationLevel.ERROR) get

    fun setLayoutRes(res: Int, listener: CustomListener)
}