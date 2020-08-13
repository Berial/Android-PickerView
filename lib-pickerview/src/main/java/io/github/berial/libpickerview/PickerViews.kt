package io.github.berial.libpickerview

import android.app.SearchManager
import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.bigkoo.pickerview.listener.CustomListener
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener
import com.contrarywind.view.WheelView
import io.github.berial.libpickerview.Internals.NO_GETTER
import java.util.*
import com.bigkoo.pickerview.builder.TimePickerBuilder as Builder

/**
 *
 * @author Berial
 * @date 2020/8/13
 */
fun Context.timePicker(init: TimePickerBuilder.() -> Unit): TimePickerBuilder =
    TimePickerBuilder(this).apply { init() }

fun <T> Context.optionsPicker(init: OptionsPickerBuilder<T>.() -> Unit): OptionsPickerBuilder<T> =
    OptionsPickerBuilder<T>(this).apply { init() }

fun <T> Context.picker(init: CommonPickerBuilder<T>.()->Unit): CommonPickerBuilder<T> =
    CommonPickerBuilder<T>(this).apply { init() }