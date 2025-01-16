package io.github.toma910248.android.inputfilter.example.ui.main

import android.os.Bundle
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import io.github.toma910248.android.inputfilter.DecimalInputFilter
import io.github.toma910248.android.inputfilter.RegexValidation
import io.github.toma910248.android.inputfilter.ValidationInputFilter
import io.github.toma910248.android.inputfilter.example.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val examples = arrayOf(
            generatorExample("Integer ###", DecimalInputFilter(3, 0)),
            generatorExample("Decimal ###.#", DecimalInputFilter(3, 1)),
            generatorExample("Decimal ###.##", DecimalInputFilter(3, 2)),
            generatorExample("HEX regex", RegexValidation("[0-9A-Fa-f]*")),
            generatorExample("Reject \"hello\"", RegexValidation("((?!hello).)*")),
            generatorExample("Start with \"@\"", object : ValidationInputFilter() {
                override fun validate(newText: CharSequence, oldText: CharSequence): Boolean {
                    return newText.isEmpty() || newText.startsWith("@")
                }
            }),
        )

        val examplesLayout = requireView().findViewById<LinearLayout>(R.id.examplesLayout)
        examples.forEach { examplesLayout.addView(it) }
    }

    private fun generatorExample(label: String, filter: InputFilter): View {
        val editText = TextInputEditText(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            isTextInputLayoutFocusedRectEnabled = false
            hint = label
            filters = arrayOf(filter)
        }
        val inputLayout = TextInputLayout(requireContext()).apply {
            boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_NONE
            addView(editText)
        }

        return inputLayout
    }
}