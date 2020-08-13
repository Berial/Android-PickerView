package io.github.berial.pickerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bigkoo.pickerview.listener.CustomListener
import io.github.berial.libpickerview.optionsPicker
import io.github.berial.libpickerview.picker
import io.github.berial.libpickerview.timePicker
import org.jetbrains.anko.alert
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        find<Button>(R.id.btn1).setOnClickListener {
            timePicker {
                callback = {
                    toast(it.toString())
                }

                show()
            }
        }

        find<Button>(R.id.btn2).setOnClickListener {
            optionsPicker<String> {

                callback = { option1, option2, option3 ->
                    toast(it.toString())
                }

                setData(listOf("xx"), listOf("xxxx"), listOf("xxxxx"))

                show()
            }
        }

        find<Button>(R.id.btn3).setOnClickListener {
            picker<String> {

                callback = { index, item ->
                    toast("index: $index, item: $item")
                }

                data = listOf("xxx", "xxxx", "xxxxx")


                show()
            }
        }
    }
}