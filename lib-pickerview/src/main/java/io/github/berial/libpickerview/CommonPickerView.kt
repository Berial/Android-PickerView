package io.github.berial.libpickerview

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.bigkoo.pickerview.configure.PickerOptions
import com.bigkoo.pickerview.view.BasePickerView
import io.github.berial.libpickerview.common.WheelOptions

/**
 *
 * @author Berial
 * @date 2020/8/13
 */
class CommonPickerView<T>(private val options: Options<T>) : BasePickerView(options.context), View.OnClickListener {

    companion object {
        private const val TAG_SUBMIT = "submit"
        private const val TAG_CANCEL = "cancel"
    }

    private lateinit var wheelOptions: WheelOptions<T>

    init {
        mPickerOptions = PickerOptions(PickerOptions.TYPE_PICKER_TIME).apply {
            cancelable = options.cancelable
        }

        initView(options.context)
    }

    override fun isDialog() = true

    override fun onClick(v: View?) {
        v?.let {
            val tag = v.tag
            when (tag as String) {
                TAG_SUBMIT -> options.callback?.invoke(wheelOptions.currentItemIndex, wheelOptions.currentItem)
                TAG_CANCEL -> options.cancelListener?.onClick(v)
                else -> Unit
            }
        }
        dismiss()
    }

    private fun initView(context: Context?) {
        setDialogOutSideCancelable()
        initViews()
        initAnim()
        initEvents()

        LayoutInflater.from(context).inflate(R.layout.pickerview_common, contentContainer)

        (findViewById(R.id.btnSubmit) as Button).apply {
            tag = TAG_SUBMIT
            setOnClickListener(this@CommonPickerView)

            text = when {
                TextUtils.isEmpty(options.textContentConfirm) -> "确定"
                else -> options.textContentConfirm
            }

            setTextColor(options.textColorConfirm)
            textSize = options.textSizeSubmitCancel.toFloat()
        }

        (findViewById(R.id.btnCancel) as Button).apply {
            tag = TAG_CANCEL
            setOnClickListener(this@CommonPickerView)

            text = when {
                TextUtils.isEmpty(options.textContentCancel) -> "取消"
                else -> options.textContentCancel
            }

            setTextColor(options.textColorCancel)
            textSize = options.textSizeSubmitCancel.toFloat()
        }

        (findViewById(R.id.tvTitle) as TextView).apply {
            text = when {
                TextUtils.isEmpty(options.textContentTitle) -> ""
                else -> options.textContentTitle
            }

            setTextColor(options.textColorTitle)
            textSize = options.textSizeTitle.toFloat()
        }

        (findViewById(R.id.rv_topbar) as RelativeLayout).apply {
            setBackgroundColor(options.bgColorTitle)
        }


        // ----滚轮布局
        val container = findViewById(R.id.container) as LinearLayout
        container.setBackgroundColor(options.bgColorWheel)

        wheelOptions = WheelOptions(container)

        options.data?.let {
            wheelOptions.setData(it)
        }
        wheelOptions.setTextContentSize(options.textSizeContent)
        wheelOptions.setItemsVisible(options.itemsVisibleCount)
        wheelOptions.setAlphaGradient(options.isAlphaGradient)
        wheelOptions.setUnit(options.label)
        wheelOptions.setTextXOffset(options.xOffset)
        wheelOptions.setCyclic(options.cyclic)
        wheelOptions.setTypeface(options.font)

        setOutSideCancelable(options.cancelable)

        wheelOptions.setDividerColor(options.dividerColor)
        wheelOptions.setDividerType(options.dividerType)
        wheelOptions.setLineSpacingMultiplier(options.lineSpacingMultiplier)
        wheelOptions.setTextColorOut(options.textColorOut)
        wheelOptions.setTextColorCenter(options.textColorCenter)
        wheelOptions.isCenterLabel(options.isCenterLabel)
    }
}