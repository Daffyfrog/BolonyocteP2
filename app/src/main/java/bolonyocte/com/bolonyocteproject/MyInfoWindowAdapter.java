package bolonyocte.com.bolonyocteproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by iem on 09/01/2017.
 */

public class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private final View myContentsView;
    LayoutInflater inflater;


    MyInfoWindowAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        myContentsView = inflater.inflate(R.layout.custom_info_contents, null);
    }

    @Override
    public View getInfoContents(Marker marker) {
        System.out.println(marker.getSnippet());
        /*TextView tvTitle = ((TextView) myContentsView.findViewById(R.id.title));
        tvTitle.setText(marker.getTitle());*/
        TextView tvSnippet = ((TextView) myContentsView.findViewById(R.id.tvGroup));
        //tvSnippet.setText(marker.getSnippet());

        return myContentsView;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        // TODO Auto-generated method stub
        return null;
    }

}

