package mx.edu.tecmm.moviles.ejercicio6listview

import android.net.wifi.p2p.WifiP2pManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var txt_descripcion:TextView

    var lugares = arrayOf("Tequila","Magdalena", "Amatitan","Arenal","Tala","La venta","Guadalajara", "Santa Teresa", "San Andres", "Hostotipaquillo")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView :ListView = findViewById(R.id.list_view_lugares)
         txt_descripcion =findViewById(R.id.txt_descripcion)
        val adaptador =ArrayAdapter(this, R.layout.list_item,lugares)
        listView.adapter = adaptador

        listView.onItemClickListener = object: AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
                //aqui viene el escuchar
                val item = listView.getItemAtPosition(pos) as String
                Log.e("ListViewEvento", item)
                txt_descripcion.setText("En camino hacia "+listView.getItemAtPosition(pos))
            }

        }      }
}