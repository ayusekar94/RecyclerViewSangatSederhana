package anandaayusekarwiranti.example.recyclerviewsangatsederhana.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import anandaayusekarwiranti.example.recyclerviewsangatsederhana.R;
import anandaayusekarwiranti.example.recyclerviewsangatsederhana.models.SuperHero;

public class SuperHeroAdapters extends RecyclerView.Adapter<SuperHeroAdapters.MyViewHolder> {
    List<SuperHero> heroList;

    public SuperHeroAdapters(List<SuperHero> heroList) {
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public SuperHeroAdapters.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //object context diambil dari parent
        Context context = parent.getContext();
        //object context digunakan untuk membuat object layoutInflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        //object layoutInflater digunakan untuk membuat object view yang merupakan hasil inflate  layout ( mengubungkan adapter degnan layout)
        View superHeroView = layoutInflater.inflate(R.layout.item_super_hero,parent,false);
        //object superHeroView digunakan untuk membuat object viewHolder
        MyViewHolder viewHolder = new MyViewHolder(superHeroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SuperHeroAdapters.MyViewHolder holder, int position) {
        //ambil satu item hero
        SuperHero hero = heroList.get(position);
        //set text heroName berdasarkan data dari model hero
        holder.heroName.setText(hero.getHeroName());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView heroName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //variabel disesuaikan dengan layout, karena pada layout item_super_hero terdapat satu
            //TextView maka pada kode program ini dibuat satu TextView yang melakukan findViewById ke id layout yang bersesuaian
            heroName = itemView.findViewById(R.id.heroName);
        }
    }
}
