package br.com.havedadoathome.presentation.view.activity

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AlertDialog
import br.com.havedadoathome.R
import br.com.havedadoathome.baseclean.presentation.view.MainContract
import br.com.havedadoathome.presentation.internal.di.AppApplication
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : BaseActivity<MainContract.Presenter, MainContract.View>(),
        MainContract.View {

    override fun createPresenter(): MainContract.Presenter {
        AppApplication.applicationComponent.inject(this)
        return AppApplication.applicationComponent.mainPresenter()
    }

    companion object {
        private const val MAX_DICE_NUMBER = 20
        fun createIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }

    private fun initListeners() {
        botao_sortear?.setOnClickListener {
            randomNumber()
        }
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dado")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(Int::class.java)
                numero_sorteado.text = value.toString()
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    private fun randomNumber() {
        val rand = Random()
        val value = rand.nextInt(MAX_DICE_NUMBER)

        if (value == 0){
            randomNumber()
        }

        val builder: AlertDialog.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert)
        } else {
            builder = AlertDialog.Builder(this)
        }

        builder.setTitle("Numero Sorteado")
                .setMessage("Seu numero sorteado foi: " + value)
                .setPositiveButton("ok", { _, _ ->
                    writeNumberServer(value)
                    numero_sorteado.text = value.toString()
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show()

    }

    private fun writeNumberServer(dadoNumber: Int) {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dado")
        myRef.setValue(dadoNumber)
    }
}