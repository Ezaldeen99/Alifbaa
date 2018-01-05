package com.example.android.alifbaa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by ali_a on 12/12/2017.
 */

public class alphabetTilesAdapter extends ArrayAdapter {
    int count=4;
    Context context ;
    int resource;
     List<Letter> letters;
    public alphabetTilesAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.letters=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null)
            convertView= LayoutInflater.from(context).inflate(resource,null);
//        if(count==-1){
//            count=4;}


//        position+=count;
if (position<30) {
//    count -= 1;
    ImageView imageView = convertView.findViewById(R.id.letter_image);
    Letter obj = letters.get(position);

    imageView.setImageResource(obj.getLetterImg());
//        imageView.setTag(obj.getIndext());

}


    return convertView;}
}
