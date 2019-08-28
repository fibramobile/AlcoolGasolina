package mobile.fibra.alcoolGasolina

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import mobile.fibra.myapplication.R

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }


    fun btnCalcular(view: View){

        //recuperar valores digitados pelo usuário:

        val precoAlcool = edit_preco_alcool.text.toString()
        val precoGasolina = edit_preco_gasolina.text.toString()
        val validarCampos = validarCampor(precoAlcool, precoGasolina)

        if (validarCampos){
            calcularMelgorPreco(precoAlcool, precoGasolina)
        }else{
            text_resultado.setText("Entre com o valor dos preços")
        }
    }

    fun validarCampor(precoAlcool: String, precoGasolina : String):Boolean{

        var camposValidados: Boolean = true

        if (precoAlcool == null || precoAlcool.equals(""))camposValidados=false
        if (precoGasolina == null || precoGasolina.equals(""))camposValidados=false

        return camposValidados
    }

    fun calcularMelgorPreco(precoAlcool: String, precoGasolina : String){

        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        val calculo = valorAlcool/valorGasolina

        if (calculo >= 0.7){
            text_resultado.setText("Melhor utilizar Gasolina")
        }else{
            text_resultado.setText("Melhor utilizar Alcool")
        }
    }
}
