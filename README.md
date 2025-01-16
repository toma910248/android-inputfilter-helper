# InputFilter

A Android **InputFilter** Example App

## Compatibility

Android 2.4 and later

### Source code

You can download and import the *inputfilter* folder as module to your project.

### Usage

```kotlin
// Integer ###
editText.filters = arrayOf(DecimalInputFilter(3, 0))

// Decimal ###.#
editText.filters = arrayOf(DecimalInputFilter(3, 1))

// usage regex
editText.filters = arrayOf(RegexValidation("[0-9A-Fa-f]*"))

// custom rule
editText.filters = arrayOf(object : ValidationInputFilter() {
    override fun validate(newText: CharSequence, oldText: CharSequence): Boolean {
        return newText.isEmpty() || newText.startsWith("@")
    }
})
```
