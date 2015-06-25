package jp.co.se.android.recipe.chapter03;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

public class UrlSearchResultAdapter extends ArrayAdapter<UrlSearchResultVO> {
	
	private LayoutInflater layoutInflater;
	
	public UrlSearchResultAdapter(Context context, int resource, List<UrlSearchResultVO> usrAdapterList) {
		super(context, resource, usrAdapterList);
		//このへんの仕様調べる
		layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	}

}

// private LayoutInflater layoutInflater;
//
// @SuppressWarnings("static-access")
// public OSYoutubeResultAdapter(Context context, int textViewResourceId,
// List<OSYoutubeResultFactor> objects) {
// super(context, textViewResourceId, objects);
// layoutInflater =
// (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
// }
//
// @Override
// public View getView (int pos, View view, ViewGroup viewGroup) {
// // Target position gets
// OSYoutubeResultFactor data = (OSYoutubeResultFactor) getItem(pos);
// if (view == null) {
// view = layoutInflater.inflate(R.layout.osyoutube_singlefactor, null);
// }
//
// // Customization data sets to each widget
//
// // Bitmap gets
// ImageView imageView =
// (ImageView)view.findViewById(R.id.osyoutube_singlefactor_youtubeimage);
// imageView.setImageBitmap(data.getImageData());
//
// // Text gets
// TextView textView =
// (TextView)view.findViewById(R.id.osyoutube_singlefactor_text);
// textView.setText(data.getStringData());
//
// return view;
// }
//
// }
