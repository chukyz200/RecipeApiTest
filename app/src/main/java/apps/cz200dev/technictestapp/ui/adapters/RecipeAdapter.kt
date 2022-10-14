package apps.cz200dev.technictestapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import apps.cz200dev.technictestapp.data.model.RecipeItem
import apps.cz200dev.technictestapp.databinding.ItemRecipeBinding
import apps.cz200dev.technictestapp.utils.loadImage

class RecipeAdapter(private val onItemClickListener: (RecipeItem) -> Unit) :
    ListAdapter<RecipeItem, RecipeAdapter.RecipeViewHolder>(DiffCallback) {


    companion object DiffCallback : DiffUtil.ItemCallback<RecipeItem>() {
        override fun areItemsTheSame(oldItem: RecipeItem, newItem: RecipeItem): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: RecipeItem, newItem: RecipeItem): Boolean =
            oldItem == newItem

    }

    inner class RecipeViewHolder(
        private val binding: ItemRecipeBinding,
        onItemClickListener: (RecipeItem) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var recipeItem: RecipeItem

        init {
            itemView.setOnClickListener {
                onItemClickListener(recipeItem)
            }
        }

        fun bind(item: RecipeItem) {
            recipeItem = item
            binding.ivImage.loadImage(item.thumb)
            binding.tvTittle.text = item.name
            binding.tvDescription.text = item.description
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding: ItemRecipeBinding =
            ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding, onItemClickListener)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

}