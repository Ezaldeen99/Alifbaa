package com.example.android.alifbaa;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali_a on 12/12/2017.
 * updated by sulaiman
 */

public class alphabetTilesAdapter extends ArrayAdapter {
    int count=4;
    Context context ;
    int resource;
     List<Letter> letters;
    private boolean isCustomArray = false;

    public alphabetTilesAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.letters=objects;
    }
// constructor

    public alphabetTilesAdapter(@NonNull Context context, int resource, int count, Context context1, int resource1, List<Letter> letters, boolean isCustomArray) {
        super(context, resource);
        this.count = count;
        this.context = context1;
        this.resource = resource1;
        this.letters = letters;
        this.isCustomArray = isCustomArray;
    }

    public alphabetTilesAdapter(@NonNull Context context, int resource, int textViewResourceId, int count, Context context1, int resource1, List<Letter> letters, boolean isCustomArray) {
        super(context, resource, textViewResourceId);
        this.count = count;
        this.context = context1;
        this.resource = resource1;
        this.letters = letters;
        this.isCustomArray = isCustomArray;
    }

    public alphabetTilesAdapter(@NonNull Context context, int resource, @NonNull Object[] objects, int count, Context context1, int resource1, List<Letter> letters, boolean isCustomArray) {
        super(context, resource, objects);
        this.count = count;
        this.context = context1;
        this.resource = resource1;
        this.letters = letters;
        this.isCustomArray = isCustomArray;
    }

    public alphabetTilesAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Object[] objects, int count, Context context1, int resource1, List<Letter> letters, boolean isCustomArray) {
        super(context, resource, textViewResourceId, objects);
        this.count = count;
        this.context = context1;
        this.resource = resource1;
        this.letters = letters;
        this.isCustomArray = isCustomArray;
    }

    public alphabetTilesAdapter(@NonNull Context context, int resource, @NonNull List objects, int count, Context context1, int resource1, List<Letter> letters, boolean isCustomArray) {
        super(context, resource, objects);
        this.count = count;
        this.context = context1;
        this.resource = resource1;
        this.letters = letters;
        this.isCustomArray = isCustomArray;
    }

    public alphabetTilesAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List objects, int count, Context context1, int resource1, List<Letter> letters, boolean isCustomArray) {
        super(context, resource, textViewResourceId, objects);
        this.count = count;
        this.context = context1;
        this.resource = resource1;
        this.letters = letters;
        this.isCustomArray = isCustomArray;
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
    ImageView imageView = (ImageView) convertView.findViewById(R.id.letter_image);
    Letter obj = letters.get(position);

    imageView.setImageResource(obj.getLetterImg());
//        imageView.setTag(obj.getIndext());

}

        setUpDragNDrop(position,convertView);

    return convertView;}

    @Override
    public int getCount(){
        return isCustomArray ? letters.size() : super.getCount();
    }

    public void setCustomArray(ArrayList array){
        this.isCustomArray = true;
        this.letters = array;
    }

    public void setUpDragNDrop(final int position, final View view){

        if (view.getTag() == null){
            view.setTag(new AlphabetTilesViewHolder(position));
        } else {
            ((AlphabetTilesViewHolder) view.getTag()).position = position;
        }

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent letters = new Intent();
                letters.putExtra("position", ((AlphabetTilesViewHolder) view.getTag()).position);
                view.startDrag(ClipData.newIntent("letters", letters), new View.DragShadowBuilder(v), v, 0);
                return true;
            }
        });

        view.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        break;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        break;
                    case DragEvent.ACTION_DROP:
                        //Delete dragged item
                        int dragPosition = event.getClipData().getItemAt(0).getIntent().getIntExtra("position", -1);
                        if (dragPosition < 0) {
                            return false;
                        }
                        Object dragItem = isCustomArray ? letters.get(dragPosition) : alphabetTilesAdapter.this.getItem(dragPosition);
                        if (isCustomArray){
                            letters.remove(dragPosition);
                            letters.add(((AlphabetTilesViewHolder) v.getTag()).position, (Letter) dragItem);
                        } else {
                            alphabetTilesAdapter.this.remove(dragPosition);
                            //Insert dropped item
                            alphabetTilesAdapter.this.insert(dragItem, ((AlphabetTilesViewHolder) v.getTag()).position);
                        }

                        alphabetTilesAdapter.this.notifyDataSetChanged();
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        GridView parent = (GridView) v.getParent();
                        int pos = ((AlphabetTilesViewHolder) v.getTag()).position;
                        if (pos > parent.getLastVisiblePosition() - parent.getNumColumns()){
                            parent.smoothScrollByOffset(1);
                        }
                        if (pos < parent.getFirstVisiblePosition() + parent.getNumColumns()){
                            parent.smoothScrollByOffset(-1);
                        }
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });

    }
}
