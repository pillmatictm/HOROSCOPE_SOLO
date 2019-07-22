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
    private FragmentInterface fragmentInterface;
    public static final String KEY = "zodiac_frag";
    private static final String IMAGE = "zodiac_image";
    private static final String NAME = "zodiac_name";
    private static final String DATE = "zodiac_date";
    private static final String PLANET = "ruling_planet";
    private static final String ELEMENT = "zodiac_element";
    private static final String MODALITY = "zodiac_modality";
    private static final String OVERVIEW = "zodiac_overview";
    private static final String LOVE = "zodiac_love";
    private static final String WEALTH = "zodiac_wealth";
    private static final String KEYWORDS = "zodiac_keywords";
    private static final String CELEBRITIES = "zodiac_famousFigures";
    private String zodiacSymbolUrl;
    private String zodiacNameString;
    private String zodiacDateString;
    private String rulingPlanetString;
    private String elementString;
    private String modalityString;
    private String overviewString;
    private String loveString;
    private String wealthString;
    private String[] keywordsStringArray;
    private String[] famousFiguresStringArray;

    public ZodiacFragment() {
        // Required empty public constructor
    }

    public static ZodiacFragment newInstance(Astrology model) {
        ZodiacFragment zodiacFragment = new ZodiacFragment();
        Bundle args = new Bundle();
        args.putSerializable(IMAGE, model);
        args.putString(NAME, model.zodiacName);
        args.putString(DATE, model.zodiacDate);
        args.putString(PLANET, model.rulingPlanet);
        args.putString(ELEMENT, model.element);
        args.putString(MODALITY, model.modality);
        args.putString(OVERVIEW, model.zodiacReading.overview);
        args.putString(LOVE, model.zodiacReading.love);
        args.putString(WEALTH, model.zodiacReading.wealth);
        args.putStringArray(KEYWORDS, model.keywords);
        args.putStringArray(CELEBRITIES, model.famousFigures);
        zodiacFragment.setArguments(args);
        return zodiacFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentInterface = (FragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentInterface");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            zodiacSymbolUrl = ((Astrology) getArguments().getSerializable(IMAGE)).zodiacSymbol;
            zodiacNameString = getArguments().getString(NAME);
            zodiacDateString = getArguments().getString(DATE);
            rulingPlanetString = "Ruling Planet: " + getArguments().getString(PLANET);
            elementString = "Element: " + getArguments().getString(ELEMENT);
            modalityString = "Modality: " + getArguments().getString(MODALITY);
            overviewString = getArguments().getString(OVERVIEW);
            loveString = getArguments().getString(LOVE);
            wealthString = getArguments().getString(WEALTH);
            keywordsStringArray = getArguments().getStringArray(KEYWORDS);
            famousFiguresStringArray = getArguments().getStringArray(CELEBRITIES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
        if (elementString.substring(9).equals("Water")) {
            zodiacName.setTextColor(getResources().getColor(R.color.colorWater));
            element.setTextColor(getResources().getColor(R.color.colorWater));
        }
        if (elementString.substring(9).equals("Fire")) {
            zodiacName.setTextColor(getResources().getColor(R.color.colorFire));
            element.setTextColor(getResources().getColor(R.color.colorFire));
        }
        if (elementString.substring(9).equals("Earth")) {
            zodiacName.setTextColor(getResources().getColor(R.color.colorEarth));
            element.setTextColor(getResources().getColor(R.color.colorEarth));
        }
        if (elementString.substring(9).equals("Air")) {
            zodiacName.setTextColor(getResources().getColor(R.color.colorAir));
            element.setTextColor(getResources().getColor(R.color.colorAir));
        }

        modality.setText(modalityString);
        overview.setText(overviewString);
        love.setText(loveString);
        wealth.setText(wealthString);

        String keywordsString = "";
        for (int i = 0; i < keywordsStringArray.length; i++) {
            keywordsString += keywordsStringArray[i];
        }

        String famousFiguresString = "";
        for (int j = 0; j < famousFiguresStringArray.length; j++) {
            famousFiguresString += famousFiguresStringArray[j];
        }

        keywords.setText(keywordsString);
        famousFigures.setText(famousFiguresString);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentInterface = null;
    }
}
