package org.pursuit.simpleastrology.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.pursuit.simpleastrology.R;
import org.pursuit.simpleastrology.fragments.FragmentInterface;
import org.pursuit.simpleastrology.model.Astrology;
import java.util.List;

public class AstrologyAdapter extends RecyclerView.Adapter<AstrologyViewHolder> {
    private List<Astrology> astrologyList;
    private FragmentInterface fragmentInterface;

    public AstrologyAdapter(List<Astrology> astrologyList, FragmentInterface fragmentInterface) {
        this.astrologyList = astrologyList;
        this.fragmentInterface = fragmentInterface;
    }

    @NonNull
    @Override
    public AstrologyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zodiac_itemview, viewGroup, false);
        return new AstrologyViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull AstrologyViewHolder astrologyViewHolder, int i) {
        astrologyViewHolder.onBind(astrologyList.get(i), fragmentInterface);
    }

    @Override
    public int getItemCount() {
        return astrologyList.size();
    }
}
