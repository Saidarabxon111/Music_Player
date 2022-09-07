package uz.saidarabxon.akramov.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import uz.adapter.RvAdapter
import uz.saidarabxon.akramov.musicplayer.databinding.ActivityMainBinding
import uz.utils.Music

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  lateinit var list: ArrayList<Music>
//    lateinit var listAdapter:  uz.adapter.ListAdapter
    lateinit var userRvAdapter: RvAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        listAdapter = uz.adapter.ListAdapter()
//        binding.rv.adapter = listAdapter

        loadDate()

        userRvAdapter = RvAdapter(list,this)
        binding.rv.adapter = userRvAdapter


//        listAdapter.submitList(list)
toachHelper()
    }

    private fun toachHelper() {


        val itemTouchHelperAdapter =  object : ItemTouchHelper.Callback(){
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
                val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
                return makeMovementFlags(dragFlags, swipeFlags)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                userRvAdapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                userRvAdapter.onItemDismiss(viewHolder.adapterPosition)
            }

        }

        val touch = ItemTouchHelper(itemTouchHelperAdapter)
        touch.attachToRecyclerView(binding.rv)
    }

    private fun loadDate() {

        list = ArrayList()

        for (i in 0..30) {
            list.add( Music("JanobRasul", "Captiva$i"))
        }
    }
}