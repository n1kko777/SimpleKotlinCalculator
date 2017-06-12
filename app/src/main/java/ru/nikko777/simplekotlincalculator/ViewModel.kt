package ru.nikko777.simplekotlincalculator

import android.databinding.BaseObservable
import android.databinding.Bindable

/**
 * Created by User on 09.06.2017.
 */

class ViewModel : BaseObservable() {


    @get:Bindable
     var textView = ""
        set(textView) {
            field = textView
            notifyPropertyChanged(BR.textView)
        }
}
