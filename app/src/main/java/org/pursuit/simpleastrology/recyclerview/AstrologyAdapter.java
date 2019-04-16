package org.pursuit.simpleastrology.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.simpleastrology.R;
import org.pursuit.simpleastrology.fragments.FragmentInterface;
import org.pursuit.simpleastrology.model.Astrology;
import org.pursuit.simpleastrology.model.ZodiacReading;

import java.util.List;

public class AstrologyAdapter extends RecyclerView.Adapter<AstrologyViewHolder> {
    public List<Astrology> astrologyList;
    private ZodiacReading reading;
    private FragmentInterface listener;

    public AstrologyAdapter(List<Astrology> astrologyList, FragmentInterface listener) {
        this.astrologyList = astrologyList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AstrologyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zodiac_itemview, viewGroup, false);
        return new AstrologyViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull AstrologyViewHolder astrologyViewHolder, int i) {
        astrologyViewHolder.onBind(astrologyList.get(i),reading, listener);
    }

    @Override
    public int getItemCount() {
        return astrologyList.size();
    }
}
