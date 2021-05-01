package layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.jota.modulo4individualfinal.R
import com.squareup.picasso.Picasso

class Adapter (val image: List<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = image[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val lInflater = LayoutInflater.from(parent.context)
        return ViewHolder(lInflater.inflate(R.layout.dogs, parent, false))
    }

    override fun getItemCount(): Int {
        return image.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(image: String) {
            var imageDogs = itemView.findViewById(R.id.ivDogs) as ImageView
            imageDogs.from(image)
        }

        fun ImageView.from(url:String){
            Picasso.get().load(url).into(this)
        }
    }
}


