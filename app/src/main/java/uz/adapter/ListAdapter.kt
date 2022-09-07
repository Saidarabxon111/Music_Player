package uz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.saidarabxon.akramov.musicplayer.databinding.ActivityMainBinding
import uz.saidarabxon.akramov.musicplayer.databinding.ItemMusicBinding
import uz.utils.Music

class ListAdapter :ListAdapter<Music,uz.adapter.ListAdapter.Vh>(MyDifUtils()){


    class MyDifUtils:DiffUtil.ItemCallback<Music>() {
        override fun areItemsTheSame(oldItem: Music, newItem: Music): Boolean {
            return  oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Music, newItem: Music): Boolean {
            return  oldItem == newItem
        }
    }

    inner class  Vh(val itemMusic: ItemMusicBinding):RecyclerView.ViewHolder(itemMusic.root){
fun onBind(music: Music){
    itemMusic.name.text = music.name
    itemMusic.musicName.text = music.musicN

}

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemMusicBinding.inflate(LayoutInflater.from(parent.context),parent,false ))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
holder.onBind(getItem(position))
    }


}