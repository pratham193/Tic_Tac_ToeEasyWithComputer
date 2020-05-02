package com.example.tic_tac_toeeasywithcomputer

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.RandomAccess

class MainActivity : AppCompatActivity() {
    var c:Int=0
    val buttons1 = ArrayList<Button>()
    val buttons = ArrayList<Button>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttons1.add(button)
        buttons1.add(button2)
        buttons1.add(button3)

        buttons1.add(button4)
        buttons1.add(button5)
        buttons1.add(button6)

        buttons1.add(button7)
        buttons1.add(button8)
        buttons1.add(button9)


        buttons.add(button)
        buttons.add(button2)
        buttons.add(button3)

        buttons.add(button4)
        buttons.add(button5)
        buttons.add(button6)

        buttons.add(button7)
        buttons.add(button8)
        buttons.add(button9)

        buttons.add(button)
        buttons.add(button4)
        buttons.add(button7)

        buttons.add(button2)
        buttons.add(button5)
        buttons.add(button8)

        buttons.add(button3)
        buttons.add(button6)
        buttons.add(button9)

        buttons.add(button)
        buttons.add(button5)
        buttons.add(button9)

        buttons.add(button3)
        buttons.add(button5)
        buttons.add(button7)

        button.setOnClickListener {
            clicked(button)
        }
        button2.setOnClickListener {
            clicked(button2)
        }
        button3.setOnClickListener {
            clicked(button3)
        }
        button4.setOnClickListener {
            clicked(button4)
        }
        button5.setOnClickListener {
            clicked(button5)
        }
        button6.setOnClickListener {
            clicked(button6)
        }
        button7.setOnClickListener {
            clicked(button7)
        }
        button8.setOnClickListener {
            clicked(button8)
        }
        button9.setOnClickListener {
            clicked(button9)
        }
        button10.setOnClickListener {
            for(i in 0 until buttons1.size){
                buttons1[i].text=""
                buttons1[i].setBackgroundColor(Color.GRAY)
                button10.visibility = View.INVISIBLE
                c=0

            }
        }


    }

    private fun clicked(button: Button) {
        if (button.text == "") {
            if(c!=8) {
                button.text = "X"
                c++
            }
            else {
                c=0
                button.text=" "

                button10.text="Reset"
                button10.visibility = View.VISIBLE
            }
        }
        var p =0
        for( i in 0..7)
        {
            if((buttons[p].text !="")&&(buttons[p].text == buttons[p+1].text) && (buttons[p+1].text==buttons[p+2].text)){
                found(p)

            }else p+=3

        }
        if(c%2!=0) {
            val entry:Button =computerEntry()
            entry.text="O"
            c++

        }
        return
    }




    private fun computerEntry(): Button {
        var btn:Button
        var  a=Random().nextInt(8)
        while(buttons1[a].text!=""){
            a=Random().nextInt(8)
        }
        btn=buttons1[a]



        if(c>2){
            var p =0
            loop@ for( i in 0..7) {


                if(((buttons[p].text=="")&&(buttons[p+1].text == buttons[p+2].text))) {
                    when(buttons[p+2].text){
                        "O" -> {
                            btn = buttons[p]
                            found(p)
                            return btn
                        }
                        "X"-> btn = buttons[p]
                        else -> {
                            p += 3
                            continue@loop
                        }

                    }
                }else{

                    if(((buttons[p+1].text=="")&&(buttons[p].text == buttons[p+2].text))) {
                        when(buttons[p+2].text){
                            "O" -> {
                                btn = buttons[p+1]
                                found(p)
                                return btn
                            }
                            "X"-> btn = buttons[p+1]
                            else -> {
                                p += 3
                                continue@loop
                            }
                        }

                    }else {
                        if(((buttons[p+2].text=="")&&(buttons[p].text == buttons[p+1].text))) {
                            when(buttons[p].text){
                                "O" -> {
                                    btn = buttons[p+2]
                                    found(p)
                                    return btn
                                }
                                "X"-> btn = buttons[p+2]
                                else -> {
                                    p += 3
                                    continue@loop
                                }
                            }
                        }else {
                            p += 3
                            continue@loop
                        }
                    }

                }
            }
        }
        return btn

    }







    private fun found(i: Int) {
        buttons[i].setBackgroundColor(Color.RED)
        buttons[i+1].setBackgroundColor(Color.RED)
        buttons[i+2].setBackgroundColor(Color.RED)
        button10.text="play again"
        button10.visibility = View.VISIBLE
        c=8
    }
}