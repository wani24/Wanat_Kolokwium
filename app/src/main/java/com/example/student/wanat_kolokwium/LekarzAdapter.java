package com.example.student.wanat_kolokwium;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class LekarzAdapter extends RecyclerView.Adapter<LekarzAdapter.ViewHolder>{
}


    private ArrayList<Lekarz> lekarze = new ArrayList<>();
    private OnClickPlace listener;

    LekarzAdapter(ArrayList<Lekarz> lekarze , OnClickPlace listener)
    {
        this.lekarze = lekarze;
        this.listener = listener;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, null);

        return new ViewHolder(itemLayoutView, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setImie(lekarze.get(position).getImie());
        holder.setNazwisko(lekarze.get(position).getNazwisko());
        holder.setSpecjalizacja(lekarze.get(position).getSpecjalizacja());



    }

    @Override
    public int getItemCount() {
        return lekarze.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.nazwisko)
        TextView nazwisko;

        @BindView(R.id.imie)
        TextView imie;

        @BindView(R.id.specjalizacja)
        TextView specjalizacja;

        private OnClickPlace listener;



        @OnClick(R.id.button_wybierz)
        void onNameClick() {
            if (Wybrane.getVisibility() == View.INVISIBLE) {
                Wybrane.setVisibility(View.VISIBLE);
            } else {
                Wybrane.setVisibility(View.INVISIBLE);
            }
        }

        public ViewHolder(View itemView, OnClickPlace listener) {

            super(itemView);
            ButterKnife.bind(this,itemView);
            this.listener = listener;
            itemView.setOnClickListener(this::OnClick);

        }

        private void setNazwisko(String nazwisko){nazwisko.setText(nazwisko);}
        private void setImie(String imie) {imie.setText(imie);}



        public void OnClick(View view)
        {
            listener.onClickPlace(view, getAdapterPosition());


        }
    }


}