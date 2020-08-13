package io.github.berial.libpickerview

/**
 *
 * @author Berial
 * @date 2020/8/13
 */
open class PickerException(message: String = "") : RuntimeException(message)

object Internals {

    const val NO_GETTER: String = "Property does not have a getter"

    fun noGetter(): Nothing = throw PickerException("Property does not have a getter")

}