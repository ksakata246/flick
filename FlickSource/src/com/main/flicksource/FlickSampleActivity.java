package com.main.flicksource;

import java.net.MalformedURLException;
import java.net.URL;

import com.main.flicksource.HttpSampleActivity.AsyncCl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FlickSampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();

		setContentView(R.layout.flick_test);

		ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
		PagerAdapter mPagerAdapter = new MyPagerAdapter();
		mViewPager.setAdapter(mPagerAdapter);
	}

	protected class FlickTouchListener implements View.OnTouchListener {
		// 最後にタッチされた座標
		private float startTouchX;
		private float startTouchY;
		// 現在タッチ中の座標
		private float nowTouchedX;
		private float nowTouchedY;

		// フリックの遊び部分（最低限移動しないといけない距離）
		private float adjust = 120;

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// タッチされている指の本数
			Log.v("motionEvent", "--touch_count = " + event.getPointerCount());

			// タッチされている座標
			Log.v("Y", "" + event.getY());
			Log.v("X", "" + event.getX());

			switch (event.getAction()) {
			// タッチ
			case MotionEvent.ACTION_DOWN:
				Log.v("motionEvent", "--ACTION_DOWN");
				startTouchX = event.getX();
				startTouchY = event.getY();
				break;

			// タッチ中に追加でタッチした場合
			case MotionEvent.ACTION_POINTER_DOWN:
				Log.v("motionEvent", "--ACTION_POINTER_DOWN");
				break;

			// スライド
			case MotionEvent.ACTION_MOVE:
				Log.v("motionEvent", "--ACTION_MOVE");
				break;

			// タッチが離れた
			case MotionEvent.ACTION_UP:
				Log.v("motionEvent", "--ACTION_UP");
				nowTouchedX = event.getX();
				nowTouchedY = event.getY();

				if (startTouchY > nowTouchedY) {
					if (startTouchX > nowTouchedX) {
						if ((startTouchY - nowTouchedY) > (startTouchX - nowTouchedX)) {
							if (startTouchY > nowTouchedY + adjust) {
								Log.v("Flick", "--上");
								try {
									asyncDoPOST();
								} catch (MalformedURLException e) {
									// TODO 自動生成された catch ブロック
									e.printStackTrace();
								}
							}
						} else if ((startTouchY - nowTouchedY) < (startTouchX - nowTouchedX)) {
							if (startTouchX > nowTouchedX + adjust) {
								Log.v("Flick", "--左");
								// 左フリック時の処理を記述する
							}
						}
					} else if (startTouchX < nowTouchedX) {
						if ((startTouchY - nowTouchedY) > (nowTouchedX - startTouchX)) {
							if (startTouchY > nowTouchedY + adjust) {
								Log.v("Flick", "--上");
								// 上フリック時の処理を記述する
								try {
									asyncDoPOST();
								} catch (MalformedURLException e) {
									// TODO 自動生成された catch ブロック
									e.printStackTrace();
								}
							}
						} else if ((startTouchY - nowTouchedY) < (nowTouchedX - startTouchX)) {
							if (startTouchX < nowTouchedX + adjust) {
								Log.v("Flick", "--右");
								// 右フリック時の処理を記述する
							}
						}
					}
				} else if (startTouchY < nowTouchedY) {
					if (startTouchX > nowTouchedX) {
						if ((nowTouchedY - startTouchY) > (startTouchX - nowTouchedX)) {
							if (startTouchY < nowTouchedY + adjust) {
								Log.v("Flick", "--下");
								// 下フリック時の処理を記述する
							}
						} else if ((nowTouchedY - startTouchY) < (startTouchX - nowTouchedX)) {
							if (startTouchX > nowTouchedX + adjust) {
								Log.v("Flick", "--左");
								// 左フリック時の処理を記述する
							}
						}
					} else if (startTouchX < nowTouchedX) {
						if ((nowTouchedY - startTouchY) > (nowTouchedX - startTouchX)) {
							if (startTouchY < nowTouchedY + adjust) {
								Log.v("Flick", "--下");
								// 下フリック時の処理を記述する
							}
						} else if ((nowTouchedY - startTouchY) < (nowTouchedX - startTouchX)) {
							if (startTouchX < nowTouchedX + adjust) {
								Log.v("Flick", "--右");
								// 右フリック時の処理を記述する
							}
						}
					}
				}
				break;

			// アップ後にほかの指がタッチ中の場合
			case MotionEvent.ACTION_POINTER_UP:
				Log.v("motionEvent", "--ACTION_POINTER_UP");
				break;

			// UP+DOWNの同時発生(タッチのキャンセル）
			case MotionEvent.ACTION_CANCEL:
				Log.v("motionEvent", "--ACTION_CANCEL");

				// ターゲットとするUIの範囲外を押下
			case MotionEvent.ACTION_OUTSIDE:
				Log.v("motionEvent", "--ACTION_OUTSIDE");
				break;
			}
			return (true);
		}

		private void asyncDoPOST() throws MalformedURLException {
			HttpSampleActivity h = new HttpSampleActivity();
			AsyncCl aul = h.new AsyncCl(this, "POST");
			aul.execute();
		}

	}

	private class MyPagerAdapter extends PagerAdapter {
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// レイアウトファイル名を配列で指定します。
			int[] pages = { R.layout.page1, R.layout.page2, R.layout.page3 };

			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			View layout;
			layout = inflater.inflate(pages[position], null);
			((ViewPager) container).addView(layout);

			if (position == 0) {
				// ImageViewに画像をセット
				Resources r = getResources();
				Bitmap bmp1 = BitmapFactory.decodeResource(r,
						R.drawable.flick_image2);
				ImageView imageView = (ImageView) layout
						.findViewById(R.id.flick_test);
				imageView.setImageBitmap(bmp1);
			} else if(position == 1){
				// ImageViewに画像をセット
				Resources r = getResources();
				Bitmap bmp1 = BitmapFactory.decodeResource(r,
						R.drawable.flick_image3);
				ImageView imageView = (ImageView) layout
						.findViewById(R.id.flick_test);
				imageView.setImageBitmap(bmp1);
			}
			
			
			int i = 0;
			
			switch(position){
				case 0:
					i = R.id.page1;
					break;
				case 1:
					i = R.id.page2;
					break;
				case 2:
					i = R.id.page3;
					break;
			}
			
			View view = findViewById(i);
			view.setOnTouchListener(new FlickTouchListener());

			return layout;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager) container).removeView((View) object);
		}

		@Override
		public int getCount() {
			// ページ数を返します。
			return 3;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view.equals(object);
		}
	}
}
