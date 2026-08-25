package br.unisanta.tp_02

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LivroActivity : AppCompatActivity(R.layout.activity_livro) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tv_titulo = findViewById<TextView>(R.id.tv_titulo)
        val tv_autor = findViewById<TextView>(R.id.tv_autor)
        val titulo = intent.getStringExtra("titulo_livro")
        val autor = intent.getStringExtra("autor_livro")

        val fab_volta = findViewById<FloatingActionButton>(R.id.fab_volta)

        tv_titulo.setText("Título: $titulo")
        tv_autor.setText("Autor: $autor")

        fab_volta.setOnClickListener{
            finish()
        }


    }
}