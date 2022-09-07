package uz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.saidarabxon.akramov.musicplayer.databinding.ItemMusicBinding
import uz.utils.ItemTouchHelperAdapter
import uz.utils.Music
import java.util.*

class RvAdapter(private val list: ArrayList<Music>, val context: Context) :
    RecyclerView.Adapter<RvAdapter.VH>(), ItemTouchHelperAdapter {
    inner class VH(private val itemMusicBinding: ItemMusicBinding) :
        RecyclerView.ViewHolder(itemMusicBinding.root) {
        fun onBind(music: Music) {

            itemMusicBinding.name.text = music.name
            itemMusicBinding.musicName.text = music.musicN

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition > toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(list, i, i + 1)
            }
        } else {
            for (i in fromPosition until toPosition + 1) {
                Collections.swap(list, i, i - 1)


            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
list.removeAt(position)

        notifyItemRemoved(position)
    }


}