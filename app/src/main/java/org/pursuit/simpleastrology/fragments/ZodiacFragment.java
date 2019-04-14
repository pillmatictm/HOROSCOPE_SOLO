package org.pursuit.simpleastrology.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.simpleastrology.R;
import org.pursuit.simpleastrology.model.Astrology;


public class ZodiacFragment extends Fragment {
    public static final String KEY = "zodiac_frag";
    public static final String SYMBOL = "zodiac_symbol";
    public static final String NAME = "zodiac_name";
    public static final String DATE = "zodiac_date";
    public static final String PLANET = "ruling_planet";
    public static final String ELEMENT = "zodiac_element";
    public static final String MODALITY = "zodiac_modality";
    public static final String OVERVIEW = "zodiac_overview";
    public static final String LOVE = "zodiac_love";
    public static final String WEALTH = "zodiac_wealth";
    public static final String KEYWORDS = "zodiac_keywords";
    public static final String CELEBRITIES = "zodiac_famousFigures";
    private String zodiacSymbolUrl;
    private String zodiacNameString;
    private String zodiacDateString;
    private String rulingPlanetString;
    private String elementString;
    private String modalityString;
    private String overviewString;
    private String loveString;
    private String wealthString;
    private String[] keywordsString;
    private String[] famousFiguresString;


    public ZodiacFragment() {
        // Required empty public constructor
    }

    public static ZodiacFragment newInstance(Astrology model, Astrology.ZodiacReading reading) {
        ZodiacFragment zodiacFragment = new ZodiacFragment();
        Bundle args = new Bundle();
        args.putString(NAME, model.zodiacName);
        args.putString(DATE, model.zodiacDate);
        args.putString(PLANET, model.rulingPlanet);
        args.putString(ELEMENT, model.element);
        args.putString(MODALITY, model.modality);
        args.putString(OVERVIEW, reading.overview);
        args.putString(LOVE, reading.love);
        args.putString(WEALTH, reading.wealth);
        args.putStringArray(KEYWORDS, model.keywords);
        args.putStringArray(CELEBRITIES, model.famousFigures);
        zodiacFragment.setArguments(args);
        return zodiacFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            FragmentInterface fragmentInterface = (FragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentInterface");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            zodiacSymbolUrl = getArguments().getString(SYMBOL);
            zodiacNameString = getArguments().getString(NAME);
            zodiacDateString = getArguments().getString(DATE);
            rulingPlanetString = getArguments().getString(PLANET);
            elementString = getArguments().getString(ELEMENT);
            modalityString = getArguments().getString(MODALITY);
            overviewString = getArguments().getString(OVERVIEW);
            loveString = getArguments().getString(LOVE);
            wealthString = getArguments().getString(WEALTH);
            keywordsString = getArguments().getStringArray(KEYWORDS);
            famousFiguresString = getArguments().getStringArray(CELEBRITIES);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_zodiac, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView zodiacSymbol = view.findViewById(R.id.zodiacTraits_symbol);
        TextView zodiacName = view.findViewById(R.id.zodiacTraits_name);
        TextView zodiacDate = view.findViewById(R.id.zodiacTraits_date);
        TextView rulingPlanet = view.findViewById(R.id.zodiacTraits_rulingPlanet);
        TextView element = view.findViewById(R.id.zodiacTraits_element);
        TextView modality = view.findViewById(R.id.zodiacTraits_modality);
        TextView overview = view.findViewById(R.id.zodiacTraits_overView_text);
        TextView love = view.findViewById(R.id.zodiacTraits_love_text);
        TextView wealth = view.findViewById(R.id.zodiacTraits_wealth_text);
        TextView keywords = view.findViewById(R.id.zodiacTraits_keywords_text);
        TextView famousFigures = view.findViewById(R.id.zodiacTraits_famousFigures_text);

        Picasso.get().load(zodiacSymbolUrl).into(zodiacSymbol);
        zodiacName.setText(zodiacNameString);
        zodiacDate.setText(zodiacDateString);
        rulingPlanet.setText(rulingPlanetString);
        element.setText(elementString);
        modality.setText(modalityString);
        overview.setText(overviewString);
        love.setText(loveString);
        wealth.setText(wealthString);
        keywords.setText(keywordsString.toString());
        famousFigures.setText(famousFiguresString.toString());

    }
}
