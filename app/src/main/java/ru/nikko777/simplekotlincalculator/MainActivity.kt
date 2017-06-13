package ru.nikko777.simplekotlincalculator

import android.app.Activity
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.Toast
import ru.nikko777.simplekotlincalculator.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : Activity() {

    private var valueOne: Double? = null
    private var valueTwo: Double? = null

    private var plus: Boolean? = null
    private var minus: Boolean? = null
    private var umn: Boolean? = null
    private var div: Boolean? = null

    private var decimalFormat: DecimalFormat? = null
    private var binding: ActivityMainBinding? = null

    val model : ViewModel = ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding!!.setModel(model)
        decimalFormat = DecimalFormat("#.##########")

        inic_value()
        inic_oper()
    }

    private fun inic_oper(){

        //Operation
        binding!!.btplus.setOnClickListener{
            try{
                valueOne=java.lang.Double.parseDouble(model!!.textView+"")
                plus=true
                model!!.textView=""

            }catch(e:Exception){
                Toast.makeText(this@MainActivity,"Incorrectvalue!",Toast.LENGTH_SHORT).show()
            }
        }

        binding!!.btminus.setOnClickListener{
            try{
                valueOne=java.lang.Double.parseDouble(model!!.textView+"")
                minus=true
                model!!.textView=""

            }catch(e:Exception){
                Toast.makeText(this@MainActivity,"Incorrectvalue!",Toast.LENGTH_SHORT).show()
            }
        }

        binding!!.btmulty.setOnClickListener{
            try{
                valueOne=java.lang.Double.parseDouble(model!!.textView+"")
                umn=true
                model!!.textView=""

            }catch(e:Exception){
                Toast.makeText(this@MainActivity,"Incorrectvalue!",Toast.LENGTH_SHORT).show()
            }
        }

        binding!!.btdivide.setOnClickListener{
            try{
                valueOne=java.lang.Double.parseDouble(model!!.textView+"")
                div=true
                model!!.textView=""

            }catch(e:Exception){
                Toast.makeText(this@MainActivity,"Incorrectvalue!",Toast.LENGTH_SHORT).show()
            }
        }

        binding!!.btequal.setOnClickListener{
            try{

                valueTwo=java.lang.Double.parseDouble(model!!.textView+"")
                computeCalculation()

            }catch(e:Exception){
                Toast.makeText(this@MainActivity,"Incorrectvalue!",Toast.LENGTH_SHORT).show()
            }
        }

        binding!!.btclear.setOnClickListener{
            model!!.textView=""
            valueOne=null
            valueTwo=null
        }
    }

    private fun inic_value(){

        //Value
        binding!!.btdote.setOnClickListener{model!!.textView=model!!.textView+"."}

        binding!!.btzero.setOnClickListener{model!!.textView=model!!.textView+"0"}

        binding!!.btone.setOnClickListener{model!!.textView=model!!.textView+"1"}

        binding!!.bttwo.setOnClickListener{model!!.textView=model!!.textView+"2"}

        binding!!.btthre.setOnClickListener{model!!.textView=model!!.textView+"3"}

        binding!!.btfour.setOnClickListener{model!!.textView=model!!.textView+"4"}

        binding!!.btfive.setOnClickListener{model!!.textView=model!!.textView+"5"}

        binding!!.btsix.setOnClickListener{model!!.textView=model!!.textView+"6"}

        binding!!.btseven.setOnClickListener{model!!.textView=model!!.textView+"7"}

        binding!!.bteight.setOnClickListener{model!!.textView=model!!.textView+"8"}

        binding!!.btnine.setOnClickListener{model!!.textView=model!!.textView+"9"}

    }


    private fun computeCalculation(){

        if(plus==true){
            model!!.textView=decimalFormat!!.format(valueOne!!+valueTwo!!)
            plus=false
        }
        if(minus==true){
            model!!.textView=decimalFormat!!.format(valueOne!!-valueTwo!!)
            minus=false

        }
        if(umn==true){
            model!!.textView=decimalFormat!!.format(valueOne!!*valueTwo!!)
            umn=false

        }
        if(div==true){
            model!!.textView=decimalFormat!!.format(valueOne!!/valueTwo!!)
            div=false

        }
    }
}