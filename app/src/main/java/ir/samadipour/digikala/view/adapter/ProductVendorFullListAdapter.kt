package ir.samadipour.digikala.view.adapter
//
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.supers.R
//import com.example.supers.service.models.sub_models.Vendors
//import ir.samadipour.digikala.service.utils.inflate
//
//
//class ProductVendorFullListAdapter : RecyclerView.Adapter<VendorsFullListHolder>() {
//    var data = emptyList<Vendors>()
//
//    fun submit(newData: List<Vendors>) {
//        data = newData
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VendorsFullListHolder =
//        VendorsFullListHolder(parent.inflate(R.layout.item_list_store_price))
//
//    override fun getItemCount(): Int = data.size
//
//    override fun onBindViewHolder(holder: VendorsFullListHolder, position: Int) =
//        holder.bind(data[position])
//}