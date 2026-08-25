package br.unisanta.tp_02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edt_titulo = findViewById<EditText>(R.id.edt_titulo)
        val edt_autor = findViewById<EditText>(R.id.edt_autor)
        val btn_cadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val fab_detalhamento = findViewById<FloatingActionButton>(R.id.fab_detalhamento)

        var titulo:String = ""
        var autor:String = ""

        btn_cadastrar.setOnClickListener{
            titulo = edt_titulo.text.toString()
            autor = edt_autor.text.toString()
            edt_titulo.text.clear()
            edt_autor.text.clear()
            Toast.makeText(this, "Salvo com sucesso!", Toast.LENGTH_SHORT).show()
        }

        fab_detalhamento.setOnClickListener{
            val intent = Intent(this, LivroActivity::class.java)
            intent.putExtra("titulo_livro", titulo.toString())
            intent.putExtra("autor_livro", autor.toString())
            startActivity(intent)
        }
    }
}