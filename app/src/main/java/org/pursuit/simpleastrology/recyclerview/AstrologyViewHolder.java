package org.pursuit.simpleastrology.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.simpleastrology.R;
import org.pursuit.simpleastrology.fragments.FragmentInterface;
import org.pursuit.simpleastrology.model.Astrology;

public class AstrologyViewHolder extends RecyclerView.ViewHolder {
private ImageView zodiacSymbol;
private TextView zodiacName;
private TextView zodiacDate;

    public AstrologyViewHolder(@NonNull View itemView) {
        super(itemView);

        zodiacSymbol = itemView.findViewById(R.id.zodiac_symbol);
        zodiacName = itemView.findViewById(R.id.zodiac_name);
        zodiacDate = itemView.findViewById(R.id.zodiac_date);
    }

    public void onBind(final Astrology model, final FragmentInterface listener){
        Picasso.get().load(model.getZodiacSymbol()).into(zodiacSymbol);
        zodiacName.setText(model.getZodiacName());
        zodiacDate.setText(model.getZodiacDate());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.toZodiacFrag(model);
            }
        });


    }
}
